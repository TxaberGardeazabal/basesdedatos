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
import ejerciciobasedatos3.EjercicioBaseDatos3;
import javax.swing.JOptionPane;
import excepciones.*;

public class VconsultaPersona extends javax.swing.JDialog {

    private String per;
    private boolean consultandoTodo = false;
    private int pos = 0;
    /**
     * Creates new form VconsultaPersona
     */
    public VconsultaPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public VconsultaPersona(java.awt.Frame parent, boolean modal,String per) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        bSiguiente.setVisible(false);
        
        this.per = per;
        if (per.equals("abogado")) {
            tfTelefono.setEditable(false);
            tfCorreo.setEditable(false);
        }
            
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfDni = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bConsulta = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfDniCaso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCasos = new javax.swing.JTextArea();
        bOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Consulta personas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Por personas"));

        jLabel3.setText("Nombre");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Telefono");

        jLabel7.setText("Direccion");

        jLabel2.setText("Dni");

        jLabel4.setText("Correo");

        bConsulta.setText("consultar");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });

        bSiguiente.setText("siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSiguiente)
                        .addGap(18, 18, 18)
                        .addComponent(bConsulta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(tfDni)
                            .addComponent(tfTelefono))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(tfDireccion)
                            .addComponent(tfApellidos))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConsulta)
                    .addComponent(bSiguiente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Por casos"));

        jLabel8.setText("Dni");

        tfDniCaso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDniCasoFocusLost(evt);
            }
        });

        taCasos.setColumns(20);
        taCasos.setRows(5);
        jScrollPane1.setViewportView(taCasos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48)
                        .addComponent(tfDniCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfDniCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bOK.setText("listo");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bOK)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void tfDniCasoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDniCasoFocusLost
        try {
            
            if (per.equals("Cliente")) {
                // validar
                
                EjercicioBaseDatos3.consultaClientePorDni(tfDniCaso.getText(), true);
                // llena el testarea
                EjercicioBaseDatos3.textoClientes(taCasos);
            }
            else {
                //abogados
                // validar
                
                EjercicioBaseDatos3.consultaAbogadoPorDni(tfDniCaso.getText(), true);
                
                EjercicioBaseDatos3.textoAbogados(taCasos);
            }
            
        }
        catch(Exception e) {
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_tfDniCasoFocusLost

    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        // bloqueo los controles en caso de estar haciendo una consulta
        if (!consultandoTodo) {
        try {
            
            
            if (per.equals("Cliente")) {
                // hay espacio para mas funcionalidades
                // validar
                if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty() || tfCorreo.getText().isEmpty()) {
                    // vamos a querer consultar todo
                    EjercicioBaseDatos3.consultaTodoCliente();
                    bSiguiente.setVisible(true);
                    bConsulta.setEnabled(false);
                    consultandoTodo = true;
                    bSiguiente.doClick();
                }
                
            }
            else {
                // abogado
                if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfDireccion.getText().isEmpty()) {
                    // vamos a querer consultar todo
                    EjercicioBaseDatos3.consultaTodoAbogado();
                    bSiguiente.setVisible(true);
                    bConsulta.setEnabled(false);
                    consultandoTodo = true;
                    bSiguiente.doClick();
                }
            }
            
            
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
        }
    }//GEN-LAST:event_bConsultaActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        try {
            if (per.equals("Cliente")) {
            
                if (pos != EjercicioBaseDatos3.getCantidadCli()) {
                
                    tfDni.setText(EjercicioBaseDatos3.getDniCli(pos));
                    tfNombre.setText(EjercicioBaseDatos3.getNombreCli(pos));
                    tfApellidos.setText(EjercicioBaseDatos3.getApellidosCli(pos));
                    tfDireccion.setText(EjercicioBaseDatos3.getDireccionCli(pos));
                    tfTelefono.setText(EjercicioBaseDatos3.getTelefonoCli(pos));
                    tfCorreo.setText(EjercicioBaseDatos3.getCorreoCli(pos));
                
                    pos++;
                    
                }
                else {
                    // se termina la consulta
                    tfDni.setText("");
                    tfNombre.setText("");
                    tfApellidos.setText("");
                    tfDireccion.setText("");
                    tfTelefono.setText("");
                    tfCorreo.setText("");
                    
                    this.terminar();
                }
                
            }
            else {
                if (pos != EjercicioBaseDatos3.getCantidadAbo()) {
                    tfDni.setText(EjercicioBaseDatos3.getDniAbo(pos));
                    tfNombre.setText(EjercicioBaseDatos3.getNombreAbo(pos));
                    tfApellidos.setText(EjercicioBaseDatos3.getApellidosAbo(pos));
                    tfDireccion.setText(EjercicioBaseDatos3.getDireccionAbo(pos));
                    
                    pos++;
                }
                else {
                    // se termina la consulta
                    tfDni.setText("");
                    tfNombre.setText("");
                    tfApellidos.setText("");
                    tfDireccion.setText("");
                    
                    this.terminar();
                }
                
            }
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void terminar() {
        // por si la tabla esta vacia
        if (pos == 0) {
            JOptionPane.showMessageDialog(null,"no existen personas el la tabla de "+per);
        }
                
        bConsulta.setEnabled(true);
        bSiguiente.setVisible(false);
        consultandoTodo = false;
        pos = 0;
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
            java.util.logging.Logger.getLogger(VconsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VconsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VconsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VconsultaPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VconsultaPersona dialog = new VconsultaPersona(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taCasos;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfDniCaso;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
