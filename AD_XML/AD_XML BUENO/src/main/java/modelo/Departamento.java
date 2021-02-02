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

/**
 *
 * @author crist
 */
public class Departamento {

    private String codDep;
    private String nombre;
    private String tipo;
    private String numeroIntegrantes;
    private String planta;
    private String fk;

    public Departamento(String codDep, String nombre, String tipo, String numeroIntegrantes, String planta, String fk) {
        this.codDep = codDep;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroIntegrantes = numeroIntegrantes;
        this.planta = planta;
        this.fk = fk;
    }

    public Departamento() {
        this.codDep = "";
        this.nombre = "";
        this.tipo = "";
        this.numeroIntegrantes = "";
        this.planta = "";
        this.fk = "";
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroIntegrantes() {
        return numeroIntegrantes;
    }

    public void setNumeroIntegrantes(String numeroIntegrantes) {
        this.numeroIntegrantes = numeroIntegrantes;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public void CrearElemento(String datoDepartamento, String valor,
            Element raiz, Document document) {
        Element elem = document.createElement(datoDepartamento);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }

    public void EscribirElemento(ArrayList<Departamento> departamento) {

        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document
                    = implementation.createDocument(null, "Departamentos", null);
            document.setXmlVersion("1.0");

            for (int i = 0; i < departamento.size(); i++) {
                Element raiz = document.createElement("Departamento");
                document.getDocumentElement().appendChild(raiz);

                CrearElemento("codDep", departamento.get(i).getCodDep(), raiz, document);

                CrearElemento("nombre", departamento.get(i).getNombre(), raiz, document);

                CrearElemento("tipo", departamento.get(i).getTipo(), raiz, document);

                CrearElemento("numero_integrantes", departamento.get(i).getNumeroIntegrantes(), raiz, document);

                CrearElemento("planta", departamento.get(i).getPlanta(), raiz, document);

                CrearElemento("fk", departamento.get(i).getFk(), raiz, document);

                Source source = new DOMSource(document);
                Result result
                        = new StreamResult(new java.io.File("Departamentos.xml"));
                Transformer transformer
                        = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            }
        } catch (Exception e) {

        }

    }

    public ArrayList<Departamento> LeerArchivoDepartamento() throws SAXException, IOException, ParserConfigurationException {
        ArrayList<Departamento> auxiliar_departamento = new ArrayList<Departamento>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse("Departamentos.xml");

        documento.getDocumentElement().normalize();

        NodeList listaDepartamento = documento.getElementsByTagName("Departamento");

        for (int i = 0; i < listaDepartamento.getLength(); i++) {
            Node nodo = listaDepartamento.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nodo;

                String codDep = e.getElementsByTagName("codDep").item(0).getTextContent();
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                String tipo = e.getElementsByTagName("tipo").item(0).getTextContent().toString();
                String integrantes = e.getElementsByTagName("numero_integrantes").item(0).getTextContent();
                String planta = e.getElementsByTagName("planta").item(0).getTextContent();
                String fk = e.getElementsByTagName("fk").item(0).getTextContent();

                Departamento departamento = new Departamento(codDep, nombre, tipo, integrantes, planta,fk);

                auxiliar_departamento.add(departamento);
            }
        }
        return auxiliar_departamento;
    }

}
