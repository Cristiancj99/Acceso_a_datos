/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;


public class Departamento implements Serializable {

    private String codDep;
    private String nombre;
    private String tipo;
    private String numeroIntegrantes;
    private String planta;
    private String fk;

    public Departamento(String codDep, String nombre, String tipo, String numeroIntegrantes, String planta, String fk) {
        this.codDep = codDep;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroIntegrantes = numeroIntegrantes;
        this.planta = planta;
        this.fk=fk;
    }

    public Departamento() {
        this.codDep = "";
        this.nombre = "";
        this.tipo = "";
        this.numeroIntegrantes = "";
        this.planta = "";
        this.fk="";
    }

    public String getCodDep() {
        return codDep;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
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

    public void rellenarArchivoDepartamento(File fichero, ArrayList<Departamento> departamentos) throws FileNotFoundException, IOException, ClassNotFoundException, ClassNotFoundException {
        FileOutputStream salida = new FileOutputStream(fichero, true);
        ObjectOutputStream dataOS = new ObjectOutputStream(salida);

        dataOS.writeObject(departamentos);
        dataOS.close();

    }

    public ArrayList<Departamento> LeerArchivoDepartamento(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            departamentos = (ArrayList<Departamento>) dataIS.readObject();
        } catch (EOFException eo) {
        } catch (StreamCorruptedException x) {
        }

        dataIS.close();
        return departamentos;
    }

    public void LimpiarArchivo(File fichero) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

        try {
            bw.write("");
        } catch (EOFException eo) {
        } catch (StreamCorruptedException x) {
        }

        bw.close();
    }
}
