
package Plataformas;

import JuegoPrincipal.Ganador;
import JuegoPrincipal.Tablero_Juego;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Plataforma_Juego extends javax.swing.JFrame implements Runnable{

    Tablero_Juego Tab;
    public static boolean Gana;
    private int Segundos;
    Thread crono;
    Ganador Gn;

    public Plataforma_Juego() {
        crono = new Thread(this);
        crono.start();
        initComponents();
        Tab = new Tablero_Juego();
        Tab.setVisible(true);
        this.add(Tab,BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(900, 560);
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Kick Ass UNO - Ingeniería en Sistemas Computacionales");
        this.setLocationRelativeTo(null);
        Gana = false;
    }

    public void run() {
        try{
            for(;;){
                if(Gana == true){
                    if(Gn==null){
                        Gn = new Ganador();
                    }

                    Gana=false;
                    this.setVisible(false);
                    Gn.setVisible(true);
                }

                Segundos++;

                crono.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

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
                new Plataforma_Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
