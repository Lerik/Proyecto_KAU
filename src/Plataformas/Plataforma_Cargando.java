
package Plataformas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Plataforma_Cargando extends javax.swing.JPanel{

    public Plataforma_Cargando() {
        initComponents();
        this.setSize(900,540);
    }

    @Override
    public void paintComponent(Graphics g){
       Dimension Scale = getSize();
       ImageIcon Back = new ImageIcon((getClass().getResource("/Imagenes/Cargando.jpg")));
       g.drawImage(Back.getImage(),0,0,Scale.width,Scale.height,null);
       setOpaque(false);
       super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 560));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setPreferredSize(new java.awt.Dimension(900, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(934, 934, 934))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(289, 289, 289))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    

}
