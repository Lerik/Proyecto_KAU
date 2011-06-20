
package Tablero;

class existenciaNick extends Exception{

    public existenciaNick(String nick) {
        super("El nickname "+nick+" ya se encuentra en uso");
    }

}
