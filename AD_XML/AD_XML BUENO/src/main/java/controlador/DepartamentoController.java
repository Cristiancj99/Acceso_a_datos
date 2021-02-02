/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Departamento;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class DepartamentoController {

    private ArrayList<Departamento> departamentos;
    private File ficheroDepartamento;
    private Departamento departamentoController;

    public DepartamentoController(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;

    }

    public DepartamentoController() {
        this.departamentos = new ArrayList<Departamento>();
        departamentoController = new Departamento();
        ficheroDepartamento = new File("Departamentos.xml");
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Departamento getPosicionDepartamentos(int i) {
        Departamento aux = departamentos.get(i);
        return aux;
    }

    public void eliminarDepartamento(int posicion) throws IOException, FileNotFoundException, ClassNotFoundException {
        departamentos.remove(posicion);
        /*departamentoController.LimpiarArchivo(ficheroDepartamento);
        departamentoController.rellenarArchivoDepartamento(ficheroDepartamento, departamentos);*/

    }

    public void refrescarDepartamentos() throws SAXException, IOException, ParserConfigurationException {
        departamentos = departamentoController.LeerArchivoDepartamento();
    }

    public void escribirDepartamentos() throws IOException, FileNotFoundException, ClassNotFoundException {
        //departamentoController.rellenarArchivoDepartamento(ficheroDepartamento, departamentos);
        departamentoController.EscribirElemento(departamentos);
    }

    public void insertarDepartamento(Departamento departamento) throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean insertado = comprobarpk(departamento.getCodDep());
        if (!insertado) {
            departamentos.add(departamento);
            escribirDepartamentos();
        }
    }

    public void insertarDepartamentoPosicion(Departamento departamento, int i) throws IOException, FileNotFoundException, ClassNotFoundException {
        departamentos.set(i, departamento);
        escribirDepartamentos();
    }

    public void modificarDepartamento(Departamento departamento, int posicion) throws IOException, FileNotFoundException, ClassNotFoundException {

        departamentos.set(posicion, departamento);
        /*departamentoController.LimpiarArchivo(ficheroDepartamento);
        departamentoController.rellenarArchivoDepartamento(ficheroDepartamento, departamentos);*/
    }

    public String[][] introducirDepartamento(ArrayList<Departamento> departamentos) throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[departamentos.size()][NUMERO_COLUMNAS];
        //refrescarDepartamentos();
        for (int i = 0; i < departamentos.size(); i++) {

            matriz[i][0] = departamentos.get(i).getCodDep();
            matriz[i][1] = departamentos.get(i).getNombre();
            matriz[i][2] = departamentos.get(i).getTipo();
            matriz[i][3] = departamentos.get(i).getNumeroIntegrantes();
            matriz[i][4] = departamentos.get(i).getPlanta();

        }

        return matriz;
    }

    public boolean comprobarpk(String pk) {
        boolean encontrado = false;

        for (int i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getCodDep() == pk) {
                encontrado = true;
            }
        }

        return encontrado;

    }

    public String[][] ComprobarFichero() throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[departamentos.size()][NUMERO_COLUMNAS];
        if (ficheroDepartamento.exists()) {
            refrescarDepartamentos();
            matriz = introducirDepartamento(departamentos);
        }
        return matriz;
    }

    public boolean comprobarfkDepartamento(String fk) {
        boolean encontrado = false;

        for (int i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getFk() == fk) {
                encontrado = true;
            }
        }

        return encontrado;

    }

}
