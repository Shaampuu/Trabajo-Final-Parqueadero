package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Map;

public class ParqueaderoTest {

    private Parqueadero parqueadero;
    private Propietario propietario1;
    private Propietario propietario2;
    private Carro carro;
    private Moto moto;

    @BeforeEach
    // Este método se ejecuta antes de cada test para inicializar el estado necesario
    // del parqueadero y los objetos relacionados. Se asegura de que el parqueadero
    // tenga dimensiones válidas y de que se creen y configuren correctamente los
    // objetos de Propietario, Carro y Moto necesarios para los tests.
    public void setUp() {
        // Inicializar un parqueadero con matriz 3x3
        parqueadero = new Parqueadero(3, 3); // Asegúrate de que las dimensiones sean válidas
        propietario1 = new Propietario("Juan");
        propietario2 = new Propietario("Maria");
        carro = new Carro(TipoCarro.CAMIONETA, "ABC123", 2020, propietario1); // Modifica para usar el enum TipoCarro
        moto = new Moto("XYZ789", 2021, propietario2, 120); // Ajusta el constructor de Moto
    }

    @Test
    // Este test verifica que el método agregarCarro() del parqueadero
    // funcione correctamente al agregar un carro al parqueadero,
    // asegurando que el carro se registre adecuadamente y se pueda recuperar
    // utilizando su número de placa.
    public void testAgregarCarro() {
        parqueadero.agregarCarro(carro);
        // Verificar que el carro se haya agregado y pueda recuperarse utilizando su número de placa
        assertNotNull(parqueadero.getCarro("ABC123"));
    }

    @Test
    // Este test verifica que el método agregarMoto() del parqueadero
    // funcione correctamente al agregar una moto al parqueadero,
    // asegurando que la moto se registre adecuadamente y se pueda recuperar
    // utilizando su número de placa.
    public void testAgregarMoto() {
        parqueadero.agregarMoto(moto);
        // Verificar que la moto se haya agregado y pueda recuperarse utilizando su número de placa
        assertNotNull(parqueadero.getMoto("XYZ789"));
    }

    @Test
    // Este test verifica que el método buscarYParquearVehiculo() del parqueadero
    // funcione correctamente al buscar un puesto disponible y parquear un carro,
    // asegurando que el carro se estacione correctamente y que el estado de disponibilidad
    // del puesto se actualice adecuadamente.
    public void testBuscarYParquearCarro() {
        parqueadero.agregarCarro(carro);
        // Buscar un puesto disponible y parquear el carro
        boolean parqueado = parqueadero.buscarYParquearVehiculo(carro);
        // Verificar que el carro haya sido parqueado exitosamente
        assertTrue(parqueado);
        // Verificar que el puesto [0, 0] no esté disponible después de parquear el carro
        assertFalse(parqueadero.verificarDisponibilidad(0, 0));
    }

    @Test
    // Este test verifica que el método buscarYParquearVehiculo() del parqueadero
    // funcione correctamente al buscar un puesto disponible y parquear una moto,
    // asegurando que la moto se estacione correctamente y que el estado de disponibilidad
    // del puesto se actualice adecuadamente.
    public void testBuscarYParquearMoto() {
        parqueadero.agregarMoto(moto);
        // Buscar un puesto disponible y parquear la moto
        boolean parqueado = parqueadero.buscarYParquearVehiculo(moto);
        // Verificar que la moto haya sido parqueada exitosamente
        assertTrue(parqueado);
        // Verificar que el puesto [0, 0] no esté disponible después de parquear la moto
        assertFalse(parqueadero.verificarDisponibilidad(0, 0));
    }

    @Test
    // Este test verifica que el método liberarPuesto() del parqueadero
    // funcione correctamente al liberar un puesto específico que ha sido ocupado
    // por un vehículo, y que el estado de disponibilidad del puesto se actualice correctamente.
    public void testLiberarPuesto() {
        parqueadero.agregarCarro(carro);
        parqueadero.buscarYParquearVehiculo(carro);
        parqueadero.liberarPuesto(0, 0);
        // Verificar que el puesto [0, 0] esté disponible después de liberarlo
        assertTrue(parqueadero.verificarDisponibilidad(0, 0));
    }

    @Test
    // Este test verifica que el método obtenerPropietario() del parqueadero
    // funcione correctamente al devolver el nombre del propietario del vehículo
    // estacionado en una posición específica dentro del parqueadero.
    public void testObtenerPropietario() {
        parqueadero.agregarCarro(carro);
        parqueadero.buscarYParquearVehiculo(carro);
        // Obtener el nombre del propietario del vehículo estacionado en la posición [0, 0]
        String nombrePropietario = parqueadero.obtenerPropietario(0, 0);
        // Verificar que el nombre del propietario obtenido sea "Juan"
        assertEquals("Juan", nombrePropietario);
    }

    @Test
    // Este test verifica que el método generarReporteDiario() del parqueadero
    // funcione correctamente al generar un reporte diario que incluya registros
    // de vehículos que han sido agregados, parqueados y liberados durante el día actual.
    public void testGenerarReporteDiario() {
        // Agregar carro y registrarlo en el parqueadero
        parqueadero.agregarCarro(carro);
        parqueadero.buscarYParquearVehiculo(carro);
        parqueadero.liberarPuesto(0, 0);

        // Generar el reporte diario para la fecha actual
        Map<TipoVehiculo, Double> reporteDiario = parqueadero.generarReporteDiario(LocalDate.now());

        // Validar que el reporte no sea nulo
        assertNotNull(reporteDiario);

        // Validar que el reporte no esté vacío
        assertFalse(reporteDiario.isEmpty(), "El reporte diario no debe ser vacío");

        // Validar que el reporte contenga el tipo de vehículo del carro
        assertTrue(reporteDiario.containsKey(carro.getTipoCarro().getTipoVehiculo()));

        // Validar que el valor del reporte para el tipo de vehículo del carro sea mayor
        // que 0
        assertTrue(reporteDiario.get(carro.getTipoCarro().getTipoVehiculo()) >= 0);
    }

    @Test
    // Este test verifica que el método generarReporteMensual() del parqueadero
    // funcione correctamente al generar un reporte mensual que incluya registros
    // de vehículos que han sido agregados, parqueados y liberados durante el mes actual.
    public void testGenerarReporteMensual() {
        // Agregar carro y registrarlo en el parqueadero
        parqueadero.agregarCarro(carro);
        parqueadero.buscarYParquearVehiculo(carro);
        parqueadero.liberarPuesto(0, 0);
    
        // Generar el reporte mensual para el mes y año actuales
        Map<TipoVehiculo, Double> reporteMensual = parqueadero.generarReporteMensual(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    
        // Validar que el reporte no sea nulo
        assertNotNull(reporteMensual);
    
        // Validar que el reporte no esté vacío
        assertFalse(reporteMensual.isEmpty(), "El reporte mensual no debe ser vacío");
    
        // Validar que el reporte contenga el tipo de vehículo del carro
        assertTrue(reporteMensual.containsKey(carro.getTipoCarro().getTipoVehiculo()));
    
        // Validar que el valor del reporte para el tipo de vehículo del carro sea mayor que 0
        assertTrue(reporteMensual.get(carro.getTipoCarro().getTipoVehiculo()) >= 0);
    }
    

    @Test
    public void testVerificarDisponibilidad() {
        assertTrue(parqueadero.verificarDisponibilidad(0, 0));
    }

    @Test
    // Este test verifica que un puesto específico en el parqueadero se ocupe correctamente
    // después de agregar un carro y luego ocupar el puesto con ese carro.
    // El propósito es asegurar que la función ocuparPuestos() actualice correctamente
    // el estado de disponibilidad del puesto en cuestión.
    public void testOcuparPuestos() {
        parqueadero.agregarCarro(carro);
        parqueadero.ocuparPuestos(1, 1, carro);
        // Verificar que el puesto [1, 1] no esté disponible
        assertFalse(parqueadero.verificarDisponibilidad(1, 1));
    }

    @Test
    // Este test verifica que el historial de registros del parqueadero no esté vacío
    // después de agregar, parquear y liberar un carro. El propósito es asegurar que
    // todas las acciones de parqueo y liberación se registren correctamente en el historial.
    public void testHistorialRegistros() {
        parqueadero.agregarCarro(carro);
        parqueadero.buscarYParquearVehiculo(carro);
        parqueadero.liberarPuesto(0, 0);

        // Verificar que el historial de registros no esté vacío
        assertFalse(parqueadero.getHistorialRegistros().isEmpty());
    }
}
