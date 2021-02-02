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

    public void setId(int id) {
        this.id=id;
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

    public String toString() {
        return " codigo: " + getCodDep() + " nombre " + getNombre();
    }

    public ArrayList<Departamento> leerDepartamento(String bd) {

        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Departamento departamento = new Departamento(0, null,null,null,null,null,0);
        ObjectSet<Departamento> result = db.queryByExample(departamento);
        if (result.size() == 0) {
        } else {
            System.out.printf("Número de registros: %d %n", result.size());
            while (result.hasNext()) {
                departamentos.add(result.next());
            }
        }
        db.close(); // cerrar base de datos

        return departamentos;

    }

    public void escribirDepartamento(String bd, Departamento departamento) {

        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        db.store(departamento);
        db.close(); // cerrar base de datos

    }

    public void EliminarDepartamento(String bd, String id ){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Departamento departamento = new Departamento(0, id,null,null,null,null,0);
        ObjectSet<Departamento> result =  db.queryByExample(departamento);

        if (result.size() == 0) {
        } else {
            System.out.printf("Registros a borrar: %d %n", result.size());

            while (result.hasNext()) {
                Departamento p = result.next();
                db.delete(p);
                System.out.println("Borrado....");
            }
        }

        db.close();
    }

    public void ModificarDepartamento(String bd, Departamento departamento, Departamento modificado) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bd);
        Departamento departamento_aux = new Departamento(0, departamento.getCodDep(),null,null,null,null,0);
        ObjectSet<Departamento> result
                = db.queryByExample(departamento_aux);
        if (result.size() == 0) {

        } else {
            Departamento existe = (Departamento) result.next();
            existe.setId(modificado.getId());
            existe.setCodDep(modificado.getCodDep());
            existe.setNombre(modificado.getNombre());
            existe.setPlanta(modificado.getPlanta());
            existe.setNumeroIntegrantes(modificado.getNumeroIntegrantes());
            existe.setTipo(modificado.getTipo());
            existe.setFk(modificado.getFk());
            db.store(existe); 

            result = db.queryByExample(new Departamento(0, existe.getCodDep(), null, null, null, null, 0));
            existe = (Departamento) result.next();

        }

        db.close();
    }

}
