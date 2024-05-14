package co.edu.uniquindio.poo;


public class Espacio {
    
    private int numero;
    private int capacidad;
    private Vehiculo vehiculo;
    private boolean disponibles;

    public Espacio(int numero, int capacidad, Vehiculo vehiculo, boolean disponibles){
        this.numero = numero;
        this.capacidad = capacidad;
        this.vehiculo = vehiculo;
        this.disponibles = disponibles;
    }

    public int getNumero(){
        return numero;
    }

    public int capacidad(){
        return capacidad;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public boolean getDisponibles(){
        return disponibles;
    }

    @Override
    public String toString(){
        return "Espacio{" +
                "numero='" + numero + '\''+
                ", capacidad='" + capacidad + '\''+
                ", vehiculo='" + vehiculo + '\''+
                ", disponible='" + disponibles + '\''+
                '}';
    }
}
