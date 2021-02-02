package modelo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Colegio implements Serializable {

    private String codigo;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigo_postal;

    public Colegio() {
        this.codigo = "";
        this.nombre = "";
        this.direccion = "";
        this.localidad = "";
        this.codigo_postal = "";
    }

    public Colegio(String codigo, String nombre, String direccion, String localidad, String codigo_postal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void CrearElemento(String datoColegio, String valor,
            Element raiz, Document document) {
        Element elem = document.createElement(datoColegio);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }

    public void EscribirElemento(ArrayList<Colegio> colegio) {

        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document
                    = implementation.createDocument(null, "colegio", null);
            document.setXmlVersion("1.0");

            for (int i = 0; i < colegio.size(); i++) {

                Element raiz
                        = document.createElement("Colegio");
                document.getDocumentElement().appendChild(raiz);

                CrearElemento("codigo", colegio.get(i).getCodigo(), raiz, document);

                CrearElemento("nombre", colegio.get(i).getNombre(), raiz, document);

                CrearElemento("direccion", colegio.get(i).getDireccion(), raiz, document);

                CrearElemento("Localidad", colegio.get(i).getLocalidad(), raiz, document);

                CrearElemento("cp", colegio.get(i).getCodigo_postal(), raiz, document);

            Source source = new DOMSource(document);
            Result result
                    = new StreamResult(new java.io.File("colegios.xml"));
            Transformer transformer
                    = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            }
        } catch (Exception e) {

        }

    }

    public ArrayList<Colegio> LeerArchivoColegio() throws SAXException, IOException, ParserConfigurationException {
        ArrayList<Colegio> auxiliar_colegio = new ArrayList<Colegio>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse("Colegios.xml");

        documento.getDocumentElement().normalize();

        NodeList listaColegio = documento.getElementsByTagName("colegio");
        System.out.println("antes del bucle");
        for (int i = 0; i < listaColegio.getLength(); i++) {
            Node nodo = listaColegio.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nodo;

                String codigo = e.getElementsByTagName("codigo").item(0).getTextContent().toString();
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent().toString();
                String direccion = e.getElementsByTagName("direccion").item(0).getTextContent().toString();
                String localidad = e.getElementsByTagName("Localidad").item(0).getTextContent().toString();
                String cp = e.getElementsByTagName("cp").item(0).getTextContent().toString();

                Colegio colegio = new Colegio(codigo, nombre, direccion, localidad, cp);

                auxiliar_colegio.add(colegio);
            }
            
        }
        System.out.println("después del bucle");
        return auxiliar_colegio;
    }

}
