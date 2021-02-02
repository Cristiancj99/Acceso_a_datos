/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
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
    public void setId( int id) {
        this.id=id;
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

    public ArrayList<Profesor> leerProfesores(String bd) {

        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Profesor profesor = new Profesor(0,null,null,null,null,null,0);
        ObjectSet<Profesor> result = db.queryByExample(profesor);
        if (result.size() == 0) {
        } else {
            System.out.printf("Número de registros: %d %n", result.size());
            while (result.hasNext()) {
                profesores.add(result.next());
            }
        }
        db.close(); // cerrar base de datos

        return profesores;

    }

    public void escribirProfesor(String bd, Profesor profesor) {

        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        db.store(profesor);
        db.close(); // cerrar base de datos

    }

    public void EliminarProfesor(String bd, String id) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Profesor profesor = new Profesor(0,id,null,null,null,null,0);
        ObjectSet<Profesor> result =  db.queryByExample(profesor);

        if (result.size() == 0) {
        } else {
            System.out.printf("Registros a borrar: %d %n", result.size());

            while (result.hasNext()) {
                Profesor p = result.next();
                db.delete(p);
                System.out.println("Borrado....");
            }
        }

        db.close();
    }

    public void ModificarProfesor(String bd, Profesor profesor, Profesor modificado) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Profesor profesor_aux = new Profesor(0,profesor.getDni(),null,null,null,null,0);
        ObjectSet<Profesor> result
                = db.queryByExample(profesor_aux);
        if (result.size() == 0) {
        } else {
            Profesor existe = (Profesor) result.next();
            existe.setId(modificado.getId());
            existe.setDni(modificado.getDni());
            existe.setNombre(modificado.getNombre());
            existe.setApellido(modificado.getApellido());
            existe.setFechaNacimiento(modificado.getFechaNacimiento());
            existe.setSexo(modificado.getSexo());
            existe.setFk(modificado.getFk());
            db.store(existe); 

            result = db.queryByExample(new Profesor(0,existe.getDni(), null, null, null, null, 0));
            existe = (Profesor) result.next();

        }

        db.close();
    }
}
