/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adXML;

import controlador.ColegioController;
import controlador.DepartamentoController;
import controlador.ProfesorController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Colegio;
import modelo.Departamento;
import modelo.Profesor;
import org.xml.sax.SAXException;

/**
 *
 * @author crist
 */
public final class Vista extends javax.swing.JFrame {

    final int NUMERO_COLUMNAS = 5;
    private ColegioController colegio;
    private DepartamentoController departamento;
    private ProfesorController profesores;
    DefaultTableModel modelo = new DefaultTableModel();
    boolean modificar_activado = false;
    
    public Vista() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
        colegio = new ColegioController();
        departamento = new DepartamentoController();
        profesores = new ProfesorController();
        initComponents();
        aceptar_departamento.setVisible(false);
        eliminar_departamento.setVisible(false);
        boton_aceptar.setVisible(false);
        boton_eliminar.setVisible(false);
        texto_cp.setEditable(false);
        texto_codigo.setEditable(false);
        texto_nombre.setEditable(false);
        texto_provincia.setEditable(false);
        texto_direccion.setEditable(false);
        text_CodDep.setEditable(false);
        texto_nombreD.setEditable(false);
        texto_tipo.setEditable(false);
        texto_numero_integrantes.setEditable(false);
        texto_planta.setEditable(false);
        boton_aceptarProfesor.setVisible(false);
        boton_eliminarProfesor.setVisible(false);
        texto_dni.setEditable(false);
        texto_nombreP.setEditable(false);
        texto_apellido.setEditable(false);
        texto_fecha_nacimiento.setEditable(false);
        texto_sexo.setEditable(false);
        textofk_departamento.setEditable(false);
        textoFK_profesor.setEditable(false);
        //refrescar_tabla(colegio.ComprobarFichero());
        //refrescar_tabla_departamento(departamento.ComprobarFichero());
        colegio.crearTabla();

        refrescar_tabla(colegio.introducirColegios(colegio.getColegios()));
        departamento.crearTabla();

        refrescar_tabla_departamento(departamento.introducirDepartamento(departamento.getDepartamentos()));
        profesores.crearTabla();
        refrescar_tabla_profesor(profesores.introducirProfesores(profesores.getProfesor()));
        actualizarFKdepartamento(colegio);
        
        actualizarFKprofesor(departamento);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        text_CodDep = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        texto_planta = new javax.swing.JTextField();
        texto_nombreD = new javax.swing.JTextField();
        texto_numero_integrantes = new javax.swing.JTextField();
        texto_tipo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_departamento = new javax.swing.JTable();
        insertar_departamento = new javax.swing.JButton();
        modificar_departamento = new javax.swing.JButton();
        borrar_departamento = new javax.swing.JButton();
        eliminar_departamento = new javax.swing.JButton();
        aceptar_departamento = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        fkDepartamento = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        textofk_departamento = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_profesor = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        texto_dni = new javax.swing.JTextField();
        texto_nombreP = new javax.swing.JTextField();
        texto_apellido = new javax.swing.JTextField();
        texto_fecha_nacimiento = new javax.swing.JTextField();
        texto_sexo = new javax.swing.JTextField();
        boton_insertarProfesor = new javax.swing.JButton();
        boton_modificarProfesor = new javax.swing.JButton();
        boton_borrarProfesor = new javax.swing.JButton();
        boton_aceptarProfesor = new javax.swing.JButton();
        boton_eliminarProfesor = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        fkProfesor = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        textoFK_profesor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        texto_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        texto_provincia = new javax.swing.JTextField();
        texto_nombre = new javax.swing.JTextField();
        texto_cp = new javax.swing.JTextField();
        texto_direccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_colegio = new javax.swing.JTable();
        boton_insertar = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();
        boton_borrar = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        boton_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setText("cod_dep");

        text_CodDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_CodDepActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre");

        jLabel13.setText("Planta localicacion");

        jLabel14.setText("Tipo");

        jLabel15.setText("Integrantes");

        texto_planta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_plantaActionPerformed(evt);
            }
        });

        texto_nombreD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nombreDActionPerformed(evt);
            }
        });

        texto_numero_integrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_numero_integrantesActionPerformed(evt);
            }
        });

        texto_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_tipoActionPerformed(evt);
            }
        });

        tabla_departamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_departamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_departamento);

        insertar_departamento.setText("Insertar");
        insertar_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_departamentoActionPerformed(evt);
            }
        });

        modificar_departamento.setText("Modificar");
        modificar_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_departamentoActionPerformed(evt);
            }
        });

        borrar_departamento.setText("Borrar");
        borrar_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_departamentoActionPerformed(evt);
            }
        });

        eliminar_departamento.setText("Eliminar");
        eliminar_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_departamentoActionPerformed(evt);
            }
        });

        aceptar_departamento.setText("Aceptar");
        aceptar_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_departamentoActionPerformed(evt);
            }
        });

        jLabel16.setText("Colegio:");

        fkDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fkDepartamentoActionPerformed(evt);
            }
        });

        jLabel19.setText("Codigo colegio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(insertar_departamento)
                        .addGap(76, 76, 76)
                        .addComponent(modificar_departamento)
                        .addGap(71, 71, 71)
                        .addComponent(borrar_departamento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fkDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(aceptar_departamento)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel15))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(texto_nombreD, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text_CodDep, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(texto_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(texto_planta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(eliminar_departamento)
                                        .addComponent(texto_numero_integrantes)
                                        .addComponent(textofk_departamento, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(text_CodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(texto_nombreD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(texto_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(texto_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(texto_numero_integrantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(textofk_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fkDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertar_departamento)
                    .addComponent(modificar_departamento)
                    .addComponent(borrar_departamento)
                    .addComponent(aceptar_departamento)
                    .addComponent(eliminar_departamento))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Departamento", jPanel2);

        tabla_profesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_profesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_profesorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_profesor);

        jLabel6.setText("DNI");

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellidos");

        jLabel9.setText("Fecha nacimiento");

        jLabel10.setText("Sexo");

        texto_nombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nombrePActionPerformed(evt);
            }
        });

        boton_insertarProfesor.setText("Insertar");
        boton_insertarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_insertarProfesorActionPerformed(evt);
            }
        });

        boton_modificarProfesor.setText("Modificar");
        boton_modificarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarProfesorActionPerformed(evt);
            }
        });

        boton_borrarProfesor.setText("Borrar");
        boton_borrarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrarProfesorActionPerformed(evt);
            }
        });

        boton_aceptarProfesor.setText("Aceptar");
        boton_aceptarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarProfesorActionPerformed(evt);
            }
        });

        boton_eliminarProfesor.setText("Eliminar");
        boton_eliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarProfesorActionPerformed(evt);
            }
        });

        jLabel17.setText("Departamento");

        fkProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fkProfesorActionPerformed(evt);
            }
        });

        jLabel18.setText("Cod_Dep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(boton_insertarProfesor)
                        .addGap(85, 85, 85)
                        .addComponent(boton_modificarProfesor)
                        .addGap(77, 77, 77)
                        .addComponent(boton_borrarProfesor)
                        .addGap(83, 83, 83)
                        .addComponent(boton_aceptarProfesor))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(texto_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(83, 83, 83)
                                    .addComponent(boton_eliminarProfesor))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18)
                                    .addComponent(fkProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(texto_apellido))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(texto_dni, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(texto_nombreP)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textoFK_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(texto_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(texto_nombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(texto_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(texto_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(texto_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(textoFK_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fkProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_modificarProfesor)
                    .addComponent(boton_insertarProfesor)
                    .addComponent(boton_borrarProfesor)
                    .addComponent(boton_aceptarProfesor)
                    .addComponent(boton_eliminarProfesor))
                .addGap(77, 77, 77))
        );

        jTabbedPane1.addTab("Profesor", jPanel3);

        jLabel1.setText("Codigo");

        texto_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_codigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Provincia");

        jLabel4.setText("Direccion");

        jLabel5.setText("Codigo postal");

        texto_provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_provinciaActionPerformed(evt);
            }
        });

        texto_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nombreActionPerformed(evt);
            }
        });

        texto_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_cpActionPerformed(evt);
            }
        });

        texto_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_direccionActionPerformed(evt);
            }
        });

        tabla_colegio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_colegio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_colegioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_colegio);

        boton_insertar.setText("Insertar");
        boton_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_insertarActionPerformed(evt);
            }
        });

        boton_modificar.setText("Modificar");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        boton_borrar.setText("Borrar");
        boton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrarActionPerformed(evt);
            }
        });

        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        boton_aceptar.setText("Aceptar");
        boton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texto_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(boton_insertar)
                .addGap(76, 76, 76)
                .addComponent(boton_modificar)
                .addGap(71, 71, 71)
                .addComponent(boton_borrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_aceptar)
                .addGap(27, 27, 27)
                .addComponent(boton_eliminar)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(texto_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(texto_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(texto_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_aceptar)
                    .addComponent(boton_eliminar))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_insertar)
                    .addComponent(boton_modificar)
                    .addComponent(boton_borrar))
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("Colegio", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texto_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_codigoActionPerformed

    private void texto_provinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_provinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_provinciaActionPerformed

    private void texto_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nombreActionPerformed

    private void texto_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_cpActionPerformed

    private void texto_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_direccionActionPerformed

    private void tabla_colegioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_colegioMouseClicked
        mostrarTupla(tabla_colegio.getSelectedRow());
    }//GEN-LAST:event_tabla_colegioMouseClicked

    private void boton_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_insertarActionPerformed
        boton_aceptar.setVisible(true);
        boton_eliminar.setVisible(true);

        texto_codigo.setEditable(true);
        texto_nombre.setEditable(true);
        texto_provincia.setEditable(true);
        texto_direccion.setEditable(true);
        texto_cp.setEditable(true);
        modificar_activado = false;

    }//GEN-LAST:event_boton_insertarActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        int posicion;

        boton_aceptar.setVisible(true);
        boton_eliminar.setVisible(true);
        texto_codigo.setEditable(true);
        texto_nombre.setEditable(true);
        texto_provincia.setEditable(true);
        texto_direccion.setEditable(true);
        texto_cp.setEditable(true);
        posicion = tabla_colegio.getSelectedRow();
        modificar_activado = true;
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void boton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrarActionPerformed
        int posicion;
        String matriz[][] = new String[colegio.getColegios().size() + 1][NUMERO_COLUMNAS];

        boton_aceptar.setVisible(false);
        boton_eliminar.setVisible(false);

        texto_codigo.setEditable(false);
        texto_nombre.setEditable(false);
        texto_provincia.setEditable(false);
        texto_direccion.setEditable(false);
        texto_cp.setEditable(false);
        posicion = tabla_colegio.getSelectedRow();

        if(!departamento.comprobarfkDepartamento(colegio.getPosicionColegios(posicion).getId())){
            colegio.eliminarColegio(colegio.getPosicionColegios(posicion).getId());
        }
        else{
            JOptionPane.showMessageDialog(this, "Lo sentimos...No puedes eliminar un colegio con departamentos previamente asignados");
        }
        try {
            matriz = colegio.introducirColegios(colegio.getColegios());
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        refrescar_tabla(matriz);
    }//GEN-LAST:event_boton_borrarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        texto_codigo.setText("");
        texto_nombre.setText("");
        texto_provincia.setText("");
        texto_direccion.setText("");
        texto_cp.setText("");    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void boton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarActionPerformed
        String matriz[][] = new String[colegio.getColegios().size() + 1][NUMERO_COLUMNAS];

        if (!modificar_activado) {
            Colegio introducir = new Colegio(texto_codigo.getText(), texto_nombre.getText(), texto_provincia.getText(), texto_direccion.getText(), texto_cp.getText());
            colegio.insertarColegio(introducir);
            try {
                matriz = colegio.introducirColegios(colegio.getColegios());
            } catch (IOException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            refrescar_tabla(matriz);


        }
        this.DesactivarFunciones();
        if (modificar_activado) {
            int posicion = tabla_colegio.getSelectedRow();
            Colegio introducir = new Colegio(texto_codigo.getText(), texto_nombre.getText(), texto_provincia.getText(), texto_direccion.getText(), texto_cp.getText());
            System.out.println(texto_codigo.getText() + texto_nombre.getText() + texto_provincia.getText() + texto_direccion.getText() + texto_cp.getText());
            try {
                colegio.modificarColegio(introducir, posicion);
            } catch (SAXException | IOException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                matriz = colegio.introducirColegios(colegio.getColegios());
            } catch (IOException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            refrescar_tabla(matriz);
            modificar_activado = false;

        }
        actualizarFKdepartamento(colegio);
        this.DesactivarFunciones();
        this.limpiar_campos();

    }//GEN-LAST:event_boton_aceptarActionPerformed

    private void tabla_profesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_profesorMouseClicked
        mostrarTuplaProfesor(tabla_profesor.getSelectedRow());
    }//GEN-LAST:event_tabla_profesorMouseClicked

    private void texto_nombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nombrePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nombrePActionPerformed

    private void boton_insertarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_insertarProfesorActionPerformed
        boton_aceptarProfesor.setVisible(true);
        boton_eliminarProfesor.setVisible(true);
        texto_dni.setEditable(true);
        texto_nombreP.setEditable(true);
        texto_apellido.setEditable(true);
        texto_fecha_nacimiento.setEditable(true);
        texto_sexo.setEditable(true);
        modificar_activado = false;
    }//GEN-LAST:event_boton_insertarProfesorActionPerformed

    private void boton_modificarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarProfesorActionPerformed
        int posicion;
        boton_aceptarProfesor.setVisible(true);
        boton_eliminarProfesor.setVisible(true);
        texto_dni.setEditable(true);
        texto_nombreP.setEditable(true);
        texto_apellido.setEditable(true);
        texto_fecha_nacimiento.setEditable(true);
        texto_sexo.setEditable(true);
        posicion = tabla_profesor.getSelectedRow();
        modificar_activado = true;    }//GEN-LAST:event_boton_modificarProfesorActionPerformed

    private void boton_borrarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrarProfesorActionPerformed
        int posicion;
        String matriz[][] = new String[profesores.getProfesor().size() + 1][NUMERO_COLUMNAS];
        DesactivarFuncionesProfesores();
        posicion = tabla_profesor.getSelectedRow();
        try {
            System.out.println(profesores.getPosicionProfesores(posicion).getId());
            profesores.eliminarProfesor(profesores.getPosicionProfesores(posicion).getId());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            matriz = profesores.introducirProfesores(profesores.getProfesor());
        } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        refrescar_tabla_profesor(matriz);
    }//GEN-LAST:event_boton_borrarProfesorActionPerformed

    private void boton_aceptarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarProfesorActionPerformed
        String matriz[][] = new String[profesores.getProfesor().size() + 1][NUMERO_COLUMNAS];

        if (!modificar_activado) {
            Profesor introducir = new Profesor(texto_dni.getText(), texto_nombreP.getText(), texto_apellido.getText(), texto_fecha_nacimiento.getText(), texto_sexo.getText(), departamento.devolverId(fkProfesor.getSelectedItem().toString()));
            try {
                profesores.insertarProfesor(introducir);
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                matriz = profesores.introducirProfesores(profesores.getProfesor());
            } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            refrescar_tabla_profesor(matriz);

        }
        this.DesactivarFuncionesProfesores();
        if (modificar_activado) {
            int posicion = tabla_profesor.getSelectedRow();
            Profesor introducir = new Profesor(texto_dni.getText(), texto_nombreP.getText(), texto_apellido.getText(), texto_fecha_nacimiento.getText(), texto_sexo.getText(), departamento.devolverId(fkProfesor.getSelectedItem().toString()));
            try {
                profesores.modificarProfesor(introducir, posicion);
            } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                matriz = profesores.introducirProfesores(profesores.getProfesor());
            } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            refrescar_tabla_profesor(matriz);
            modificar_activado = false;

        }
        this.DesactivarFuncionesProfesores();
        this.limpiar_campos_profesor();

    }//GEN-LAST:event_boton_aceptarProfesorActionPerformed

    private void boton_eliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarProfesorActionPerformed
        limpiar_campos_profesor();
    }//GEN-LAST:event_boton_eliminarProfesorActionPerformed

    private void text_CodDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_CodDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_CodDepActionPerformed

    private void texto_plantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_plantaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_plantaActionPerformed

    private void texto_nombreDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nombreDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nombreDActionPerformed

    private void texto_numero_integrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_numero_integrantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_numero_integrantesActionPerformed

    private void texto_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_tipoActionPerformed

    private void tabla_departamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_departamentoMouseClicked
        mostrarTuplaDepartamento(tabla_departamento.getSelectedRow());
    }//GEN-LAST:event_tabla_departamentoMouseClicked

    private void insertar_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_departamentoActionPerformed
        aceptar_departamento.setVisible(true);
        eliminar_departamento.setVisible(true);

        text_CodDep.setEditable(true);
        texto_nombreD.setEditable(true);
        texto_tipo.setEditable(true);
        texto_numero_integrantes.setEditable(true);
        texto_planta.setEditable(true);
        modificar_activado = false;
    }//GEN-LAST:event_insertar_departamentoActionPerformed

    private void modificar_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_departamentoActionPerformed
        int posicion;
        modificar_activado = true;
        aceptar_departamento.setVisible(true);
        eliminar_departamento.setVisible(true);
        text_CodDep.setEditable(true);
        texto_nombreD.setEditable(true);
        texto_tipo.setEditable(true);
        texto_numero_integrantes.setEditable(true);
        texto_planta.setEditable(true);    }//GEN-LAST:event_modificar_departamentoActionPerformed

    private void borrar_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_departamentoActionPerformed
        int posicion;
        String matriz[][] = new String[departamento.getDepartamentos().size() + 1][NUMERO_COLUMNAS];
        DesactivarFuncionesDepatamento();
        posicion = tabla_departamento.getSelectedRow();
        try {
            if(!profesores.comprobarfkProfesores(departamento.getPosicionDepartamentos(posicion).getId()) ){

               departamento.eliminarDepartamento(departamento.getPosicionDepartamentos(posicion).getId()); 
            }
            
            else{
                JOptionPane.showMessageDialog(this, "Lo sentimos...No puedes eliminar un departamento con profesores previamente asignados");
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            matriz = departamento.introducirDepartamento(departamento.getDepartamentos());
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        refrescar_tabla_departamento(matriz);
    }//GEN-LAST:event_borrar_departamentoActionPerformed

    private void eliminar_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_departamentoActionPerformed
        limpiar_campos_departamento();
    }//GEN-LAST:event_eliminar_departamentoActionPerformed

    private void aceptar_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_departamentoActionPerformed
               String matriz[][] = new String[departamento.getDepartamentos().size() + 1][NUMERO_COLUMNAS];

        if (!modificar_activado) {
            Departamento introducir = new Departamento(text_CodDep.getText(), texto_nombreD.getText(), texto_tipo.getText(), texto_numero_integrantes.getText(), texto_planta.getText(), colegio.devolverId(fkDepartamento.getSelectedItem().toString()));
            try {
                departamento.insertarDepartamento(introducir);
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                matriz = departamento.introducirDepartamento(departamento.getDepartamentos());
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }      catch (SAXException ex) {
                       Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (ParserConfigurationException ex) {
                       Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                   }
            refrescar_tabla_departamento(matriz);

            

        }
        this.DesactivarFuncionesProfesores();
    
        if (modificar_activado) {
            int posicion = tabla_departamento.getSelectedRow();
            Departamento introducir = new Departamento(text_CodDep.getText(), texto_nombreD.getText(), texto_tipo.getText(), texto_numero_integrantes.getText(), texto_planta.getText(), colegio.devolverId(fkDepartamento.getSelectedItem().toString()));
                   try {
                       departamento.modificarDepartamento(introducir, posicion);

                   } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
                       Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                   }
            try {
                matriz = departamento.introducirDepartamento(departamento.getDepartamentos());
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }      catch (SAXException ex) {
                       Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (ParserConfigurationException ex) {
                       Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                   }
            refrescar_tabla_departamento(matriz);
            modificar_activado = false;

        }
        actualizarFKprofesor(departamento);
        this.DesactivarFuncionesDepatamento();
        this.limpiar_campos_departamento();

    
    }//GEN-LAST:event_aceptar_departamentoActionPerformed

    private void fkDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fkDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fkDepartamentoActionPerformed

    private void fkProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fkProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fkProfesorActionPerformed

    /**
     * @param args the command line arguments
     */
    public void refrescar_tabla(String tabla[][]) {
        tabla_colegio.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "codigo", "Nombre", "provincia", "direccion", "CP"
                }
        ));
    }

    public void refrescar_tabla_departamento(String tabla[][]) {
        tabla_departamento.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "codigo departamento", "Nombre", "tipo", "integrantes", "planta"
                }
        ));
    }

    public void refrescar_tabla_profesor(String tabla[][]) {
        tabla_profesor.setModel(new javax.swing.table.DefaultTableModel(
                tabla,
                new String[]{
                    "DNI", "Nombre", "Apellido", "Fecha nacimiento", "Sexo"
                }
        ));
    }

    public void limpiar_campos() {
        texto_codigo.setText("");
        texto_nombre.setText("");
        texto_provincia.setText("");
        texto_direccion.setText("");
        texto_cp.setText("");
    }

    public void limpiar_campos_departamento() {
        text_CodDep.setText("");
        texto_nombreD.setText("");
        texto_tipo.setText("");
        texto_numero_integrantes.setText("");
        texto_planta.setText("");
    }

    public void limpiar_campos_profesor() {
        texto_dni.setText("");
        texto_nombreP.setText("");
        texto_apellido.setText("");
        texto_fecha_nacimiento.setText("");
        texto_sexo.setText("");
    }

    public void mostrarTuplaDepartamento(int i) {
        text_CodDep.setText(departamento.getPosicionDepartamentos(i).getCodDep());
        texto_nombreD.setText(departamento.getPosicionDepartamentos(i).getNombre());
        texto_tipo.setText(departamento.getPosicionDepartamentos(i).getTipo());
        texto_numero_integrantes.setText(departamento.getPosicionDepartamentos(i).getNumeroIntegrantes());
        texto_planta.setText(departamento.getPosicionDepartamentos(i).getPlanta());
        textofk_departamento.setText(colegio.devolverCodigo(departamento.getPosicionDepartamentos(i).getFk()));

    }

    public void mostrarTuplaProfesor(int i) {
        texto_dni.setText(profesores.getPosicionProfesores(i).getDni());
        texto_nombreP.setText(profesores.getPosicionProfesores(i).getNombre());
        texto_apellido.setText(profesores.getPosicionProfesores(i).getApellido());
        texto_fecha_nacimiento.setText(profesores.getPosicionProfesores(i).getFechaNacimiento());
        texto_sexo.setText(profesores.getPosicionProfesores(i).getSexo());
        textoFK_profesor.setText(departamento.devolverCodigo(profesores.getPosicionProfesores(i).getFk()));

    }

    public void mostrarTupla(int i) {
        texto_codigo.setText(colegio.getPosicionColegios(i).getCodigo());
        texto_nombre.setText(colegio.getPosicionColegios(i).getNombre());
        texto_provincia.setText(colegio.getPosicionColegios(i).getLocalidad());
        texto_direccion.setText(colegio.getPosicionColegios(i).getDireccion());
        texto_cp.setText(colegio.getPosicionColegios(i).getCodigo_postal());

    }

    public void DesactivarFunciones() {
        boton_aceptar.setVisible(false);
        boton_eliminar.setVisible(false);
        texto_codigo.setEditable(false);
        texto_nombre.setEditable(false);
        texto_provincia.setEditable(false);
        texto_direccion.setEditable(false);
        texto_cp.setEditable(false);

    }

    public void DesactivarFuncionesDepatamento() {
        aceptar_departamento.setVisible(false);
        eliminar_departamento.setVisible(false);
        text_CodDep.setEditable(false);
        texto_nombreD.setEditable(false);
        texto_tipo.setEditable(false);
        texto_numero_integrantes.setEditable(false);
        texto_planta.setEditable(false);

    }

    public void DesactivarFuncionesProfesores() {
        boton_aceptarProfesor.setVisible(false);
        boton_eliminarProfesor.setVisible(false);
        texto_dni.setEditable(false);
        texto_nombreP.setEditable(false);
        texto_apellido.setEditable(false);
        texto_fecha_nacimiento.setEditable(false);
        texto_sexo.setEditable(false);

    }
    public void actualizarFKdepartamento(ColegioController colegio){
        fkDepartamento.removeAllItems();
        for (int i=0;i<colegio.getColegios().size();i++){
            fkDepartamento.addItem(colegio.getPosicionColegios(i).getCodigo());
        }
    }
    public void actualizarFKprofesor(DepartamentoController departamento){
        fkProfesor.removeAllItems();
        for (int i=0;i<departamento.getDepartamentos().size();i++){
            fkProfesor.addItem(departamento.getPosicionDepartamentos(i).getCodDep());
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Vista().setVisible(true);
                } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar_departamento;
    private javax.swing.JButton borrar_departamento;
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_aceptarProfesor;
    private javax.swing.JButton boton_borrar;
    private javax.swing.JButton boton_borrarProfesor;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_eliminarProfesor;
    private javax.swing.JButton boton_insertar;
    private javax.swing.JButton boton_insertarProfesor;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton boton_modificarProfesor;
    private javax.swing.JButton eliminar_departamento;
    private javax.swing.JComboBox<String> fkDepartamento;
    private javax.swing.JComboBox<String> fkProfesor;
    private javax.swing.JButton insertar_departamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modificar_departamento;
    private javax.swing.JTable tabla_colegio;
    private javax.swing.JTable tabla_departamento;
    private javax.swing.JTable tabla_profesor;
    private javax.swing.JTextField text_CodDep;
    private javax.swing.JTextField textoFK_profesor;
    private javax.swing.JTextField texto_apellido;
    private javax.swing.JTextField texto_codigo;
    private javax.swing.JTextField texto_cp;
    private javax.swing.JTextField texto_direccion;
    private javax.swing.JTextField texto_dni;
    private javax.swing.JTextField texto_fecha_nacimiento;
    private javax.swing.JTextField texto_nombre;
    private javax.swing.JTextField texto_nombreD;
    private javax.swing.JTextField texto_nombreP;
    private javax.swing.JTextField texto_numero_integrantes;
    private javax.swing.JTextField texto_planta;
    private javax.swing.JTextField texto_provincia;
    private javax.swing.JTextField texto_sexo;
    private javax.swing.JTextField texto_tipo;
    private javax.swing.JTextField textofk_departamento;
    // End of variables declaration//GEN-END:variables
}
