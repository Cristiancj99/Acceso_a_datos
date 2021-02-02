package modelo;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Colegio implements Serializable {
    private static int id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigo_postal;

    public Colegio() {
        id++;
        this.codigo = "";
        this.nombre = "";
        this.direccion = "";
        this.localidad = "";
        this.codigo_postal = "";
    }

    public Colegio(String codigo, String nombre, String direccion, String localidad, String codigo_postal) {
        id++;
        System.out.println("el id es de: "+id);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
    }
    
    public Colegio(int id,String codigo, String nombre, String direccion, String localidad, String codigo_postal) {
        this.id=id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void comprobarIdTamanio(int id) {
        this.id=id;
        System.out.println(this.id);
        System.out.println("cambiando id");
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public ArrayList<Colegio> leerColegio(String bd) {

        ArrayList<Colegio> colegios = new ArrayList<Colegio>();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd.yap");
        Colegio colegio = new Colegio(0, null,null,null,null,null);
        ObjectSet<Colegio> result = db.queryByExample(colegio);
        if (result.size() == 0) {
        } else {
            System.out.printf("Número de registros: %d %n", result.size());
            while (result.hasNext()) {
                Colegio auxiliar=result.next();
                colegios.add(auxiliar);
            }
        }
        db.close(); // cerrar base de datos

        return colegios;

    }

    public void escribirColegio(String bd, Colegio colegio) {
        System.out.println(colegio.getNombre() );
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd.yap");
        db.store(colegio);

        db.close(); // cerrar base de datos

    }

    public void EliminarColegio(String bd, String id) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Colegio colegio = new Colegio(0, id,null,null,null,null);
        ObjectSet<Colegio> result =  db.queryByExample(colegio);

        if (result.size() == 0) {
        } else {
            System.out.printf("Registros a borrar: %d %n", result.size());

            while (result.hasNext()) {
                Colegio c = result.next();
                db.delete(c);
                System.out.println("Borrado....");
            }
        }

        db.close();
    }

    public void ModificarColegio(String bd, Colegio colegio, Colegio modificado) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Colegio colegio_aux = new Colegio(0, colegio.getCodigo(),null,null,null,null);
        ObjectSet<Colegio> result
                = db.queryByExample(colegio_aux);
        if (result.size() == 0) {
            System.out.println("No existe Juanů");
        } else {
            Colegio existe = (Colegio) result.next();
            existe.setId(modificado.getId());
            existe.setCodigo(modificado.getCodigo());
            existe.setNombre(modificado.getNombre());
            existe.setLocalidad(modificado.getLocalidad());
            existe.setDireccion(modificado.getDireccion());
            existe.setCodigo_postal(modificado.getCodigo_postal());
            db.store(existe); 

            result = db.queryByExample(new Colegio(0, existe.getCodigo(), null, null, null, null));
            existe = (Colegio) result.next();

        }

        db.close();
    }
}
