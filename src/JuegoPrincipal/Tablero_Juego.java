
package JuegoPrincipal;

import Plataformas.Plataforma_Juego;
import Tablero.Cartas;
import Tablero.Color;
import Tablero.InfoJuego;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Tablero_Juego extends javax.swing.JPanel {

    private Cartas Contacto;
    protected Cartas[] BPrincipal = new Cartas[108];
    protected ArrayList CJ1 = new ArrayList();
    protected ArrayList CJ2 = new ArrayList();
    protected ArrayList BRobo = new ArrayList(108);
    private ArrayList Primero = new ArrayList();
    private ArrayList Segundo = new ArrayList();
    protected Vector BDescarte = new Vector(108);
    private static Cartas Temporal, Temporal1, Temporal2, Temporal3, Temporal4, Temporal5, Temporal6, Temporal7;
    private static int vl1, vl2, vl3, vl4, vl5, vl6, vl7, puntoCJ1, puntoCJ2, IniBP;
    public static InfoJuego Partida;
    Plataforma_Juego PJ;

    private static int PJugador1=0;
    private static int PJugador2=0;
    private static boolean activoJugador1 = true;
    private static boolean comColor = false, comienzo = true;
    private static Color cc = null;

    public Tablero_Juego() {
        initComponents();
        this.setSize(900,540);
        this.repaint();
        Contacto = new Cartas(Color.NEGRO,15,new ImageIcon((getClass().getResource("/Imagenes/Robo.jpg"))));
        BPrincipal = Contacto.barajaInicial();
        barajearRobo();
        jLabel19.setText("");
        jLabel15.setIcon(Contacto.queImagen());
        jLabel15.setSize(Contacto.queImagen().getIconWidth(),Contacto.queImagen().getIconHeight());
        jLabel16.setText("");
        jLabel11.setText("Puntaje = ");
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        puntoCJ1 = 0;
        puntoCJ2 = 0;

        try{
            Partida = new InfoJuego();
            jLabel13.setText("Se cargo la Partida");
        }catch(Exception e){
            jLabel13.setText("No se cargo la Partida");
        }

        jLabel13.setText(Partida.ultimaPartida());

        quienJuegaPrimero(0,0,0);
        barajearJugadores();
        mostrarLabels();
        mostrarPuntajes();
        mostrarComparativa();
        comienzo=false;
    }

    public void paintComponent(Graphics g){
       Dimension Scale = getSize();
       ImageIcon Back = new ImageIcon((getClass().getResource("/Imagenes/Tablero_Juego.jpg")));
       g.drawImage(Back.getImage(),0,0,Scale.width,Scale.height,null);
       setOpaque(false);
       super.paintComponent(g);
    }

    private void barajearJugadores(){
        BDescarte.add(BRobo.get(IniBP));
        BRobo.remove(IniBP);
        
       Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));

      if(Temporal.queNumero()==10){
          if(activoJugador1==true){
              activoJugador1=false;
          }else{
              activoJugador1=true;
          }
      }

      if(Temporal.queNumero()==12){
          if(activoJugador1==true){
              agregarJugador2();
               agregarJugador2();
          }else{
              agregarJugador1();
              agregarJugador1();
          }
      }

      if(Temporal.queNumero()==13){
            BDescarte.add(BRobo.get(IniBP));
            BRobo.remove(IniBP);
            mostrarComparativa();
            barajearJugadores();
      }

      if(Temporal.queNumero()==14){
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
          jLabel8.setVisible(true);
          jLabel9.setVisible(true);
          jLabel10.setVisible(true);
          jLabel17.setVisible(true);
          jLabel13.setText("Escoja un color para el siguiente descarte");
          comColor = true;
      }

        System.out.println("Paso por Inicio condiciones");

        if(activoJugador1){
            for(int A=0; A<7; A++){
                CJ1.add(BRobo.get(IniBP));
                BRobo.remove(IniBP);
                
            }

            jLabel13.setText(Partida.Jugador1()+", es su turno");
            jLabel14.setText(Partida.Jugador1());
            jLabel19.setIcon( new ImageIcon((getClass().getResource(Partida.avJugador1()))));

            if(CJ1.size()>7 && comColor == false){
                jButton2.setEnabled(true);
            }

            for(int A=0; A<7; A++){
                CJ2.add(BRobo.get(IniBP));
                BRobo.remove(IniBP);
            }
        }else{
             for(int A=0; A<7; A++){
                CJ2.add(BRobo.get(IniBP));
                BRobo.remove(IniBP);
            }

            jLabel13.setText(Partida.Jugador2()+", es su turno");
             jLabel14.setText(Partida.Jugador2());
             jLabel19.setIcon( new ImageIcon((getClass().getResource(Partida.avJugador2()))));

            if(CJ2.size()>7 && comColor == false){
                jButton2.setEnabled(true);
            }

            for(int A=0; A<7; A++){
                CJ1.add(BRobo.get(IniBP));
                BRobo.remove(IniBP);
            }
        }
    }

    private void barajearRobo(){
        int[] Posiciones = new int[108];
        int Acumulador = 0, Aleatorio = 0;
        boolean Igualdad = false;
        Random Numero = new Random();

        do{
            Aleatorio = Numero.nextInt(108);

            for(int A=0; A<Acumulador; A++){
                if(Posiciones[A]==Aleatorio){
                    Igualdad = true;
                }
            }

            if(Igualdad!=true){
                Posiciones[Acumulador] = Aleatorio;
                ++Acumulador;
            }

            Igualdad=false;
        }while(Acumulador<108);

        for(int A=0; A<108; A++){
            BRobo.add(BPrincipal[Posiciones[A]]);
        }
       
    }

  private void quienJuegaPrimero(int P1, int P2, int Posicion){
        Primero.add(BRobo.get(IniBP));
        ++IniBP;
        Segundo.add(BRobo.get(IniBP));
        ++IniBP;
        
        Temporal =(Cartas)Primero.get(Posicion);
        if(Temporal.quePuntaje()==20 || Temporal.quePuntaje()==50){
            P1+=0;
        }else{
             P1 += Temporal.quePuntaje();
         }

        PJugador1 += P1;

        Temporal =(Cartas)Segundo.get(Posicion);
        if(Temporal.quePuntaje()==20 || Temporal.quePuntaje()==50){
            P2+=0;
        }else{
             P2+=Temporal.quePuntaje();
        }

        PJugador2 += P2;

        if(P1==P2){
            quienJuegaPrimero(P1,P2,++Posicion);
        }else{
            if(P1<P2)
                activoJugador1=false;
        }

        IniBP=0;
        return;
  }

  private void mostrarPuntajes(){
      if(activoJugador1){
          jLabel12.setText(""+PJugador1);
      }else{
          jLabel12.setText("" + PJugador2);
      }
  }

  private void Siguiente(){
      if(activoJugador1==true){
          siguienteJugador1();
      }else{
          siguienteJugador2();
      }
  }

  private void siguienteJugador1(){
      ++puntoCJ1;
      mostrarLabels();

      if((puntoCJ1+6)>=(CJ1.size()-1))
          jButton2.setEnabled(false);

      jButton1.setEnabled(true);
  }

  private void siguienteJugador2(){
       ++puntoCJ2;
      mostrarLabels();

      if((puntoCJ2+6)>=(CJ2.size()-1))
          jButton2.setEnabled(false);

      jButton1.setEnabled(true);
  }

  private void Anterior(){
      if(activoJugador1==true){
          anteriorJugador1();
      }else{
          anteriorJugador2();
      }
  }

  private void anteriorJugador1(){
      --puntoCJ1;
      mostrarLabels();

      if(puntoCJ1==0)
          jButton1.setEnabled(false);

      jButton2.setEnabled(true);
  }

  private void anteriorJugador2(){
      --puntoCJ2;
      mostrarLabels();

      if(puntoCJ2==0)
          jButton1.setEnabled(false);

      jButton2.setEnabled(true);
  }

  private void agregarCarta(){
      if(BRobo.isEmpty()==true){
          barajearRobo();
          agregarCarta();
      }else{
          if(activoJugador1==true){
              agregarJugador1();
              mostrarLabels();
              mostrarComparativa();
              return;
          }else{
              agregarJugador2();
              mostrarLabels();
              mostrarComparativa();
              return;
        }
      }
  }

  private void agregarJugador1(){
      CJ1.add(BRobo.get(IniBP));
      BRobo.remove(IniBP);
      Temporal = (Cartas)(CJ1.get(CJ1.size()-1));
      descartarCartasCJ1(Temporal,CJ1.size()-1);

      if(jLabel13.getText().compareTo("Desigualdad")==0){
          puntoCJ1=0;
          if(CJ2.size()>7){
                jButton2.setEnabled(true);
          }else{
              jButton2.setEnabled(false);
          }
          activoJugador1 = false;
          jLabel13.setText(Partida.Jugador2()+", es su turno");
          jLabel14.setText(Partida.Jugador2());
          jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
          mostrarPuntajes();
          jButton1.setEnabled(false);
      }
  }

  private void agregarJugador2(){
       CJ2.add(BRobo.get(IniBP));
      BRobo.remove(IniBP);
      Temporal = (Cartas)(CJ2.get(CJ2.size()-1));
      descartarCartasCJ2(Temporal,CJ2.size()-1);

      if(jLabel13.getText().compareTo("Desigualdad")==0){
          puntoCJ2=0;
          if(CJ2.size()>7){
                jButton2.setEnabled(true);
          }else{
              jButton2.setEnabled(false);
          }
          activoJugador1 = true;
          jLabel13.setText(Partida.Jugador1()+", es su turno");
          jLabel14.setText(Partida.Jugador1());
          jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
          mostrarPuntajes();
          jButton1.setEnabled(false);
      }
  }

  private void descartarCarta(Cartas Label, int Posicionador){
      if(activoJugador1==true){
            descartarCartasCJ1(Label, Posicionador);
            mostrarComparativa();
            mostrarLabels();
            return;
        }else{
            descartarCartasCJ2(Label, Posicionador);
            mostrarComparativa();
            mostrarLabels();
            return;
        }
  }

  private void descartarCartasCJ1(Cartas Label, int Posicionador){

      if(cc != null){
          if(Label.queNumero()==13 || Label.queNumero()==14){
              jLabel13.setText("Desigualdad");
              return;
          }else{
              if(Label.queColor().compareTo(cc)==0.){
                  if(Label.queNumero()==12){
                       for(int A=0; A<2; A++){
                           if(BRobo.isEmpty()==true){
                                barajearRobo();
                            }

                            CJ2.add(BRobo.get(0));
                            BRobo.remove(0);
                       }
                  }
                  jLabel18.setEnabled(false);
                  jLabel18.setVisible(false);

                  BDescarte.add(Label);
                  CJ1.remove(Posicionador);
                  System.out.println("descartada 1");
                  puntoCJ1=0;
                  if(CJ2.size()>7){
                        jButton2.setEnabled(true);
                  }else{
                      jButton2.setEnabled(false);
                  }
                  sumarPuntajes(Label);
                  ganador();
                  activoJugador1 = false;
                  jLabel13.setText("Carta descartada correctamente");
                  jLabel14.setText(Partida.Jugador2());
                  jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
                  mostrarPuntajes();
                  jButton1.setEnabled(false);
                  cc = null;
                  return;
              }else{
                  jLabel13.setText("Desigualdad");
                  return;
              }
          }
      }

      if(Label.queNumero()==13 || Label.queNumero()==14){
          BDescarte.add(Label);
          CJ1.remove(Posicionador);
          System.out.println("descartada 1");
          puntoCJ1=0;
          sumarPuntajes(Label);
          ganador();
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
          jLabel8.setVisible(true);
          jLabel9.setVisible(true);
          jLabel10.setVisible(true);
          jLabel17.setVisible(true);
          jLabel13.setText("Escoja un color para el siguiente descarte");
          comColor = true;

          if(Label.queNumero()==13){
              System.out.println("Es 13");
              for(int A=0; A<4; A++){
                  if(BRobo.isEmpty()==true){
                        barajearRobo();
                    }

                  CJ2.add(BRobo.get(0));
                  BRobo.remove(0);
              }
              jLabel18.setVisible(true);
              jLabel18.setEnabled(false);
              return;
          }

          return;
      }else{
          Cartas Temporal8 = (Cartas)(BDescarte.get(BDescarte.size()-1));

          if(Label.queNumero()==Temporal8.queNumero() || Label.queColor().compareTo(Temporal8.queColor())==0 || Label.queNumero()==13 || Label.queNumero()==14){
               if(Label.queNumero()==12){
                   for(int A=0; A<2; A++){
                       if(BRobo.isEmpty()==true){
                            barajearRobo();
                        }

                        CJ2.add(BRobo.get(0));
                        BRobo.remove(0);
                   }
              }

              BDescarte.add(Label);
              CJ1.remove(Posicionador);
              System.out.println("descartada 1");
              puntoCJ1=0;
              if(CJ2.size()>7){
                    jButton2.setEnabled(true);
              }else{
                  jButton2.setEnabled(false);
              }
              sumarPuntajes(Label);
              ganador();
              activoJugador1 = false;
              jLabel13.setText("Carta descartada correctamente");
              jLabel14.setText(Partida.Jugador2());
              jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
              mostrarPuntajes();
              jButton1.setEnabled(false);
              return;
          }else{
              jLabel13.setText("Desigualdad");
              return;
          }
      }
  }

  private void descartarCartasCJ2(Cartas Label, int Posicionador){
      if(cc != null){
          if(Label.queNumero()==13 || Label.queNumero()==14){
              jLabel13.setText("Desigualdad");
              return;
          }else{
              if(Label.queColor().compareTo(cc)==0.){
                  if(Label.queNumero()==12){
                      for(int A=0; A<2; A++){
                          if(BRobo.isEmpty()==true){
                              barajearRobo();
                           }

                          CJ1.add(BRobo.get(0));
                          BRobo.remove(0);
                      }
                  }
                   jLabel18.setEnabled(false);
                  jLabel18.setVisible(false);

                  BDescarte.add(Label);
                  CJ2.remove(Posicionador);
                  System.out.println("descartada 2");
                  puntoCJ2=0;
                  if(CJ1.size()>7){
                        jButton2.setEnabled(true);
                  }else{
                      jButton2.setEnabled(false);
                  }
                  sumarPuntajes(Label);
                  ganador();
                  activoJugador1 = true;
                  jLabel13.setText("Carta descartada correctamente");
                  jLabel14.setText(Partida.Jugador1());
                  jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
                  mostrarPuntajes();
                  jButton1.setEnabled(false);
                  cc = null;
                  return;
              }else{
                  jLabel13.setText("Desigualdad");
                  return;
              }
          }
      }

      if(Label.queNumero()==13 || Label.queNumero()==14){
          BDescarte.add(Label);
          CJ2.remove(Posicionador);
          System.out.println("descartada 2");
          puntoCJ2=0;
          sumarPuntajes(Label);
          ganador();
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
          jLabel8.setVisible(true);
          jLabel9.setVisible(true);
          jLabel10.setVisible(true);
          jLabel17.setVisible(true);
          jLabel13.setText("Escoja un color para el siguiente descarte");
          comColor = true;

          if(Label.queNumero()==13){
              System.out.println("Es 13");
              for(int A=0; A<4; A++){
                  if(BRobo.isEmpty()==true){
                      barajearRobo();
                   }

                  CJ2.add(BRobo.get(0));
                  BRobo.remove(0);
              }
              jLabel18.setVisible(true);
              jLabel18.setEnabled(false);
              return;
          }

          return;
      }else{
        Cartas Temporal8 = (Cartas)(BDescarte.get(BDescarte.size()-1));

          if(Label.queNumero()==Temporal8.queNumero() || Label.queColor().compareTo(Temporal8.queColor())==0){
              if(Label.queNumero()==12){
                  for(int A=0; A<2; A++){
                      if(BRobo.isEmpty()==true){
                          barajearRobo();
                       }

                      CJ1.add(BRobo.get(0));
                      BRobo.remove(0);
                  }
              }

              BDescarte.add(Label);
              CJ2.remove(Posicionador);
              System.out.println("descartada 2");
              puntoCJ2=0;
              if(CJ1.size()>7){
                    jButton2.setEnabled(true);
              }else{
                  jButton2.setEnabled(false);
              }
              sumarPuntajes(Label);
              ganador();
              activoJugador1 = true;
              jLabel13.setText("Carta descartada correctamente");
              jLabel14.setText(Partida.Jugador1());
              jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
              mostrarPuntajes();
              jButton1.setEnabled(false);
              return;
          }else{
              jLabel13.setText("Desigualdad");
              return;
          }
      }
  }

  private void mostrarComparativa(){
      Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));

      jLabel16.setText("");
      jLabel16.setIcon(Temporal.queImagen());
      jLabel16.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
  }

  private void mostrarLabel1(){
      if(vl1==-1){
          jLabel1.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl1));
          }else{
              Temporal = (Cartas)(CJ2.get(vl1));
          }
          jLabel1.setText("");
          jLabel1.setIcon(Temporal.queImagen());
          jLabel1.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel1.setVisible(true);
      }
  }

  private void mostrarLabel2(){
      if(vl2==-1){
          jLabel2.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl2));
          }else{
              Temporal = (Cartas)(CJ2.get(vl2));
          }
          jLabel2.setText("");
          jLabel2.setIcon(Temporal.queImagen());
          jLabel2.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel2.setVisible(true);
      }
  }

  private void mostrarLabel3(){
      if(vl3==-1){
          jLabel3.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl3));
          }else{
              Temporal = (Cartas)(CJ2.get(vl3));
          }
          jLabel3.setText("");
          jLabel3.setIcon(Temporal.queImagen());
          jLabel3.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel3.setVisible(true);
      }
  }

  private void mostrarLabel4(){
      if(vl4==-1){
          jLabel4.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl4));
          }else{
              Temporal = (Cartas)(CJ2.get(vl4));
          }
          jLabel4.setText("");
          jLabel4.setIcon(Temporal.queImagen());
          jLabel4.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel4.setVisible(true);
      }
  }

  private void mostrarLabel5(){
      if(vl5==-1){
          jLabel5.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl5));
          }else{
              Temporal = (Cartas)(CJ2.get(vl5));
          }
          jLabel5.setText("");
          jLabel5.setIcon(Temporal.queImagen());
          jLabel5.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel5.setVisible(true);
      }
  }

  private void mostrarLabel6(){
      if(vl6==-1){
          jLabel6.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl6));
          }else{
              Temporal = (Cartas)(CJ2.get(vl6));
          }
          jLabel6.setText("");
          jLabel6.setIcon(Temporal.queImagen());
          jLabel6.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel6.setVisible(true);
      }
  }

  private void mostrarLabel7(){
      if(vl7==-1){
          jLabel7.setVisible(false);
      }else{
          if(activoJugador1==true){
              Temporal = (Cartas)(CJ1.get(vl7));
          }else{
              Temporal = (Cartas)(CJ2.get(vl7));
          }
          jLabel7.setText("");
          jLabel7.setIcon(Temporal.queImagen());
          jLabel7.setSize(Temporal.queImagen().getIconWidth(), Temporal.queImagen().getIconHeight());
          jLabel7.setVisible(true);
      }
  }

  private void gestionarApuntadores(){
      int Contador = 0;

      if(activoJugador1==true){
          Contador += puntoCJ1;

          if(Contador>=CJ1.size()){
              vl1=-1;
          }else{
              vl1=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl2=-1;
          }else{
              vl2=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl3=-1;
          }else{
              vl3=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl4=-1;
          }else{
              vl4=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl5=-1;
          }else{
              vl5=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl6=-1;
          }else{
              vl6=Contador;
              ++Contador;
          }

          if(Contador>=CJ1.size()){
              vl7=-1;
          }else{
              vl7=Contador;

          }
      }else{
           Contador += puntoCJ2;

          if(Contador>=CJ2.size()){
              vl1=-1;
          }else{
              vl1=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl2=-1;
          }else{
              vl2=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl3=-1;
          }else{
              vl3=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl4=-1;
          }else{
              vl4=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl5=-1;
          }else{
              vl5=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl6=-1;
          }else{
              vl6=Contador;
              ++Contador;
          }

          if(Contador>=CJ2.size()){
              vl7=-1;
          }else{
              vl7=Contador;
          }
      }
  }

  private void mostrarLabels(){
      gestionarApuntadores();
      mostrarLabel1();
      mostrarLabel2();
      mostrarLabel3();
      mostrarLabel4();
      mostrarLabel5();
      mostrarLabel6();
      mostrarLabel7();
  }

  private boolean desafioTomaCuatro(){
      Temporal = (Cartas)(BDescarte.get(BDescarte.size()-2));
      Cartas tmp;

      if(activoJugador1 == true){
          for(int A=0; A<CJ2.size(); A++){
              tmp = (Cartas)(CJ2.get(A));

              if(tmp.queNumero()==Temporal.queNumero() || tmp.queColor().compareTo(Temporal.queColor())==0){
                  return true;
              }
          }
      }else{
          for(int A=0; A<CJ1.size(); A++){
              tmp = (Cartas)(CJ1.get(A));

              if(tmp.queNumero()==Temporal.queNumero() || tmp.queColor().compareTo(Temporal.queColor())==0){
                  return true;
              }
          }
      }

      return false;
  }

  private void sumarPuntajes(Cartas Label){

      if(activoJugador1==true){
          if(Label.queNumero()>=0 && Label.queNumero()<=9){
              PJugador1 += Label.queNumero();
          }else if(Label.queNumero()>=10 && Label.queNumero()<=12){
              PJugador1 += 20;
          }else{
              PJugador1 += 50;
          }
      }else{
          if(Label.queNumero()>=0 && Label.queNumero()<=9){
              PJugador2 += Label.queNumero();
          }else if(Label.queNumero()>=10 && Label.queNumero()<=12){
              PJugador2 += 20;
          }else{
              PJugador2 += 50;
          }
      }

  }

  private void ganador(){

      if(comienzo==true){
          return;
      }

      if(CJ1.isEmpty()==true || PJugador1>=500 || CJ2.isEmpty()==true || PJugador2>=500){

          if(CJ1.isEmpty()==true || PJugador1>=500){
              for(int A=0; A<CJ2.size(); A++){
                  sumarPuntajes((Cartas)(CJ2.get(A)));
              }

              Partida.actualizarPartida(PJugador1, PJugador2, 1);
          }else{
               for(int A=0; A<CJ1.size(); A++){
                  sumarPuntajes((Cartas)(CJ1.get(A)));
              }

              Partida.actualizarPartida(PJugador1, PJugador2, 2);
          }

          PJ.Gana=true;

      }
      
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel13 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(900, 570));
        setMinimumSize(new java.awt.Dimension(900, 570));
        setPreferredSize(new java.awt.Dimension(900, 570));

        jLabel7.setText("jLabel7");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jLabel7.setBounds(630, 0, 40, -1);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jLabel5.setBounds(450, 0, 40, -1);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("jLabel6");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jLabel6.setBounds(540, 0, 40, -1);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jLabel3.setBounds(270, 0, 40, -1);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jLabel4.setBounds(360, 0, 40, -1);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jLabel2.setBounds(180, 0, 40, -1);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.setBounds(90, 0, 40, -1);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fder.gif"))); // NOI18N
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(740, 10, 50, 80);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fizq.gif"))); // NOI18N
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(10, 10, 50, 80);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel13.setText("jLabel13");
        jLabel13.setBounds(90, 10, 290, 18);
        jLayeredPane2.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setText("jLabel16");
        jLabel16.setBounds(280, 50, 50, 14);
        jLayeredPane3.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel15.setText("jLabel15");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jLabel15.setBounds(140, 50, 40, 14);
        jLayeredPane3.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13));
        jLabel8.setMaximumSize(new java.awt.Dimension(34, 14));
        jLabel8.setMinimumSize(new java.awt.Dimension(34, 14));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(34, 14));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jLabel8.setBounds(210, 10, 30, 20);
        jLayeredPane3.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setBackground(new java.awt.Color(0, 51, 0));
        jLabel9.setForeground(new java.awt.Color(0, 51, 0));
        jLabel9.setText("jLabel9");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        jLabel9.setBounds(210, 30, 30, 20);
        jLayeredPane3.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setBackground(new java.awt.Color(102, 0, 102));
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("jLabel10");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jLabel10.setBounds(240, 30, 30, 20);
        jLayeredPane3.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("jLabel17");
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });
        jLabel17.setBounds(240, 10, 30, 20);
        jLayeredPane3.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/top.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jLabel18.setBounds(0, 30, 160, 120);
        jLayeredPane3.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("jLabel14");
        jLabel14.setBounds(20, 120, 120, 14);
        jLayeredPane4.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("jLabel19");
        jLabel19.setBounds(20, 0, 120, 110);
        jLayeredPane4.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setBounds(10, 10, 100, 18);
        jLayeredPane5.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel12.setText("jLabel12");
        jLabel12.setBounds(130, 10, 110, 18);
        jLayeredPane5.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jButton3.setText("Guardar");

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jButton4.setText("Abandonar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(61, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Siguiente();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Anterior();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        if(comColor==true){
            return;
        }

        agregarCarta();
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal1 = (Cartas)(CJ1.get(vl1));
        }else{
            Temporal1 = (Cartas) (CJ2.get(vl1));
        }

        System.out.println(Temporal1.queColor().toString());
        System.out.println(Temporal1.queNumero());

        descartarCarta(Temporal1, vl1);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal2 = (Cartas)(CJ1.get(vl2));
        }else{
            Temporal2 = (Cartas) (CJ2.get(vl2));
        }

        System.out.println(Temporal2.queColor().toString());
        System.out.println(Temporal2.queNumero());
        
        descartarCarta(Temporal2, vl2);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal3 = (Cartas)(CJ1.get(vl3));
        }else{
            Temporal3 = (Cartas) (CJ2.get(vl3));
        }

        System.out.println(Temporal3.queColor().toString());
        System.out.println(Temporal3.queNumero());

        descartarCarta(Temporal3, vl3);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal4 = (Cartas)(CJ1.get(vl4));
        }else{
            Temporal4 = (Cartas) (CJ2.get(vl4));
        }

        System.out.println(Temporal4.queColor().toString());
        System.out.println(Temporal4.queNumero());

        descartarCarta(Temporal4, vl4);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal5 = (Cartas)(CJ1.get(vl5));
        }else{
            Temporal5 = (Cartas) (CJ2.get(vl5));
        }

        System.out.println(Temporal5.queColor().toString());
        System.out.println(Temporal5.queNumero());

        descartarCarta(Temporal5, vl5);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal6 = (Cartas)(CJ1.get(vl6));
        }else{
            Temporal6 = (Cartas) (CJ2.get(vl6));
        }

        System.out.println(Temporal6.queColor().toString());
        System.out.println(Temporal6.queNumero());

        descartarCarta(Temporal6, vl6);
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        if(comColor==true){
           return;
       }

        if(activoJugador1==true){
           Temporal7 = (Cartas)(CJ1.get(vl7));
        }else{
            Temporal7 = (Cartas) (CJ2.get(vl7));
        }

        System.out.println(Temporal7.queColor().toString());
        System.out.println(Temporal7.queNumero());

        descartarCarta(Temporal7, vl7);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        
        cc = Color.NEGRO;
        comColor = false;

        if(activoJugador1==true){
            activoJugador1 = false;
            if(CJ2.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador2());
            jLabel13.setText(Partida.Jugador2()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
            mostrarPuntajes();
        }else{
            activoJugador1 = true;
            if(CJ1.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador1());
            jLabel13.setText(Partida.Jugador1()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
            mostrarPuntajes();
        }

        mostrarComparativa();
        mostrarLabels();
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel17.setVisible(false);

        Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));
        if(Temporal.queNumero()==13){
            jLabel18.setEnabled(true);
        }

    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        
        cc = Color.VERDE;
        comColor = false;

        if(activoJugador1==true){
            activoJugador1 = false;
            if(CJ2.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador2());
            jLabel13.setText(Partida.Jugador2()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
            mostrarPuntajes();
        }else{
            activoJugador1 = true;
            if(CJ1.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador1());
            jLabel13.setText(Partida.Jugador1()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
            mostrarPuntajes();
        }

        mostrarComparativa();
        mostrarLabels();

        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel17.setVisible(false);

        Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));
        if(Temporal.queNumero()==13){
            jLabel18.setEnabled(true);
        }

    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed

        cc = Color.PURPURA;
        comColor = false;

        if(activoJugador1==true){
            activoJugador1 = false;
            if(CJ2.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador2());
            jLabel13.setText(Partida.Jugador2()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
            mostrarPuntajes();
        }else{
            activoJugador1 = true;
            if(CJ1.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador1());
            jLabel13.setText(Partida.Jugador1()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
            jLabel13.setText("Jugador 1 es su turno");
            mostrarPuntajes();
        }

        mostrarComparativa();
        mostrarLabels();

        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel17.setVisible(false);

        Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));
        if(Temporal.queNumero()==13){
            jLabel18.setEnabled(true);
        }

    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed

        cc = Color.ROJO;
        comColor = false;

        if(activoJugador1==true){
            activoJugador1 = false;
            if(CJ2.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador2());
            jLabel13.setText(Partida.Jugador2()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
            mostrarPuntajes();
        }else{
            activoJugador1 = true;
            if(CJ1.size()>7){
                jButton2.setEnabled(true);
            }

            jLabel14.setText(Partida.Jugador1());
            jLabel13.setText(Partida.Jugador1()+", es su turno");
            jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
            mostrarPuntajes();
        }
        
        mostrarComparativa();
        mostrarLabels();

        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel17.setVisible(false);

        Temporal = (Cartas)(BDescarte.get(BDescarte.size()-1));
        if(Temporal.queNumero()==13){
            jLabel18.setEnabled(true);
        }
        
    }//GEN-LAST:event_jLabel17MousePressed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        if(desafioTomaCuatro()==true){

            if(activoJugador1==true){
                for(int A=0; A<4; A++){
                    CJ2.add(CJ1.get(CJ1.size()-1));
                    CJ1.remove(CJ1.size()-1);
                }
                puntoCJ1 = 0;
                jLabel13.setText(Partida.Jugador2()+" ha sido sancionado");
            }else{
                for(int A=0; A<4; A++){
                    CJ1.add(CJ2.get(CJ2.size()-1));
                    CJ2.remove(CJ2.size()-1);
                }
                 puntoCJ2 = 0;
                jLabel13.setText(Partida.Jugador1()+" ha sido sancionado");
            }

        }else{

            if(activoJugador1 == true){
                for(int A=0; A<2; A++){
                    if(BRobo.isEmpty()==true){
                        barajearRobo();
                    }
                    CJ1.add(BRobo.get(0));
                    BRobo.remove(0);
                }

                activoJugador1 = false;
                puntoCJ2 = 0;
                jLabel13.setText(Partida.Jugador1()+" perdio el desafio de castigo");
                jLabel14.setText(Partida.Jugador2());
                jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador2()))));
            }else{
                for(int A=0; A<2; A++){
                    if(BRobo.isEmpty()==true){
                        barajearRobo();
                    }

                    CJ2.add(BRobo.get(0));
                    BRobo.remove(0);
                }

                activoJugador1 = true;
                puntoCJ1 = 0;
                jLabel13.setText(Partida.Jugador2()+" perdio el desafio de castigo");
                jLabel14.setText(Partida.Jugador1());
                jLabel19.setIcon(new ImageIcon((getClass().getResource(Partida.avJugador1()))));
            }

        }

        jLabel18.setVisible(false);
        mostrarComparativa();
        mostrarLabels();
        mostrarPuntajes();
    }//GEN-LAST:event_jLabel18MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    // End of variables declaration//GEN-END:variables

}
