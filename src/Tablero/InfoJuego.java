
package Tablero;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoJuego {

    private RandomAccessFile Codigos = null, Jugadores = null, Partidas = null;
    private static String Cargador="";
    private File Folder = null, arc = null;
    private Scanner Leer = new Scanner(System.in);
    private ArrayList Puntuaciones = new ArrayList();

    public InfoJuego() throws Exception{
        Folder = new File("src/Tablero/Archivos del Juego/");


        if(Folder.exists()){
            Codigos = new RandomAccessFile("src/Tablero/Archivos del Juego/codigos.uno","rw");
            Jugadores = new RandomAccessFile("src/Tablero/Archivos del Juego/jugadores.uno","rw");
            Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/partidas.uno","rw");
        }else{
            if(Folder.mkdirs()){
                Codigos = new RandomAccessFile("src/Tablero/Archivos del Juego/codigos.uno","rw");
                Jugadores = new RandomAccessFile("src/Tablero/Archivos del Juego/jugadores.uno","rw");
                Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/partidas.uno","rw");
            }else{
                throw new imposibleFolder();
            }
        }
    }

    public int generarCodigo() throws Exception{
        int tmpInt = 0;

        if(Codigos.length()==0){
            Codigos.writeInt(1000);
            return 1000;
        }else{
            Codigos.seek(Codigos.length()-4);
            tmpInt = Codigos.readInt();
            Codigos.writeInt(++tmpInt);
            return tmpInt;
        }
    }

    private boolean existeNickname(String nick) throws Exception{
        Jugadores.seek(0);

        while(Jugadores.getFilePointer()<Jugadores.length()){
            Jugadores.readInt();

            if(Jugadores.readUTF().compareTo(nick)==0){
                return true;
            }

            Jugadores.readInt();
            Jugadores.readUTF();
            Jugadores.readInt();
            Jugadores.readBoolean();
            Jugadores.readUTF();
        }

        return false;
    }

    public String adicionarJugador(String nick, int edad, String genero, String icon){

        try{
            if(existeNickname(nick)==true){
                throw new existenciaNick(nick);
            }

            int Codigo = generarCodigo();

            Jugadores.seek(Jugadores.length());
            Jugadores.writeInt(Codigo);
            Jugadores.writeUTF(nick);
            Jugadores.writeInt(edad);
            Jugadores.writeUTF(genero);
            Jugadores.writeInt(0);
            Jugadores.writeBoolean(true);
            Jugadores.writeUTF(icon);

        }catch(existenciaNick a){
            return a.getMessage();
        }catch (Exception e) {
            return "Hubo un error en el almacenamiento del jugador, intentelo de nuevo";
        }

        return "Jugador almacenado correctamente";

    }

    public String eliminarJugador(String nick){
        try{

            if(existeNickname(nick)==true){
                Jugadores.readInt();
                Jugadores.readUTF();
                Jugadores.readInt();
                Jugadores.writeBoolean(false);
            }else{
                throw new existenciaNick(nick);
            }

        }catch(existenciaNick f){
             return f.getMessage();
        }catch (Exception e) {
            return "Hubo un error en la eliminacion del jugador, intentelo de nuevo";
        }

        return "El jugador "+nick+" ha sido eliminado permanentemente del juego";
    }

    private boolean agregarListado(){
        int Cod = 0, Punt, Mayor=0;

        try{

            Jugadores.seek(0);

            while(Jugadores.getFilePointer()<Jugadores.length()){
                Cod = Jugadores.readInt();
                Jugadores.readUTF();
                Jugadores.readInt();
                Jugadores.readUTF();
                Punt = Jugadores.readInt();
                Jugadores.readBoolean();
                Jugadores.readUTF();

                Puntuaciones.add(new Ranking(Cod, Punt));
            }

            ArrayList Temporal = (ArrayList)(Puntuaciones.clone());
            Puntuaciones.clear();

            int Vueltas = Temporal.size();

            for(int A = 0; A<Vueltas; A++){

                for(int B = 0; B<Temporal.size(); B++){
                    Ranking tmp = (Ranking)(Temporal.get(B));

                    if(tmp.cualPuntaje()>Mayor){
                        Mayor = tmp.cualPuntaje();
                        Cod = B;
                    }
                }

                Puntuaciones.add(Temporal.get(Cod));
                Temporal.remove(Cod);

            }

        }catch(Exception e){
            return false;
        }

        return true;
    }

    public String siguienteJugador(){
        String Jugador="";
        Ranking tmp = (Ranking)(Puntuaciones.get(0));

        try{

            Jugadores.seek(0);

            while(Jugadores.getFilePointer()<Jugadores.length()){
                if(Jugadores.readInt()==tmp.cualCodigo()){
                    Jugador = tmp.cualCodigo()+" -- "+Jugadores.readUTF()+" -- ";
                    Jugadores.readInt();
                    Jugadores.readUTF();
                    Jugador += Jugadores.readInt();
                    break;
                }

                Jugadores.readUTF();
                Jugadores.readUTF();
                Jugadores.readInt();
                Jugadores.readBoolean();
                Jugadores.readUTF();
            }

        }catch(Exception e){
            return "Error del juego - no se ha encontrado algun jugador";
        }

        Puntuaciones.remove(0);
        return Jugador;

    }

    public Object[] todosNicks()throws Exception{
        ArrayList Nicks = new ArrayList();
        Jugadores.seek(0);
        String Nick;
        boolean activo;
        int Pos = 0;

        while(Jugadores.getFilePointer()<Jugadores.length()){
            Jugadores.readInt();
            Nick = Jugadores.readUTF();
            Jugadores.readInt();
            Jugadores.readUTF();
            Jugadores.readInt();
            activo = Jugadores.readBoolean();
            Jugadores.readUTF();

            if(activo){
                Nicks.add(Nick);
            }
        }

        return Nicks.toArray();
    }

    public int generarPartida() throws Exception{
        int tmpPart = 0;

        if(Partidas.length()==0){
            Partidas.writeInt(100);
            return 100;
        }else{
            Partidas.seek(Partidas.length()-4);
            tmpPart = Partidas.readInt();
            Partidas.writeInt(++tmpPart);
            return tmpPart;
        }
    }

    public boolean adicionarPartida(String Jugador1, String Jugador2){

        try{

            Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/Partida_"+generarPartida()+".uno","rw");
            Partidas.writeUTF(Jugador1);
            Partidas.writeInt(0);
            Partidas.writeBoolean(false);
            Partidas.writeBoolean(false);
            Partidas.writeUTF(Jugador2);
            Partidas.writeInt(0);
            Partidas.writeBoolean(false);
            Partidas.writeBoolean(false);
            Partidas.writeBoolean(true);

        }catch(Exception e){
            return false;
        }

        return true;

    }

    public String Jugador1(){
        try{
            Partidas.seek(0);
            return Partidas.readUTF();
        }catch(Exception e){
            return "Jugador 1";
        }
    }

    public String Jugador2(){
        try{
            Partidas.seek(0);
            Partidas.readUTF();
            Partidas.readInt();
            Partidas.readBoolean();
            Partidas.readBoolean();
            return Partidas.readUTF();
        }catch(Exception e){
            return "Jugador 2";
        }
    }

    public String avJugador1(){

        try{
            Jugadores.seek(0);

            while(Jugadores.getFilePointer()<Jugadores.length()){
                Jugadores.readInt();

                if(Jugadores.readUTF().compareTo(Jugador1())==0){
                    Jugadores.readInt();
                    Jugadores.readUTF();
                    Jugadores.readInt();
                    Jugadores.readBoolean();
                    return Jugadores.readUTF();
                }

                Jugadores.readInt();
                Jugadores.readUTF();
                Jugadores.readInt();
                Jugadores.readBoolean();
                Jugadores.readUTF();
            }

        }catch(Exception e){
            return "/Imagenes/av1.jpg";
        }

        return "/Imagenes/av1.jpg";

    }

    public String avJugador2(){

        try{
            Jugadores.seek(0);

            while(Jugadores.getFilePointer()<Jugadores.length()){
                Jugadores.readInt();

                if(Jugadores.readUTF().compareTo(Jugador2())==0){
                    Jugadores.readInt();
                    Jugadores.readUTF();
                    Jugadores.readInt();
                    Jugadores.readBoolean();
                    return Jugadores.readUTF();
                }

                Jugadores.readInt();
                Jugadores.readUTF();
                Jugadores.readInt();
                Jugadores.readBoolean();
                Jugadores.readUTF();
            }

        }catch(Exception e){
            return "/Imagenes/av4.jpg";
        }

        return "/Imagenes/av4.jpg";

    }

    public String ultimaPartida(){

        try{
            if(Cargador.compareTo("")==0){
                Partidas.seek(Partidas.length()-4);
                int valor = Partidas.readInt();

                Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/Partida_"+valor+".uno","rw");
            }else{
                Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/"+Cargador+".uno","rw");
            }
            return "Correcto";
        }catch(Exception e){
            return "Incorrecto";
        }

    }

    public ArrayList listaPartidas(){
        ArrayList Lista = new ArrayList();

        try{
            Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/partidas.uno","rw");
            int Contador = 0;
            Long Posicion;
            String Nick1, Nick2;
            Partidas.seek(0);

            while(Partidas.getFilePointer()<Partidas.length()){
                Contador = Partidas.readInt();
                Posicion = Partidas.getFilePointer();
                Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/Partida_"+Contador+".uno","rw");
                Partidas.seek(0);
                Nick1 = Partidas.readUTF();
                Partidas.readInt();
                Partidas.readBoolean();
                Partidas.readBoolean();
                Nick2 = Partidas.readUTF();
                Lista.add(new Listado(Contador,Nick1+" vs "+Nick2));
                Partidas = new RandomAccessFile("src/Tablero/Archivos del Juego/partidas.uno","rw");
                Partidas.seek(Posicion);
            }

        }catch(Exception e){
            for(int A= 0; A<10; A++){
                Lista.add("sin partida");
            }

            return Lista;
        }

        return Lista;
    }

    public void estCargador(String name){
        Cargador = name;
    }

    public boolean actualizarPartida(int P1, int P2, int P3){
        try{
            Partidas.seek(0);
            Partidas.readUTF();
            Partidas.writeInt(P1);
            if(P3==1){
                Partidas.writeBoolean(true);
            }else{
                Partidas.writeBoolean(false);
            }
            Partidas.readBoolean();
            Partidas.readUTF();
            Partidas.writeInt(P2);
            if(P3==2){
                Partidas.writeBoolean(true);
            }else{
                Partidas.writeBoolean(false);
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public String nickGanador(){
        try{
            Partidas.seek(0);
            String name = Partidas.readUTF();
            Partidas.readInt();
            if(Partidas.readBoolean()==true){
                return name;
            }else{
                Partidas.readBoolean();
                return Partidas.readUTF();
            }
        }catch(Exception e){
            return "Inexistente";
        }
    }

    public String iconGanador(){
        String gane = nickGanador();

        try{
            Jugadores.seek(0);

            while(Jugadores.getFilePointer()<Jugadores.length()){
                Jugadores.readInt();

                if(Jugadores.readUTF().compareTo(gane)==0){
                    Jugadores.readInt();
                    Jugadores.readUTF();
                    Jugadores.readBoolean();
                    gane = Jugadores.readUTF();
                    break;
                }

                Jugadores.readInt();
                Jugadores.readUTF();
                Jugadores.readBoolean();
                Jugadores.readUTF();
            }
        }catch(Exception e){
            return "ERROR";
        }
        Cargador = "";
        return gane;
    }

}
