
package Plataformas;

import Tablero.InfoJuego;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Manejo_Jugadores extends javax.swing.JPanel {

    private static int Avatar = 1;
    private static InfoJuego Jugador = null;
    private static boolean activoAlm = false;
    private static Frame_Jugadores Paso;

    public Manejo_Jugadores() {
        initComponents();
        this.setSize(900,560);
        cambioAvatar();
        try{
            Jugador = new InfoJuego();
            activoAlm = true;
        }catch(Exception e){
            activoAlm = false;
        }
        Paso = new Frame_Jugadores(0);
        jLabel9.setText("Texto Dinamico");
        jLabel9.setSize(700, 25);
        jLabel3.setVisible(true);
        jLabel5.setVisible(true);
        try{
            jList1.setListData(Jugador.todosNicks());
        }catch(Exception e){
            jLabel2.setText("Error");
        }
    }

    @Override
    public void paintComponent(Graphics g){
       Dimension Scale = getSize();
       ImageIcon Back = new ImageIcon((getClass().getResource("/Imagenes/Menu_Principal3.jpg")));
       g.drawImage(Back.getImage(),0,0,Scale.width,Scale.height,null);
       setOpaque(false);
       super.paintComponent(g);
    }

    private void cambioAvatar(){
        if(Avatar == 1){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av1.jpg"))));
            jButton2.setEnabled(false);
        }

        if(Avatar == 2){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av2.jpg"))));
            jButton2.setEnabled(true);
        }

        if(Avatar == 3){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av3.jpg"))));
        }

        if(Avatar == 4){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av4.jpg"))));
        }

        if(Avatar == 5){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av5.jpg"))));
        }

        if(Avatar == 6){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av6.jpg"))));
        }

        if(Avatar == 7){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av7.jpg"))));
        }

        if(Avatar == 8){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av8.jpg"))));
        }

        if(Avatar == 9){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av9.jpg"))));
        }

        if(Avatar == 10){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av10.jpg"))));
        }

        if(Avatar == 11){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av11.jpg"))));
            jButton1.setEnabled(true);
        }

        if(Avatar == 12){
            jLabel8.setIcon(new ImageIcon((getClass().getResource("/Imagenes/av12.jpg"))));
            jButton1.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setMaximumSize(new java.awt.Dimension(900, 560));
        setMinimumSize(new java.awt.Dimension(900, 560));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Jugador(a)");
        jLabel1.setBounds(100, 10, 160, 23);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Nickname");
        jLabel3.setBounds(50, 120, 70, 18);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jLabel4.setText("Edad");
        jLabel4.setBounds(80, 150, 43, 20);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Género");
        jLabel5.setBounds(63, 200, 50, 18);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jTextField1.setToolTipText("Escriba su Nickname sin espacios");
        jTextField1.setBounds(130, 110, 220, 30);
        jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSpinner1.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(7, 7, 75, 1));
        jSpinner1.setToolTipText("Indique su edad");
        jSpinner1.setBounds(130, 150, 50, 24);
        jLayeredPane1.add(jSpinner1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femenino", "Masculino" }));
        jComboBox1.setToolTipText("Indique su género");
        jComboBox1.setBounds(130, 190, 150, 30);
        jLayeredPane1.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15));
        jLabel6.setText("Elija una imagen de identificacion");
        jLabel6.setBounds(90, 230, 230, 18);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BA.jpg"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        jLabel20.setBounds(60, 390, 250, 30);
        jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/av1.jpg"))); // NOI18N
        jLabel8.setToolTipText("No es necesario darle click, basta con dejarla intacta");
        jLabel8.setBounds(120, 250, 130, 130);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fder.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(270, 290, 50, 60);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fizq.gif"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(50, 290, 50, 60);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Texto");
        jLabel9.setBounds(0, 450, 380, 30);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Eliminar Jugador(a)");
        jLabel2.setBounds(30, 20, 180, 23);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jList1.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jScrollPane1.setBounds(50, 150, 180, 170);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BE.jpg"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });
        jLabel22.setBounds(50, 370, 180, 30);
        jLayeredPane2.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 19));
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        --Avatar;
        cambioAvatar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         ++Avatar;
        cambioAvatar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
       if(!activoAlm){
           jLabel9.setText("No se puede almacenar por el momento");
           return;
       }

        if(jTextField1.getText().compareTo("")==0){
            jTextField1.setText("Dejo vacio este campo");
            jTextField1.setForeground(Color.red);
        }else{
            String Nickname = jTextField1.getText();
            int Edad = Integer.parseInt(jSpinner1.getValue().toString());
            String Genero = jComboBox1.getSelectedItem().toString();
            String Icono;

            if(Avatar == 1){
                Icono = "/Imagenes/av1.jpg";
            }else if(Avatar == 2){
                Icono = "/Imagenes/av2.jpg";
            }else if(Avatar == 3){
                Icono = "/Imagenes/av3.jpg";
            }else if(Avatar == 4){
                Icono = "/Imagenes/av4.jpg";
            }else if(Avatar == 5){
                Icono = "/Imagenes/av5.jpg";
            }else if(Avatar == 6){
                Icono = "/Imagenes/av6.jpg";
            }else if(Avatar == 7){
                Icono = "/Imagenes/av7.jpg";
            }else if(Avatar == 8){
                Icono = "/Imagenes/av8.jpg";
            }else if(Avatar == 9){
                Icono = "/Imagenes/av9.jpg";
            }else if(Avatar == 10){
                Icono = "/Imagenes/av10.jpg";
            }else if(Avatar == 11){
                Icono = "/Imagenes/av11.jpg";
            }else{
                Icono = "/Imagenes/av12.jpg";
            }

            jLabel9.setText(Jugador.adicionarJugador(Nickname, Edad, Genero, Icono));
            jTextField1.setText("");
            jComboBox1.setSelectedIndex(0);
            Avatar = 1;
            cambioAvatar();
             try{
                jList1.setListData(Jugador.todosNicks());
            }catch(Exception e){
                jLabel2.setText("Error");
            }

            Paso.retorno = true;
        }
    }//GEN-LAST:event_jLabel20MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Paso.retorno = true;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
        if(activoAlm){
            String Nick = jList1.getSelectedValue().toString();

            jLabel9.setText(Jugador.eliminarJugador(Nick));
            jTextField1.setText("");
            jComboBox1.setSelectedIndex(0);
            Avatar = 1;
            cambioAvatar();
             try{
                jList1.setListData(Jugador.todosNicks());
            }catch(Exception e){
                jLabel2.setText("Error");
            }
            Paso.retorno = true;
        }
    }//GEN-LAST:event_jLabel22MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
