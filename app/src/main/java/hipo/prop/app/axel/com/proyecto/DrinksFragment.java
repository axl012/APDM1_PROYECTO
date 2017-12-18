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


public class DrinksFragment extends Fragment {
    ArrayList<Product> food=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_drinks,container,false);
        android.widget.ListView lv= rootView.findViewById(R.id.DrinksList);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(),getDrinksMenu());
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
    private ArrayList<Product> getDrinksMenu() {
        Product product=new Product("Coca-Cola","20",R.drawable.soda1,"140");
        food.add(product);
        product = new Product("Pepsi","20",R.drawable.soda2,"150");
        food.add(product);
        product = new Product("Limonada","15",R.drawable.agua1,"99");
        food.add(product);
        product =  new Product("Orchata","15",R.drawable.agua2,"54");
        food.add(product);
        return food;
    }
    @Override
    public String toString() {
        return "Bebidas";
    }
}