package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * La clase Parqueadero representa un estacionamiento que maneja puestos de aparcamiento
 * para motos y carros. Permite registrar la entrada y salida de vehículos y mantener 
 * un historial de estos registros.
 * Este tiene: un numero total de puestos en el parqueadero, collecion de motos actualmente en el parqueadero,
 * colleción de carros actualmente en el parqueadero, matriz bidimensional que representa los puestos de aparcamiento en el parqueadero, 
 * lista de registros de entrada y salida de vehículos en el parqueadero.
 */
public class Parqueadero {
    private final int cantidadPuestos;
    private final Collection<Moto> motos;
    private final Collection<Carro> carros;
    private final Puesto[][] puestos;
    private final ArrayList<Registro> historialRegistros = new ArrayList<>();

    /*
     * Se crea el respectivo constructor, con un numero entero de filas y columnas.
     */
    public Parqueadero(int columnas, int filas) {
        assert columnas > 0 : "El número de columnas debe ser mayor a cero";
        assert filas > 0 : "El número de filas debe ser mayor a cero";

        this.cantidadPuestos = columnas * filas;

        motos = new LinkedList<>();
        carros = new LinkedList<>();

        puestos = new Puesto[columnas][filas];
        /*
         * Inicializa la matriz de puestos en el parqueadero. Cada elemento de la matriz representa
         * un puesto de aparcamiento y se crea una nueva instancia de Puesto para cada posición
         * en la matriz.
         */
        for (int posicionI = 0; posicionI < columnas; posicionI++) {
            for (int posicionJ = 0; posicionJ < filas; posicionJ++) {
                puestos[posicionI][posicionJ] = new Puesto(posicionI, posicionJ, null, columnas, filas);
            }
        }
    }

    /*
     * Se generan los getters del numero total de puestos.
     */
    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    /*
     * Verifica si un puesto especifico esta disponible 
     */
    public boolean verificarDisponibilidad(int posicionI, int posicionJ) {
        return !puestos[posicionI][posicionJ].estaOcupado();
    }

    /*
     * Ocupa un puesto especifico con un vehiculo, registrando la entrada del vehiculo.
     */
    public void ocuparPuestos(int posicionI, int posicionJ, Vehiculo vehiculo) {
        if (verificarDisponibilidad(posicionI, posicionJ)) {
            LocalDateTime fechaEntrada = LocalDateTime.now(); // Obtener la fecha y hora actual
            puestos[posicionI][posicionJ].ocuparPuesto(vehiculo);
            Registro registro = new Registro(vehiculo, fechaEntrada, null); // Pasar fecha de entrada
            vehiculo.setRegistro(registro); // Asociar el registro con el vehículo
            historialRegistros.add(registro);
        } else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    /*
     * Busca el primer puesto disponible y parquea el vehiculo. 
     */
    public boolean buscarYParquearVehiculo(Vehiculo vehiculo) {
        for (int posicionI = 0; posicionI < puestos.length; posicionI++) {
            for (int posicionJ = 0; posicionJ < puestos[0].length; posicionJ++) {
                if (verificarDisponibilidad(posicionI, posicionJ)) {
                    ocuparPuestos(posicionI, posicionJ, vehiculo);
                    return true;
                }
            }
        }
        System.out.println("No hay puesto disponible");
        return false;
    }

    /*
     * Libera un pueste especifico que fue ocupado, registrando la salida del vehiculo.
     */
    public void liberarPuesto(int posicionI, int posicionJ) {
        Puesto puesto = puestos[posicionI][posicionJ];
        if (puesto.estaOcupado()) {
            Vehiculo vehiculo = puesto.getVehiculo();
            LocalDateTime fechaSalida = LocalDateTime.now();
    
            // Buscar el registro correspondiente en el historial de registros
            Registro registro = vehiculo.getRegistro();
            if (registro != null) {
                registro.setFechaSalida(fechaSalida);
                puesto.liberarPuesto();
            } else {
                System.err.println("No se encontró el registro correspondiente para el vehículo.");
            }
        }
    }
    
    public Puesto[][] getPuestos() {
        return puestos;
    }

    /*
     * Obtiene el nombre del propietario segun el puesto ocupado.
     */
    public String obtenerPropietario(int posicionI, int posicionJ) {
        if (puestos[posicionI][posicionJ].estaOcupado()) {
            return puestos[posicionI][posicionJ].getVehiculo().getPropietario().getNombre();
        } else {
            return "El puesto está vacio.";
        }
    }

    /*
     * Agrega una moto a la colección de motos en el parqueadero 
     * Verifica que la placa de la moto no exista ya en la colección.
     */
    public void agregarMoto(Moto moto) {
        assert !validarPlacaMotoExiste(moto.getPlaca()) : "La placa ya existe";
        motos.add(moto);
    }

    /*
     * Busca y retorna una moto por su placa.
     */
    public Moto getMoto(String placa) {
        Moto motoInteres = null;
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                motoInteres = moto;
            }
        }
        return motoInteres;
    }

    /*
     * Retorna una colección inmodificable de todas las motos en el parqueadero.
     */
    public Collection<Moto> getMotos() {
        return Collections.unmodifiableCollection(motos);
    }

    /*
     * Agrega un carro a la colección de carros en el parqueadero 
     * Verifica que la placa del carro no exista ya en la colección.
     */
    public void agregarCarro(Carro carro) {
        assert !validarPlacaCarroExiste(carro.getPlaca()) : "La placa ya existe";
        carros.add(carro);
    }

    /*
     * Busca y retorna un carro por su placa.
     */
    public Carro getCarro(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
    
    /*
     * Retorna una colección inmodificable de todos los carros en el parqueadero.
     */
    public Collection<Carro> getCarros() {
        return Collections.unmodifiableCollection(carros);
    }
    
    /*
     * Verifica si una placa de moto ya existe en la colección de motos.
     */
    private boolean validarPlacaMotoExiste(String placa) {
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Verifica si una placa de un carro ya existe en la colección de carros.
     */
    private boolean validarPlacaCarroExiste(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Retorna el historial de registros de entrada y salida de vehículos en el parqueadero.
     */
    public ArrayList<Registro> getHistorialRegistros() {
        return historialRegistros;
    }

    /*
     * Genera un reporte diario de ingresos por tipo de vehículo para una fecha específica.
     */
    public Map<TipoVehiculo, Double> generarReporteDiario(LocalDate fecha) {
        Map<TipoVehiculo, Double> reporteDiario = inicializarReporte();
    
        for (Registro registro : historialRegistros) {
            if (esFechaIgual(registro, fecha)) {
                actualizarReporte(registro, reporteDiario);
            }
        }
        return reporteDiario;
    }
    
    /*
     * Genera un reporte mensual de ingresos por tipo de vehículo para un mes y año específicos.
     */
    public Map<TipoVehiculo, Double> generarReporteMensual(int mes, int año) {
        Map<TipoVehiculo, Double> reporteMensual = inicializarReporte();
    
        for (Registro registro : historialRegistros) {
            if (esMesYAñoIguales(registro, mes, año)) {
                actualizarReporte(registro, reporteMensual);
            }
        }
        return reporteMensual;
    }
    
    /*
     * Inicializa un reporte con los tipos de vehículos y los ingresos inicializados a cero.
     * Los tipos de vehículos se obtienen de las enumeraciones TipoCarro y TipoMoto.
     */
    private Map<TipoVehiculo, Double> inicializarReporte() {
        Map<TipoVehiculo, Double> reporte = new HashMap<>();
        for (TipoCarro tipoCarro : TipoCarro.values()) {
            reporte.put(tipoCarro.getTipoVehiculo(), 0.0);
        }
        for (TipoMoto tipoMoto : TipoMoto.values()) {
            reporte.put(tipoMoto.getTipoVehiculo(), 0.0);
        }
        return reporte;
    }
    
    /*
     * Verifica si la fecha del registro es igual a la fecha especificada.
     */
    private boolean esFechaIgual(Registro registro, LocalDate fecha) {
        return registro.getFechaEntrada().toLocalDate().equals(fecha);
    }
    
    /*
     * Verifica si el mes y año del registro son iguales al mes y año especificados.
     */
    private boolean esMesYAñoIguales(Registro registro, int mes, int año) {
        LocalDate fechaEntrada = registro.getFechaEntrada().toLocalDate();
        return fechaEntrada.getMonthValue() == mes && fechaEntrada.getYear() == año;
    }
    
    /*
     * Actualiza el reporte con los datos del registro.
     * Calcula el costo del registro y lo agrega al total acumulado del tipo de vehículo correspondiente.
     */
    private void actualizarReporte(Registro registro, Map<TipoVehiculo, Double> reporte) {
        double costo = registro.calcularCosto();
        Vehiculo vehiculo = registro.getVehiculo();
    
        if (vehiculo instanceof Moto) {
            reporte.compute(TipoVehiculo.MOTO, (tipo, acumulado) -> (acumulado == null) ? costo : acumulado + costo);
        } else if (vehiculo instanceof Carro) {
            TipoCarro tipoCarro = ((Carro) vehiculo).getTipoCarro();
            if (tipoCarro != null) {
                reporte.compute(tipoCarro.getTipoVehiculo(), (tipo, acumulado) -> (acumulado == null) ? costo : acumulado + costo);
            } else {
                System.err.println("Tipo de vehículo desconocido: " + vehiculo.getClass().getSimpleName());
            }
        } else {
            System.err.println("Tipo de vehículo desconocido: " + vehiculo.getClass().getSimpleName());
        }
    }             
}
