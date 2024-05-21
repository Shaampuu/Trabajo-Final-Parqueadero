package co.edu.uniquindio.poo;

import  java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        //Crear propietarios
        Propietario propietario1 = new Propietario("Jorge Simon Nieto");
        Propietario propietario2 = new Propietario("Nicolas Buitrago");

        //Crear Vehiculos
        Carro carro1 = new Carro(TipoCarro.CAMIONETA, "ABC-123", 2020, propietario2);
        Moto moto2 = new Moto("NMA-44X", 2020, propietario1, 130);

        //Crear parqueadero con 3 columnas y 3 filas
        Parqueadero parqueadero = new Parqueadero(3, 3);

        //Agregar vehiculos al parqueadero
        parqueadero.agregarCarro(carro1);
        parqueadero.agregarMoto(moto2);

        //Buscar y parquear vehiculos
        parqueadero.buscarYParquearVehiculo(carro1);
        parqueadero.buscarYParquearVehiculo(moto2);

        //Mostrar el propietario del vehiculo en una posición especifica
        System.out.println(parqueadero.obtenerPropietario(0, 0));
        System.out.println(parqueadero.obtenerPropietario(0, 1));

        //Liberar un puesto y mostrar el propietario nuevamente
        parqueadero.liberarPuesto(0, 0);
        System.out.println(parqueadero.obtenerPropietario(0, 0));//Deberia mostrar el puesto esta vacío

        //Liberar el puesto de la moto 
        parqueadero.liberarPuesto(0, 1);
        
        //Generar reporte diario y mensual 
        System.out.println("Reporte Diario:" + parqueadero.generarReporteDiario(LocalDate.now()));
        System.out.println("Reporte Mensual:" + parqueadero.generarReporteMensual(LocalDate.now().getMonthValue(), LocalDate.now().getYear()));
    }
}
