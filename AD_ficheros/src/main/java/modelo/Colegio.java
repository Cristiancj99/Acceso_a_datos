
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


public class Colegio implements Serializable{
    private String codigo;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigo_postal;


    public Colegio() {
        this.codigo = "";
        this.nombre = "";
        this.direccion = "";
        this.localidad = "";
        this.codigo_postal = "";
        
    }
    

    public Colegio(String codigo, String nombre, String direccion, String localidad, String codigo_postal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;

    }
    
    

    public String getCodigo() {
        return codigo;
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
    
    public  void rellenarArchivoColegio(File fichero, ArrayList <Colegio> colegios) throws FileNotFoundException, IOException, ClassNotFoundException, ClassNotFoundException{
        FileOutputStream salida=new FileOutputStream(fichero);
        ObjectOutputStream dataOS= new ObjectOutputStream(salida);
             
            dataOS.writeObject(colegios);
        
                
        dataOS.close();
        
    }
    
     public  ArrayList<Colegio> LeerArchivoColegio(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
         ArrayList <Colegio> colegios=new ArrayList <Colegio>();
		try {			
                    colegios = (ArrayList <Colegio>) dataIS.readObject(); 
		} catch (EOFException eo) {
		} catch (StreamCorruptedException x) {
		}
                
		dataIS.close(); 
                         

                return colegios;
    }
    public void LimpiarArchivo(File fichero) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));


        int i = 1;
              
	try {
            bw.write("");
                } catch (EOFException eo) {
                } catch (StreamCorruptedException x) {
            }

		bw.close(); 
    }
}
