/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;
import javax.swing.JOptionPane;
import java.lang.String;
import logica.Comida;
import basedatos.conexionBD;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VtnAgregarComidaProgreso extends javax.swing.JFrame {
    
    Comida objComida = null;
    VtnMenuPrincipal objMenuPrincipal = null;
    conexionBD objBD = null;
    
    public VtnAgregarComidaProgreso() {
        initComponents();
    }

    public VtnAgregarComidaProgreso(VtnMenuPrincipal objMenuPrincipal) {
        this.objMenuPrincipal = objMenuPrincipal;
        objBD = new conexionBD();
        objComida = new Comida();
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

        jPanel1 = new javax.swing.JPanel();
        btnRegresarComida = new javax.swing.JButton();
        txtGuardarComida = new javax.swing.JLabel();
        PanelEtiquetas1 = new javax.swing.JPanel();
        lblCalorias = new javax.swing.JLabel();
        lblProteina = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblCarbohidratos = new javax.swing.JLabel();
        lblGrasas = new javax.swing.JLabel();
        lblAzucares = new javax.swing.JLabel();
        PanelInstertarDatos1 = new javax.swing.JPanel();
        comboCategoria1 = new javax.swing.JComboBox<>();
        lblNombreComida = new javax.swing.JLabel();
        lblProteinaComida = new javax.swing.JLabel();
        lblCarbohidratosComida = new javax.swing.JLabel();
        lblGrasasComida = new javax.swing.JLabel();
        lblAzucaresComida = new javax.swing.JLabel();
        lblCaloriasComida = new javax.swing.JLabel();
        btnAgregarComida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        btnRegresarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenes/cerrar.png"))); // NOI18N
        btnRegresarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarComidaActionPerformed(evt);
            }
        });

        txtGuardarComida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtGuardarComida.setForeground(new java.awt.Color(255, 255, 255));
        txtGuardarComida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGuardarComida.setText("Guardar comida en progreso");
        txtGuardarComida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        PanelEtiquetas1.setBackground(new java.awt.Color(51, 0, 102));

        lblCalorias.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCalorias.setForeground(new java.awt.Color(255, 255, 255));
        lblCalorias.setText("Calorias");

        lblProteina.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblProteina.setForeground(new java.awt.Color(255, 255, 255));
        lblProteina.setText("Proteina");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria");

        lblCarbohidratos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCarbohidratos.setForeground(new java.awt.Color(255, 255, 255));
        lblCarbohidratos.setText("Carbohidratos");

        lblGrasas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblGrasas.setForeground(new java.awt.Color(255, 255, 255));
        lblGrasas.setText("Grasas");

        lblAzucares.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblAzucares.setForeground(new java.awt.Color(255, 255, 255));
        lblAzucares.setText("Azucares");

        PanelInstertarDatos1.setBackground(new java.awt.Color(51, 0, 102));

        comboCategoria1.setMaximumRowCount(4);
        comboCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Colacion", "Comida", "Cena" }));

        lblNombreComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblNombreComida.setForeground(new java.awt.Color(255, 255, 255));

        lblProteinaComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblProteinaComida.setForeground(new java.awt.Color(255, 255, 255));

        lblCarbohidratosComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCarbohidratosComida.setForeground(new java.awt.Color(255, 255, 255));

        lblGrasasComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblGrasasComida.setForeground(new java.awt.Color(255, 255, 255));

        lblAzucaresComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblAzucaresComida.setForeground(new java.awt.Color(255, 255, 255));

        lblCaloriasComida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCaloriasComida.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelInstertarDatos1Layout = new javax.swing.GroupLayout(PanelInstertarDatos1);
        PanelInstertarDatos1.setLayout(PanelInstertarDatos1Layout);
        PanelInstertarDatos1Layout.setHorizontalGroup(
            PanelInstertarDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInstertarDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInstertarDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarbohidratosComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelInstertarDatos1Layout.createSequentialGroup()
                        .addGroup(PanelInstertarDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProteinaComida, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrasasComida, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAzucaresComida, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelInstertarDatos1Layout.createSequentialGroup()
                .addComponent(lblCaloriasComida, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelInstertarDatos1Layout.setVerticalGroup(
            PanelInstertarDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInstertarDatos1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblNombreComida)
                .addGap(32, 32, 32)
                .addComponent(comboCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProteinaComida)
                .addGap(35, 35, 35)
                .addComponent(lblCarbohidratosComida)
                .addGap(34, 34, 34)
                .addComponent(lblGrasasComida)
                .addGap(26, 26, 26)
                .addComponent(lblAzucaresComida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCaloriasComida))
        );

        javax.swing.GroupLayout PanelEtiquetas1Layout = new javax.swing.GroupLayout(PanelEtiquetas1);
        PanelEtiquetas1.setLayout(PanelEtiquetas1Layout);
        PanelEtiquetas1Layout.setHorizontalGroup(
            PanelEtiquetas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEtiquetas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEtiquetas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEtiquetas1Layout.createSequentialGroup()
                        .addGroup(PanelEtiquetas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProteina, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAzucares, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrasas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarbohidratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInstertarDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelEtiquetas1Layout.setVerticalGroup(
            PanelEtiquetas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEtiquetas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEtiquetas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInstertarDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelEtiquetas1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblProteina)
                        .addGap(18, 18, 18)
                        .addComponent(lblCarbohidratos)
                        .addGap(18, 18, 18)
                        .addComponent(lblGrasas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAzucares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCalorias)))
                .addContainerGap())
        );

        btnAgregarComida.setText("Agregar");
        btnAgregarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEtiquetas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnAgregarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(txtGuardarComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegresarComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGuardarComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelEtiquetas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarComida)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void interfazAgregarComida(String nombre, double calorias, double proteina, double grasa, double carbohidratos) {
        lblNombreComida.setText(nombre);
        lblCaloriasComida.setText(String.valueOf(calorias));
        lblProteinaComida.setText(String.valueOf(proteina));
        lblGrasasComida.setText(String.valueOf(grasa));
        lblCarbohidratosComida.setText(String.valueOf(carbohidratos));
    }
    
    
    private boolean cajasVacias(){
        
    
        if(txtnombre.getText().isEmpty()||txtProteina.getText().isEmpty()||txtCarbohidratos.getText().isEmpty()||
            txtAzucares.getText().isEmpty()||txtGrasas.getText().isEmpty()||txtCalorias.getText().isEmpty()){
            
            return true;
            
        }
            
        return false;
              
    }
    
    private void btnRegresarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarComidaActionPerformed
        // TODO add your handling code here:
        //objMenuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarComidaActionPerformed

    private void btnAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComidaActionPerformed
        // TODO add your handling code here:
        
            
    }//GEN-LAST:event_btnAgregarComidaActionPerformed

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
            java.util.logging.Logger.getLogger(VtnAgregarComidaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnAgregarComidaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnAgregarComidaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnAgregarComidaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnAgregarComidaProgreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEtiquetas;
    private javax.swing.JPanel PanelEtiquetas1;
    private javax.swing.JPanel PanelInstertarDatos;
    private javax.swing.JPanel PanelInstertarDatos1;
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JButton btnRegresarComida;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboCategoria1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAzucares;
    private javax.swing.JLabel lblAzucaresComida;
    private javax.swing.JLabel lblCalorias;
    private javax.swing.JLabel lblCaloriasComida;
    private javax.swing.JLabel lblCarbohidratos;
    private javax.swing.JLabel lblCarbohidratosComida;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblGrasas;
    private javax.swing.JLabel lblGrasasComida;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreComida;
    private javax.swing.JLabel lblProteina;
    private javax.swing.JLabel lblProteinaComida;
    private javax.swing.JTextField txtAzucares;
    private javax.swing.JTextField txtCalorias;
    private javax.swing.JTextField txtCarbohidratos;
    private javax.swing.JTextField txtGrasas;
    private javax.swing.JLabel txtGuardarComida;
    private javax.swing.JTextField txtProteina;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}
