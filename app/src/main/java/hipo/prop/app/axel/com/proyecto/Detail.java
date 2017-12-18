package hipo.prop.app.axel.com.proyecto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    ImageView imgDetail;
    TextView txtNombred, txtPreciod, txtDescripcion;
    Arreglo data = new Arreglo();
    TextView txtVwDiag;

    // ArrayList<Product> food=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imgDetail = (ImageView) findViewById(R.id.imgDetails);
        txtNombred = (TextView) findViewById(R.id.txtNombred);
        txtPreciod = (TextView) findViewById(R.id.txtPreciod);
       // txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);


        Intent inDatos = getIntent();
        int ima = inDatos.getIntExtra("IMAGEN", R.drawable.tacos1);
        String Nom = inDatos.getStringExtra("NOMBRE");
        String pre = inDatos.getStringExtra("PRECIO");
        String cal = inDatos.getStringExtra("CALORIAS");
       // String det = inDatos.getStringExtra("DESCRIPCION");
        imgDetail.setImageResource(ima);
        txtNombred.setText(Nom);
        txtPreciod.setText(pre);

       // txtDescripcion.setText(det);
    }

    public void onClickAñadir(View v){
        Intent inDatosRShow = getIntent();//SE OBTIENE EL INTENTO
        int Img = inDatosRShow.getIntExtra("IMAGEN",R.drawable.tacos1);
        String Nom = inDatosRShow.getStringExtra("NOMBRE");
        String Des = inDatosRShow.getStringExtra("PRECIO");
        String cal = inDatosRShow.getStringExtra("CALORIAS");
        data.ticketdata.add(new Product(Nom, Des, Img,cal));
        finish();
        Toast.makeText(this, "Añadido al ticket", Toast.LENGTH_SHORT).show();

    }

    public void onClickCalorias(View v){
        final Dialog digMiDialogo = new Dialog(this);
        digMiDialogo.setContentView(R.layout.cuadro);
        Button btnBoton;
        txtVwDiag = (TextView)digMiDialogo.findViewById(R.id.txtcal);
        btnBoton = (Button) digMiDialogo.findViewById(R.id.cerrar);

        Intent inDatos = getIntent();
        String cal = inDatos.getStringExtra("CALORIAS");
        txtVwDiag.setText(cal);
        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digMiDialogo.dismiss();
            }
        });
        digMiDialogo.show();

    }

}
