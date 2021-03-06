/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import static visual.EliminarColaborador.seleccionado;

/**
 *
 * @author esporras
 */
public class EliminarEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form EliminarEstudiante
     */
    
    private String[] estudiantes = {};
    public static String seleccionado;
    public EliminarEstudiante() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        listaestudiantesComboBox = new javax.swing.JComboBox();
        EliminarBoton = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Matricular1 = new javax.swing.JMenu();
        itmInicio1 = new javax.swing.JMenuItem();
        itmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(280, 236));
        getContentPane().setLayout(null);

        jLabel2.setText("Estudiante:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 190, 14);

        listaestudiantesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rosa Fallas Mora", "Julio Vargas Soto", "Julieta Zuñiga Granados" }));
        listaestudiantesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaestudiantesComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(listaestudiantesComboBox);
        listaestudiantesComboBox.setBounds(40, 90, 186, 30);

        EliminarBoton.setText("Eliminar");
        EliminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarBoton);
        EliminarBoton.setBounds(80, 140, 100, 23);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Eliminar Estudiante");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 10, 280, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 52, 280, 2);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        lblFondo.setText("jLabel3");
        lblFondo.setPreferredSize(new java.awt.Dimension(280, 211));
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 400, 420);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(49, 25));

        Matricular1.setText("Archivo");
        Matricular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Matricular1ActionPerformed(evt);
            }
        });

        itmInicio1.setText("Menú Principal");
        itmInicio1.setActionCommand("");
        itmInicio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmInicio1MouseClicked(evt);
            }
        });
        itmInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmInicio1ActionPerformed(evt);
            }
        });
        Matricular1.add(itmInicio1);

        itmSalir.setText("Salir");
        itmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmSalirMouseClicked(evt);
            }
        });
        itmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSalirActionPerformed(evt);
            }
        });
        Matricular1.add(itmSalir);

        jMenuBar1.add(Matricular1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaestudiantesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaestudiantesComboBoxActionPerformed
        // TODO add your handling code here:
        seleccionado=(String) listaestudiantesComboBox.getSelectedItem();
    }//GEN-LAST:event_listaestudiantesComboBoxActionPerformed

    private void EliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBotonActionPerformed
        // TODO add your handling code here:
        listaestudiantesComboBox.removeItem(seleccionado);

    }//GEN-LAST:event_EliminarBotonActionPerformed

    private void itmInicio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmInicio1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itmInicio1MouseClicked

    private void itmInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmInicio1ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);

        dispose();
    }//GEN-LAST:event_itmInicio1ActionPerformed

    private void itmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmSalirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itmSalirMouseClicked

    private void itmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_itmSalirActionPerformed

    private void Matricular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Matricular1ActionPerformed
        // TODO add your handling code here:

        Matricular matricular = new Matricular();
        matricular.setVisible(true);
        System.out.println("estoy aquí");
    }//GEN-LAST:event_Matricular1ActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarBoton;
    private javax.swing.JMenu Matricular;
    private javax.swing.JMenu Matricular1;
    private javax.swing.JMenuItem itmInicio;
    private javax.swing.JMenuItem itmInicio1;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JComboBox listaestudiantesComboBox;
    // End of variables declaration//GEN-END:variables
}
