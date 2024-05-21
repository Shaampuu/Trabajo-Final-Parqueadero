package co.edu.uniquindio.poo;

/*
 * La clase Carro representa un carro y extiende de la clase Vehiculo.
 */
public class Carro extends Vehiculo {
    private TipoCarro tipoCarro;

    /*
     * Se crea su respectivo constructor, este contiene una enumeracion de el tipo de carro, da una cadena de texto para la placa,
     * genera un numero para el modelo y llama la clase propietario para definirla como un objeto.
     */
    public Carro(TipoCarro tipoCarro, String placa, int modelo, Propietario propietario) {
        super(placa, modelo, propietario);
        this.tipoCarro = tipoCarro;
        validarPlaca(placa);
        validarModelo(modelo);
        validarPropietario(propietario);
    }

    /*
     * Se generan los respectivos getters y setters.
     */
    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    /*
     * Valida que la placa no sea nula ni esté vacía.
     */
    private void validarPlaca(String placa) {
        assert placa != null && !placa.isEmpty() : "La placa no puede ser nula o vacía";
    }

    /*
     * Valida que el modelo no sea un numero negativo o sea mayor a cero (0)
     */
    private void validarModelo(int modelo) {
        assert modelo > 0 : "El modelo debe ser un número positivo";
    }

    /*
     * Valida que el propietario no sea nulo ni este vacío.
     */
    private void validarPropietario(Propietario propietario) {
        assert propietario != null : "El propietario no puede ser nulo";
    }

    /*
     * Retorna la tarifa por hora del carro basada en su tipo.
     */
    @Override
    public double getTarifaPorHora() {
        switch (tipoCarro) {
            case CAMIONETA:
                return 15.0;
            case DEPORTIVO:
                return 20.0;
            default:
                return 10.0;
        }
    }
}

