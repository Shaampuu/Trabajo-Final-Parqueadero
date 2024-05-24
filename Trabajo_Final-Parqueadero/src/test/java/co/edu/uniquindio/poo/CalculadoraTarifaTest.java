package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTarifaTest {

    @Test
    public void testCalcularCostoNormalDuration() {
        // Caso de prueba: Duración normal (2 horas y 30 minutos)
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 24, 12, 30);
        double tarifa = 10.0;
        double expected = 30.0; // 3 horas * 10.0 (redondea hacia arriba al siguiente hora completa)

        double actual = CalculadoraTarifa.calcularCosto(entrada, salida, tarifa);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalcularCostoLessThanOneHour() {
        // Caso de prueba: Duración menor a una hora (45 minutos)
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 24, 10, 45);
        double tarifa = 10.0;
        double expected = 10.0; // 1 hora * 10.0 (se cobra una hora completa aunque sea menos de una hora)

        double actual = CalculadoraTarifa.calcularCosto(entrada, salida, tarifa);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalcularCostoExactlyOneHour() {
        // Caso de prueba: Duración exactamente de una hora
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 24, 11, 0);
        double tarifa = 10.0;
        double expected = 10.0; // 1 hora * 10.0

        double actual = CalculadoraTarifa.calcularCosto(entrada, salida, tarifa);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalcularCostoMultipleDays() {
        // Caso de prueba: Duración que abarca varios días
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 26, 10, 0);
        double tarifa = 10.0;
        double expected = 480.0; // 24 horas * 2 días * 10.0

        double actual = CalculadoraTarifa.calcularCosto(entrada, salida, tarifa);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalcularCostoFechaSalidaNull() {
        // Caso de prueba: Asegurar que la afirmación para fechaSalida null se dispare
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime salida = null;
        double tarifa = 10.0;

        assertThrows(AssertionError.class, () -> {
            CalculadoraTarifa.calcularCosto(entrada, salida, tarifa);
        });
    }
}
