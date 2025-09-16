/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import entity.DepositoProductos;
import entity.Producto;
import entity.Rubro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolino Uchiha
 */
public class ListadoRubro extends javax.swing.JInternalFrame {
        
    
    private DefaultTableModel modeloTabla;
    
     
    public ListadoRubro() {
        initComponents();
        
        modeloTabla = new DefaultTableModel(new Object[]{"codigo", "Descripcion", "Precio","Categoria","Stock"}, 0);
        tblproductos.setModel(modeloTabla);
        
        cmbRubro.removeAllItems();
        for (String r : Rubro.getRubros()) {
        cmbRubro.addItem(r);  
    }

        }

    
    private void cargarTabla(List<Producto> lista) {
    modeloTabla.setRowCount(0);
    
    for (Producto p : lista) {
        modeloTabla.addRow(new Object[]{
            p.getCodigo(),
            p.getDescripcion(),
            p.getPrecio(),
            p.getRubro(),
            p.getStock()
        });
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        txtRubro = new javax.swing.JLabel();
        cmbRubro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTitulo.setText("Listado Por Rubro ");

        txtRubro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtRubro.setText("Rubro:");

        cmbRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRubroActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblproductos);

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
                .addGap(72, 72, 72)
                .addComponent(txtRubro)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo)
                    .addComponent(cmbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRubro)
                    .addComponent(cmbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRubroActionPerformed
    String rubroSeleccionado = (String) cmbRubro.getSelectedItem();
    
    if (rubroSeleccionado != null) {
        // Creo una lista para los productos de ese rubro
        List<Producto> filtrados = new ArrayList<>();
        
        // Recorro todos los productos del depósito
        for (Producto p : DepositoProductos.listarTodos()) {
            if (p.getRubro().equalsIgnoreCase(rubroSeleccionado)) {
                filtrados.add(p);
            }
        }
        
        // Cargo los filtrados en la tabla
        cargarTabla(filtrados);
    }
    }//GEN-LAST:event_cmbRubroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbRubro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblproductos;
    private javax.swing.JLabel txtRubro;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
