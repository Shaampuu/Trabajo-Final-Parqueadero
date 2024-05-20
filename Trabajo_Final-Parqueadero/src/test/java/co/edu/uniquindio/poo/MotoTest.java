package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

/**
 * Unit test for simple App.
 */
public class MotoTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    // Este test verifica que un objeto Moto se crea correctamente con todos los datos completos
    // y que los métodos de obtención (getters) devuelven los valores esperados para cada atributo.
    public void datosCompletos() {
        LOG.info("Iniciando test datosCompletos");
        var propietario = new Propietario("Veronica Martinez");
        var moto = new Moto("KUK-44F", 2022, propietario, 120);
        // Registrar en el log el valor esperado del nombre del propietario
        LOG.info("Valor esperado: " + "Veronica Martinez");
        // Registrar en el log el valor real obtenido del nombre del propietario
        LOG.info("Valor real: " + moto.getPropietario().getNombre());
        // Verificar que el nombre del propietario de la moto sea "Veronica Martinez"
        assertEquals("Veronica Martinez", moto.getPropietario().getNombre());
        LOG.info("Finalizando test datosCompletos");
    }

    @Test
    // Este test verifica que el constructor de la clase Moto lanza una excepción
    // cuando se proporcionan valores nulos o inválidos para sus parámetros.
    public void datosNulos(){
        LOG.info("Iniciando test datosNulos");
         // Verificar que se lanza una excepción al intentar crear una moto con valores nulos e inválidos
        assertThrows(Throwable.class, () -> new Moto(null, (int) 0, null, (int) 0));
        LOG.info("Finalizando test datosNulos");
    }

    @Test
    public void datosVacios(){
    // Este test verifica que el constructor de la clase Moto lanza una excepción
    // cuando se proporcionan valores vacíos o inválidos para sus parámetros.
        LOG.info("Iniciando test datosVacíos");
        var propietario = new Propietario("Veronica Martinez");
        // Verificar que se lanza una excepción al intentar crear una moto con valores vacíos e inválidos
        assertThrows(Throwable.class, () -> new Moto(" ", (int) 0, propietario, (int) 0));
        LOG.info("Finalizando test datosVacíos");
    }

    @Test
    // Este test verifica que el constructor de la clase Moto lanza una excepción
    // cuando se proporcionan valores negativos para los parámetros de año y cilindrada.
    public void numeroNegativo(){
        LOG.info("Iniciando test númeroNegativo");
        var propietario = new Propietario("Veronica Martinez");
        // Verificar que se lanza una excepción al intentar crear una moto con año y cilindrada negativos
        assertThrows(Throwable.class, () -> new Moto("TTA-98F", (int) -2023, propietario, (int) -130));
        TesteadorDeNumeroNegativo testeador = new TesteadorDeNumeroNegativo();
        // Verificar que se lanza una excepción al ejecutar el testeador
        assertThrows(Throwable.class, testeador);
        LOG.info("Finalizando test númeroNegativo");
    }

    private static class TesteadorDeNumeroNegativo implements Executable{
        // Este método verifica la creación de un objeto Moto con valores negativos
        // para el año y la cilindrada, asegurando que el constructor de la clase Moto
        // maneje adecuadamente estos casos.
        @Override
        public void execute () throws Throwable {
            var propietario = new Propietario("Veronica Martinez");
            new Moto("TTA-98F", (int) -2023, propietario, (int) -130);
        }
    }
    
}