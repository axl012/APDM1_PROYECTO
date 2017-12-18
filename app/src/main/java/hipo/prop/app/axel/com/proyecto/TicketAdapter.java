package hipo.prop.app.axel.com.proyecto;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by axel012 on 12/14/2017.
 */

public class TicketAdapter extends ArrayAdapter<Product> {
    Context cntApp;
    int iLayout;
    Product[] rDatos;
    public TicketAdapter(@NonNull Context context, int resource, Product[] objects) {
        super(context, resource, objects);
        cntApp = context;
        iLayout = resource;
        rDatos = objects;
    }

    @NonNull
    @Override
    //OBTENER LA VISTA
    public View getView(int position, View convertView, ViewGroup parent) {
        View vFila = convertView;
        ImageView ivticket;
        TextView txtVwNombre, txtVrprecio;

        if (vFila == null){
            LayoutInflater liCrearLayout = ((Activity)cntApp).getLayoutInflater();
            vFila = liCrearLayout.inflate(iLayout,parent,false);
        }
        ivticket =  vFila.findViewById(R.id.imgticket);
        txtVwNombre = vFila.findViewById(R.id.ticketnombre);
        txtVrprecio =  vFila.findViewById(R.id.ticketprecio);

        Product dcOb = rDatos[position];

        ivticket.setImageResource(dcOb.getIdThumbnail());
        txtVwNombre.setText(dcOb.getNombre());
        txtVrprecio.setText(dcOb.getPrecio());
        //REGRESAR LA FILA
        return vFila;
    }

}


