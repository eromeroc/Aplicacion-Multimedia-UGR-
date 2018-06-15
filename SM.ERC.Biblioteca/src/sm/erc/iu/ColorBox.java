/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.erc.iu;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 * Representa lista de celdas de Color
 * @version 1.0
 * @author Elena Romero Contreras
 */
public class ColorBox extends javax.swing.JPanel implements ListCellRenderer<java.awt.Color> {

    /**
     * Crea un nuevo ColorBox
     */
    public ColorBox() {
        initComponents();
    }

    /**
     * Devuelve un componente que ha sido configurado para mostrar el valor especificado.
     * 
     * @param list lista que estamos pintando
     * @param value valor 
     * @param index índice de la celda
     * @param isSelected True si la celda especificada está seleccionada
     * @param cellHasFocus
     * @return componente
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends java.awt.Color> list, java.awt.Color value, int index, boolean isSelected, boolean cellHasFocus) {
        java.awt.Color foreground;
        java.awt.Color background;
        JList.DropLocation dropLocation = list.getDropLocation();
        
        if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {
            background = java.awt.Color.BLUE;
            foreground = java.awt.Color.WHITE;
        } else if (isSelected) {
            background = UIManager.getDefaults().getColor("ComboBox.selectionBackground");
            foreground = UIManager.getDefaults().getColor("ComboBox.selectionForeground");
        } else {
            background = java.awt.Color.WHITE;
            foreground = java.awt.Color.BLACK;
        }
        this.setBackground(background);
        this.setForeground(foreground);
        this.color.setBackground(value);
        return this;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        color = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        color.setPreferredSize(new java.awt.Dimension(30, 30));
        add(color, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton color;
    // End of variables declaration//GEN-END:variables
}
