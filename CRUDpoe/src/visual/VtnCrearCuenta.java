
package visual;

import logica.Usuario;

import basedatos.conexionBD;
import javax.swing.JOptionPane;

public class VtnCrearCuenta extends javax.swing.JFrame {

    conexionBD objBD = null;
   
    Usuario objUs = null;
    VtnIniciarUsuario objIniciarSesion = null;
    
    
    public VtnCrearCuenta() {
        
        objUs = new Usuario();
        objBD = new conexionBD();
        initComponents();
    }
    
    public VtnCrearCuenta(VtnIniciarUsuario objIniciarSesion){
        this.objIniciarSesion = objIniciarSesion;
        
        objUs = new Usuario();
        objBD = new conexionBD();
        initComponents();
    }
    

    /*public CrearCuenta() {
        initComponents();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngTipoCuenta = new javax.swing.ButtonGroup();
        pnlBotonesInicio = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        pnlInscribirse = new javax.swing.JPanel();
        btnCrearCuenta = new javax.swing.JButton();
        pnlRegistroDatos = new javax.swing.JPanel();
        lblRegistro = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmarP = new javax.swing.JLabel();
        lblObligatorio = new javax.swing.JLabel();
        lblObligatorio1 = new javax.swing.JLabel();
        lblObligatorio2 = new javax.swing.JLabel();
        lblObligatorio3 = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        txtfUser = new javax.swing.JTextField();
        txtfEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmar = new javax.swing.JPasswordField();
        jpTipoCuenta = new javax.swing.JPanel();
        btnCUser = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBotonesInicio.setBackground(new java.awt.Color(51, 0, 102));

        btnIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnIniciarSesion.setText("Iniciar sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlBotonesInicio.add(btnIniciarSesion);

        getContentPane().add(pnlBotonesInicio, java.awt.BorderLayout.PAGE_START);

        pnlInscribirse.setLayout(new java.awt.BorderLayout());

        btnCrearCuenta.setBackground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        pnlInscribirse.add(btnCrearCuenta, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlInscribirse, java.awt.BorderLayout.PAGE_END);

        pnlRegistroDatos.setBackground(new java.awt.Color(51, 0, 102));

        lblRegistro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRegistro.setText("Ingresa tu informacion");

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUser.setText("Usuario:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        lblConfirmarP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConfirmarP.setText("Confirma tu Password:");

        lblObligatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblObligatorio.setText("*");

        lblObligatorio1.setForeground(new java.awt.Color(255, 0, 0));
        lblObligatorio1.setText("*");

        lblObligatorio2.setForeground(new java.awt.Color(255, 0, 0));
        lblObligatorio2.setText("*");

        lblObligatorio3.setForeground(new java.awt.Color(255, 0, 0));
        lblObligatorio3.setText("*");

        jpDatos.setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfUser)
                    .addComponent(txtfEmail)
                    .addComponent(txtPassword)
                    .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpDatosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtConfirmar, txtPassword, txtfEmail, txtfUser});

        jpTipoCuenta.setBackground(new java.awt.Color(51, 0, 102));
        jpTipoCuenta.setForeground(new java.awt.Color(153, 153, 255));

        btnCUser.setBackground(new java.awt.Color(51, 0, 102));
        btngTipoCuenta.add(btnCUser);
        btnCUser.setText("Cuenta usuario");

        javax.swing.GroupLayout jpTipoCuentaLayout = new javax.swing.GroupLayout(jpTipoCuenta);
        jpTipoCuenta.setLayout(jpTipoCuentaLayout);
        jpTipoCuentaLayout.setHorizontalGroup(
            jpTipoCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCUser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jpTipoCuentaLayout.setVerticalGroup(
            jpTipoCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlRegistroDatosLayout = new javax.swing.GroupLayout(pnlRegistroDatos);
        pnlRegistroDatos.setLayout(pnlRegistroDatosLayout);
        pnlRegistroDatosLayout.setHorizontalGroup(
            pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                        .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblConfirmarP))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroDatosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(35, 35, 35)
                        .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblObligatorio)
                            .addComponent(lblObligatorio1)
                            .addComponent(lblObligatorio2)
                            .addComponent(lblObligatorio3)))
                    .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblRegistro))
                    .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jpTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlRegistroDatosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblConfirmarP, lblEmail, lblPassword, lblUser});

        pnlRegistroDatosLayout.setVerticalGroup(
            pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jpTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRegistro)
                .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmail)
                        .addGap(11, 11, 11)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblConfirmarP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlRegistroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRegistroDatosLayout.createSequentialGroup()
                                .addComponent(lblObligatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblObligatorio1)
                                .addGap(12, 12, 12)
                                .addComponent(lblObligatorio2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblObligatorio3)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlRegistroDatosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblObligatorio, lblObligatorio1, lblObligatorio2, lblObligatorio3});

        getContentPane().add(pnlRegistroDatos, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        
        if(txtfUser.getText().isEmpty() || txtfEmail.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(this, "Error, llene todos los espacios requeridos");
            
        }else if(!txtPassword.getText().equals(txtConfirmar.getText())){
            JOptionPane.showMessageDialog(this, "Advertencia, las contraseñas no coinciden");
            }else{
            
                if(btnCUser.isSelected()){
                    
                    boolean usExiste;
                    objUs.setUser(txtfUser.getText());
                    objUs.setEmail(txtfEmail.getText());
                    char[] password = txtConfirmar.getPassword();
                    String pswr = new String(password);
                    objUs.setPassword(pswr);
                    
                    objBD.abrirConexion();
                    usExiste = objBD.insertarUser(objUs);
                    objBD.cerrarConexion();
                    
                    if(usExiste){
                    JOptionPane.showMessageDialog(this, "Cuenta creada");
                    }else {
                        JOptionPane.showMessageDialog(this, "Error, este nombre de usuario ya esta registrado");
                        System.out.println("objUs esta nulo"); 
                    
                    }   
               }   
                
   
        }
    

        
            
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        objIniciarSesion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(VtnCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnCrearCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnCUser;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.ButtonGroup btngTipoCuenta;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpTipoCuenta;
    private javax.swing.JLabel lblConfirmarP;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblObligatorio;
    private javax.swing.JLabel lblObligatorio1;
    private javax.swing.JLabel lblObligatorio2;
    private javax.swing.JLabel lblObligatorio3;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlBotonesInicio;
    private javax.swing.JPanel pnlInscribirse;
    private javax.swing.JPanel pnlRegistroDatos;
    private javax.swing.JPasswordField txtConfirmar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtfEmail;
    private javax.swing.JTextField txtfUser;
    // End of variables declaration//GEN-END:variables
}
