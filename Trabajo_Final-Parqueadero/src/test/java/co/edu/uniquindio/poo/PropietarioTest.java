package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
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
public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    /*
     * Este test verifica que un objeto Propietario se creo correctamente con todos los datos completos
     * Los metodos de obtención (getters) devuelvan los valores esperados para cada atributo.
     */
    @Test 
    public void datosCompletos(){
        LOG.info("Iniciando test datosCompletos");
        var propietario = new Propietario("Jorge Simon Nieto");
        assertEquals("Jorge Simon Nieto", propietario.getNombre());
        LOG.info("Finalizando test datosCompletos");
    }

    /*
     * Este test verifica que el constructor de la clase Propietario lanza una excepción 
     * cuando se proporcionan valores nulos o inválidos para sus parámetros.
     */
    @Test 
    public void datosNulos(){
        LOG.info("Iniciando test datosNulos");
        assertThrows(Throwable.class, () -> new Propietario(null));
        LOG.info("Finalizando test datosNulos");
    }
    
    /*
     * Este test verifica que el constructor de la clase Propietario lanza una excepción 
     * cuando se proporcionan valores vacios o inválidos para sus parametros. 
     */
    @Test 
    public void datosVacios(){
        LOG.info("Iniciando test datosVacios");
        assertThrows(Throwable.class, () -> new Propietario(""));
        LOG.info("Finalizando test datosVacios");
    }
    
}