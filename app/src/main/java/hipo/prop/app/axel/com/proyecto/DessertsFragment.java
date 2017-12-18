package hipo.prop.app.axel.com.proyecto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

public class DessertsFragment extends Fragment {
    ArrayList<Product> food=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_desserts,container,false);
        android.widget.ListView lv= rootView.findViewById(R.id.dessertlist);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(),getDessertMenu());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Detail.class);
                int Imag = food.get(i).getIdThumbnail();
                String sNombre = food.get(i).getNombre();
                String sprecio =food.get(i).getPrecio();
                String cal =food.get(i).getCalorias();
                intent.putExtra("IMAGEN",Imag);
                intent.putExtra("NOMBRE",sNombre);
                intent.putExtra("PRECIO",sprecio);
                intent.putExtra("CALORIAS",cal);
                startActivityForResult(intent,13);
            }
        });
        return rootView;
    }
    private ArrayList<Product> getDessertMenu() {
        Product product=new Product("Pay de queso","60",R.drawable.postre1, "Fibra: 0.7g \n Azucar: 12.5g \n Grasa saturada: 0.972g \n ");
        food.add(product);
        product = new Product("Brownie con helado","70",R.drawable.postre2,"Fibra: 8g \n Azucar: 30g \n Grasa saturada: 18g \n");
        food.add(product);
        product = new Product("Tiramisu","70",R.drawable.postre3,"\"Fibra: 1.6g \\n Azucar: 29.27g \\n Grasa saturada: 18.3g \\n\"");
        food.add(product);
        return food;
    }
    @Override
    public String toString() {
        return "Postres";
    }
}