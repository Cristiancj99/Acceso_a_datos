/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public class Profesor{
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String fk;

    public Profesor(String dni, String nombre, String apellido, String fechaNacimiento, String sexo, String fk) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fk=fk;
    }

    public Profesor() {
        this.dni = "";
        this.nombre ="";
        this.apellido = "";
        this.fechaNacimiento = "";
        this.sexo = "";  
        this.fk="";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void CrearElemento(String datoProfesor, String valor,
        Element raiz, Document document) {
        Element elem = document.createElement(datoProfesor);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
    
    public void EscribirElemento(ArrayList<Profesor> profesor){


        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();

        try {
            System.out.println("insertando usuario");
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document
                    = implementation.createDocument(null, "profesores", null);
            document.setXmlVersion("1.0");
             for(int i=0;i<profesor.size();i++){
                    Element raiz
                            = document.createElement("Profesor"); 
                    document.getDocumentElement().appendChild(raiz);
                      
                    CrearElemento("DNI", profesor.get(i).getDni(), raiz, document);
                    CrearElemento("nombre", profesor.get(i).getNombre(), raiz, document);
                    
                    CrearElemento("apellido", profesor.get(i).getApellido(), raiz, document);
                    
                    CrearElemento("fecha_nacimiento", profesor.get(i).getFechaNacimiento(), raiz,document);                   

                    CrearElemento("sexo", profesor.get(i).getSexo(), raiz,document);              
                    CrearElemento("fk", profesor.get(i).getFk(), raiz,document);     

            Source source = new DOMSource(document);
            
            Result result
                    = new StreamResult(new java.io.File("profesores.xml"));
            Transformer transformer
                    = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
                System.out.println("final usuario");
             }
             } catch (ParserConfigurationException | TransformerException | DOMException e) {

        }
        

    }
    public ArrayList<Profesor> LeerArchivoProfesor() throws SAXException, IOException, ParserConfigurationException{
        
        
        ArrayList <Profesor> auxiliar_profesor=new ArrayList<Profesor>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document documento = builder.parse("profesores.xml");
       
        documento.getDocumentElement().normalize();
        
        NodeList listaProfesor = documento.getElementsByTagName("Profesor");
        
        for(int i = 0; i < listaProfesor.getLength(); i++){
            Node nodo = listaProfesor.item(i);
            
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element e  = (Element) nodo;
                
                String dni = e.getElementsByTagName("DNI").item(0).getTextContent().toString();
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent().toString();
                String apellido = e.getElementsByTagName("apellido").item(0).getTextContent().toString();              
                String fecha_nacimiento = e.getElementsByTagName("fecha_nacimiento").item(0).getTextContent().toString();
                String sexo = e.getElementsByTagName("sexo").item(0).getTextContent().toString();
                String fk = e.getElementsByTagName("fk").item(0).getTextContent().toString();

                
                Profesor profesor = new Profesor(dni, nombre, apellido, fecha_nacimiento, sexo, fk);
                
                auxiliar_profesor.add(profesor);
            }
        }
    return auxiliar_profesor;
    }

}     
    
