package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import practicahibernate.Profesor;
import org.xml.sax.SAXException;
import practicahibernate.NewHibernateUtil;

/**
 *
 * @author crist
 */
public class ProfesorController {

    private ArrayList<Profesor> profesores;
    private String url;
    private Profesor profesorController;
    Transaction t = null;

    public ProfesorController(ArrayList<Profesor> profesor) {
        this.profesores = profesor;
    }

    public ProfesorController() throws SAXException, IOException, ParserConfigurationException {
        this.profesores = new ArrayList<Profesor>();
        profesorController = new Profesor();
        url = "bd.yap";
        refrescarProfesores();

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
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        s.beginTransaction();
        s.update(profesor);

        s.getTransaction().commit();
        refrescarProfesores();

    }

    public void refrescarProfesores() throws SAXException, IOException, ParserConfigurationException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        profesores = (ArrayList<Profesor>) s.createQuery("FROM profesor").list();
        s.close();
        
    }

    public void escribirProfesores(Profesor profesor) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.save(profesor);
        t.commit();
        s.close();
        
    }

    public String[][] introducirProfesores(ArrayList<Profesor> profesores) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        final int NUMERO_COLUMNAS = 5;
        String matriz[][] = new String[profesores.size()][NUMERO_COLUMNAS];
        refrescarProfesores();
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
            escribirProfesores(profesor);
        }
    }



    public void eliminarProfesor(String id) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        Transaction t = null;
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        String sentencia = "DELETE FROM profesor WHERE idProfesor = :criterioBorrar";

        s.beginTransaction();

        Query query = s.createQuery(sentencia);
        query.setParameter("criterioBorrar", id);

        int a = query.executeUpdate();

        System.out.println("Se afectaron " + a + " filas");
        s.getTransaction().commit();
        s.close();
        refrescarProfesores();

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
            if (profesores.get(i).getDepartamento().getIdDepartamento() == fk) {
                encontrado = true;
            }
        }

        return encontrado;

    }
    
    
    

}
