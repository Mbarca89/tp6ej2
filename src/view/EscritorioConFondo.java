/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Mauricio
 */
public class EscritorioConFondo extends javax.swing.JDesktopPane {
    private final java.awt.Image img;
    public EscritorioConFondo(String ruta) {
        this.img = new javax.swing.ImageIcon(getClass().getResource(ruta)).getImage();
    }
    @Override protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}