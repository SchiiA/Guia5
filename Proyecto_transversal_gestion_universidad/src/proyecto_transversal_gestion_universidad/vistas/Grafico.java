/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad.vistas;

/**
 *
 * @author User
 */
public class Grafico extends javax.swing.JFrame {

    /**
     * Creates new form Grafico
     */
    public Grafico() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAlumno = new javax.swing.JMenu();
        jMIFormularioAlumno = new javax.swing.JMenuItem();
        jMMateria = new javax.swing.JMenu();
        jMIFormularioMateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMIManejoInscripciones = new javax.swing.JMenuItem();
        jMIManipulacionNotas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMIAlumnosMateria = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        jMAlumno.setText("Alumno");

        jMIFormularioAlumno.setText("Formulario de Alumno");
        jMIFormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFormularioAlumnoActionPerformed(evt);
            }
        });
        jMAlumno.add(jMIFormularioAlumno);

        jMenuBar1.add(jMAlumno);

        jMMateria.setText("Materia");

        jMIFormularioMateria.setText("Formulario de Materia");
        jMIFormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFormularioMateriaActionPerformed(evt);
            }
        });
        jMMateria.add(jMIFormularioMateria);

        jMenuBar1.add(jMMateria);

        jMenu3.setText("Administracion");

        jMIManejoInscripciones.setText("Manejo de Inscripciones");
        jMIManejoInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIManejoInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(jMIManejoInscripciones);

        jMIManipulacionNotas.setText("Manipulacion de Notas");
        jMIManipulacionNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIManipulacionNotasActionPerformed(evt);
            }
        });
        jMenu3.add(jMIManipulacionNotas);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Consultas");

        jMIAlumnosMateria.setText("Alumnos por Materia");
        jMIAlumnosMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAlumnosMateriaActionPerformed(evt);
            }
        });
        jMenu5.add(jMIAlumnosMateria);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIFormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFormularioAlumnoActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        GestionDeAlumnos gestionAlumno = new GestionDeAlumnos();
        gestionAlumno.setVisible(true);
        jDesktopPane.add(gestionAlumno);
    }//GEN-LAST:event_jMIFormularioAlumnoActionPerformed

    private void jMIManipulacionNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIManipulacionNotasActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        ActualizacionDeNotas actuNotas = new ActualizacionDeNotas();
        actuNotas.setVisible(true);
        jDesktopPane.add(actuNotas);
    }//GEN-LAST:event_jMIManipulacionNotasActionPerformed

    private void jMIAlumnosMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAlumnosMateriaActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        ConsultaDeAlumnosPorMateria alumnoMateria = new ConsultaDeAlumnosPorMateria();
        alumnoMateria.setVisible(true);
        jDesktopPane.add(alumnoMateria);
    }//GEN-LAST:event_jMIAlumnosMateriaActionPerformed

    private void jMIManejoInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIManejoInscripcionesActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        Inscripciones inscripcion = new Inscripciones();
        inscripcion.setVisible(true);
        jDesktopPane.add(inscripcion);    }//GEN-LAST:event_jMIManejoInscripcionesActionPerformed

    private void jMIFormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFormularioMateriaActionPerformed
        jDesktopPane.removeAll();
        jDesktopPane.repaint();
        GestionDeMaterias gestionMaterias = new GestionDeMaterias();
        gestionMaterias.setVisible(true);
        jDesktopPane.add(gestionMaterias);
    }//GEN-LAST:event_jMIFormularioMateriaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMAlumno;
    private javax.swing.JMenuItem jMIAlumnosMateria;
    private javax.swing.JMenuItem jMIFormularioAlumno;
    private javax.swing.JMenuItem jMIFormularioMateria;
    private javax.swing.JMenuItem jMIManejoInscripciones;
    private javax.swing.JMenuItem jMIManipulacionNotas;
    private javax.swing.JMenu jMMateria;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
