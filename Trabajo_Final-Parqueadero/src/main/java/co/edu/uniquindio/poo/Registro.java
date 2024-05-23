package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

/*
 * La clase Registro representa el registro de la entrada y salida de vehiculos que se deben encontrar 
 * dentro de un sistema.
 * Este contiene: llama la clase Vehiculo para definir el registro de entrada y salida, 
 * nos da una fecha para definir la fecha de entrada y fecha de salida. 
 */
public class Registro {
    
    private Vehiculo vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    /*
     * Se crea su respectivo constructor, el cual contiene la clase Vehiculo
     * y la fecha de entrada y fecha de salida.  
     */
    public Registro(Vehiculo vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Registro(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida= null;
    }
    
    /*
     * Se generan sus respectivos getters y setters 
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

    /*
     * Se crea un metodo  para calcular el costo en base a la fecha de salida, la duración de estacionamiento,
     * calcular el numero de horas estacionadas, cobrar por menos de un tiempo determinado, obtener la tarifa especifica,
     * calcular el costo total. 
     */
    public double calcularCosto() {
        assert fechaSalida != null : "El vehículo aún está estacionado, la fecha de salida es null.";
    
        // Calcular la duración del estacionamiento
        Duration duracion = Duration.between(fechaEntrada, fechaSalida);
    
        // Calcular el número de horas estacionadas
        long horasEstacionadas = duracion.toHours();
    
        // Si ha estacionado por menos de una hora, se cobra una hora completa
        if (duracion.toMinutes() % 60 != 0) {
            horasEstacionadas++;
        }
    
        // Obtener la tarifa específica para este tipo de vehículo
        double tarifaPorHora = vehiculo.getTarifaPorHora();
    
        // Calcular el costo total
        return horasEstacionadas * tarifaPorHora;
    }
}
