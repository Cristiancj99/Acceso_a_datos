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
import javax.xml.parsers.ParserConfigurationException;
import modelo.Colegio;
import modelo.Departamento;
import modelo.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class test {
    
    private ProfesorController controlador_profesor;
    private ColegioController controlador_colegio;
    private DepartamentoController controlador_departamento; 

    public test() throws SAXException, IOException, ParserConfigurationException {
        controlador_profesor = new ProfesorController();
        controlador_colegio = new ColegioController();
        controlador_departamento = new DepartamentoController();
    }
    
    @Test
    public void insertar_profesor_en_vector_de_alumnocontroller() throws IOException, FileNotFoundException, ClassNotFoundException {
        int tamanio = controlador_profesor.getProfesor().size();
        Profesor profesor = new Profesor("76592866Z", "Christian", " Campos", "22-11-1999", "masculino", 1);
        controlador_profesor.insertarProfesor(profesor);
        assertEquals(controlador_profesor.getProfesor().size(), tamanio + 1);
    }

    @Test
    public void eliminar_colegio_de_vector_de_collegiocontroller() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        Colegio prueba = new Colegio("323", "prueba", "prueba", "prueba", "prueba");
        controlador_colegio.insertarColegio(prueba);
        int tamanio = controlador_colegio.getColegios().size();
        controlador_colegio.eliminarColegio(controlador_colegio.getColegios().get(tamanio-1).getCodigo());
        assertEquals(controlador_colegio.getColegios().size(), tamanio - 1);
    }

    @Test
    public void modificar_departamento_en_vector_de_departamentoController() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        boolean encontrado;
        Departamento departamento = new Departamento("PROG", "PROGRAMACION", "PRACTICO", "2", "4",1);
        controlador_departamento.insertarDepartamento(departamento);
        Departamento departamento2 = new Departamento("LENG", "Lengua", "PRACTICO", "2", "4",1);
        controlador_departamento.modificarDepartamento(departamento2, 0);
        encontrado = controlador_departamento.comprobarpk("PROG");
        assertEquals(false, encontrado);

    }

    @Test
    public void intentar_introducir_pk_repetida_en_profesor() throws IOException, FileNotFoundException, ClassNotFoundException {
        Profesor profesor = new Profesor("76592866Z", "Christian", " Campos", "22-11-1999", "masculino",22);
        Profesor profesor2 = new Profesor("76592866Z", "manolo", " Herrera", "22-11-1999", "masculino",33);
        controlador_profesor.insertarProfesor(profesor);
        int tamanio1 = controlador_profesor.getProfesor().size();
        controlador_profesor.insertarProfesor(profesor2);
        int tamanio2 = controlador_profesor.getProfesor().size();
        assertEquals(tamanio1,tamanio2);
    }
}
