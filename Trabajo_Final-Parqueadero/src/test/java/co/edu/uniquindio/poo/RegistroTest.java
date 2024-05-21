package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    void testRegistro() {
        Propietario propietario = new Propietario("Antonio");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "HBO234", 2020, propietario);
        // Crear fechas de entrada y salida
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 20, 8, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 20, 10, 0);
        // Crear un objeto Registro con el carro, la fecha de entrada y la fecha de salida
        Registro registro = new Registro(carro, entrada, salida);

        // Verificar que el vehículo del registro es el mismo que el carro creado
        assertEquals(carro, registro.getVehiculo());
        // Verificar que la fecha de entrada del registro es la misma que la fecha de entrada creada
        assertEquals(entrada, registro.getFechaEntrada());
        // Verificar que la fecha de salida del registro es la misma que la fecha de salida creada
        assertEquals(salida, registro.getFechaSalida());
    }

    @Test
    void testRegistroSinFechaSalida() {
        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario);
        // Crear la fecha de entrada
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 20, 8, 0);
        // Crear un objeto Registro con el carro y la fecha de entrada, sin fecha de salida
        Registro registro = new Registro(carro, entrada);

        // Verificar que el vehículo del registro es el mismo que el carro creado
        assertEquals(carro, registro.getVehiculo());
        // Verificar que la fecha de entrada del registro es la misma que la fecha de entrada creada
        assertEquals(entrada, registro.getFechaEntrada());
        // Verificar que la fecha de salida del registro es null
        assertNull(registro.getFechaSalida());
    }

    @Test
    void testSetFechaSalida() {
        Propietario propietario = new Propietario("Azul");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "CIL856", 2020, propietario);
        // Crear la fecha de entrada
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 20, 8, 0);
        // Crear un objeto Registro con el carro y la fecha de entrada, sin fecha de salida
        Registro registro = new Registro(carro, entrada);
        // Crear la fecha de salida
        LocalDateTime salida = LocalDateTime.of(2024, 5, 20, 10, 0);
        // Establecer la fecha de salida en el registro
        registro.setFechaSalida(salida);

        // Verificar que la fecha de salida del registro es la misma que la fecha de salida creada
        assertEquals(salida, registro.getFechaSalida());
    }

    @Test
    void testCalcularCosto() {
        Propietario propietario = new Propietario("Pedro");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "SEX69F", 2020, propietario);
        // Crear la fecha de entrada
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 20, 8, 0);
        // Crear la fecha de salida
        LocalDateTime salida = LocalDateTime.of(2024, 5, 20, 10, 0);
        // Crear un objeto Registro con el carro, la fecha de entrada y la fecha de salida
        Registro registro = new Registro(carro, entrada, salida);

        //Asumimos que la tarifa por hora del carro es 15.0 (esto debe estar definido en la clase Vehiculo)
        double expectedCost = 2 * 15.0;// 2 horas * 15.0 tarifa por hora
        // Verificar que el costo calculado por el registro es el mismo que el costo esperado
        assertEquals(expectedCost, registro.calcularCosto());
    }

    @Test
    void testCalcularCostoMenosDeUnaHora() {
        Propietario propietario = new Propietario("Jorge");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "PUY34E", 2020, propietario);
        // Crear la fecha de entrada
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 20, 8, 0);
        // Crear la fecha de salida
        LocalDateTime salida = LocalDateTime.of(2024, 5, 20, 8, 30);
        // Crear un objeto Registro con el carro, la fecha de entrada y la fecha de salida
        Registro registro = new Registro(carro, entrada, salida);

        // Asumimos que la tarifa por hora del carro es 15.0 (esto debe estar definido en la clase Vehiculo)
        double expectedCost = 1 * 15.0; // Menos de una hora se cobra una hora completa
        // Verificar que el costo calculado por el registro es el mismo que el costo esperado
        assertEquals(expectedCost, registro.calcularCosto());
    }
}
