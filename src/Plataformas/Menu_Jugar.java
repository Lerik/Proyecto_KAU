
package Plataformas;

import Tablero.InfoJuego;
import Tablero.Listado;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Menu_Jugar extends javax.swing.JPanel {

    private boolean BJugar;
    Frame_Partida Part;
    private static InfoJuego Partida;
    private static Object[] Nicks, Partidas;
    private static ArrayList Temp = new ArrayList();
    Frame_Partida Parti;

    public Menu_Jugar() {
        initComponents();
        this.setSize(900,560);

        jLabel3.setText("Texto Dinamico");
         jLabel3.setSize(700, 25);

        try{
            Partida = new InfoJuego();
            BJugar = true;
        }catch(Exception e){
            BJugar = false;
        }
        try{
            Nicks = Partida.todosNicks();

            for(int A=0; A<Nicks.length; A++){
                jComboBox1.addItem(Nicks[A].toString());
                jComboBox2.addItem(Nicks[A].toString());
            }

        }catch(Exception e){
            jLabel3.setText("Imposible Cargar Datos");
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
        }

         Partidas = Partida.listaPartidas().toArray();

         for(int A=0; A<Partidas.length; A++){
             Listado B = (Listado)(Partidas[A]);
             Temp.add(B.Codigo+" - "+B.Jugadores);
         }

         jList1.setListData(Temp.toArray());

    }

    @Override
    public void paintComponent(Graphics g){
       Dimension Scale = getSize();
       ImageIcon Back = new ImageIcon((getClass().getResource("/Imagenes/Menu_Principal3.jpg")));
       g.drawImage(Back.getImage(),0,0,Scale.width,Scale.height,null);
       setOpaque(false);
       super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 560));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setPreferredSize(new java.awt.Dimension(900, 560));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cargar Partida");
        jLabel2.setBounds(50, 20, 140, 23);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jList1.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jScrollPane1.setBounds(60, 120, 160, 170);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BCG.jpg"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });
        jLabel22.setBounds(40, 360, 190, 30);
        jLayeredPane2.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nueva Partida");
        jLabel1.setBounds(90, 20, 160, 23);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jLabel4.setText("Jugador No. 1");
        jLabel4.setBounds(140, 110, 120, 20);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jComboBox1.setToolTipText("Seleccione un Jugador");
        jComboBox1.setBounds(90, 140, 190, 30);
        jLayeredPane1.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jLabel5.setText("Jugador No. 2");
        jLabel5.setBounds(140, 200, 120, 18);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jComboBox2.setToolTipText("Seleccione un Jugador");
        jComboBox2.setBounds(90, 230, 190, 30);
        jLayeredPane1.add(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BA.jpg"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        jLabel20.setBounds(60, 380, 250, 30);
        jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Texto");
        jLabel3.setBounds(20, 450, 270, 18);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed

        int Posicion = jList1.getSelectedIndex();
        Listado tmp = (Listado)(Partidas[Posicion]);
        Partida.estCargador("Partida_"+tmp.Codigo);

         try{
                Nicks = Partida.todosNicks();

                for(int A=0; A<Nicks.length; A++){
                    jComboBox1.addItem(Nicks[A].toString());
                    jComboBox2.addItem(Nicks[A].toString());
                }

            }catch(Exception e){
                jLabel3.setText("Imposible Cargar Datos");
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(false);
            }
            Parti.Juego=true;


}//GEN-LAST:event_jLabel22MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Part.Carga=true;
}//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        if(jComboBox1.getSelectedItem().toString().compareTo(jComboBox2.getSelectedItem().toString())==0){
            jLabel3.setText("No pueden jugar dos jugadores iguales");
        }else{

            if(BJugar){
                boolean Inicio = Partida.adicionarPartida(jComboBox1.getSelectedItem().toString(),jComboBox2.getSelectedItem().toString());
                if(Inicio){
                    try{
                        Nicks = Partida.todosNicks();

                        for(int A=0; A<Nicks.length; A++){
                            jComboBox1.addItem(Nicks[A].toString());
                            jComboBox2.addItem(Nicks[A].toString());
                        }

                    }catch(Exception e){
                        jLabel3.setText("Imposible Cargar Datos");
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(false);
                    }
                    Parti.Juego=true;
                }else{
                    jLabel3.setText("No pudo crear la partida de juego");
                }
            }
        }
    }//GEN-LAST:event_jLabel20MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
