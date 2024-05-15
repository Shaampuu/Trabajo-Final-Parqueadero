package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{
    private int velocidadMaxima;
    
    public Moto(String placa, int modelo, String propietario, int velocidadMaxima){
        super(placa, modelo, propietario);
        
        this.velocidadMaxima=velocidadMaxima;
    }

    public int getVelocidadMaxima(){
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima){
        this.velocidadMaxima=velocidadMaxima;
    }
}
