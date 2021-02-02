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

/**
 *
 * @author crist
 */
public class Profesor implements Serializable{
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String fk;

    public Profesor(String dni, String nombre, String apellido, String fechaNacimiento, String sexo, String fk) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fk=fk;
    }

    public Profesor() {
        this.dni = "";
        this.nombre ="";
        this.apellido = "";
        this.fechaNacimiento = "";
        this.sexo = ""; 
        this.fk="";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
        public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    
    public  void rellenarArchivoProfesor(File fichero, ArrayList <Profesor> profesores) throws FileNotFoundException, IOException, ClassNotFoundException, ClassNotFoundException{
        FileOutputStream salida=new FileOutputStream(fichero, true);
        ObjectOutputStream dataOS= new ObjectOutputStream(salida);
           
            dataOS.writeObject(profesores);               
        dataOS.close();
        
    }
    
     public  ArrayList<Profesor> LeerArchivoProfesor(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
         ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
         ArrayList <Profesor> profesores=new ArrayList <Profesor>();
                int posicion=0;
              
		try {
                        profesores = (ArrayList <Profesor>) dataIS.readObject();
                      
		} catch (EOFException eo) {
		} catch (StreamCorruptedException x) {
		}
                
		dataIS.close(); 
                return profesores;
    }
     
    public void LimpiarArchivo(File fichero) throws IOException{
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));              
		try {
			bw.write("");
		} catch (EOFException eo) {
		} catch (StreamCorruptedException x) {
		}

		bw.close(); 
    }
}     
    
