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
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import practicahibernate.*;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class ColegioController {

    private ArrayList<Colegio> colegios;
    private String url;
    private Colegio colegioController;
    Transaction t = null;

    public ColegioController(ArrayList<Colegio> colegios) {
        this.colegios = colegios;
    }

    public ColegioController() throws IOException, ParserConfigurationException, SAXException {
        this.colegios = new ArrayList<Colegio>();
        url = "bd.yap";
        colegioController = new Colegio();

        refrescarColegios();


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

    public void refrescarColegios() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        colegios = (ArrayList<Colegio>) s.createQuery("FROM colegio").list();
        s.close();
    }

    public void escribirColegio(Colegio colegio) throws SAXException, IOException, ParserConfigurationException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.save(colegio);
        t.commit();
        s.close();

    }

    public void insertarColegio(Colegio colegio) throws SAXException, IOException, ParserConfigurationException {
        boolean insertado = comprobarpk(colegio.getCodigo());
        if (!insertado) {
            colegios.add(colegio);
            escribirColegio(colegio);
        }
    }

    public void modificarColegio(Colegio colegio, int posicion) throws SAXException, IOException, ParserConfigurationException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        s.beginTransaction();
        s.update(colegio);

        s.getTransaction().commit();
        refrescarColegios();
    }

    public void eliminarColegio(String id) throws SAXException, IOException, ParserConfigurationException {

        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        String sentencia = "DELETE FROM colegio WHERE id_sede = :criterioBorrar";

        s.beginTransaction();

        Query query = s.createQuery(sentencia);
        query.setParameter("criterioBorrar", id);

        int a = query.executeUpdate();

        System.out.println("Se afectaron " + a + " filas");
        s.getTransaction().commit();
        s.close();
        refrescarColegios();

    }

    public String[][] introducirColegios(ArrayList<Colegio> colegios) throws SAXException, IOException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[colegios.size()][NUMERO_COLUMNAS];
        refrescarColegios();
        for (int i = 0; i < colegios.size(); i++) {

            matriz[i][0] = colegios.get(i).getCodigo();
            matriz[i][1] = colegios.get(i).getNombre();
            matriz[i][2] = colegios.get(i).getProvincia();
            matriz[i][3] = colegios.get(i).getDireccion();
            matriz[i][4] = colegios.get(i).getCodigoPostal();

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
                id = colegios.get(i).getIdColegio();
            }
        }

        return id;

    }

    public String devolverCodigo(int pk) {
        boolean encontrado = false;
        int i;
        String cadena = null;
        for (i = 0; (i < colegios.size() && !encontrado); i++) {
            if (colegios.get(i).getIdColegio() == pk) {
                encontrado = true;
                cadena = colegios.get(i).getCodigo();
            }
        }

        return cadena;

    }
        public Colegio devolverColegio(int pk) {
        boolean encontrado = false;
        int i;
        Colegio aux = new Colegio();
        for (i = 0; (i < colegios.size() && !encontrado); i++) {
            if (colegios.get(i).getIdColegio() == pk) {
                encontrado = true;
                aux=colegios.get(i);
            }
        }

        return aux;

    }
}
