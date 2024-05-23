package co.edu.uniquindio.poo;

/*
 * La clase Moto representa una motocicleta y hereda de la clase Vehiculo.
 * Incluye un detalle específico el cual es la velocidad máxima.
 */
public class Moto extends Vehiculo {
    private int velocidadMaxima;
    private double tarifaPorHora;

    /*
     * Se crea su respectivo constructor el cual contiene una cadena de texto para la placa,
     * un número para definir el modelo de la moto, llamamos la clase Propietario para devolverla como un objeto
     * y un número para definir la velocidad maxima de la moto. 
     */
    public Moto(String placa, int modelo, Propietario propietario, int velocidadMaxima) {
        super(placa, modelo, propietario);
        assert velocidadMaxima > 0 : "La velocidad máxima debe ser mayor a 0 (cero)";
        this.velocidadMaxima = velocidadMaxima;
        this.tarifaPorHora = calcularTarifaPorHora();
    }

    /*
     * Se generan los getters y setters.
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.tarifaPorHora = calcularTarifaPorHora();
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    /*
     * Calcula la tarifa por hora de la motocicleta basada en su velocidad máxima.
     */
    private double calcularTarifaPorHora() {
        if (velocidadMaxima >= 0 && velocidadMaxima <= 100) {
            return 5.0;
        } else if (velocidadMaxima > 100 && velocidadMaxima <= 150) {
            return 7.0;
        } else {
            return 10.0;
        }
    }
}
