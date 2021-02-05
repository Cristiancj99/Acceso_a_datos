/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Query;
import org.hibernate.Session;
import practicahibernate.Departamento;
import org.hibernate.Transaction;
import org.xml.sax.SAXException;
import practicahibernate.NewHibernateUtil;

/**
 *
 * @author crist
 */
public class DepartamentoController {

    private ArrayList<Departamento> departamentos;
    private String url;
    private Departamento departamentoController;
    Transaction t = null;

    public DepartamentoController(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;

    }

    public DepartamentoController() throws SAXException, IOException, ParserConfigurationException {
        this.departamentos = new ArrayList<Departamento>();
        departamentoController = new Departamento();
        url = "bd.yap";
        refrescarDepartamentos();

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

    public void eliminarDepartamento(String id) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        String sentencia = "DELETE FROM departamento WHERE id_departamento = :criterioBorrar";

        s.beginTransaction();

        Query query = s.createQuery(sentencia);
        query.setParameter("criterioBorrar", id);

        int a = query.executeUpdate();

        System.out.println("Se afectaron " + a + " filas");
        s.getTransaction().commit();
        s.close();
        refrescarDepartamentos();
    }

    public void refrescarDepartamentos() throws SAXException, IOException, ParserConfigurationException {
       Session s = NewHibernateUtil.getSessionFactory().openSession();

        departamentos = (ArrayList<Departamento>) s.createQuery("FROM departamento").list();
        s.close();
    }

    public void escribirDepartamentos(Departamento departamento) throws IOException, FileNotFoundException, ClassNotFoundException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.save(departamento);
        t.commit();
        s.close();

    }

    public void insertarDepartamento(Departamento departamento) throws IOException, FileNotFoundException, ClassNotFoundException {
        boolean insertado = comprobarpk(departamento.getCodDep());
        if (!insertado) {
            departamentos.add(departamento);
            escribirDepartamentos(departamento);
        }
    }

    public void modificarDepartamento(Departamento departamento, int posicion) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        s.beginTransaction();
        s.update(departamento);

        s.getTransaction().commit();
        refrescarDepartamentos();

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
            matriz[i][4] = departamentos.get(i).getPlantaLocalizacion();

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
            if (departamentos.get(i).getColegio().getIdColegio() == fk) {
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
                id = departamentos.get(i).getIdDepartamento();
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
            if (departamentos.get(i).getIdDepartamento() == pk) {
                encontrado = true;
                codDep = departamentos.get(i).getCodDep();
            }
        }

        return codDep;

    }
    public Departamento devolverDepartamento(int pk) {
        boolean encontrado = false;
        int i;
        Departamento aux = new Departamento();
        for (i = 0; (i < departamentos.size() && !encontrado); i++) {
            if (departamentos.get(i).getIdDepartamento() == pk) {
                encontrado = true;
                aux=departamentos.get(i);
            }
        }

        return aux;

    }
}
