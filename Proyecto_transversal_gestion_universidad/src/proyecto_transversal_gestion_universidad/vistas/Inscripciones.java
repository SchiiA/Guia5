/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_transversal_gestion_universidad.acceso_a_datos.AlumnoData;
import proyecto_transversal_gestion_universidad.acceso_a_datos.InscripcionData;
import proyecto_transversal_gestion_universidad.acceso_a_datos.MateriaData;
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Inscripcion;
import proyecto_transversal_gestion_universidad.entidades.Materia;

/**
 *
 * @author User
 */
public class Inscripciones extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData = new AlumnoData();
    private MateriaData matData = new MateriaData();
    private InscripcionData insData = new InscripcionData();
    private int idAlumno;
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form Inscripciones
     */
    public Inscripciones() {
        initComponents();
        cargarComboBox();
        cabecera();
        jBInscribir.setEnabled(false);
        jBAnularInscripcion.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBAlumno = new javax.swing.JComboBox<>();
        jRBNoInscriptas = new javax.swing.JRadioButton();
        jRBInscriptas = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBAnularInscripcion = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO DE INSCRIPCIÓN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Seleccione un Alumno:");

        jCBAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCBAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnoActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBNoInscriptas);
        jRBNoInscriptas.setText("Materias no Inscriptas");
        jRBNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNoInscriptasActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBInscriptas);
        jRBInscriptas.setText("Materias Inscriptas");
        jRBInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBInscriptasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("LISTADO DE MATERIAS");

        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMaterias);

        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBAnularInscripcion.setText("Anular Inscripción");
        jBAnularInscripcion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jBInscribir)
                            .addGap(53, 53, 53)
                            .addComponent(jBAnularInscripcion)
                            .addGap(68, 68, 68)
                            .addComponent(jBSalir)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(112, 112, 112)
                                    .addComponent(jCBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jRBInscriptas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRBNoInscriptas)))
                            .addGap(40, 40, 40)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(122, 122, 122))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBInscriptas)
                    .addComponent(jRBNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBSalir)
                    .addComponent(jBAnularInscripcion))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNoInscriptasActionPerformed
        // TODO add your handling code here:
        jBAnularInscripcion.setEnabled(false);
        if (jCBAlumno.getSelectedItem() == "") {
            borrarFila();
            JOptionPane.showMessageDialog(null, "Seleccione un alumno");
        } else {
            jBInscribir.setEnabled(true);
            borrarFila();
            ArrayList<Materia> materias = new ArrayList<>(insData.obtenerMateriasNoCursadas(idAlumno));
            for (Materia recorrer : materias) {
                modelo.addRow(new Object[]{recorrer.getIdMateria(), recorrer.getNombre(), recorrer.getAnio()});
            }
        }
    }//GEN-LAST:event_jRBNoInscriptasActionPerformed

    private void jRBInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBInscriptasActionPerformed
        // TODO add your handling code here:
        jBInscribir.setEnabled(false);
        if (jCBAlumno.getSelectedItem() == "") {
            borrarFila();
            JOptionPane.showMessageDialog(null, "Seleccione un alumno");
        } else {
            jBAnularInscripcion.setEnabled(true);
            borrarFila();
            ArrayList<Materia> materias = new ArrayList<>(insData.obtenerMateriasCursadas(idAlumno));
            for (Materia recorrer : materias) {
                modelo.addRow(new Object[]{recorrer.getIdMateria(), recorrer.getNombre(), recorrer.getAnio()});
            }
        }
    }//GEN-LAST:event_jRBInscriptasActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnoActionPerformed
        // TODO add your handling code here:
        try {
            String[] alumno = String.valueOf(jCBAlumno.getSelectedItem()).split(", ");
            this.idAlumno = alumnoData.buscarAlumnoPorDni(Integer.valueOf(alumno[0])).getIdAlumno();
            if (jRBNoInscriptas.isSelected()) {
                jRBNoInscriptasActionPerformed(evt);
            } else if (jRBInscriptas.isSelected()) {
                jRBInscriptasActionPerformed(evt);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno");
            jBInscribir.setEnabled(false);
            jBAnularInscripcion.setEnabled(false);
            borrarFila();
        }

    }//GEN-LAST:event_jCBAlumnoActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        // TODO add your handling code here:
        int filaS = jTMaterias.getSelectedRow();
        if (filaS != -1) {
            Alumno alumno = alumnoData.buscarAlumnoPorId(idAlumno);
            int idMateria = (int) jTMaterias.getValueAt(filaS, 0);
            Materia materia = matData.buscarMateria(idMateria);
            insData.guardarInscripcion(new Inscripcion(alumno, materia));
            jRBNoInscriptasActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "debe seleccionar una fila");
        }
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jBAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularInscripcionActionPerformed
        // TODO add your handling code here:
        int filaS = jTMaterias.getSelectedRow();
        if (filaS != -1) {
            int idMateria = (int) jTMaterias.getValueAt(jTMaterias.getSelectedRow(), 0);
            insData.borrarInscripcion(idAlumno, idMateria);
            jRBInscriptasActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "debe seleccionar una fila");
        }
    }//GEN-LAST:event_jBAnularInscripcionActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBAnularInscripcion;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRBInscriptas;
    private javax.swing.JRadioButton jRBNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBox() {
        ArrayList<Alumno> alumnos = new ArrayList<>(alumnoData.listarAlumnos());
        for (Alumno re : alumnos) {
            jCBAlumno.addItem(re.getDni() + ", " + re.getApellido() + ", " + re.getNombre());
        }
    }

    private void cabecera() {
        modelo.addColumn("idMateria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jTMaterias.setModel(modelo);
    }

    private void borrarFila() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
