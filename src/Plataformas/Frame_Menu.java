package Plataformas;

import JuegoPrincipal.Tablero_Juego;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
public class Frame_Menu extends javax.swing.JFrame implements Runnable{

    private int Segundos;
    Thread crono;
    Plataforma_Menu Menu;
    Menu_Jugar MJugar;
    Tablero_Juego Tablero;
    Frame_Partida Partida;
    Frame_Jugadores FJ ;
    public static boolean BJugar, BManejo, BTop, activame;

    public Frame_Menu(int A){
        BJugar = false;
        BManejo = false;
        BTop= false;
        activame = false;
    }

    public Frame_Menu() {
        crono = new Thread(this);
        crono.start();
        initComponents();
        Menu = new Plataforma_Menu();
        Menu.setVisible(true);
        this.add(Menu,BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(900, 560);
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Kick Ass UNO - Menu Principal");
        this.setLocationRelativeTo(null);
    }

    public void run(){
        try{
            for(;;){

                if(activame==true){
                    this.setVisible(true);
                    if(Partida!=null){
                        Partida.setVisible(false);
                    }

                    if(FJ!=null){
                      FJ.setVisible(false);
                    activame = false;
                    }
                }

                if(BJugar==true){
                    if(Partida==null){
                        Partida = new Frame_Partida();
                    }
                    BJugar = false;
                    this.setVisible(false);
                    Partida.setVisible(true);
                }

                if(BManejo== true){
                    if(FJ==null){
                        FJ = new Frame_Jugadores();
                    }
                    BManejo = false;
                    this.setVisible(false);
                    FJ.setVisible(true);
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
        setResizable(false);

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
                new Frame_Menu().setVisible(true);
            }
        });
    }

    private void setOpaque(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
