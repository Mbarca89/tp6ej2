/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import entity.DepositoProductos;
import entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Listado_Nombre extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla;
    private List<Producto> listaProductos;

    public Listado_Nombre() {
        initComponents();
        this.listaProductos = DepositoProductos.listarTodos();

        
        modeloTabla = new DefaultTableModel(
            new Object[]{"Codigo", "Descripcion", "Precio", "Categoria", "Stock"}, 0
        );
        tblproductos.setModel(modeloTabla);

       
        cargarTabla(listaProductos);

        // Listener para filtrar mientras escribe
        txtDescrip.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filtrar(); }
            public void removeUpdate(DocumentEvent e) { filtrar(); }
            public void changedUpdate(DocumentEvent e) { filtrar(); }
        });
    }

    private void cargarTabla(List<Producto> productos) {
        modeloTabla.setRowCount(0); 
        for (Producto p : productos) {
            modeloTabla.addRow(new Object[]{
                p.getCodigo(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getRubro(),
                p.getStock()
            });
        }
    }

    private void filtrar() {
        String texto = txtDescrip.getText().trim().toLowerCase();
        if (texto.isEmpty()) {
            cargarTabla(listaProductos);
        } else {
            List<Producto> filtrados = new ArrayList<>();
            for (Producto p : listaProductos) {
                if (p.getDescripcion().toLowerCase().contains(texto)) {
                    filtrados.add(p);
                }
            }
            cargarTabla(filtrados);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblDescrpcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        txtDescrip = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombre.setText("Listado por Nombre");

        lblDescrpcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDescrpcion.setText("Ingrese Descripcion: ");

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion ", "Precio", "Categoria", "Stock"
            }
        ));
        jScrollPane2.setViewportView(tblproductos);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblDescrpcion)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblDescrpcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSalir)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.dispose();       
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescrpcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txtDescrip;
    // End of variables declaration//GEN-END:variables
}
