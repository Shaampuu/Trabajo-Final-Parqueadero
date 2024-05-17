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
public class CarroTest {
    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void datosCompletos(){
        LOG.info("Iniciando test datosCompletos");
        var carro = new Carro("KDM-645", (int) 2013, "Alexander Buitrago");
        assertEquals("KDM-645", carro.getPlaca());
        assertEquals((int) 2013, carro.getModelo());
        assertEquals("Alexander Buitrago", carro.getPropietario());
    }

    @Test 
    public void datosNulos(){
        LOG.info("Iniciando test datosNulos");
        assertThrows(Throwable.class, () -> new Carro(null, (int) 0, null));
        LOG.info("Finalizando test datosNulos");
    }

    @Test 
    public void datosVacios(){
        LOG.info("Iniciando test datosVacíos");
        assertThrows(Throwable.class, () -> new Carro(" ", (int) 0, " "));
        LOG.info("Finalizando test datosVacíos");
    }

    @Test 
    public void numeroNegativo() {
        LOG.info("iniciando test númerosNegativos");
        assertThrows(Throwable.class, () -> new Carro("KDM-645", (int)-2013, "Alexander Buitrago"));
        TesteadorDeNumeroNegativo testeador = new TesteadorDeNumeroNegativo ();
        assertThrows(Throwable.class, testeador);
        LOG.info("finalizando test númerosNegativos");
    }

    private static class TesteadorDeNumeroNegativo implements Executable{
        @Override
        public void execute () throws Throwable {
            new Carro("KDM-645", (int)-2013, "Alexander Buitrago");
        }   
    }
}
