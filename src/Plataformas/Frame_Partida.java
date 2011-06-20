
package Plataformas;

import JuegoPrincipal.Tablero_Juego;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Frame_Partida extends javax.swing.JFrame implements Runnable{

    private int Segundos;
    Thread crono;
    Menu_Jugar Menu;
    Frame_Menu Menu5;
    Plataforma_Juego Plata;
    public static boolean Carga, Juego;

    public Frame_Partida(){
        crono = new Thread(this);
        crono.start();
        initComponents();
        Menu = new Menu_Jugar();
        Menu.setVisible(true);
        this.add(Menu,BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(900, 560);
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Kick Ass UNO - Administración de Partidas de Juego");
        this.setLocationRelativeTo(null);
        Carga = false;
        Juego = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 560));

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
                new Frame_Partida().setVisible(true);
            }
        });
    }

    public void run() {
        try{
            for(;;){
                if(Carga){
                    Carga = false;
                    Menu5.activame=true;
                }

                if(Juego){
                    if(Plata == null){
                        Plata = new Plataforma_Juego();
                    }
                    Juego=false;

                    this.setVisible(false);
                    Plata.setVisible(true);
                }

                Segundos++;

                crono.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
