/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

/**
 *
 * @author Sephi
 */
public class EliminarColaborador extends javax.swing.JFrame {

    /**
     * Creates new form EliminarColaboradorRol
     */
    private String[] colaboradores = {};
    
    public EliminarColaborador() {
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
        listaColaboradorComboBox = new javax.swing.JComboBox();
        EliminarBoton = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblFondo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        Matricular = new javax.swing.JMenu();
        itmInicio = new javax.swing.JMenuItem();
        itmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));
        setPreferredSize(new java.awt.Dimension(280, 235));
        getContentPane().setLayout(null);

        jLabel2.setText("Colaborador:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 190, 14);

        listaColaboradorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jean Carlo Alfaro Campos", "Daniela Solís Calderón", "Melvin Orozco Aguilar" }));
        listaColaboradorComboBox.setToolTipText("");
        listaColaboradorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaColaboradorComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(listaColaboradorComboBox);
        listaColaboradorComboBox.setBounds(40, 90, 186, 30);

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
        lblTitulo.setText("Eliminar Colabolador");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 10, 280, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 52, 280, 2);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        lblFondo.setText("jLabel3");
        lblFondo.setPreferredSize(new java.awt.Dimension(280, 211));
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 400, 420);

        jMenuBar.setPreferredSize(new java.awt.Dimension(49, 25));

        Matricular.setText("Archivo");
        Matricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatricularActionPerformed(evt);
            }
        });

        itmInicio.setText("Menú Principal");
        itmInicio.setActionCommand("");
        itmInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itmInicioMouseClicked(evt);
            }
        });
        itmInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmInicioActionPerformed(evt);
            }
        });
        Matricular.add(itmInicio);

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
        Matricular.add(itmSalir);

        jMenuBar.add(Matricular);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String seleccionado;
    
    private void EliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBotonActionPerformed
        // TODO add your handling code here:
        listaColaboradorComboBox.removeItem(seleccionado);        
    }//GEN-LAST:event_EliminarBotonActionPerformed

    private void listaColaboradorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaColaboradorComboBoxActionPerformed
        // TODO add your handling code here:
        seleccionado=(String) listaColaboradorComboBox.getSelectedItem();
    }//GEN-LAST:event_listaColaboradorComboBoxActionPerformed

    private void itmInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmInicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itmInicioMouseClicked

    private void itmInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmInicioActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);

        dispose();
    }//GEN-LAST:event_itmInicioActionPerformed

    private void itmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmSalirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itmSalirMouseClicked

    private void itmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_itmSalirActionPerformed

    private void MatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatricularActionPerformed
        // TODO add your handling code here:

        Matricular matricular = new Matricular();
        matricular.setVisible(true);
        System.out.println("estoy aquí");
    }//GEN-LAST:event_MatricularActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarColaborador().setVisible(true);
            }
        });
    }
    
    public void setColaboradores(String[] pColaboradores)
    {
        colaboradores=pColaboradores;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarBoton;
    private javax.swing.JMenu Matricular;
    private javax.swing.JMenuItem itmInicio;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JComboBox listaColaboradorComboBox;
    // End of variables declaration//GEN-END:variables
}
