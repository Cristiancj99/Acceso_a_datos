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

/**
 *
 * @author crist
 */
public class Profesor {

    private static int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private int fk;

    public Profesor(String dni, String nombre, String apellido, String fechaNacimiento, String sexo, int fk) {
        this.id++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fk = fk;
    }

    public Profesor(int id, String dni, String nombre, String apellido, String fechaNacimiento, String sexo, int fk) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fk = fk;
    }

    public Profesor() {
        this.id++;
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.fechaNacimiento = "";
        this.sexo = "";
        this.fk = 0;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public void createNewTable(String url) {
        String sql = "CREATE TABLE  profesor (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	dni text NOT NULL,\n"
                + "     nombre text NOT NULL, \n"
                + "     apellido text NOT NULL,\n "
                + "     fecha_nacimiento text NOT NULL,\n"
                + "     sexo text NOT NULL,\n"
                + "     fk text NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Profesor profesor, String url) {
        String sql = "INSERT INTO profesor(id,dni,nombre,apellido,fecha_nacimiento,sexo,fk) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, profesor.getId());
            pstmt.setString(2, profesor.getDni());
            pstmt.setString(3, profesor.getNombre());
            pstmt.setString(4, profesor.getApellido());
            pstmt.setString(5, profesor.getFechaNacimiento());
            pstmt.setString(6, profesor.getSexo());
            pstmt.setInt(7, profesor.getFk());
            System.out.println("hola");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Profesor> refrescarProfesores(String url) throws SQLException {
        String sql = "SELECT id,dni,nombre,apellido,fecha_nacimiento,sexo,fk FROM profesor";
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        Connection conn = connection(url);
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Profesor profesor = new Profesor(rs.getInt("id"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("fecha_nacimiento"), rs.getString("sexo"), rs.getInt("fk"));
                profesores.add(profesor);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();

        return profesores;
    }

    public ArrayList<Profesor> delete(int id, String url) throws SQLException {
        String sql = "DELETE FROM profesor WHERE id = ?";
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        Connection conn = connection(url);
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            profesores = refrescarProfesores(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return profesores;
    }

    public void update(Profesor profesor, String url, int id) throws SQLException {
        String sql = "UPDATE profesor SET dni = ? , "
                + "nombre = ? , "
                + " apellido = ? , "
                + "fecha_nacimiento= ? ,"
                + "sexo= ?, "
                + "fk=?"
                + "WHERE id = ?";
        
        Connection conn = connection(url);

        try (
               
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, profesor.getDni());
            pstmt.setString(2, profesor.getNombre());
            pstmt.setString(3, profesor.getApellido());
            pstmt.setString(4, profesor.getFechaNacimiento());
            pstmt.setString(5, profesor.getSexo());
            pstmt.setInt(6, profesor.getFk());
            pstmt.setInt(7, id-1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }
}
