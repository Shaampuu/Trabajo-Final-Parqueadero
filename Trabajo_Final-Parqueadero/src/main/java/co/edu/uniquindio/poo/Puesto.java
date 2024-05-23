package co.edu.uniquindio.poo;

/*
 * La clase Puesto representa la ubicacion de los puestos que se encuentran dentro de un parqueadero.
 * Permite definir y registrar la posición en la cual se ubica un vehiculo dentro de un parqueadero.
 * Este tiene: un numero para la posicion I y un numero para la posicion J, 
 * ademas de esto tambien llama la clase Vehiculo para definir el estado del puesto.
 */
public class Puesto {
    private int posicionI;
    private int posicionJ;
    private Vehiculo vehiculo;

    /*
     * Se crea su respectivo constructor, el cual contiene el numero entero de posición I y posicion J,
     * contiene la informacion que hay en la clase Vehiculo y también contiene el número entero de columnas y filas.
     */
    public Puesto(int posicionI, int posicionJ, Vehiculo vehiculo, int columnas, int filas){
        assert posicionI >= 0 && posicionI < columnas : "PosiciónI debe estar dentro de los límites (0 a columnas-1)";
        assert posicionJ >= 0 && posicionJ < filas : "PosiciónJ debe estar dentro de los límites (0 a filas-1)";

        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.vehiculo = vehiculo;
    }

    /*
     * Se generan los respectivos getters y setters. 
     */
    public int getPosicionI(){
        return posicionI;
    }

    public void setPosicionI(int posicionI){
        this.posicionI = posicionI;
    }

    public int getPosicionJ(){
        return posicionJ;
    }

    public void setPosicionJ(int posicionJ){
        this.posicionJ = posicionJ;
    }

    /*
     * Se genera un metodo el cual nos define si el puesto esta ocupado y nos devuelve que esta ocupado.
     */
    public boolean estaOcupado(){
        return vehiculo != null;
    }

    /*
     * Se genera un metodo para ocupar el puesto con un Vehiculo.
     */
    public void ocuparPuesto(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    /*
     * Se genera un metodo para liberar el puesto de un vehiculo el cual devuelve un null cuando no esta ocupado.
     */
    public void liberarPuesto(){
        this.vehiculo = null;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }
}
