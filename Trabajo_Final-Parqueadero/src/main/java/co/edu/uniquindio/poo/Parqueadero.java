package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Parqueadero {
    private byte cantidadPuestos;
    private final Puesto[][] puestos;
    private final ArrayList<Vehiculo> historialVehiculos = new ArrayList<>();

    public Parqueadero(int columnas, int filas, byte cantidadPuestos){

        puestos = new Puesto[columnas][filas];
        for (int posicionI = 0; posicionI < columnas; posicionI++){
            for (int posicionJ = 0; posicionJ < filas; posicionJ++){
                puestos[posicionI][posicionJ] = new Puesto(columnas, filas, null, false);
            }
        }

        this.cantidadPuestos = columnas * filas;

    }

    public byte getCantidadPuestos(){
        return cantidadPuestos;
    }

    public boolean verificarDisponibilidad(int posicionI, int posicionJ){
        return !puestos[posicionI][posicionJ].estaOcupado();
    }

    public void ocuparPuestos(int posicionI, int posicionJ, Vehiculo vehiculo){
        if (verificarDisponibilidad(posicionI, posicionJ)){
            puestos[posicionI][posicionJ].ocuparPuesto(vehiculo);
            historialVehiculos.add(vehiculo);
        }else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    public void liberarPuesto(int posicionI, int posicionJ){
        puestos[posicionI][posicionJ].liberarPuesto();
    }

    public String obtenerPropietario(int posicionI, int posicionJ){
        if (puestos[posicionI][posicionJ].estaOcupado()){
            return puestos[posicionI][posicionJ].getVehiculo().getPropietario();
        } else {
            return "El puesto está vacio.";
        }
    }

    

}