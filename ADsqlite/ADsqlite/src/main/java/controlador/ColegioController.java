/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.*;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class ColegioController {

    private ArrayList<Colegio> colegios;
    private String url;
    private Colegio colegioController;

    public ColegioController(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }

    public ColegioController() throws IOException, ParserConfigurationException, SAXException {
        this.colegios = new ArrayList<Colegio>();
        url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
        colegioController = new Colegio();
        crearTabla();
        refrescarColegios(url);
        if (colegios.size() > 0) {
            System.out.println(colegios.size());
            colegioController.comprobarIdTamanio(colegios.get(colegios.size() - 1).getId());
        }

    }

    public ArrayList<Colegio> getColegios() {
        return colegios;
    }

    public String getUrl() {
        return url;
    }

    public void setColegios(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }

    public Colegio getPosicionColegios(int i) {
        return colegios.get(i);
    }

    public void refrescarColegios(String url1) throws SAXException, IOException, ParserConfigurationException {
        colegios = colegioController.refrescarColegios(url);
    }

    public void escribirColegio(Colegio colegio) {
        colegioController.insert(colegio, url);

    }

    public void insertarColegio(Colegio colegio) {
        boolean insertado = comprobarpk(colegio.getCodigo());
        if (!insertado) {
            colegios.add(colegio);
            escribirColegio(colegio);
        }
    }

    public void modificarColegio(Colegio colegio, int posicion) throws SAXException, IOException, ParserConfigurationException {
        int id=colegios.get(posicion).getId();
        colegios=colegioController.update(colegio, url, id);
        refrescarColegios(url);
        
        
    }

    public void eliminarColegio(int id) {
        colegios = colegioController.delete(id, url);

    }

    public void crearTabla() {
        colegioController.createNewTable(url);
    }

    public String[][] introducirColegios(ArrayList<Colegio> colegios) throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[colegios.size()][NUMERO_COLUMNAS];
        refrescarColegios(url);
        for (int i = 0; i < colegios.size(); i++) {

            matriz[i][0] = colegios.get(i).getCodigo();
            matriz[i][1] = colegios.get(i).getNombre();
            matriz[i][2] = colegios.get(i).getLocalidad();
            matriz[i][3] = colegios.get(i).getDireccion();
            matriz[i][4] = colegios.get(i).getCodigo_postal();

        }

        return matriz;
    }

    public boolean comprobarpk(String pk) {
        boolean encontrado = false;

        for (int i = 0; (i < colegios.size() && !encontrado); i++) {
            if (colegios.get(i).getCodigo() == pk) {
                encontrado = true;
            }
        }

        return encontrado;

    }

    public int devolverId(String pk) {
        boolean encontrado = false;
        int i;
        int id = 0;
        for (i = 0; (i < colegios.size() && !encontrado); i++) {
            if (colegios.get(i).getCodigo() == pk) {
                encontrado = true;
                id=colegios.get(i).getId();
            }
        }
        
        return id;

    }

    public String devolverCodigo(int pk) {
        boolean encontrado = false;
        int i;
        String cadena = null;
        for (i = 0; (i < colegios.size() && !encontrado); i++) {
            if (colegios.get(i).getId() == pk) {
                encontrado = true;
                 cadena=colegios.get(i).getCodigo();
            }
        }
        
        return cadena;

    }
}
