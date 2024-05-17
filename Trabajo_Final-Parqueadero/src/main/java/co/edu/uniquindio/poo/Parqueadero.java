package co.edu.uniquindio.poo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Parqueadero {
    private int cantidadPuestos;
    private final Collection<Moto> motos;
    private final Collection<Carro> carros;
    private final Puesto[][] puestos;
    private final ArrayList<Registro> historialRegistros = new ArrayList<>();

    public Parqueadero(int columnas, int filas){

        this.cantidadPuestos = columnas * filas;

        motos = new LinkedList<>();
        carros = new LinkedList<>();

        puestos = new Puesto[columnas][filas];
        for (int posicionI = 0; posicionI < columnas; posicionI++){
            for (int posicionJ = 0; posicionJ < filas; posicionJ++){
                puestos[posicionI][posicionJ] = new Puesto(posicionI, posicionJ, null, false);
            }
        }
    }

    public int getCantidadPuestos(){
        return cantidadPuestos;
    }

    public boolean verificarDisponibilidad(int posicionI, int posicionJ){
        return !puestos[posicionI][posicionJ].estaOcupado();
    }

    public void ocuparPuestos(int posicionI, int posicionJ, Vehiculo vehiculo, double tarifaPorHora){
        if (verificarDisponibilidad(posicionI, posicionJ)){
            puestos[posicionI][posicionJ].ocuparPuesto(vehiculo);
            Registro registro = new Registro(LocalTime.now(), null, tarifaPorHora);
            historialRegistros.add(registro);
        }else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    public void liberarPuesto(int posicionI, int posicionJ){
        if (!verificarDisponibilidad(posicionI, posicionJ)) {
            puestos[posicionI][posicionJ].liberarPuesto();
            for (Registro registro : historialRegistros) {
                if (registro.getHoraSalida() == null) {
                    registro.setHoraSalida(LocalTime.now());
                    break;
                }
            }
        } else {
            System.out.println("El puesto ya está libre.");
        }
    }

    public String obtenerPropietario(int posicionI, int posicionJ){
        if (puestos[posicionI][posicionJ].estaOcupado()){
            return puestos[posicionI][posicionJ].getVehiculo().getPropietario().getNombre();
        } else {
            return "El puesto está vacio.";
        }
    }

    public void agregarMoto (Moto moto) {
        assert validarPlacaMotoExiste(moto.getPlaca()) == false : "La placa ya existe";
        motos.add(moto);
    }

    public Moto getMoto(String placa) {
        Moto motoInteres = null; 
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)){
                motoInteres = moto;
            }
        }
        return motoInteres;
    }

    public Collection<Moto> getMotos(){
        return Collections.unmodifiableCollection(motos);
    }

    public void agregarCarro (Carro carro) {
        assert validarPlacaCarroExiste(carro.getPlaca());
        carros.add(carro);
    }

    public Carro getCarro (String placa) {
        Carro carroInteres = null; 
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)){
                carroInteres = carro;
            }
        }
        return carroInteres;
    }

    public Collection<Carro> getCarros(){
        return Collections.unmodifiableCollection(carros);
    }

    private boolean validarPlacaMotoExiste(String placa) {
        boolean existe = false; 
        for (Moto moto : motos){
            if (moto.getPlaca().equals(placa)){
                existe = true;
            }
        }
        return existe;
    }

    private boolean validarPlacaCarroExiste(String placa) {
        boolean existe = false; 
        for (Carro carro : carros){
            if (carro.getPlaca().equals(placa)){
                existe = true;
            }
        }
        return existe;
    }
}