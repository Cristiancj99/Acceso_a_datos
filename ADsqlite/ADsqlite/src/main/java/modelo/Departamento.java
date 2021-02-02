/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
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

/**
 *
 * @author crist
 */
public class Departamento {

    private static int id;
    private String codDep;
    private String nombre;
    private String tipo;
    private String numeroIntegrantes;
    private String planta;
    private int fk;

    public Departamento(String codDep, String nombre, String tipo, String numeroIntegrantes, String planta, int fk) {
        id++;
        this.codDep = codDep;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroIntegrantes = numeroIntegrantes;
        this.planta = planta;
        this.fk = fk;
    }

    public Departamento(int id, String codDep, String nombre, String tipo, String numeroIntegrantes, String planta, int fk) {
        this.id = id;
        this.codDep = codDep;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroIntegrantes = numeroIntegrantes;
        this.planta = planta;
        this.fk = fk;
    }

    public Departamento() {
        id++;
        this.codDep = "";
        this.nombre = "";
        this.tipo = "";
        this.numeroIntegrantes = "";
        this.planta = "";
        this.fk = 0;
    }

    public int getId() {
        return id;
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFk() {
        return fk;
    }

    public void setFk(int fk) {
        this.fk = fk;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroIntegrantes() {
        return numeroIntegrantes;
    }

    public void setNumeroIntegrantes(String numeroIntegrantes) {
        this.numeroIntegrantes = numeroIntegrantes;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public void comprobarIdTamanio(int id) {
        id = id;
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

    public static Connection connection(String url) {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewTable(String url) {

        String sql = "CREATE TABLE departamento (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	cod_dep text NOT NULL,\n"
                + "     nombre text NOT NULL, \n"
                + "     tipo text NOT NULL,\n "
                + "     numero_integrantes text NOT NULL,\n"
                + "     planta text NOT NULL,\n"
                + "     fk text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Departamento departamento, String url) throws SQLException {
        String sql = "INSERT INTO departamento(id,cod_dep,nombre,tipo,numero_integrantes,planta,fk) VALUES(?,?,?,?,?,?,?)";
        Connection conn = connection(url);
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departamento.getId());
            pstmt.setString(2, departamento.getCodDep());
            pstmt.setString(3, departamento.getNombre());
            pstmt.setString(4, departamento.getTipo());
            pstmt.setString(5, departamento.getNumeroIntegrantes());
            pstmt.setString(6, departamento.getPlanta());
            pstmt.setInt(7, departamento.getFk());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public static ArrayList<Departamento> refrescarDepartamentos(String url) throws SQLException {
        String sql = "SELECT id,cod_dep,nombre,tipo,numero_integrantes,planta,fk FROM departamento";
        ArrayList<Departamento> departamento = new ArrayList<Departamento>();
        Connection conn = connection(url);
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Departamento departamentos = new Departamento(rs.getInt("id"), rs.getString("cod_dep"), rs.getString("nombre"), rs.getString("tipo"), rs.getString("numero_integrantes"), rs.getString("planta"), rs.getInt("fk"));
                departamento.add(departamentos);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return departamento;
    }

    public ArrayList<Departamento> delete(int id, String url) throws SQLException {
        String sql = "DELETE FROM departamento WHERE id = ?";
        ArrayList<Departamento> departamentos_aux = new ArrayList<Departamento>();
        Connection conn = connection(url);
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            departamentos_aux = refrescarDepartamentos(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return departamentos_aux;
    }

    public String toString() {
        return " codigo: " + getCodDep() + " nombre " + getNombre();
    }

    public void updateDepartamento(Departamento departamento, String url, int id) {
        String sql = "UPDATE departamento SET cod_dep = ?, "
                + "nombre = ?, "
                + " tipo = ?, "
                + "numero_integrantes= ?,"
                + "planta= ?, "
                + "fk=?"
                + "WHERE id = ?";
        Connection conn = null;
        try {

            conn = connection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, departamento.getCodDep());
            pstmt.setString(2, departamento.getNombre());
            pstmt.setString(3, departamento.getTipo());
            pstmt.setString(4, departamento.getNumeroIntegrantes());
            pstmt.setString(5, departamento.getPlanta());
            pstmt.setInt(6, departamento.getFk());
            pstmt.setInt(7, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String codDep, String nombre,String tipo,String integrantes, String planta, int fk, int id, String url) throws SQLException {
        String sql = "UPDATE departamento SET cod_dep = ?, "
                + "nombre = ?, "
                + " tipo = ?, "
                + "numero_integrantes= ?,"
                + "planta= ?, "
                + "fk=?"
                + "WHERE id = ?";
        Connection conn = connection(url);
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            System.out.println(id);
            pstmt.setString(1, codDep);
            pstmt.setString(2, nombre);
            pstmt.setString(3, tipo);
            pstmt.setString(4, integrantes);
            pstmt.setString(5, planta);
            pstmt.setInt(6, fk);
            pstmt.setInt(7, id-1);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

}
