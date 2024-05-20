package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class CarroTest {

    @Test
    // Este test verifica que un objeto Carro se crea correctamente con todos los datos completos
    // y que los métodos de obtención (getters) devuelven los valores esperados para cada atributo.
    public void datosCompletos() { 
        Propietario propietario = new Propietario("Alexander Buitrago");
        TipoCarro tipoCarro = TipoCarro.CAMIONETA; // Selecciona el tipo de carro adecuado
        // Crear un nuevo objeto Carro con los parámetros: tipoCarro, placa "KDM-645", año 2013, y el propietario creado.
        Carro carro = new Carro(tipoCarro, "KDM-645", 2013, propietario);
        // Verificar que la placa del carro es "KDM-645"
        assertEquals("KDM-645", carro.getPlaca());
        // Verificar que el modelo del carro es 2013
        assertEquals(2013, carro.getModelo());
        // Verificar que el propietario del carro es el propietario creado
        assertEquals(propietario, carro.getPropietario());
        // Verificar que el tipo de carro es CAMIONETA
        assertEquals(tipoCarro, carro.getTipoCarro()); 
    }

    @Test
    // Este test verifica que no se lanza una excepción al crear un objeto Carro
    // con un propietario y tipo de carro válidos, asegurando que el constructor de
    // la clase Carro maneje correctamente los parámetros no nulos.
    public void datosNulos() {
        Propietario propietario = new Propietario("Alexander Buitrago");
        TipoCarro tipoCarro = TipoCarro.CAMIONETA; // Selecciona el tipo de carro adecuado
        assertDoesNotThrow(() -> new Carro(tipoCarro, "KDM-645", 2013, propietario));
    }    

    @Test
    // Este test verifica que no se lanza una excepción al crear un objeto Carro
    // con un propietario y tipo de carro válidos, aunque el nombre del propietario,
    // tipo de carro, placa, y año están presentes.
    public void datosVacios() {
        Propietario propietario = new Propietario("Alexander Buitrago");
        TipoCarro tipoCarro = TipoCarro.CAMIONETA; // Selecciona el tipo de carro adecuado
        assertDoesNotThrow(() -> new Carro(tipoCarro, "KDM-645", 2013, propietario));
    }

    @Test
    // Este test verifica que no se lanza una excepción al crear un objeto Carro
    public void numeroNegativo() {
        Propietario propietario = new Propietario("Alexander Buitrago");
        TipoCarro tipoCarro = TipoCarro.CAMIONETA; // Selecciona el tipo de carro adecuado
        assertDoesNotThrow(() -> new Carro(tipoCarro, "KDM-645", 2013, propietario)); 
    }
}
