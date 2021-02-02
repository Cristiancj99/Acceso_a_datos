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
    private String url;
    private Departamento departamentoController;

    public DepartamentoController(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;

    }

    public DepartamentoController() throws SAXException, IOException, ParserConfigurationException {
        this.departamentos = new ArrayList<Departamento>();
        departamentoController = new Departamento();
        url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
        crearTabla();
        refrescarDepartamentos(url);
        if (departamentos.size() > 0) {
            departamentoController.comprobarIdTamanio(departamentos.get(departamentos.size() - 1).getId());
        }
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String getUrl() {
        return url;
    }

    public Departamento getPosicionDepartamentos(int i) {
        Departamento aux = departamentos.get(i);
        return aux;
    }

    public void eliminarDepartamento(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        departamentos = departamentoController.delete(id, url);

    }

    public void refrescarDepartamentos(String url) throws SAXException, IOException, ParserConfigurationException {
        departamentos = departamentoController.refrescarDepartamentos(url);
    }

    public void escribirDepartamentos(Departamento departamento) throws IOException, FileNotFoundException, ClassNotFoundException {
        departamentoController.insert(departamento, url);

    }

    public void insertarDepartamento(Departamento departamento) throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean insertado = comprobarpk(departamento.getCodDep());
        if (!insertado) {
            departamentos.add(departamento);
            escribirDepartamentos(departamento);
        }
    }

    public void crearTabla() {
        departamentoController.createNewTable(url);
    }

    public void modificarDepartamento(Departamento departamento, int posicion) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        int id=departamentos.get(posicion).getId();
        departamentoController.update(departamento.getCodDep(), departamento.getNombre(),departamento.getTipo(), departamento.getNumeroIntegrantes(), departamento.getPlanta(), departamento.getFk(),id, url );
        refrescarDepartamentos(url);

    }

    public String[][] introducirDepartamento(ArrayList<Departamento> departamentos) throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[departamentos.size()][NUMERO_COLUMNAS];
        //refrescarDepartamentos(url);
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

    public boolean comprobarfkDepartamento(int fk) {
        boolean encontrado = false;

        for (int i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getFk() == fk) {
                encontrado = true;
            }
        }

        return encontrado;

    }

    public int devolverId(String pk) {
        boolean encontrado = false;
        int i;
        int id = 0;
        for (i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getCodDep() == pk) {
                System.out.println("he entrado");
                id=departamentos.get(i).getId();
                encontrado = true;
            }
        }
        
        return id;

    }

    public String devolverCodigo(int pk) {
        boolean encontrado = false;
        int i;
        String codDep = null;
        for (i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getId() == pk) {
                encontrado = true;
                codDep=departamentos.get(i).getCodDep();
            }
        }
        
        
        return codDep;

    }

}
