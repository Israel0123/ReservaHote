/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vhabitacion;
import Datos.vpago;
import Datos.vreserva;
import Logica.fconsumo;
import Logica.fhabitacion;
import Logica.fpago;
import Logica.fproducto;
import Logica.freserva;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isrm_
 */
public class Frmpago extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frmpago
     */
    public Frmpago() {
        initComponents();
        mostrar(idreserva);
        Inhabilitar();
        txtidreserva.setText(idreserva);
        txtcliente.setText(cliente);
        txthabitacion.setText(habitacion);
        txtidhabitacion.setText(idhabitacion);
        txttotalreserva.setText(Double.toString(totalreserva));
        
        fconsumo func=new fconsumo();
        func.mostrar(idreserva);
        
        txttotal_pago.setText(Double.toString(totalreserva+func.totalconsumo));
    }

    private String accion="Guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;
    
    void ocultar_columnas()
    {
        
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    void ocultar_columnasconsumo()
    {
        
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    void Inhabilitar()
    {
        txtidpago.setVisible(false);
        txtidreserva.setEnabled(false);
        txtnumero_comprobante.setEnabled(false);
        cbotipo_comprobante.setEnabled(false);
        txtigv.setEnabled(false);
        txttotal_pago.setEnabled(false);
        txttotalreserva.setEnabled(false);
        dcfecha_emision.setEnabled(false);
        dcfecha_pago.setEnabled(false);
        txtidhabitacion.setVisible(false);
        txthabitacion.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpago.setText("");
        txtnumero_comprobante.setText("");
        txtigv.setText("");
        txttotal_pago.setText("");
        
    }
    
    void Habilitar()
    {
       txtidpago.setVisible(false);
        txtidreserva.setEnabled(true);
        txtnumero_comprobante.setEnabled(true);
        cbotipo_comprobante.setEnabled(true);
        txtigv.setEnabled(true);
        txttotal_pago.setEnabled(true);
        txttotalreserva.setEnabled(true);
        dcfecha_emision.setEnabled(true);
        dcfecha_pago.setEnabled(true);
        txtidhabitacion.setVisible(true);
        txthabitacion.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpago.setText("");
        txtnumero_comprobante.setText("");
        txtigv.setText("");
        ///txttotal_pago.setText("");
        
    }
    
    void mostrar(String buscar)
    {
        try {
            DefaultTableModel modelo;
            fpago func=new fpago();
            modelo=func.mostrar(buscar);
        
            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos"+Integer.toString(func.totalregistros));
            ///mostrar los datos de los consumos
            fconsumo func2=new fconsumo();
            modelo=func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();
            
            lbltotalregistrosconsumos.setText("Total consumo"+func2.totalregistros);
            lbltotalconsumo.setText("Consumo total: $."+func2.totalconsumo);
            
        } catch (Exception e) {
            JOptionPane.showInternalConfirmDialog(rootPane, e);
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

        jPanel1 = new javax.swing.JPanel();
        txtidpago = new javax.swing.JTextField();
        txtnumero_comprobante = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbotipo_comprobante = new javax.swing.JComboBox<>();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotalreserva = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txthabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtigv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttotal_pago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dcfecha_emision = new com.toedter.calendar.JDateChooser();
        dcfecha_pago = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbltotalregistrosconsumos = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de pagos"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jLabel2.setText("Reserva:");

        jLabel4.setText("Habitacion:");

        jLabel6.setText("Num Comprobante:");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setIconTextGap(0);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(102, 102, 102));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(102, 102, 102));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Comprobante:");

        cbotipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket ", "Otro", " " }));

        jLabel3.setText("Total Reserva:");

        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        jLabel8.setText("Igv:");

        jLabel9.setText("Total pago:");

        jLabel5.setText("Fecha Emision:");

        jLabel10.setText("Fecha Pago:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnguardar)
                        .addGap(26, 26, 26)
                        .addComponent(btncancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(txttotalreserva, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidreserva, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbotipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnumero_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txttotal_pago, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(dcfecha_emision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcfecha_pago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtidreserva)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtidhabitacion)
                                .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbotipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtnumero_comprobante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtigv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txttotal_pago))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dcfecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(dcfecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pagos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de pagos"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(102, 102, 102));
        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(102, 102, 102));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(btneliminar)
                        .addGap(48, 48, 48)
                        .addComponent(btnsalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lbltotalregistros)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de consumo"));

        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistadoconsumo);

        lbltotalregistrosconsumos.setText("Registros");

        lbltotalconsumo.setText("jLabel11");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalconsumo)
                .addGap(67, 67, 67)
                .addComponent(lbltotalregistrosconsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumos)
                    .addComponent(lbltotalconsumo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
        txtidreserva.transferFocus();
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        Habilitar();
        btnguardar.setText("Guardar");
        accion="guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtigv.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el igv del comprobante de pago");
            txtigv.requestFocus();
            return;
        }
        if(txttotal_pago.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante");
            txttotal_pago.requestFocus();
            return;
        }
        if(txtnumero_comprobante.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de comprobante del producto");
            txtnumero_comprobante.requestFocus();
            return;
        }

        vpago dts=new vpago();
        fpago func=new fpago();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));

        int seleccionado=cbotipo_comprobante.getSelectedIndex();
        dts.setTipo_comprobante((String)cbotipo_comprobante.getItemAt(seleccionado));
        dts.setNum_comprobante(txtnumero_comprobante.getText());
        dts.setIgv(Double.parseDouble(txtigv.getText()));
        dts.setTotal_pago(Double.parseDouble(txttotal_pago.getText()));

        Calendar cal;
        int d,m,a;
        
        cal=dcfecha_pago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR)-1900;
        
        dts.setFecha_pago(new Date(a,m,d));
        
        cal=dcfecha_pago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR)-1900;
        
        dts.setFecha_emision(new Date(a,m,d));
        
        
        if(accion.equals("guardar"))
        {
            if(func.Insertar(dts))
            {
                JOptionPane.showMessageDialog(rootPane, "El pago por $."+txttotal_pago.getText()+
                        "del Sr. "+txtcliente.getText()+"Ha sido realizado con Éxito");
                mostrar(idreserva);
                Inhabilitar();
                ///Desocupar la habitacion
                fhabitacion func2=new fhabitacion();
                vhabitacion dts2=new vhabitacion();
                
                dts2.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocupar(dts2);
                
                //cancelar o pagar la reserva
                
                freserva func3=new freserva();
                vreserva dts3=new vreserva();
                
                dts3.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
            }
        }
        else if(accion.equals("editar"))
        {
            dts.setPago(Integer.parseInt(txtidpago.getText()));

            if(func.Editar(dts))
            {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr."+txtcliente.getText()+"Ha sido modificado correctamente");
                mostrar("");
                Inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        Habilitar();
        btneliminar.setEnabled(true);
        accion="editar";

        int fila=tablalistado.rowAtPoint(evt.getPoint());

        txtidpago.setText(tablalistado.getValueAt(fila, 0).toString());
        cbotipo_comprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtnumero_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtigv.setText(tablalistado.getValueAt(fila,4).toString());
        txttotal_pago.setText(tablalistado.getValueAt(fila, 5).toString());
        
        dcfecha_emision.setDate(Date.valueOf(tablalistado.getValueAt(fila,6).toString()));
        dcfecha_pago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString()));
        
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if(!txtidpago.getText().equals(""))
        {
            int confirmacion=JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar el pago seleccionado", "Confirmar", 2);

            if(confirmacion==0)
            {
                fpago func=new fpago();
                vpago dts=new vpago();

                dts.setPago(Integer.parseInt(txtidpago.getText()));
                func.Eliminar(dts);
                mostrar(idreserva);
                Inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

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
            java.util.logging.Logger.getLogger(Frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmpago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbotipo_comprobante;
    private com.toedter.calendar.JDateChooser dcfecha_emision;
    private com.toedter.calendar.JDateChooser dcfecha_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumos;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txthabitacion;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidpago;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtnumero_comprobante;
    private javax.swing.JTextField txttotal_pago;
    private javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
}
