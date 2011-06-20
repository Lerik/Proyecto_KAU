
package Plataformas;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Frame_Inicial extends javax.swing.JFrame  implements Runnable{

    Plataforma_Cargando Cargando;
    Plataforma_Presentacion Presentacion;
    Frame_Menu Menu;
    private int Segundos;
    Thread crono;

    public Frame_Inicial() {
        initComponents();
        crono = new Thread(this);
        crono.start();
        Presentacion = new Plataforma_Presentacion();
        Presentacion.setVisible(true);
        this.add(Presentacion,BorderLayout.CENTER);
        this.pack();
        this.setIconImage (new ImageIcon((getClass().getResource("/Imagenes/danger.png"))).getImage());
        this.setTitle("Iniciando carga de archivos...");
        this.setSize(900, 560);
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 560));
        setName("Frame_Inicial"); // NOI18N
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
                new Frame_Inicial().setVisible(true);
            }
        });
    }

    public void run() {
        try{
            for(;;){
                if(Segundos==11){
                    this.getContentPane().removeAll();
                    this.getContentPane().add(Cargando = new Plataforma_Cargando(), 0);
                    this.repaint();
                }

                if(Segundos==16){
                    Menu = new Frame_Menu();
                    Menu.setVisible(true);
                    this.setVisible(false);
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
