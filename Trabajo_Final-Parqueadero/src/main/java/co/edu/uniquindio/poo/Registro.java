package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 * La clase Registro representa el registro de la entrada y salida de vehículos en el parqueadero.
 */
public class Registro {
    
    private Vehiculo vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    /**
     * Constructor para inicializar el registro con los datos del vehículo, fecha de entrada y salida.
     */
    public Registro(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Registro(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = null;
    }
    
    /**
     * Getters y setters para los atributos de la clase.
     */
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Método para calcular el costo usando la clase CalculadoraTarifa.
     *
     * @return El costo total del estacionamiento.
     */
    public double calcularCosto() {
        return CalculadoraTarifa.calcularCosto(fechaEntrada, fechaSalida, vehiculo.getTarifaPorHora());
    }
}
