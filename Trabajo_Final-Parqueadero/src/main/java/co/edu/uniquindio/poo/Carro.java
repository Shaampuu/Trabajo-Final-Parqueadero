package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    public Carro (String placa, int modelo, String propietario){
        super(placa, modelo, propietario);
    }

    @Override
    public double calcularCosto(int horas, double tarifa){
        return horas * tarifa; 
    }
    
}
