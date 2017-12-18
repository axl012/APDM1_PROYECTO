package hipo.prop.app.axel.com.proyecto;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by axel012 on 12/13/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Product> dishes;
    LayoutInflater inflater;
    Intent inDetail;

    public CustomAdapter(Context c, ArrayList<Product> dishes) {
        this.c = c;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int i) {
        return dishes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null)
        {
            view=inflater.inflate(R.layout.activity_list_view,viewGroup,false);
        }
        TextView nameTxt= (TextView) view.findViewById(R.id.txtViewName);
        TextView priceTxt = view.findViewById(R.id.txtViewPrice);
        ImageView img= (ImageView) view.findViewById(R.id.imgView);
        final String name=dishes.get(i).getNombre();
        final String price = dishes.get(i).getPrecio();
        int image=dishes.get(i).getIdThumbnail();
        nameTxt.setText(name);
        priceTxt.setText(price);
        img.setImageResource(image);
       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        }); */
        return view;
    }
}