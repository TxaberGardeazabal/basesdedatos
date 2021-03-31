/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author txaber
 */

import excepciones.*;
import ejerciciobasedatos3.EjercicioBaseDatos3;
import javax.swing.JOptionPane;

public class VcambioPersona extends javax.swing.JDialog {

    private String persona;
    private String operacion;
    /**
     * Creates new form VcambioPersona
     */
    public VcambioPersona(java.awt.Frame parent, boolean modal, String per, String op) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        persona = per;
        operacion = op;
        
        if (!op.equals("alta"))
            pedirDni();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfCorreo = new javax.swing.JTextField();
        jTitulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        tfNombre = new javax.swing.JTextField();
        bCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTitulo.setText("Clientes");

        jLabel7.setText("Correo electronico");

        jLabel2.setText("Nombre");

        tfDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDniFocusLost(evt);
            }
        });

        jLabel3.setText("Apellidos");

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Dni");

        jLabel5.setText("Telefono");

        jLabel6.setText("Direccion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(bAceptar)
                        .addGap(29, 29, 29)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(tfDni, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTitulo)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try {
            
            if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfDireccion.getText().isEmpty())
                throw new DatoRequerido();
            // validar
            
            if (persona.equals("cliente")) {
                // validar cliente
                if (tfTelefono.getText().isEmpty() || tfCorreo.getText().isEmpty()) {
                    throw new DatoRequerido();
                }
                
                if (operacion.equals("alta")) {
                    EjercicioBaseDatos3.altaCliente(tfDni.getText(),tfNombre.getText(),tfApellidos.getText(),tfDireccion.getText(),tfCorreo.getText(),tfTelefono.getText());
                    JOptionPane.showMessageDialog(this, "cliente añadido");
                }
                else {
                    if (operacion.equals("modificar")) {
                        EjercicioBaseDatos3.modificarCliente(tfDni.getText(),tfNombre.getText(),tfApellidos.getText(),tfDireccion.getText(),tfCorreo.getText(),tfTelefono.getText(),false);
                        JOptionPane.showMessageDialog(this, "cliente modificado");
                    }
                    else {
                        // sera baja
                        int x = JOptionPane.showConfirmDialog(this, "estas seguro de querer borrar el cliente "+EjercicioBaseDatos3.getDniCli()+"?");
                        if (x == 0) {
                            EjercicioBaseDatos3.bajaCliente();
                            JOptionPane.showMessageDialog(this, "cliente borrado");
                        }
                    }
                }    
            }  
        }
        catch (Exception e) {
            System.out.println(e.getClass());
            JOptionPane.showMessageDialog(this, "a");
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Vprincipal.cancelar(0);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void tfDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDniFocusLost
        
        if (!operacion.equals("alta")) {
            try {
                if (persona.equals("cliente")) {
                    EjercicioBaseDatos3.consultaClientePorDni(tfDni.getText(),false);
                
                    tfDni.setEditable(false);
                    tfNombre.setText(EjercicioBaseDatos3.getNombreCli());
                    tfApellidos.setText(EjercicioBaseDatos3.getApellidosCli());
                    tfDireccion.setText(EjercicioBaseDatos3.getDireccionCli());
                    tfTelefono.setText(EjercicioBaseDatos3.getTelefonoCli());
                    tfCorreo.setText(EjercicioBaseDatos3.getCorreoCli());
                    
                    if (operacion.equals("modificar"))
                        habilitar();
                }
            }
            catch (FilaNoEncontrada e) {
                JOptionPane.showMessageDialog(this, "no se encontro la persona con ese dni");
            }
            catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
    }//GEN-LAST:event_tfDniFocusLost

    private void pedirDni() {
        tfDni.requestFocus();
        tfNombre.setEditable(false);
        tfApellidos.setEditable(false);
        tfDireccion.setEditable(false);
        tfTelefono.setEditable(false);
        tfCorreo.setEditable(false);
    }
    
    
    private void habilitar() {
        tfNombre.setEditable(true);
        tfApellidos.setEditable(true);
        tfDireccion.setEditable(true);
        tfTelefono.setEditable(true);
        tfCorreo.setEditable(true);
    }
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
            java.util.logging.Logger.getLogger(VcambioPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VcambioPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VcambioPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VcambioPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VcambioPersona dialog = new VcambioPersona(new javax.swing.JFrame(), true,"","");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
