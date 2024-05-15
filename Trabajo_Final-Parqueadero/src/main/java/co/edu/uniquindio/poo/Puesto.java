package co.edu.uniquindio.poo;

public class Puesto {
    private int posicionI;
    private int posicionJ;
    private Vehiculo vehiculo;


    public Puesto(int posicionI, int posicionJ, Vehiculo vehiculo, boolean disponibles){
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.vehiculo = vehiculo;
    }

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

    public boolean estaocupado(){
        return vehiculo != null;
    }

    public void ocuparPuesto(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public void liberarPuesto(){
        this.vehiculo = null;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }
}