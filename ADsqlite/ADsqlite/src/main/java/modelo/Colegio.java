package modelo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

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

    public static Connection connection(String url) {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void connect(String url) {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public String toString(){
        return " codigo: " + getCodigo() + " nombre " + getNombre() + "direccion " + getDireccion();
    }
    public static void createNewTable(String url) {

        String sql = "CREATE TABLE colegio (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	codigo text NOT NULL,\n"
                + "     nombre text NOT NULL, \n"
                + "     direccion text NOT NULL,\n "
                + "     localidad text NOT NULL,\n"
                + "     codigo_postal text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
               
            stmt.execute(sql);
            conn.close();
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        

    }

    public void insert(Colegio colegio, String url) throws SQLException {
        String sql = "INSERT INTO colegio(id,codigo,nombre,direccion,localidad,codigo_postal) VALUES(?,?,?,?,?,?)";
        Connection conn = connection(url);
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, colegio.getId());
            pstmt.setString(2, colegio.getCodigo());
            pstmt.setString(3, colegio.getNombre());
            pstmt.setString(4, colegio.getDireccion());
            pstmt.setString(5, colegio.getLocalidad());
            pstmt.setString(6, colegio.getCodigo_postal());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public  ArrayList<Colegio> refrescarColegios(String url) throws SQLException {
        String sql = "SELECT id,codigo,nombre,direccion,localidad,codigo_postal FROM colegio";
        ArrayList<Colegio> colegios_aux = new ArrayList<Colegio>();
        Connection conn = connection(url);
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
                
            // loop through the result set
            while (rs.next()) {
                Colegio colegio = new Colegio(rs.getInt("id"),rs.getString("codigo"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("localidad"), rs.getString("codigo_postal"));
                colegios_aux.add(colegio);

            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return colegios_aux;
    }

public ArrayList<Colegio> delete(int id, String url) throws SQLException {
        String sql = "DELETE FROM colegio WHERE id = ?";
        ArrayList<Colegio> colegios_aux = new ArrayList<Colegio>();
        Connection conn = connection(url);
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            colegios_aux=refrescarColegios(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return colegios_aux;
    }
 public ArrayList<Colegio> update(Colegio colegio, String url, int id) throws SQLException {

       
        ArrayList<Colegio> colegios_aux = new ArrayList<Colegio>();
        String sql = "UPDATE colegio SET codigo = ? , "
                + "nombre = ? , "
                +" direccion = ? , "
                + "localidad= ? ,"
                + "codigo_postal= ?"
                + "WHERE id = ?" ;

         Connection conn = connection(url);
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, colegio.getCodigo());
            pstmt.setString(2, colegio.getNombre());
            pstmt.setString(3, colegio.getDireccion());
            pstmt.setString(4, colegio.getLocalidad());
            pstmt.setString(5, colegio.getCodigo_postal());
            pstmt.setInt(6, id-1);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            conn.close();
            return colegios_aux;
            
    }
}
