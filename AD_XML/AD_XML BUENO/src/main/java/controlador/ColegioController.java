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
import modelo.*;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class ColegioController {

    private ArrayList<Colegio> colegios;
    private File ficheroColegio;
    private Colegio colegioController;
    
    

    public ColegioController(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }

    public ColegioController() {
        this.colegios = new ArrayList<Colegio>();
        colegioController = new Colegio();
        ficheroColegio = new File("Colegios.xml");
    }

    public ArrayList<Colegio> getColegios() {
        return colegios;
    }

    public void setColegios(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }

    public Colegio getPosicionColegios(int i) {
        return colegios.get(i);
    }

    public void refrescarColegios() throws SAXException, IOException, ParserConfigurationException {
        colegios= colegioController.LeerArchivoColegio();
    }


    public String[][] ComprobarFichero() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        String matriz[][] = new String[colegios.size()][5];
        if (ficheroColegio.exists()) {
            refrescarColegios();
            matriz = introducirColegios(colegios);
        }
        return matriz;

    }
    public void escribirColegio()  {
        colegioController.EscribirElemento(colegios);

    }

    public void insertarColegio(Colegio colegio)  {
        boolean insertado = comprobarpk(colegio.getCodigo());
        if (!insertado) {
            colegios.add(colegio);
            escribirColegio();
        }
    }

    public void insertarColegioPosicion(Colegio colegio, int i)  {
        colegios.set(i, colegio);
        escribirColegio();
    }

    public void modificarColegio(Colegio colegio, int posicion) {

        colegios.set(posicion, colegio);
        escribirColegio();
    }

    public void eliminarColegio(int posicion) throws IOException, FileNotFoundException, ClassNotFoundException {
        colegios.remove(posicion);
        escribirColegio(); 

        

    }

    public String[][] introducirColegios(ArrayList<Colegio> colegios) throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[colegios.size()][NUMERO_COLUMNAS];
        //refrescarColegios();
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

}
