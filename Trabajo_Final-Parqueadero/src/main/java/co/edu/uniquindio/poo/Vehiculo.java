package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private String placa; 
    private int modelo;
    private String propietario;

    public Vehiculo (String placa, int modelo, String propietario){
        this.placa=placa;
        this.modelo=modelo;
        this.propietario=propietario; 
    }

    public String getPlaca(){
        return placa; 
    }

    public void setPlaca(String placa){
        this.placa=placa;
    } 

    public int getModelo(){
        return modelo;
    }

    public void setModelo(int modelo){
        this.modelo=modelo;
    }

    public String getPropietario(){
        return propietario;
    }

    public void setPropietario(String propietario){
        this.propietario=propietario;
    }
}