/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.erc.iu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Representa un lienzo con imagen y
 * proporciona métodos para manejarla.
 * 
 * @version 1.0
 * @author elena
 */
public class Lienzo2DImagen extends Lienzo2D {
    
    private BufferedImage img;

    /**
     * Crea un Lienzo2DImagen
     */
    public Lienzo2DImagen() {
        initComponents();
    }
    
    /**
     * Modifica la imagen de este Lienzo2DImagen.
     * Adapta las dimensiones del lienzo a las de la nueva imagen.
     * @param img nueva imagen
     */
    public void setImage(BufferedImage img){
        this.img = img;
        if(img!=null){
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
    }
    /**
     * Devuelve la imagen sin incluir el vector de figuras.
     * @return imagen 
     */
    public BufferedImage getImage(){
        return getImage(false);
    }
    /**
     * Devuelve la imagen incluyendo o no el vector de figuras.
     * Si drawVector es true, creamos Graphics2D asociado a la imagen,
     * la dibujamos y llamamos al métod que pinta el vector de figuras.
     * Si drawVector es false, solo devolvemos la imagen
     * @param drawVector si se incluye el vector de figuras
     * @return imagen con/sin vector de figuras
     */
    public BufferedImage getImage(boolean drawVector){
        if(drawVector){
            BufferedImage imgOut = new BufferedImage(img.getWidth(), img.getHeight(),img.getType());
            Graphics2D g = imgOut.createGraphics(); //PASO IMPORTANTE
            g.drawImage(img, 0,0,this);           
            super.paint(g);
            
            return imgOut;
        }else{
            return img;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Visualiza la imagen y el vector de formas.
     * @param g gráfico
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null)
            g.drawImage(img,0,0,this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
