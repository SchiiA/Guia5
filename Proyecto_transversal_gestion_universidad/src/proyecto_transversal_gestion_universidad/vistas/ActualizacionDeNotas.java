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
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Inscripcion;

/**
 *
 * @author User
 */
public class ActualizacionDeNotas extends javax.swing.JInternalFrame {

    private double nota;
    private AlumnoData alumnoData = new AlumnoData();
    private InscripcionData inscripcionData = new InscripcionData();
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c == 2) {
                return true;
            } else {
                return false;
            }
        }
    };

    /**
     * Creates new form ActualizacionDeNotas
     */
    public ActualizacionDeNotas() {
        initComponents();
        cargarComboBox();
        cabecera();
        jBGuardar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCbAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNotas = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CARGA DE NOTAS");

        jLabel2.setText("Seleccione un Alumno");

        jCbAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbAlumnosActionPerformed(evt);
            }
        });

        jTNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTNotas.setToolTipText("");
        jTNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTNotas.setDragEnabled(true);
        jScrollPane1.setViewportView(jTNotas);

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jBGuardar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jBSalir))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbAlumnosActionPerformed
        // TODO add your handling code here:
        borrarFila();
        try {
            String[] dni = String.valueOf(jCbAlumnos.getSelectedItem()).split(", ");
            ArrayList<Inscripcion> inscripcions = new ArrayList<>(inscripcionData.obtenerInscripcionesPorAlumno(Integer.parseInt(dni[0])));
            jBGuardar.setEnabled(true);
            if(inscripcions.isEmpty()){
                jBGuardar.setEnabled(false);
            }
            for (Inscripcion re : inscripcions) {
                modelo.addRow(new Object[]{re.getMateria().getIdMateria(), re.getMateria().getNombre(), re.getNota()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno");
            jBGuardar.setEnabled(false);
        }

    }//GEN-LAST:event_jCbAlumnosActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        int filaS = jTNotas.getSelectedRow();
        if (filaS != -1) {
            nota = Double.valueOf(jTNotas.getValueAt(filaS, 2).toString());
            if (jTNotas.getSelectedColumn() == 2) {
                if (verif(filaS, nota) == true || nota < 1 || nota > 10) {
                    if (nota < 1 || nota > 10) {
                        JOptionPane.showMessageDialog(null, "la nota debe estar entre el rango 1 al 10");
                    } else {
                        JOptionPane.showMessageDialog(null, "debe dar un enter para poder guardar la nueva nota");
                    }
                } else {
                    String[] dni = String.valueOf(jCbAlumnos.getSelectedItem()).split(", ");
                    int idAlumno = alumnoData.buscarAlumnoPorDni(Integer.valueOf(dni[0])).getIdAlumno();
                    int idMateria = (int) jTNotas.getValueAt(filaS, 0);
                    inscripcionData.actualizarNota(idAlumno, idMateria, nota);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed


    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTNotas;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBox() {
        ArrayList<Alumno> alumnos = new ArrayList<>(alumnoData.listarAlumnos());
        for (Alumno re : alumnos) {
            jCbAlumnos.addItem(re.getDni() + ", " + re.getApellido() + ", " + re.getNombre());
        }
    }

    private void borrarFila() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cabecera() {
        modelo.addColumn("idMateria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTNotas.setModel(modelo);
    }

    private boolean verif(int fila, double nota) {
        String[] dni = String.valueOf(jCbAlumnos.getSelectedItem()).split(", ");
        ArrayList<Inscripcion> inscripcions = new ArrayList<>(inscripcionData.obtenerInscripcionesPorAlumno(Integer.parseInt(dni[0])));
        double vector[] = new double[inscripcions.size()];
        int cont = 0;
        //vector que guarda notas desde base de datos
        for (Inscripcion re : inscripcions) {
            vector[cont] = re.getNota();
            cont++;
        }
        if (vector[fila] == nota) {
            return true;
        } else {
            return false;
        }
    }
}
