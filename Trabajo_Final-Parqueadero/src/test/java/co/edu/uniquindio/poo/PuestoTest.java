package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PuestoTest {

    @Test
    // Este test verifica que el constructor de la clase Puesto funcione correctamente
    // al crear un puesto con las posiciones, vehículo y dimensiones especificadas.
    // Asegura que los valores iniciales se establezcan adecuadamente.
    public void testConstructor() {
        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario);
        Puesto puesto = new Puesto(0, 0, carro, 5, 5);
        // Verificar que la posición I del puesto sea 0
         assertEquals(0, puesto.getPosicionI());
        // Verificar que la posición J del puesto sea 0
        assertEquals(0, puesto.getPosicionJ());
        // Verificar que el vehículo en el puesto sea el carro creado
        assertEquals(carro, puesto.getVehiculo());
    }

    @Test
    // Este test verifica que el método estaOcupado() de la clase Puesto
    // funcione correctamente al determinar si un puesto está ocupado o no.
    public void testEstaOcupado() {
        // Crear un puesto vacío en la posición [0, 0] con matriz de 5x5
        Puesto puestoVacio = new Puesto(0, 0, null, 5, 5);
        // Verificar que el puesto vacío no esté ocupado
        assertFalse(puestoVacio.estaOcupado());

        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario);
        // Crear un puesto ocupado en la posición [0, 0] con el carro y matriz de 5x5
        Puesto puestoOcupado = new Puesto(0, 0, carro, 5, 5);
        // Verificar que el puesto ocupado esté ocupado
        assertTrue(puestoOcupado.estaOcupado());
    }

    @Test
    // Este test verifica que el método ocuparPuesto() de la clase Puesto
    // funcione correctamente al ocupar un puesto con un vehículo,
    // asegurando que el estado del puesto se actualice adecuadamente y
    // que el vehículo se asigne correctamente al puesto.
    public void testOcuparPuesto() {
        // Crear un puesto vacío en la posición [0, 0] con matriz de 5x5
        Puesto puesto = new Puesto(0, 0, null, 5, 5);
        assertFalse(puesto.estaOcupado());

        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario);
        // Ocupar el puesto con el carro
        puesto.ocuparPuesto(carro);
        // Verificar que el puesto esté ocupado después de ocuparlo con el carro
        assertTrue(puesto.estaOcupado());
        // Verificar que el vehículo en el puesto sea el carro que se usó para ocupar el puesto
        assertEquals(carro, puesto.getVehiculo());
    }

    @Test
    // Este test verifica que el método liberarPuesto() de la clase Puesto
    // funcione correctamente al liberar un puesto que está ocupado por un vehículo,
    // asegurando que el estado del puesto se actualice adecuadamente y
    // que el vehículo sea removido del puesto.
    public void testLiberarPuesto() {
        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario);
        Puesto puesto = new Puesto(0, 0, carro, 5, 5);
        // Verificar que el puesto esté ocupado
        assertTrue(puesto.estaOcupado());

        // Liberar el puesto
        puesto.liberarPuesto();
        // Verificar que el puesto no esté ocupado después de liberarlo
        assertFalse(puesto.estaOcupado());
        // Verificar que el vehículo en el puesto sea nulo después de liberarlo
        assertEquals(null, puesto.getVehiculo());
    }
}
