
package Plataformas;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Frame_Jugadores extends javax.swing.JFrame implements Runnable{

    Manejo_Jugadores Manejo;
    Frame_Menu Menu2;
    public static boolean Nuevo;
    public static boolean retorno;
    private int Segundos;
    Thread crono;

    public Frame_Jugadores(int A){
        Nuevo = false;
        retorno = false;
    }

    public Frame_Jugadores() {
        initComponents();
        crono = new Thread(this);
        crono.start();
        Manejo = new Manejo_Jugadores();
        Manejo.setVisible(true);
        this.add(Manejo,BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(900, 560);
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Kick Ass UNO - Administracion de Jugadores");
        this.setLocationRelativeTo(null);
        Nuevo = false;
        retorno = false;
    }

    public void run() {
        try{
            for(;;){

                if(retorno == true){
                    Menu2.activame=true;
                    retorno = false;
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
        setMinimumSize(new java.awt.Dimension(900, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Jugadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
