package Tablero;

import javax.swing.ImageIcon;

public class Cartas extends java.awt.Label{

    private Color TipodeColor;
    private int NumerodeCarta;
    private ImageIcon Icono;

    public Cartas(Color TC, int NC, ImageIcon Ic){
        TipodeColor = TC;
        NumerodeCarta = NC;
        Icono = Ic;
    }

    public Color queColor(){
        return TipodeColor;
    }

    public int queNumero(){
        return NumerodeCarta;
    }

    public int quePuntaje(){
       int Puntaje=0;

        if(NumerodeCarta>=0 && NumerodeCarta<=9){
            Puntaje = NumerodeCarta;
        }else{
            if(NumerodeCarta==10 || NumerodeCarta==11 || NumerodeCarta==12){
                Puntaje = 20;
            }else if(NumerodeCarta==13 || NumerodeCarta==14){
                Puntaje = 50;
            }
        }

       return Puntaje;
    }

    public ImageIcon queImagen(){
        return Icono;
    }

    public Cartas[] barajaInicial(){
        Cartas[] Baraja = new Cartas[108];

        Baraja[0] = new Cartas(Color.NEGRO,0,new ImageIcon((getClass().getResource("/Imagenes/N0.jpg"))));
        Baraja[1] = new Cartas(Color.NEGRO,1,new ImageIcon((getClass().getResource("/Imagenes/N1.jpg"))));
        Baraja[2] = new Cartas(Color.NEGRO,2,new ImageIcon((getClass().getResource("/Imagenes/N2.jpg"))));
        Baraja[3] = new Cartas(Color.NEGRO,3,new ImageIcon((getClass().getResource("/Imagenes/N3.jpg"))));
        Baraja[4] = new Cartas(Color.NEGRO,4,new ImageIcon((getClass().getResource("/Imagenes/N4.jpg"))));
        Baraja[5] = new Cartas(Color.NEGRO,5,new ImageIcon((getClass().getResource("/Imagenes/N5.jpg"))));
        Baraja[6] = new Cartas(Color.NEGRO,6,new ImageIcon((getClass().getResource("/Imagenes/N6.jpg"))));
        Baraja[7] = new Cartas(Color.NEGRO,7,new ImageIcon((getClass().getResource("/Imagenes/N7.jpg"))));
        Baraja[8] = new Cartas(Color.NEGRO,8,new ImageIcon((getClass().getResource("/Imagenes/N8.jpg"))));
        Baraja[9] = new Cartas(Color.NEGRO,9,new ImageIcon((getClass().getResource("/Imagenes/N9.jpg"))));
        Baraja[10] = new Cartas(Color.NEGRO,10,new ImageIcon((getClass().getResource("/Imagenes/NR.jpg"))));
        Baraja[11] = new Cartas(Color.NEGRO,11,new ImageIcon((getClass().getResource("/Imagenes/NS.jpg"))));
        Baraja[12] = new Cartas(Color.NEGRO,12,new ImageIcon((getClass().getResource("/Imagenes/NT2.jpg"))));
        Baraja[13] = new Cartas(Color.NEGRO,1,new ImageIcon((getClass().getResource("/Imagenes/N1.jpg"))));
        Baraja[14] = new Cartas(Color.NEGRO,2,new ImageIcon((getClass().getResource("/Imagenes/N2.jpg"))));
        Baraja[15] = new Cartas(Color.NEGRO,3,new ImageIcon((getClass().getResource("/Imagenes/N3.jpg"))));
        Baraja[16] = new Cartas(Color.NEGRO,4,new ImageIcon((getClass().getResource("/Imagenes/N4.jpg"))));
        Baraja[17] = new Cartas(Color.NEGRO,5,new ImageIcon((getClass().getResource("/Imagenes/N5.jpg"))));
        Baraja[18] = new Cartas(Color.NEGRO,6,new ImageIcon((getClass().getResource("/Imagenes/N6.jpg"))));
        Baraja[19] = new Cartas(Color.NEGRO,7,new ImageIcon((getClass().getResource("/Imagenes/N7.jpg"))));
        Baraja[20] = new Cartas(Color.NEGRO,8,new ImageIcon((getClass().getResource("/Imagenes/N8.jpg"))));
        Baraja[21] = new Cartas(Color.NEGRO,9,new ImageIcon((getClass().getResource("/Imagenes/N9.jpg"))));
        Baraja[22] = new Cartas(Color.NEGRO,10,new ImageIcon((getClass().getResource("/Imagenes/NR.jpg"))));
        Baraja[23] = new Cartas(Color.NEGRO,11,new ImageIcon((getClass().getResource("/Imagenes/NS.jpg"))));
        Baraja[24] = new Cartas(Color.NEGRO,12,new ImageIcon((getClass().getResource("/Imagenes/NT2.jpg"))));

        Baraja[25] = new Cartas(Color.VERDE,0,new ImageIcon((getClass().getResource("/Imagenes/V0.jpg"))));
        Baraja[26] = new Cartas(Color.VERDE,1,new ImageIcon((getClass().getResource("/Imagenes/V1.jpg"))));
        Baraja[27] = new Cartas(Color.VERDE,2,new ImageIcon((getClass().getResource("/Imagenes/V2.jpg"))));
        Baraja[28] = new Cartas(Color.VERDE,3,new ImageIcon((getClass().getResource("/Imagenes/V3.jpg"))));
        Baraja[29] = new Cartas(Color.VERDE,4,new ImageIcon((getClass().getResource("/Imagenes/V4.jpg"))));
        Baraja[30] = new Cartas(Color.VERDE,5,new ImageIcon((getClass().getResource("/Imagenes/V5.jpg"))));
        Baraja[31] = new Cartas(Color.VERDE,6,new ImageIcon((getClass().getResource("/Imagenes/V6.jpg"))));
        Baraja[32] = new Cartas(Color.VERDE,7,new ImageIcon((getClass().getResource("/Imagenes/V7.jpg"))));
        Baraja[33] = new Cartas(Color.VERDE,8,new ImageIcon((getClass().getResource("/Imagenes/V8.jpg"))));
        Baraja[34] = new Cartas(Color.VERDE,9,new ImageIcon((getClass().getResource("/Imagenes/V9.jpg"))));
        Baraja[35] = new Cartas(Color.VERDE,10,new ImageIcon((getClass().getResource("/Imagenes/VR.jpg"))));
        Baraja[36] = new Cartas(Color.VERDE,11,new ImageIcon((getClass().getResource("/Imagenes/VS.jpg"))));
        Baraja[37] = new Cartas(Color.VERDE,12,new ImageIcon((getClass().getResource("/Imagenes/VT2.jpg"))));
        Baraja[38] = new Cartas(Color.VERDE,1,new ImageIcon((getClass().getResource("/Imagenes/V1.jpg"))));
        Baraja[39] = new Cartas(Color.VERDE,2,new ImageIcon((getClass().getResource("/Imagenes/V2.jpg"))));
        Baraja[40] = new Cartas(Color.VERDE,3,new ImageIcon((getClass().getResource("/Imagenes/V3.jpg"))));
        Baraja[41] = new Cartas(Color.VERDE,4,new ImageIcon((getClass().getResource("/Imagenes/V4.jpg"))));
        Baraja[42] = new Cartas(Color.VERDE,5,new ImageIcon((getClass().getResource("/Imagenes/V5.jpg"))));
        Baraja[43] = new Cartas(Color.VERDE,6,new ImageIcon((getClass().getResource("/Imagenes/V6.jpg"))));
        Baraja[44] = new Cartas(Color.VERDE,7,new ImageIcon((getClass().getResource("/Imagenes/V7.jpg"))));
        Baraja[45] = new Cartas(Color.VERDE,8,new ImageIcon((getClass().getResource("/Imagenes/V8.jpg"))));
        Baraja[46] = new Cartas(Color.VERDE,9,new ImageIcon((getClass().getResource("/Imagenes/V9.jpg"))));
        Baraja[47] = new Cartas(Color.VERDE,10,new ImageIcon((getClass().getResource("/Imagenes/VR.jpg"))));
        Baraja[48] = new Cartas(Color.VERDE,11,new ImageIcon((getClass().getResource("/Imagenes/VS.jpg"))));
        Baraja[49] = new Cartas(Color.VERDE,12,new ImageIcon((getClass().getResource("/Imagenes/VT2.jpg"))));

        Baraja[50] = new Cartas(Color.PURPURA,0,new ImageIcon((getClass().getResource("/Imagenes/P0.jpg"))));
        Baraja[51] = new Cartas(Color.PURPURA,1,new ImageIcon((getClass().getResource("/Imagenes/P1.jpg"))));
        Baraja[52] = new Cartas(Color.PURPURA,2,new ImageIcon((getClass().getResource("/Imagenes/P2.jpg"))));
        Baraja[53] = new Cartas(Color.PURPURA,3,new ImageIcon((getClass().getResource("/Imagenes/P3.jpg"))));
        Baraja[54] = new Cartas(Color.PURPURA,4,new ImageIcon((getClass().getResource("/Imagenes/P4.jpg"))));
        Baraja[55] = new Cartas(Color.PURPURA,5,new ImageIcon((getClass().getResource("/Imagenes/P5.jpg"))));
        Baraja[56] = new Cartas(Color.PURPURA,6,new ImageIcon((getClass().getResource("/Imagenes/P6.jpg"))));
        Baraja[57] = new Cartas(Color.PURPURA,7,new ImageIcon((getClass().getResource("/Imagenes/P7.jpg"))));
        Baraja[58] = new Cartas(Color.PURPURA,8,new ImageIcon((getClass().getResource("/Imagenes/P8.jpg"))));
        Baraja[59] = new Cartas(Color.PURPURA,9,new ImageIcon((getClass().getResource("/Imagenes/P9.jpg"))));
        Baraja[60] = new Cartas(Color.PURPURA,10,new ImageIcon((getClass().getResource("/Imagenes/PR.jpg"))));
        Baraja[61] = new Cartas(Color.PURPURA,11,new ImageIcon((getClass().getResource("/Imagenes/PS.jpg"))));
        Baraja[62] = new Cartas(Color.PURPURA,12,new ImageIcon((getClass().getResource("/Imagenes/PT2.jpg"))));
        Baraja[63] = new Cartas(Color.PURPURA,1,new ImageIcon((getClass().getResource("/Imagenes/P1.jpg"))));
        Baraja[64] = new Cartas(Color.PURPURA,2,new ImageIcon((getClass().getResource("/Imagenes/P2.jpg"))));
        Baraja[65] = new Cartas(Color.PURPURA,3,new ImageIcon((getClass().getResource("/Imagenes/P3.jpg"))));
        Baraja[66] = new Cartas(Color.PURPURA,4,new ImageIcon((getClass().getResource("/Imagenes/P4.jpg"))));
        Baraja[67] = new Cartas(Color.PURPURA,5,new ImageIcon((getClass().getResource("/Imagenes/P5.jpg"))));
        Baraja[68] = new Cartas(Color.PURPURA,6,new ImageIcon((getClass().getResource("/Imagenes/P6.jpg"))));
        Baraja[69] = new Cartas(Color.PURPURA,7,new ImageIcon((getClass().getResource("/Imagenes/P7.jpg"))));
        Baraja[70] = new Cartas(Color.PURPURA,8,new ImageIcon((getClass().getResource("/Imagenes/P8.jpg"))));
        Baraja[71] = new Cartas(Color.PURPURA,9,new ImageIcon((getClass().getResource("/Imagenes/P9.jpg"))));
        Baraja[72] = new Cartas(Color.PURPURA,10,new ImageIcon((getClass().getResource("/Imagenes/PR.jpg"))));
        Baraja[73] = new Cartas(Color.PURPURA,11,new ImageIcon((getClass().getResource("/Imagenes/PS.jpg"))));
        Baraja[74] = new Cartas(Color.PURPURA,12,new ImageIcon((getClass().getResource("/Imagenes/PT2.jpg"))));

        Baraja[75] = new Cartas(Color.ROJO,0,new ImageIcon((getClass().getResource("/Imagenes/R0.jpg"))));
        Baraja[76] = new Cartas(Color.ROJO,1,new ImageIcon((getClass().getResource("/Imagenes/R1.jpg"))));
        Baraja[77] = new Cartas(Color.ROJO,2,new ImageIcon((getClass().getResource("/Imagenes/R2.jpg"))));
        Baraja[78] = new Cartas(Color.ROJO,3,new ImageIcon((getClass().getResource("/Imagenes/R3.jpg"))));
        Baraja[79] = new Cartas(Color.ROJO,4,new ImageIcon((getClass().getResource("/Imagenes/R4.jpg"))));
        Baraja[80] = new Cartas(Color.ROJO,5,new ImageIcon((getClass().getResource("/Imagenes/R5.jpg"))));
        Baraja[81] = new Cartas(Color.ROJO,6,new ImageIcon((getClass().getResource("/Imagenes/R6.jpg"))));
        Baraja[82] = new Cartas(Color.ROJO,7,new ImageIcon((getClass().getResource("/Imagenes/R7.jpg"))));
        Baraja[83] = new Cartas(Color.ROJO,8,new ImageIcon((getClass().getResource("/Imagenes/R8.jpg"))));
        Baraja[84] = new Cartas(Color.ROJO,9,new ImageIcon((getClass().getResource("/Imagenes/R9.jpg"))));
        Baraja[85] = new Cartas(Color.ROJO,10,new ImageIcon((getClass().getResource("/Imagenes/RR.jpg"))));
        Baraja[86] = new Cartas(Color.ROJO,11,new ImageIcon((getClass().getResource("/Imagenes/RS.jpg"))));
        Baraja[87] = new Cartas(Color.ROJO,12,new ImageIcon((getClass().getResource("/Imagenes/RT2.jpg"))));
        Baraja[88] = new Cartas(Color.ROJO,1,new ImageIcon((getClass().getResource("/Imagenes/R1.jpg"))));
        Baraja[89] = new Cartas(Color.ROJO,2,new ImageIcon((getClass().getResource("/Imagenes/R2.jpg"))));
        Baraja[90] = new Cartas(Color.ROJO,3,new ImageIcon((getClass().getResource("/Imagenes/R3.jpg"))));
        Baraja[91] = new Cartas(Color.ROJO,4,new ImageIcon((getClass().getResource("/Imagenes/R4.jpg"))));
        Baraja[92] = new Cartas(Color.ROJO,5,new ImageIcon((getClass().getResource("/Imagenes/R5.jpg"))));
        Baraja[93] = new Cartas(Color.ROJO,6,new ImageIcon((getClass().getResource("/Imagenes/R6.jpg"))));
        Baraja[94] = new Cartas(Color.ROJO,7,new ImageIcon((getClass().getResource("/Imagenes/R7.jpg"))));
        Baraja[95] = new Cartas(Color.ROJO,8,new ImageIcon((getClass().getResource("/Imagenes/R8.jpg"))));
        Baraja[96] = new Cartas(Color.ROJO,9,new ImageIcon((getClass().getResource("/Imagenes/R9.jpg"))));
        Baraja[97] = new Cartas(Color.ROJO,10,new ImageIcon((getClass().getResource("/Imagenes/RR.jpg"))));
        Baraja[98] = new Cartas(Color.ROJO,11,new ImageIcon((getClass().getResource("/Imagenes/RS.jpg"))));
        Baraja[99] = new Cartas(Color.ROJO,12,new ImageIcon((getClass().getResource("/Imagenes/RT2.jpg"))));

        Baraja[100] = new Cartas(Color.NEGRO,13,new ImageIcon((getClass().getResource("/Imagenes/NT4.jpg"))));
        Baraja[101] = new Cartas(Color.NEGRO,13,new ImageIcon((getClass().getResource("/Imagenes/NT4.jpg"))));
        Baraja[102] = new Cartas(Color.NEGRO,13,new ImageIcon((getClass().getResource("/Imagenes/NT4.jpg"))));
        Baraja[103] = new Cartas(Color.NEGRO,13,new ImageIcon((getClass().getResource("/Imagenes/NT4.jpg"))));
        Baraja[104] = new Cartas(Color.NEGRO,14,new ImageIcon((getClass().getResource("/Imagenes/NC.jpg"))));
        Baraja[105] = new Cartas(Color.NEGRO,14,new ImageIcon((getClass().getResource("/Imagenes/NC.jpg"))));
        Baraja[106] = new Cartas(Color.NEGRO,14,new ImageIcon((getClass().getResource("/Imagenes/NC.jpg"))));
        Baraja[107] = new Cartas(Color.NEGRO,14,new ImageIcon((getClass().getResource("/Imagenes/NC.jpg"))));

        return Baraja;
    }

}
