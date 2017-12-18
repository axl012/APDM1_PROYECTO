package hipo.prop.app.axel.com.proyecto;

/**
 * Created by axel012 on 12/6/2017.
 */

public class Product {
    private String nombre;
    private String precio;
    private int idThumbnail;
    private String calorias;

    public Product(String nombre,String precio, int idThumbnail, String calorias) {
        this.nombre = nombre;
        this.precio = precio;
        this.idThumbnail = idThumbnail;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }


    public String getPrecio() {
        return precio;
    }

    public String getCalorias(){
        return calorias;
    }


    public int getIdThumbnail() {
        return idThumbnail;
    }
}

