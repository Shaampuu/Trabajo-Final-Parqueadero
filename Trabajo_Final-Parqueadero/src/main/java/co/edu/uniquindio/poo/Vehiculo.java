package co.edu.uniquindio.poo;

/*
 * La clase abstracta Vehiculo representa un vehículo general en el sistema de parqueadero.
 * Incluye atributos comunes como la placa, el modelo y el propietario.
 * Proporciona métodos getter y setter para estos atributos y define un método abstracto para obtener la tarifa por hora.
 */
public abstract class Vehiculo {
    private String placa; 
    private int modelo;
    private Propietario propietario;

    /*
     * Constructor para inicializar una instancia de Vehiculo con la información especificada.
     */
    public Vehiculo(String placa, int modelo, Propietario propietario) {
        assert placa != null && !placa.isBlank() : "La placa debe ser diferente de null";
        assert modelo > 0 : "El modelo del vehiculo debe ser mayor a 0 (cero)";
        assert propietario != null : "El propietario debe ser diferente de null";

        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /*
     * Se hacen los respectivos getters y setters. 
     */
    public String getPlaca() {
        return placa; 
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    } 

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    /*
     * Método abstracto para obtener la tarifa por hora del vehículo.
     * Este método debe ser implementado por las subclases de Vehiculo.
     */
    public abstract double getTarifaPorHora();
}