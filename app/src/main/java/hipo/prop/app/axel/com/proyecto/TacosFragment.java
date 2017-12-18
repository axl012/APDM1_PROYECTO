package hipo.prop.app.axel.com.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by axel012 on 12/13/2017.
 */

public class TacosFragment extends Fragment {
    android.widget.ListView lv;
    ArrayList<Product> food=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.tacos_fragment,container,false);
        lv= rootView.findViewById(R.id.tacoslist);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(),getTacosMenu());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Detail.class);
                int Imag = food.get(i).getIdThumbnail();
                String sNombre = food.get(i).getNombre();
                String sprecio =food.get(i).getPrecio();
                String cal =food.get(i).getCalorias();
                //tring sDireccion = drDatos[position].Direccion;
                //String sTelefono = drDatos[position].Telefono;
                intent.putExtra("IMAGEN",Imag);
                intent.putExtra("NOMBRE",sNombre);
                intent.putExtra("PRECIO",sprecio);
                intent.putExtra("CALORIAS",cal);
                /*inDetalle.putExtra("NOMBRE",sNombre);
                inDetalle.putExtra("TIPO",sTipo);
                inDetalle.putExtra("DIRECCION",sDireccion);
                inDetalle.putExtra("TELEFONO",sTelefono);*/
                startActivityForResult(intent,13);
            }
        });
        return rootView;
    }
    private ArrayList<Product> getTacosMenu() {
        //COLECTION OF CRIME MOVIES
        //SINGLE MOVIE
        Product product=new Product("Tacos de bistek","125",R.drawable.tacos1,"grasas totales: 130 g\n" +
                "\n" +
                "grasas saturadas: 50 g\n" +
                "\n" +
                "calorias: 90 g\n" +
                "\n" +
                "valor energetico: 6000 kJ\n" +
                "\n" +
                "azucares: 100 g\n" +
                "\n" +
                "proteinas: 50 g\n" +
                "\n" +
                "sal: 6 g");
        //ADD ITR TO COLLECTION
        food.add(product);
        product=new Product("Tacos al pastor","80",R.drawable.tacos2,"grasas totales: 100 g\n" +
                "\n" +
                "grasas saturadas: 30 g\n" +
                "\n" +
                "calorias: 70g\n" +
                "\n" +
                "valor energetico: 5000 kJ\n" +
                "\n" +
                "azucares: 80 g\n" +
                "\n" +
                "proteinas: 60 g\n" +
                "\n" +
                "sal: 2 g");
        food.add(product);
        product=new Product("Tacos de alambre","150",R.drawable.tacos3,"grasas totales: 150 g\n" +
                "\n" +
                "grasas saturadas: 100 g\n" +
                "\n" +
                "calorias: 120 g\n" +
                "\n" +
                "valor energetico: 8500 kJ\n" +
                "\n" +
                "azucares: 100 g\n" +
                "\n" +
                "proteinas: 75 g\n" +
                "\n" +
                "sal: 5 g");
        food.add(product);
        return food;
    }
    @Override
    public String toString() {
        String title="Tacos";
        return title;
    }
}
