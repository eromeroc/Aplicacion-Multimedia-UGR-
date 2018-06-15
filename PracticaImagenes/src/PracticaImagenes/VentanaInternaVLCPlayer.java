/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaImagenes;

import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 * Ventana interna para reproducir vídeo 
 * @verion 1.0
 * @author Elena Romero Contreras
 */
public class VentanaInternaVLCPlayer extends javax.swing.JInternalFrame{

    private EmbeddedMediaPlayer vlcplayer = null;
    private File fMedia;
    /**
     * Crea nueva VentanaInternaVLCPlayer. 
     * @param f fichero a reproducir
     */
    public VentanaInternaVLCPlayer(File f) {
        initComponents();
        fMedia = f;
        EmbeddedMediaPlayerComponent aVisual = new EmbeddedMediaPlayerComponent();
        getContentPane().add(aVisual,java.awt.BorderLayout.CENTER);
        vlcplayer = aVisual.getMediaPlayer();
    }
    /**
     * Devuelve instancia de VentanaInternaVLCPlayer.
     * @return ventana interna con reproductor de vídeo si se ha creado sin errores,
     * false si no ha podido crearse
     */  
    public static VentanaInternaVLCPlayer getInstance(File f){
        VentanaInternaVLCPlayer v = new VentanaInternaVLCPlayer(f);
        return (v.vlcplayer!=null?v:null);
    }
    /**
     * Clase manejadora de eventos generados por el reproductor
     */
    private class VideoListener extends MediaPlayerEventAdapter{
        @Override
        public void finished(MediaPlayer mediaplayer){
            
        }
    }
    /**
     * Reproduce el vídeo del vlcplayer de esta VentanaInternaVLCPlayer
     */
    public void play(){
        if(vlcplayer != null){
            if(vlcplayer.isPlayable()){
                //Si se estaba reproduciendo
                vlcplayer.play();
            }else{
                vlcplayer.playMedia(fMedia.getAbsolutePath());
            }
        }
    }
    /**
     * Pausa/para el vídeo del vlcplayer de esta VentanaInternaVLCPlayer.
     */
    public void stop(){
        if(vlcplayer != null){
            if(vlcplayer.isPlaying()){
                //Si se estaba reproduciendo
                vlcplayer.pause();
            }else{
                vlcplayer.stop();
            }
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
        botonPlay = new javax.swing.JToggleButton();
        botonStop = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(20, 100));

        botonPlay.setIcon(new javax.swing.ImageIcon("/home/elena/NetBeansProjects/PracticaImagenes/iconos/Play.png")); // NOI18N
        botonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlayActionPerformed(evt);
            }
        });
        jPanel1.add(botonPlay);

        botonStop.setIcon(new javax.swing.ImageIcon("/home/elena/NetBeansProjects/PracticaImagenes/iconos/Stop.png")); // NOI18N
        botonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStopActionPerformed(evt);
            }
        });
        jPanel1.add(botonStop);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.stop();
        vlcplayer = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void botonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlayActionPerformed
        this.play();
    }//GEN-LAST:event_botonPlayActionPerformed

    private void botonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopActionPerformed
        this.stop();
    }//GEN-LAST:event_botonStopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonPlay;
    private javax.swing.JButton botonStop;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
