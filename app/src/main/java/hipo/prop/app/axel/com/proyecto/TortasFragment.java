package hipo.prop.app.axel.com.proyecto;

import android.app.Dialog;
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

public class TortasFragment extends Fragment {
    ArrayList<Product> food=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_tortas,container,false);
        android.widget.ListView lv= rootView.findViewById(R.id.tortaslist);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(),getTortasMenu());
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
                startActivityForResult(intent,13);
            }
        });

        return rootView;
    }
    private ArrayList<Product> getTortasMenu() {
        Product product=new Product("Torta ahogada","90",R.drawable.torta1,"grasas totales: 200 g\n" +
                "\n" +
                "grasas saturadas: 120 g\n" +
                "\n" +
                "calorias: 150 g\n" +
                "\n" +
                "valor energetico: 9000 kJ\n" +
                "\n" +
                "azucares: 50 g\n" +
                "\n" +
                "proteinas: 100 g\n" +
                "\n" +
                "sal: 3 g");
        food.add(product);
        product =  new Product("Torta de lomo","80",R.drawable.torta2,"grasas totales: 100 g\n" +
                "\n" +
                "grasas saturadas: 30 g\n" +
                "\n" +
                "calorias: 60 g\n" +
                "\n" +
                "valor energetico: 3000 kJ\n" +
                "\n" +
                "azucares: 50 g\n" +
                "\n" +
                "proteinas: 50 g\n" +
                "\n" +
                "sal: 3 g");
        food.add(product);
        product = new Product("Torta de bistek","150",R.drawable.torta3,"grasas totales: 150 g\n" +
                "\n" +
                "grasas saturadas: 130 g\n" +
                "\n" +
                "calorias: 90 g\n" +
                "\n" +
                "valor energetico: 10000 kJ\n" +
                "\n" +
                "azucares: 30 g\n" +
                "\n" +
                "proteinas: 30 g\n" +
                "\n" +
                "sal: 10 g");
        food.add(product);
        return food;
    }
    @Override
    public String toString() {
        return "Tortas";
    }

}