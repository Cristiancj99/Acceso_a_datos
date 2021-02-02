package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Profesor;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class ProfesorController {

    private ArrayList<Profesor> profesores;
    private String url;
    private Profesor profesorController;

    public ProfesorController(ArrayList<Profesor> profesor) {
        this.profesores = profesor;
    }

    public ProfesorController() throws SAXException, IOException, ParserConfigurationException {
        this.profesores = new ArrayList<Profesor>();
        profesorController = new Profesor();
        url="jdbc:sqlite:C:/sqlite/db/chinook.db";
        crearTabla();
        refrescarProfesores(url);

        if(profesores.size()>0){
            profesorController.comprobarIdTamanio(profesores.get(profesores.size()-1).getId());
        }
    }

    public ArrayList<Profesor> getProfesor() {
        return profesores;
    }
    public String getUrl() {
        return url;
    }
    public void setProfesor(ArrayList<Profesor> profesor) {
        this.profesores = profesor;
    }

    public Profesor getPosicionProfesores(int i) {
        return profesores.get(i);
    }

    public void modificarProfesor(Profesor profesor, int posicion) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        profesorController.update(profesor, url, profesores.get(posicion).getId());
        refrescarProfesores(url);

    }

    public void refrescarProfesores(String url) throws SAXException, IOException, ParserConfigurationException {
        profesores= profesorController.refrescarProfesores(url);
        
    }

    public void escribirProfesores(Profesor profesor) {

            profesorController.insert(profesor, url);
        
    }

    public String[][] introducirProfesores(ArrayList<Profesor> profesores) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[profesores.size()][NUMERO_COLUMNAS];
        refrescarProfesores(url);
        for (int i = 0; i < profesores.size(); i++) {

            matriz[i][0] = profesores.get(i).getDni();
            matriz[i][1] = profesores.get(i).getNombre();
            matriz[i][2] = profesores.get(i).getApellido();
            matriz[i][3] = profesores.get(i).getFechaNacimiento();
            matriz[i][4] = profesores.get(i).getSexo();

        }

        return matriz;
    }
    public void crearTabla(){
        profesorController.createNewTable(url);
    }
    public void insertarProfesor(Profesor profesor) throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean repetido = comprobarpk(profesor.getDni());
        if (!repetido) {
            profesores.add(profesor);
            escribirProfesores(profesor);
        }
    }



    public void eliminarProfesor(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        profesores=profesorController.delete(id, url);;

    }

    public boolean comprobarpk(String pk) {
        boolean encontrado = false;

        for (int i = 0; (i < profesores.size() && !encontrado); i++) {
            if (profesores.get(i).getDni() == pk) {
                encontrado = true;
            }
        }

        return encontrado;

    }



    public boolean comprobarfkProfesores(int fk) {
        boolean encontrado = false;

        for (int i = 0; (i < profesores.size() && !encontrado); i++) {
            if (profesores.get(i).getFk() == fk) {
                encontrado = true;
            }
        }

        return encontrado;

    }
    
    
    

}
