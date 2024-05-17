package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());


    @Test
    public void datosCompletos() {
        LOG.info("Iniciando test datosCompletos");
        var parqueadero = new Parqueadero(12,12);
        assertEquals(144, parqueadero.getCantidadPuestos() );
        LOG.info("Finalizando test datosCompletos");
    }

    @Test
    public void valoresErroneosDePuestos(){
        LOG.info("Iniciando test valoresErroneosDePuestos");
        var parqueadero = new Parqueadero(12, 12);
        assertNotEquals(parqueadero.getCantidadPuestos(), 24);
    }

    @Test
    public void agregarMoto(){
        LOG.info("Iniciando test agregarMoto");
        var parqueadero = new Parqueadero(12, 12);
        var moto = new Moto("TTA-98F", (int) 2023, "Alexander Buitrago", (int) 130);
        parqueadero.agregarMoto(moto);
        assertTrue(parqueadero.getMotos().contains(moto));
        assertEquals(1,parqueadero.getMotos().size());
        LOG.info("Finalizando test agregarMoto");
    }

    @Test 
    public void agregarCarro(){
        LOG.info("Iniciando test agregarMoto");
        var parqueadero new Parqueadero(12, 12);
        var carro = new Carro("KDM-645", (int) 2013, "Alexander Buitrago");
        parqueadero.agregarCarro(carro);
        assertTrue(parqueadero.getCarro(carro));
        assertEquals(1, parqueadero.getCarros().size());
    }

}