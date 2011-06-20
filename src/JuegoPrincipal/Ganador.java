
package JuegoPrincipal;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Ganador extends javax.swing.JFrame {

    muestraGanadores Ganador;

    public Ganador() {
        initComponents();
        Ganador = new muestraGanadores();
        Ganador.setVisible(true);
        this.add(Ganador,BorderLayout.CENTER);
        this.pack();
        this.setSize(900, 560);
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Kick Ass UNO - Felicidades");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ganador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
