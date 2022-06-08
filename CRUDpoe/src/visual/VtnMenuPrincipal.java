/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import basedatos.conexionBD;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import logica.Usuario;
import logica.Asesor;
import logica.Comida;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VtnMenuPrincipal extends javax.swing.JFrame {
    
    conexionBD bd = null;
    VtnIniciarUsuario vtnIniciarUsuario = null;
    VtnIniciarAsesor vtnIniciarAsesor = null;
    VtnAgregarComida objAgregarComida = null;
    Usuario objUsuario = null;
    Asesor objAsesor = null;
    Comida objComida = null;
    
    /**
     * Creates new form VtnMenuPrincipal
     */
    public VtnMenuPrincipal() {
        initComponents();
    }
    
    public VtnMenuPrincipal(VtnIniciarUsuario vtnIniciarUsuario, Usuario objUsuario) {
        bd = new conexionBD();
        objComida = new Comida();
        this.objUsuario = objUsuario;
        this.vtnIniciarUsuario = vtnIniciarUsuario;
        initComponents();
        cargarLista();
        llenarTablaComida();
        listCategorias.requestFocus();
        listCategorias.setSelectedIndex(0);
        
    }
    
    public VtnMenuPrincipal(VtnIniciarAsesor vtnIniciarAsesor, Asesor objAsesor) {
        this.objAsesor = objAsesor;
        this.vtnIniciarAsesor = vtnIniciarAsesor;
        initComponents();
        cargarLista();
        llenarTablaComida();
        listCategorias.requestFocus();
        listCategorias.setSelectedIndex(0);
    }
    
    
    private void cargarLista(){
        
        String categorias[] = {"Todos","Bebidas","Lacteos","Carnes",
                                "Cereales","Frutas", "Verduras","Comida rapida",
                                "Snacks","Pescado","Semillas","Huevos","Postres"};
        
        DefaultListModel<String> modelo1 = new DefaultListModel<>();
        
        listCategorias.setModel(modelo1);
        
        for(String elementos : categorias){
            System.out.println(" " + elementos);
            modelo1.addElement(elementos);
        }
        
    }
    
        private void llenarTablaComida(){
        
        String nombreColumnas [] = {"Nombre","Categoria","Calorias","Proteina",
                                    "Carbohidratos","Grasas","Azucares"};
        
        DefaultTableModel modeloTabla1 = new DefaultTableModel();
        
        modeloTabla1.setColumnIdentifiers(nombreColumnas);
        
        tableComida.setModel(modeloTabla1);
        
        bd.abrirConexion();
        ResultSet rs = bd.mostrarTodasComidas();
        
        if(rs==null){
            JOptionPane.showMessageDialog(this, "Error, valor nulo retornado");
            return;
        }
        
        try {
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String categoriaComida = rs.getString("categoria");
                Double calorias = rs.getDouble("calorias");
                Double proteina = rs.getDouble("proteina");
                Double carbohidratos = rs.getDouble("carbohidratos");
                Double grasas = rs.getDouble("grasas");
                Double azucares = rs.getDouble("azucares");
                
                Object[] row = new Object[7];
                
                row[0] = nombre;
                row[1] = categoriaComida;
                row[2] = calorias;
                row[3] = proteina;
                row[4] = carbohidratos;
                row[5] = grasas;
                row[6] = azucares;
                
                
                modeloTabla1.addRow(row);
            }
            
        } catch (Exception e) {
            System.out.println("Error al llenar la tabla");
            
        }
        
        bd.cerrarConexion();
        tableComida.setModel(modeloTabla1);
        
        
    }
        
        private void llenarTablaCatComida(String categoria){
        
        String nombreColumnas [] = {"Nombre","Categoria","Calorias","Proteina",
                                    "Carbohidratos","Grasas","Azucares"};
        
        DefaultTableModel modeloTabla1 = new DefaultTableModel();
        
        modeloTabla1.setColumnIdentifiers(nombreColumnas);
        
        tableComida.setModel(modeloTabla1);
        
        bd.abrirConexion();
        ResultSet rs = bd.mostrarCategoriaComidas(categoria);
        
        if(rs==null){
            JOptionPane.showMessageDialog(this, "Error, valor nulo retornado");
            return;
        }
        
        try {
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre");
                String categoriaComida = rs.getString("categoria");
                Double calorias = rs.getDouble("calorias");
                Double proteina = rs.getDouble("proteina");
                Double carbohidratos = rs.getDouble("carbohidratos");
                Double grasas = rs.getDouble("grasas");
                Double azucares = rs.getDouble("azucares");
                
                Object[] row = new Object[7];
                
                row[0] = nombre;
                row[1] = categoriaComida;
                row[2] = calorias;
                row[3] = proteina;
                row[4] = carbohidratos;
                row[5] = grasas;
                row[6] = azucares;
                
                
                modeloTabla1.addRow(row);
            }
            
        } catch (Exception e) {
            System.out.println("Error al llenar la tabla");
            
        }
        
        bd.cerrarConexion();
        tableComida.setModel(modeloTabla1);
        
        
    }
    
    private void llenarTablaBuscarComida(String nombreBuscado){
        
        String nombreColumnas [] = {"Nombre","Categoria","Calorias","Proteina",
                                    "Carbohidratos","Grasas","Azucares"};
        
        DefaultTableModel modeloTabla1 = new DefaultTableModel();
        
        modeloTabla1.setColumnIdentifiers(nombreColumnas);
        
        tableComida.setModel(modeloTabla1);
        
        bd.abrirConexion();
        ResultSet rs = bd.mostrarComidaBuscada(nombreBuscado);
        
        if(rs==null){
            JOptionPane.showMessageDialog(this, "Error, valor nulo retornado");
            return;
        }
        
        try {
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String categoriaComida = rs.getString("categoria");
                Double calorias = rs.getDouble("calorias");
                Double proteina = rs.getDouble("proteina");
                Double carbohidratos = rs.getDouble("carbohidratos");
                Double grasas = rs.getDouble("grasas");
                Double azucares = rs.getDouble("azucares");
                
                Object[] row = new Object[7];
                
                row[0] = nombre;
                row[1] = categoriaComida;
                row[2] = calorias;
                row[3] = proteina;
                row[4] = carbohidratos;
                row[5] = grasas;
                row[6] = azucares;
                
                
                modeloTabla1.addRow(row);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla");
            
        }
        
        bd.cerrarConexion();
        tableComida.setModel(modeloTabla1);
        
        
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
        jPanel2 = new javax.swing.JPanel();
        tabPrincipal = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtBuscarComida = new javax.swing.JTextField();
        btnBuscarComida = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableComida = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarComida = new javax.swing.JButton();
        btnEliminarComida = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabPrincipal.setBackground(new java.awt.Color(51, 0, 102));
        tabPrincipal.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("Home", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 0, 102));

        btnBuscarComida.setText("Buscar");
        btnBuscarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarComidaActionPerformed(evt);
            }
        });

        tableComida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableComida);

        listCategorias.setBackground(new java.awt.Color(51, 0, 102));
        listCategorias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        listCategorias.setForeground(new java.awt.Color(255, 255, 255));
        listCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCategoriasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listCategorias);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Categorias");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAgregarComida.setBackground(new java.awt.Color(51, 0, 102));
        btnAgregarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenes/new.png"))); // NOI18N
        btnAgregarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComidaActionPerformed(evt);
            }
        });

        btnEliminarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnBuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarComida)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregarComida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarComida)))
                            .addComponent(btnEliminarComida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabPrincipal.addTab("Comidas", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPrincipal)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(tabPrincipal)
                .addContainerGap())
        );

        tabPrincipal.getAccessibleContext().setAccessibleName("MainTab");

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(51, 0, 102));

        jMenu1.setText("Configuracion");
        jMenu1.setToolTipText("");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Actualizar datos");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCategoriasValueChanged
        // TODO add your handling code here:
        
        
        String itemSeleccionado = listCategorias.getSelectedValue();
        
        if(itemSeleccionado.equals("Todos")){
            llenarTablaComida();
        }else{
            llenarTablaCatComida(itemSeleccionado);
        }
        
        
        
    }//GEN-LAST:event_listCategoriasValueChanged

    private void btnBuscarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarComidaActionPerformed
        // TODO add your handling code here:
        String nombre = txtBuscarComida.getText();
        
        llenarTablaBuscarComida(nombre);
        
        
    }//GEN-LAST:event_btnBuscarComidaActionPerformed

    private void btnAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComidaActionPerformed
        // TODO add your handling code here:
        if (objAgregarComida == null) {
                objAgregarComida = new VtnAgregarComida(this);
                }
                
                objAgregarComida.setVisible(true);
                
                //this.setVisible(false);
        
    }//GEN-LAST:event_btnAgregarComidaActionPerformed

    private void btnEliminarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarComidaActionPerformed
        // TODO add your handling code here:
        
        int seleccionar = tableComida.getSelectedRow();
        
        if(seleccionar<0){
            JOptionPane.showMessageDialog(this, "Error, ningun elemento seleccionado para eliminar");
        }else{
            bd.abrirConexion();
            bd.borrarComida((String)tableComida.getValueAt(seleccionar, 0));
            bd.cerrarConexion();
            JOptionPane.showMessageDialog(this, "Se ha elimidado " + tableComida.getValueAt(seleccionar, 0));
            System.out.println("La columa seleccionada es: " + seleccionar + " y su nombre es " + tableComida.getValueAt(seleccionar, 0));
        }
        
        
        
    }//GEN-LAST:event_btnEliminarComidaActionPerformed

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
            java.util.logging.Logger.getLogger(VtnMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JToggleButton btnBuscarComida;
    private javax.swing.JButton btnEliminarComida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JTabbedPane tabPrincipal;
    private javax.swing.JTable tableComida;
    private javax.swing.JTextField txtBuscarComida;
    // End of variables declaration//GEN-END:variables
}
