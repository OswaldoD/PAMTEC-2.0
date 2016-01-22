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
 * @author Sephi
 */
public class Colaborador extends javax.swing.JFrame {
    

    /**
     * Creates new form ColaboradorFrame
     */
    private String[] colaborador = {};
    private String[] tipo = {};
    
    public Colaborador() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        nombrePanelTexto = new javax.swing.JTextPane();
        opcionesAvanzadasBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ApellidoPanelTexto = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Apellido2PanelTexto = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        CorreoPanelTexto = new javax.swing.JTextPane();
        BuscarColaboradorComboBox = new javax.swing.JComboBox();
        TipoColaboradorComboBox = new javax.swing.JComboBox();
        guardarColaboradorBoton = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir o Modificar Colaboladores");
        setBackground(new java.awt.Color(0, 0, 51));
        setPreferredSize(new java.awt.Dimension(512, 400));
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(nombrePanelTexto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 110, 220, 30);

        opcionesAvanzadasBoton.setText("Opciones avanzadas");
        opcionesAvanzadasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesAvanzadasBotonActionPerformed(evt);
            }
        });
        getContentPane().add(opcionesAvanzadasBoton);
        opcionesAvanzadasBoton.setBounds(80, 323, 160, 30);

        jScrollPane2.setViewportView(ApellidoPanelTexto);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 150, 220, 30);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 120, 140, 14);

        jLabel2.setText("Primer Apellido:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 160, 140, 14);

        jLabel3.setText("Segundo Apellido:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 200, 140, 14);

        jLabel4.setText("Correo electronico:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 240, 140, 14);

        jLabel5.setText("Tipo de colaborador:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 290, 140, 14);

        jScrollPane3.setViewportView(Apellido2PanelTexto);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(230, 190, 220, 30);

        jScrollPane4.setViewportView(CorreoPanelTexto);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(230, 230, 220, 30);

        BuscarColaboradorComboBox.setModel(new javax.swing.DefaultComboBoxModel(colaborador));
        getContentPane().add(BuscarColaboradorComboBox);
        BuscarColaboradorComboBox.setBounds(120, 70, 249, 30);

        TipoColaboradorComboBox.setModel(new javax.swing.DefaultComboBoxModel(tipo));
        getContentPane().add(TipoColaboradorComboBox);
        TipoColaboradorComboBox.setBounds(230, 280, 220, 30);

        guardarColaboradorBoton.setText("Guardar");
        guardarColaboradorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarColaboradorBotonActionPerformed(evt);
            }
        });
        getContentPane().add(guardarColaboradorBoton);
        guardarColaboradorBoton.setBounds(310, 323, 120, 30);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Añadir o Modificar Colabolador");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 10, 500, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 60, 510, 2);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 510, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesAvanzadasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesAvanzadasBotonActionPerformed
        // TODO add your handling code here:
        EliminarColaborador ec = new EliminarColaborador();
        ec.setVisible(true);
    }//GEN-LAST:event_opcionesAvanzadasBotonActionPerformed

    private void guardarColaboradorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarColaboradorBotonActionPerformed
        // TODO add your handling code here:
        
        validaciones validar = new validaciones();
                //Mediante este ciclo se valida que no existan campos te texto vacíos
        if(validar.esVacio(nombrePanelTexto.getText())==true || validar.esVacio(ApellidoPanelTexto.getText())==true || 
                         validar.esVacio(Apellido2PanelTexto.getText())==true || validar.esVacio(CorreoPanelTexto.getText())==true){
            
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos solicitados");            
        }
        else{
            if(validar.email(CorreoPanelTexto.getText())==false){//formato correo inválido
                JOptionPane.showMessageDialog(this, "Ingrese un formato de correo válido");            
            }
            else {
                //llamar al método que guarde los datos en la BD (paquete controlador Controlador.java)
            }
        }
                                               

        
    }//GEN-LAST:event_guardarColaboradorBotonActionPerformed

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
            java.util.logging.Logger.getLogger(Colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Colaborador().setVisible(true);
            }
        });
    }
    
    public void setColaborador(String[] pC)
    {
        colaborador=pC;
    }
    
    public void setTipo(String[] pT)
    {
        tipo=pT;
    }
    
    public void addBuscarColaborador()
    {
        int i = 0;
        while(colaborador[i]!=null)
        {
            BuscarColaboradorComboBox.addItem(colaborador[i++]);
        }
    }
    
    public void addTipoColaborador()
    {
        int i = 0;
        while(tipo[i]!=null)
        {
            TipoColaboradorComboBox.addItem(tipo[i++]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Apellido2PanelTexto;
    private javax.swing.JTextPane ApellidoPanelTexto;
    private javax.swing.JComboBox BuscarColaboradorComboBox;
    private javax.swing.JTextPane CorreoPanelTexto;
    private javax.swing.JComboBox TipoColaboradorComboBox;
    private javax.swing.JButton guardarColaboradorBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextPane nombrePanelTexto;
    private javax.swing.JButton opcionesAvanzadasBoton;
    // End of variables declaration//GEN-END:variables
}
