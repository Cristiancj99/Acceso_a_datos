package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Profesor;

/**
 *
 * @author crist
 */
public class ProfesorController {

    private ArrayList<Profesor> profesores;
    private File ficheroProfesor;
    private Profesor profesorController;

    public ProfesorController(ArrayList<Profesor> profesor) {
        this.profesores = profesor;
    }

    public ProfesorController() {
        this.profesores = new ArrayList<Profesor>();
        profesorController = new Profesor();
        ficheroProfesor = new File("profesor.dat");
    }

    public ArrayList<Profesor> getProfesor() {
        return profesores;
    }

    public void setProfesor(ArrayList<Profesor> profesor) {
        this.profesores = profesor;
    }

    public Profesor getPosicionProfesores(int i) {
        return profesores.get(i);
    }

    public void modificarProfesor(Profesor profesor, int posicion) throws IOException, FileNotFoundException, ClassNotFoundException {

        profesores.set(posicion, profesor);
        profesorController.LimpiarArchivo(ficheroProfesor);
        profesorController.rellenarArchivoProfesor(ficheroProfesor, profesores);
    }

    public void refrescarProfesores() throws IOException, FileNotFoundException, ClassNotFoundException {
        profesores = profesorController.LeerArchivoProfesor(ficheroProfesor);

    }

    public String[][] ComprobarFichero() throws IOException, FileNotFoundException, ClassNotFoundException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[profesores.size()][NUMERO_COLUMNAS];
        if (ficheroProfesor.exists()) {
            refrescarProfesores();
            matriz = introducirProfesores(profesores);
        }
        return matriz;

    }

    public void escribirProfesores() throws IOException, FileNotFoundException, ClassNotFoundException {
        profesorController.rellenarArchivoProfesor(ficheroProfesor, profesores);
    }

    public String[][] introducirProfesores(ArrayList<Profesor> profesores) throws IOException, FileNotFoundException, ClassNotFoundException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[profesores.size()][NUMERO_COLUMNAS];
        for (int i = 0; i < profesores.size(); i++) {

            matriz[i][0] = profesores.get(i).getDni();
            matriz[i][1] = profesores.get(i).getNombre();
            matriz[i][2] = profesores.get(i).getApellido();
            matriz[i][3] = profesores.get(i).getFechaNacimiento();
            matriz[i][4] = profesores.get(i).getSexo();

        }

        return matriz;
    }

    public void insertarProfesor(Profesor profesor) throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean repetido = comprobarpk(profesor.getDni());
        if (!repetido) {
            profesores.add(profesor);
            escribirProfesores();
        }
    }

    public void insertarProfesorPosicion(Profesor profesor, int i) throws IOException, FileNotFoundException, ClassNotFoundException {
        profesores.set(i, profesor);
        escribirProfesores();
    }

    public void eliminarProfesor(int posicion) throws IOException, FileNotFoundException, ClassNotFoundException {
        profesores.remove(posicion);
        profesorController.LimpiarArchivo(ficheroProfesor);
        profesorController.rellenarArchivoProfesor(ficheroProfesor, profesores);

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

    public boolean comprobarfkProfesores(String fk) {
        boolean encontrado = false;

        for (int i = 0; (i < profesores.size() && !encontrado); i++) {
            if (profesores.get(i).getFk() == fk) {
                encontrado = true;
            }
        }

        return encontrado;

    }

}
