/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.ColegioController;
import controlador.DepartamentoController;
import controlador.ProfesorController;
import java.io.FileNotFoundException;
import java.io.IOException;
import modelo.Colegio;
import modelo.Departamento;
import modelo.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author crist
 */
public class test {

    private ProfesorController controlador_profesor = new ProfesorController();
    private ColegioController controlador_colegio = new ColegioController();
    private DepartamentoController controlador_departamento = new DepartamentoController();

    public test() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void insertar_profesor_en_vector_de_alumnocontroller() throws IOException, FileNotFoundException, ClassNotFoundException {
        int tamanio = controlador_profesor.getProfesor().size();
        Profesor profesor = new Profesor("76592866Z", "Christian", " Campos", "22-11-1999", "masculino", "k");
        controlador_profesor.insertarProfesor(profesor);
        assertEquals(controlador_profesor.getProfesor().size(), tamanio + 1);
    }

    @Test
    public void eliminar_colegio_de_vector_de_collegiocontroller() throws IOException, FileNotFoundException, ClassNotFoundException {
        Colegio prueba = new Colegio("323", "prueba", "prueba", "prueba", "prueba");
        controlador_colegio.insertarColegio(prueba);
        int tamanio = controlador_colegio.getColegios().size();
        controlador_colegio.eliminarColegio(tamanio - 1);
        assertEquals(controlador_colegio.getColegios().size(), tamanio - 1);
    }

    @Test
    public void modificar_departamento_en_vector_de_departamentoController() throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean encontrado;
        Departamento departamento = new Departamento("PROG", "PROGRAMACION", "PRACTICO", "2", "4","p");
        controlador_departamento.insertarDepartamento(departamento);
        Departamento departamento2 = new Departamento("LENG", "Lengua", "PRACTICO", "2", "4","p");
        controlador_departamento.modificarDepartamento(departamento2, 0);
        encontrado = controlador_departamento.comprobarpk("PROG");
        assertEquals(false, encontrado);

    }

    @Test
    public void intentar_introducir_pk_repetida_en_profesor() throws IOException, FileNotFoundException, ClassNotFoundException {
        Profesor profesor = new Profesor("76592866Z", "Christian", " Campos", "22-11-1999", "masculino","p");
        Profesor profesor2 = new Profesor("76592866Z", "manolo", " Herrera", "22-11-1999", "masculino","p");
        controlador_profesor.insertarProfesor(profesor);
        int tamanio1 = controlador_profesor.getProfesor().size();
        controlador_profesor.insertarProfesor(profesor2);
        int tamanio2 = controlador_profesor.getProfesor().size();
        assertEquals(tamanio1,tamanio2);
    }

}