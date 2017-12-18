package hipo.prop.app.axel.com.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

public class Ticket extends AppCompatActivity implements
    android.widget.ListView.OnItemClickListener {

  ImageButton menuButton;
  Intent inMenu, inMain;
  ListView ticketlist;
  private TicketAdapter adap;
  int indice;
  TextView txtTotal, txtPropina;
  Arreglo data = new Arreglo();
  Product[] rDatosR;// = new Product[data.ticketdata.size()];
  Product[] precios;// = new Product[data.ticketdata.size()];


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ticket);
    menuButton = findViewById(R.id.menuButton);
    txtTotal = findViewById(R.id.txtTotal);
    txtPropina = findViewById(R.id.txtTip);
    Intent inDatosRShow = getIntent();//SE OBTIENE EL INTENTO
    indice = inDatosRShow.getIntExtra("INDICE", 0);


    rDatosR = new Product[data.ticketdata.size()];
    data.ticketdata.toArray(rDatosR); //PARA OBTENER LO DATOS
    precios = new Product[data.ticketdata.size()];

    setTotal();

    ticketlist = findViewById(R.id.ticketlist);
    ticketlist.setAdapter(new TicketAdapter(this, R.layout.activity_ticket_view, rDatosR));
    ticketlist.setOnItemClickListener(this);

    inMain = new Intent(this, Main.class);
    inMenu = new Intent(this, Menu.class);
    //inicio de menu
    menuButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final PopupMenu popmenu = new PopupMenu(Ticket.this, menuButton);
        popmenu.getMenuInflater().inflate(R.menu.popup_menu, popmenu.getMenu());

        popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
              case R.id.menu:
                startActivityForResult(inMenu, 1);
                finish();
                return true;
            }
            return true;
          }
        });
        popmenu.show();
      }
    });
    //fin de menu

  }

  private void setTotal() {
    int totalCartValue = sumar();
    double propina = totalCartValue*0.15;
    txtTotal.setText("$"+totalCartValue+"");
    txtPropina.setText("$"+propina);
  }


  public int sumar() {
    int totalCartValue;
    totalCartValue = 0;
    for (int i = 0; i < data.ticketdata.size(); i++) {
      totalCartValue += Integer.parseInt(data.ticketdata.get(i).getPrecio());
//      txtTotal.setText(totalCartValue);
    }
    return totalCartValue;
  }

  public void onClickTitulo(View v) {
    startActivityForResult(inMain, 3);
    finish();
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

  }

  @Override
  protected void onResume() {
    super.onResume();
    ticketlist.invalidateViews(); //PARA ACTUALIZAR LA LISTA EN CASI DE CAMBAIR EVALUACIÓN

  }

  public void onClickCancelar(View v) {
    data.ticketdata.clear();
        txtTotal.setText("$0.00");
          txtPropina.setText("$0.00");
    Toast.makeText(this, "Pedido cancelado", Toast.LENGTH_SHORT).show();
  }

  public void onClickEnviar(View v) {
    data.ticketdata.clear();
    txtTotal.setText("$0.00");
    txtPropina.setText("$0.00");
    Toast.makeText(this, "Enviado a cocina", Toast.LENGTH_SHORT).show();
  }

}
