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

import logica.Comida;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VtnMenuPrincipal extends javax.swing.JFrame {
    
    DefaultTableModel m;
    conexionBD bd = null;
    VtnIniciarUsuario vtnIniciarUsuario = null;
    VtnAgregarComida objAgregarComida = null;
    VtnActualizarUsuario objActualizarUsuario = null;
    Usuario objUsuario = null;
    
    Comida objComida = null;
    double totalCalorias = 0.0;
    
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
        llenarTablaProgreso();
        saludar();
        mostrarDatos();
        cargarLista();
        llenarTablaComida();
        listCategorias.requestFocus();
        listCategorias.setSelectedIndex(0);
        
    }
    
    private void mostrarDatos(){
        bd.abrirConexion();
        objUsuario = bd.verUsuario(objUsuario.getUser());
        bd.cerrarConexion();
        txtAreaDatosUsuario.setText(objUsuario.mostrarDatos());
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
    
    private void llenarTablaProgreso(){
        
        String nombreColumnas [] = {"Dia de la semana ","Total Calorias"};
        
        DefaultTableModel m = new DefaultTableModel();
        
        m.setColumnIdentifiers(nombreColumnas);
        
        tableProgreso.setModel(m);
        //m = (DefaultTableModel) tableProgreso.getModel();
        
        bd.abrirConexion();
        ResultSet rs = bd.mostrarProgreso(objUsuario.getUser());
        
        if(rs==null){
            JOptionPane.showMessageDialog(this, "Error, valor nulo retornado");
            return;
        }
        
        try {
            
            while(rs.next()){
                String dia = rs.getString("Dia");
                Double TotalCalorias = rs.getDouble("TotalCalorias");
                String filaselemento[] = {dia, TotalCalorias.toString()};
                m.addRow(filaselemento);
            }
            
        } catch (Exception e) {
            System.out.println("Error al llenar la tabla");
            
        }
        
        
        
        bd.cerrarConexion();
        
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
            
        } catch (SQLException e) {
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
            
        } catch (SQLException e) {
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
        jScrollPane5 = new javax.swing.JScrollPane();
        tableProgreso = new javax.swing.JTable();
        txtBienvenidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAreaDatosUsuario = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        lblSergioOliva = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
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
        btnAgregarProgresoDes = new javax.swing.JButton();
        btnAgregarProgresoCom = new javax.swing.JButton();
        btnAgregarProgresoCen = new javax.swing.JButton();
        btnAgregarProgresoSnacks = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDes = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCom = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableCen = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableSnacks = new javax.swing.JTable();
        lblDesayuno = new javax.swing.JLabel();
        lblComida = new javax.swing.JLabel();
        lblCena = new javax.swing.JLabel();
        lblSnacks = new javax.swing.JLabel();
        lblCalTotalDes = new javax.swing.JLabel();
        lblCalTotalNumDes = new javax.swing.JLabel();
        btnSumarDes = new javax.swing.JButton();
        lblCalTotalCom = new javax.swing.JLabel();
        lblCalTotalCen = new javax.swing.JLabel();
        lblCalTotalSnacks = new javax.swing.JLabel();
        lblCalTotalNumCom = new javax.swing.JLabel();
        lblCalTotalNumCen = new javax.swing.JLabel();
        lblCalTotalNumSnacks = new javax.swing.JLabel();
        lblCalTotalDiario = new javax.swing.JLabel();
        lblCalTotalNumDiario = new javax.swing.JLabel();
        comboDias = new javax.swing.JComboBox<>();
        btnGuardarDia = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabPrincipal.setBackground(new java.awt.Color(51, 0, 102));
        tabPrincipal.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));

        tableProgreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia de la semana", "Total de calorias"
            }
        ));
        jScrollPane5.setViewportView(tableProgreso);

        txtBienvenidos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtBienvenidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenes/sergio-olica-2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Datos del usuario");

        txtAreaDatosUsuario.setColumns(20);
        txtAreaDatosUsuario.setRows(5);
        jScrollPane8.setViewportView(txtAreaDatosUsuario);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblSergioOliva.setForeground(new java.awt.Color(255, 255, 255));
        lblSergioOliva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSergioOliva.setText("“El Mito”, Sergio Oliva");

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblSergioOliva, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                                .addComponent(txtBienvenidos)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtBienvenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnMostrar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSergioOliva, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        tabPrincipal.addTab("Home", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 0, 102));

        btnBuscarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenes/edit.png"))); // NOI18N
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

        btnEliminarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenes/delete.png"))); // NOI18N
        btnEliminarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComidaActionPerformed(evt);
            }
        });

        btnAgregarProgresoDes.setText("Agregar a Desayuno");
        btnAgregarProgresoDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProgresoDesActionPerformed(evt);
            }
        });

        btnAgregarProgresoCom.setText("Agregar a Comida");
        btnAgregarProgresoCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProgresoComActionPerformed(evt);
            }
        });

        btnAgregarProgresoCen.setText("Agregar a Cena");
        btnAgregarProgresoCen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProgresoCenActionPerformed(evt);
            }
        });

        btnAgregarProgresoSnacks.setText("Agregar a Snacks");
        btnAgregarProgresoSnacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProgresoSnacksActionPerformed(evt);
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(txtBuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnBuscarComida)
                        .addGap(107, 107, 107)
                        .addComponent(btnEliminarComida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarComida)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProgresoDes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarProgresoCen)
                            .addComponent(btnAgregarProgresoCom)
                            .addComponent(btnAgregarProgresoSnacks))))
                .addContainerGap())
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
                                .addComponent(txtBuscarComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminarComida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarComida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnAgregarProgresoDes)
                        .addGap(32, 32, 32)
                        .addComponent(btnAgregarProgresoCom)
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarProgresoCen)
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarProgresoSnacks)))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        tabPrincipal.addTab("Comidas", jPanel4);

        jPanel7.setBackground(new java.awt.Color(51, 0, 102));

        tableDes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Calorias", "Proteinas", "Carbohidratos", "Grasas", "Azucares"
            }
        ));
        jScrollPane3.setViewportView(tableDes);

        tableCom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Calorias", "Proteinas", "Carbohidratos", "Grasas", "Azucares"
            }
        ));
        jScrollPane4.setViewportView(tableCom);

        tableCen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Calorias", "Proteinas", "Carbohidratos", "Grasas", "Azucares"
            }
        ));
        jScrollPane6.setViewportView(tableCen);

        tableSnacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Calorias", "Proteinas", "Carbohidratos", "Grasas", "Azucares"
            }
        ));
        jScrollPane7.setViewportView(tableSnacks);

        lblDesayuno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDesayuno.setForeground(new java.awt.Color(255, 255, 255));
        lblDesayuno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesayuno.setText("Desayuno");
        lblDesayuno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblComida.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComida.setForeground(new java.awt.Color(255, 255, 255));
        lblComida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComida.setText("Comida");
        lblComida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCena.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCena.setForeground(new java.awt.Color(255, 255, 255));
        lblCena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCena.setText("Cena");
        lblCena.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSnacks.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSnacks.setForeground(new java.awt.Color(255, 255, 255));
        lblSnacks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSnacks.setText("Snacks");
        lblSnacks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalDes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalDes.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalDes.setText("Total:");
        lblCalTotalDes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalNumDes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalNumDes.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalNumDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalNumDes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSumarDes.setText("Sumar Calorias");
        btnSumarDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarDesActionPerformed(evt);
            }
        });

        lblCalTotalCom.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalCom.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalCom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalCom.setText("Total:");
        lblCalTotalCom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalCen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalCen.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalCen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalCen.setText("Total:");
        lblCalTotalCen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalSnacks.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalSnacks.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalSnacks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalSnacks.setText("Total:");
        lblCalTotalSnacks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalNumCom.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalNumCom.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalNumCom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalNumCom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalNumCen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalNumCen.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalNumCen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalNumCen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalNumSnacks.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalNumSnacks.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalNumSnacks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalNumSnacks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalDiario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalDiario.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalDiario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalDiario.setText("Total diario:");
        lblCalTotalDiario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCalTotalNumDiario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCalTotalNumDiario.setForeground(new java.awt.Color(255, 255, 255));
        lblCalTotalNumDiario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCalTotalNumDiario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));

        btnGuardarDia.setText("Guardar progreso");
        btnGuardarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lblComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lblDesayuno, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSnacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(lblCalTotalDes)
                        .addGap(46, 46, 46)
                        .addComponent(lblCalTotalNumDes))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnSumarDes)
                        .addGap(175, 175, 175)
                        .addComponent(lblCalTotalDiario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCalTotalNumDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDias, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnGuardarDia))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(lblCalTotalCom)
                        .addGap(41, 41, 41)
                        .addComponent(lblCalTotalNumCom))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(lblCalTotalCen)
                        .addGap(43, 43, 43)
                        .addComponent(lblCalTotalNumCen))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(lblCalTotalSnacks)
                        .addGap(44, 44, 44)
                        .addComponent(lblCalTotalNumSnacks)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSumarDes)
                            .addComponent(lblCalTotalDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCalTotalNumDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarDia))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesayuno)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCalTotalDes, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCalTotalNumDes, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCalTotalCom, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCalTotalNumCom, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCena)))
                            .addComponent(lblComida))
                        .addGap(7, 7, 7)
                        .addComponent(lblCalTotalCen, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCalTotalNumCen, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSnacks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCalTotalSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalTotalNumSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        tabPrincipal.addTab("Progreso", jPanel7);

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

    private void btnAgregarProgresoDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProgresoDesActionPerformed
        // TODO add your handling code here:

        int fsel = tableComida.getSelectedRow();
        try {
            String nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares;
            int cant = 0;
            
            if(fsel == -1) {
                JOptionPane.showMessageDialog(null, "Seleciona una comida");
            } else {

                
                m = (DefaultTableModel) tableComida.getModel();
                nombre = tableComida.getValueAt(fsel, 0).toString();
                categoria = tableComida.getValueAt(fsel, 1).toString();
                calorias = tableComida.getValueAt(fsel, 2).toString();
                proteina = tableComida.getValueAt(fsel, 3).toString();
                carbohidratos = tableComida.getValueAt(fsel, 4).toString();
                grasas = tableComida.getValueAt(fsel, 5).toString();
                azucares = tableComida.getValueAt(fsel, 6).toString();
                
                m = (DefaultTableModel) tableDes.getModel();
                String filaselemento[] = {nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares};
                m.addRow(filaselemento);
            }
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_btnAgregarProgresoDesActionPerformed

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

    private void btnAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComidaActionPerformed
        // TODO add your handling code here:
        if (objAgregarComida == null) {
            objAgregarComida = new VtnAgregarComida(this);
        }

        objAgregarComida.setVisible(true);

        //this.setVisible(false);
    }//GEN-LAST:event_btnAgregarComidaActionPerformed

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

    private void btnAgregarProgresoComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProgresoComActionPerformed
        // TODO add your handling code here:
        int fsel = tableComida.getSelectedRow();
        try {
            String nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares;
            int cant = 0;
            
            if(fsel == -1) {
                JOptionPane.showMessageDialog(null, "Selleciona una comida");
            } else {
                m = (DefaultTableModel) tableComida.getModel();
                nombre = tableComida.getValueAt(fsel, 0).toString();
                categoria = tableComida.getValueAt(fsel, 1).toString();
                calorias = tableComida.getValueAt(fsel, 2).toString();
                proteina = tableComida.getValueAt(fsel, 3).toString();
                carbohidratos = tableComida.getValueAt(fsel, 4).toString();
                grasas = tableComida.getValueAt(fsel, 5).toString();
                azucares = tableComida.getValueAt(fsel, 6).toString();
                
                m = (DefaultTableModel) tableCom.getModel();
                String filaselemento[] = {nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares};
                m.addRow(filaselemento);
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnAgregarProgresoComActionPerformed

    private void btnAgregarProgresoCenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProgresoCenActionPerformed
        // TODO add your handling code here:
        int fsel = tableComida.getSelectedRow();
        try {
            String nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares;
            int cant = 0;
            
            if(fsel == -1) {
                JOptionPane.showMessageDialog(null, "Selleciona una comida");
            } else {
                m = (DefaultTableModel) tableComida.getModel();
                nombre = tableComida.getValueAt(fsel, 0).toString();
                categoria = tableComida.getValueAt(fsel, 1).toString();
                calorias = tableComida.getValueAt(fsel, 2).toString();
                proteina = tableComida.getValueAt(fsel, 3).toString();
                carbohidratos = tableComida.getValueAt(fsel, 4).toString();
                grasas = tableComida.getValueAt(fsel, 5).toString();
                azucares = tableComida.getValueAt(fsel, 6).toString();
                
                m = (DefaultTableModel) tableCen.getModel();
                String filaselemento[] = {nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares};
                m.addRow(filaselemento);
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnAgregarProgresoCenActionPerformed

    private void btnAgregarProgresoSnacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProgresoSnacksActionPerformed
        // TODO add your handling code here:
        int fsel = tableComida.getSelectedRow();
        try {
            String nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares;
            int cant = 0;
            
            if(fsel == -1) {
                JOptionPane.showMessageDialog(null, "Selleciona una comida");
            } else {
                m = (DefaultTableModel) tableComida.getModel();
                nombre = tableComida.getValueAt(fsel, 0).toString();
                categoria = tableComida.getValueAt(fsel, 1).toString();
                calorias = tableComida.getValueAt(fsel, 2).toString();
                proteina = tableComida.getValueAt(fsel, 3).toString();
                carbohidratos = tableComida.getValueAt(fsel, 4).toString();
                grasas = tableComida.getValueAt(fsel, 5).toString();
                azucares = tableComida.getValueAt(fsel, 6).toString();
                
                m = (DefaultTableModel) tableSnacks.getModel();
                String filaselemento[] = {nombre, categoria, calorias, proteina, carbohidratos, grasas, azucares};
                m.addRow(filaselemento);
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnAgregarProgresoSnacksActionPerformed

    private void btnSumarDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarDesActionPerformed
        // TODO add your handling code here:
        String sumaDiaria = "";
        double acumuladorDiario = 0;
        String sumaDes = "";
        double acumuladorDes = 0;
        
        int iDes;
        for (iDes = 0; iDes < tableDes.getRowCount(); iDes++) {
            sumaDes = String.valueOf(tableDes.getValueAt(iDes, 2).toString());
            acumuladorDes += Double.parseDouble(sumaDes);
        }
        lblCalTotalNumDes.setText("" + acumuladorDes);
        
        String sumaCom = "";
        double acumuladorCom = 0;
        int iCom;
        for (iCom = 0; iCom < tableCom.getRowCount(); iCom++) {
            sumaCom = String.valueOf(tableCom.getValueAt(iCom, 2).toString());
            acumuladorCom += Double.parseDouble(sumaCom);
        }
        lblCalTotalNumCom.setText("" + acumuladorCom);
        
        
        String sumaCen = "";
        double acumuladorCen = 0;
        int iCen;
        for (iCen = 0; iCen < tableCen.getRowCount(); iCen++) {
            sumaCen = String.valueOf(tableCen.getValueAt(iCen, 2).toString());
            acumuladorCen += Double.parseDouble(sumaCen);
        }
        lblCalTotalNumCen.setText("" + acumuladorCen);
        
        
        String sumaSnacks = "";
        double acumuladorSnacks = 0;
        int iSnacks;
        for (iSnacks = 0; iSnacks < tableSnacks.getRowCount(); iSnacks++) {
            sumaSnacks = String.valueOf(tableSnacks.getValueAt(iSnacks, 2).toString());
            acumuladorSnacks += Double.parseDouble(sumaSnacks);
        }
        lblCalTotalNumSnacks.setText("" + acumuladorSnacks);
        
        
        acumuladorDiario = Double.parseDouble(lblCalTotalNumDes.getText()) + Double.parseDouble(lblCalTotalNumCom.getText()) + 
                Double.parseDouble(lblCalTotalNumCen.getText()) + Double.parseDouble(lblCalTotalNumSnacks.getText());
        lblCalTotalNumDiario.setText("" + acumuladorDiario);
    }//GEN-LAST:event_btnSumarDesActionPerformed

    private void btnGuardarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDiaActionPerformed
        // TODO add your handling code here:
        if (lblCalTotalNumDiario.getText() == null){
            JOptionPane.showMessageDialog(null, "Calcula el total de calorias primero");
        } else {
            System.out.println(""+ tableProgreso.getRowCount());
            bd.abrirConexion();
            bd.agregarProgresoDiario((String)comboDias.getSelectedItem(), Double.parseDouble(lblCalTotalNumDiario.getText()),objUsuario.getUser());
            limpiarTabla();
            llenarTablaProgreso();
            bd.cerrarConexion();
            
        }
    }//GEN-LAST:event_btnGuardarDiaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (objActualizarUsuario == null) {
            objActualizarUsuario = new VtnActualizarUsuario(this,objUsuario);
        }

        objActualizarUsuario.setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void saludar(){
        txtBienvenidos.setText("Bienvenido " + objUsuario.getUser() + "!");
    }
    
    private void limpiarTabla(){
        
        if(tableProgreso.getRowCount()>0){
            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(0,tableProgreso.getColumnCount());
            tableProgreso.setModel(modelo);
        }
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarComida;
    private javax.swing.JButton btnAgregarProgresoCen;
    private javax.swing.JButton btnAgregarProgresoCom;
    private javax.swing.JButton btnAgregarProgresoDes;
    private javax.swing.JButton btnAgregarProgresoSnacks;
    private javax.swing.JToggleButton btnBuscarComida;
    private javax.swing.JButton btnEliminarComida;
    private javax.swing.JButton btnGuardarDia;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSumarDes;
    private javax.swing.JComboBox<String> comboDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblCalTotalCen;
    private javax.swing.JLabel lblCalTotalCom;
    private javax.swing.JLabel lblCalTotalDes;
    private javax.swing.JLabel lblCalTotalDiario;
    private javax.swing.JLabel lblCalTotalNumCen;
    private javax.swing.JLabel lblCalTotalNumCom;
    private javax.swing.JLabel lblCalTotalNumDes;
    private javax.swing.JLabel lblCalTotalNumDiario;
    private javax.swing.JLabel lblCalTotalNumSnacks;
    private javax.swing.JLabel lblCalTotalSnacks;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblComida;
    private javax.swing.JLabel lblDesayuno;
    private javax.swing.JLabel lblSergioOliva;
    private javax.swing.JLabel lblSnacks;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JTabbedPane tabPrincipal;
    private javax.swing.JTable tableCen;
    private javax.swing.JTable tableCom;
    private javax.swing.JTable tableComida;
    private javax.swing.JTable tableDes;
    private javax.swing.JTable tableProgreso;
    private javax.swing.JTable tableSnacks;
    private javax.swing.JTextArea txtAreaDatosUsuario;
    private javax.swing.JTextField txtBienvenidos;
    private javax.swing.JTextField txtBuscarComida;
    // End of variables declaration//GEN-END:variables
}
