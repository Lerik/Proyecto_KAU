
package Tablero;

public class Ranking {

    private int Codigo;
    private int Puntaje;

    public Ranking(int Cod, int Punt){
        Codigo = Cod;
        Puntaje = Punt;
    }

    public int cualCodigo(){
        return Codigo;
    }

    public int cualPuntaje(){
        return Puntaje;
    }

}
