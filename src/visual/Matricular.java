/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controlador.validaciones;
import javax.swing.JOptionPane;


/**
 *
 * @author esporras
 */
public class Matricular extends javax.swing.JFrame {

    /**
     * Creates new form Matricular
     */
    public Matricular() {
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

        lblNombre = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        lblTelefono2 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JTextField();
        lblDatosPersonales = new javax.swing.JLabel();
        btnMatricualar = new javax.swing.JButton();
        btnOpcionesAvanzadas = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnMatricular = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matricular Estudiante");
        setPreferredSize(new java.awt.Dimension(743, 478));
        getContentPane().setLayout(null);

        lblNombre.setText("Primer Apellido");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(260, 140, 170, 14);
        lblNombre.getAccessibleContext().setAccessibleName("Nombre");

        lblApellido1.setText("Segundo Apellido");
        getContentPane().add(lblApellido1);
        lblApellido1.setBounds(490, 140, 180, 14);

        lblApellido2.setText("Nombre");
        getContentPane().add(lblApellido2);
        lblApellido2.setBounds(20, 140, 180, 14);

        lblBuscar.setText("Buscar Estudiante");
        getContentPane().add(lblBuscar);
        lblBuscar.setBounds(450, 10, 180, 14);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(10, 170, 180, 30);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(450, 40, 180, 30);

        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido1);
        txtApellido1.setBounds(250, 170, 180, 30);

        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido2);
        txtApellido2.setBounds(490, 170, 180, 30);

        lblCorreo.setText("Correo");
        getContentPane().add(lblCorreo);
        lblCorreo.setBounds(110, 230, 180, 14);

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(110, 250, 180, 30);

        lblCedula.setText("Cédula");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(400, 230, 180, 14);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(400, 250, 180, 30);

        lblTelefono1.setText("Teléfono Principal");
        getContentPane().add(lblTelefono1);
        lblTelefono1.setBounds(110, 300, 180, 14);

        txtTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono1);
        txtTelefono1.setBounds(110, 330, 180, 30);

        lblTelefono2.setText("Teléfono Secundario");
        getContentPane().add(lblTelefono2);
        lblTelefono2.setBounds(400, 300, 180, 14);

        txtTelefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono2);
        txtTelefono2.setBounds(400, 330, 180, 30);

        lblDatosPersonales.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDatosPersonales.setText("Datos Personales");
        getContentPane().add(lblDatosPersonales);
        lblDatosPersonales.setBounds(20, 90, 220, 30);

        btnMatricualar.setText("Matricular");
        btnMatricualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricualarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMatricualar);
        btnMatricualar.setBounds(410, 390, 170, 30);

        btnOpcionesAvanzadas.setText("Opciones Avanzadas");
        btnOpcionesAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionesAvanzadasActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpcionesAvanzadas);
        btnOpcionesAvanzadas.setBounds(110, 390, 190, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 118, 740, 2);

        btnMatricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        btnMatricular.setText("jLabel4");
        getContentPane().add(btnMatricular);
        btnMatricular.setBounds(0, -70, 740, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:              
        resultadoEmail = validar.email(txtCorreo.getText());
        
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono1ActionPerformed

    private void txtTelefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono2ActionPerformed

    private void btnOpcionesAvanzadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesAvanzadasActionPerformed
        // TODO add your handling code here:
        EliminarEstudiante eliminarEstudiante = new EliminarEstudiante();
        eliminarEstudiante.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOpcionesAvanzadasActionPerformed

    private void btnMatricualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricualarActionPerformed
        // TODO add your handling code here:        
        validaciones validar = new validaciones();
        
        //Mediante este ciclo se valida que no existan campos te texto vacíos
        if(validar.esVacio(txtNombre.getText())==true || validar.esVacio(txtApellido1.getText())==true || 
                         validar.esVacio(txtApellido2.getText())==true || validar.esVacio(txtCorreo.getText())==true || 
                         validar.esVacio(txtCedula.getText())==true || validar.esVacio(txtTelefono1.getText())==true || 
                         validar.esVacio(txtTelefono2.getText())==true){
            
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos solicitados");            
        }
        else{
            if(validar.email(txtCorreo.getText())==false){//formato correo inválido
                JOptionPane.showMessageDialog(this, "Ingrese un formato de correo válido");            
            }
            //valida si uno o ambos teléfonos no tienen el formato oficial
            if((validar.esNumberoTelefonico(txtTelefono1.getText())==false)|| (validar.esNumberoTelefonico(txtTelefono2.getText())==false)){
                JOptionPane.showMessageDialog(this, "Ingrese un número telefónico válido");            
            } 
            else {
                
            }
        }
    }//GEN-LAST:event_btnMatricualarActionPerformed

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
            java.util.logging.Logger.getLogger(Matricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matricular().setVisible(true);
            }
        });
    }

    validaciones validar = new validaciones(); 
    boolean resultadoEmail;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricualar;
    private javax.swing.JLabel btnMatricular;
    private javax.swing.JButton btnOpcionesAvanzadas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    // End of variables declaration//GEN-END:variables
}
