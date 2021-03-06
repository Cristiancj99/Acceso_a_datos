package practicahibernate;
// Generated 02-feb-2021 10:12:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Colegio generated by hbm2java
 */
public class Colegio  implements java.io.Serializable {


     private int idColegio;
     private String codigo;
     private String nombre;
     private String provincia;
     private String direccion;
     private String codigoPostal;
     private Set departamentos = new HashSet(0);

    public Colegio() {
    }

	
    public Colegio(int idColegio, String nombre) {
        this.idColegio = idColegio;
        this.nombre = nombre;
    }
    public Colegio(int idColegio, String codigo, String nombre, String provincia, String direccion, String codigoPostal/*, Set departamentos*/) {
       this.idColegio = idColegio;
       this.codigo = codigo;
       this.nombre = nombre;
       this.provincia = provincia;
       this.direccion = direccion;
       this.codigoPostal = codigoPostal;
      // this.departamentos = departamentos;
    }
   
    public int getIdColegio() {
        return this.idColegio;
    }
    
    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public Set getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Set departamentos) {
        this.departamentos = departamentos;
    }




}


