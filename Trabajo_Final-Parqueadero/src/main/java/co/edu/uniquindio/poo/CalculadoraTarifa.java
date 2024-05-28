package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;  // Import statement added

/**
 * La clase CalculadoraTarifa maneja el cálculo del costo basado en las horas y la tarifa por hora.
 */
public class CalculadoraTarifa {

    /**
     * Calcula el costo total basado en la fecha de entrada, la fecha de salida y la tarifa por hora.
     *
     * @param fechaEntrada   La fecha y hora de entrada.
     * @param fechaSalida    La fecha y hora de salida.
     * @param tarifaPorHora  La tarifa por hora.
     * @return               El costo total.
     */
    public static double calcularCosto(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, double tarifaPorHora) {
        // Check for null values
        Objects.requireNonNull(fechaEntrada, "La fecha de entrada no puede ser null.");
        Objects.requireNonNull(fechaSalida, "El vehículo aún está estacionado, la fecha de salida es null.");

        // Calcular la duración del estacionamiento
        Duration duracion = Duration.between(fechaEntrada, fechaSalida);

        // Calcular el número de horas estacionadas
        long horasEstacionadas = duracion.toHours();

        // Si ha estacionado por menos de una hora, se cobra una hora completa
        if (duracion.toMinutes() % 60 != 0) {
            horasEstacionadas++;
        }

        // Calcular el costo total
        return horasEstacionadas * tarifaPorHora;
    }
}
