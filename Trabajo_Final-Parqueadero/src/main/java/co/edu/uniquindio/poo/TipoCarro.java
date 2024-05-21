package co.edu.uniquindio.poo;

/**
 * La enumeración TipoCarro representa los diferentes tipos de carros.
 * Cada tipo de carro está asociado a un tipo de vehículo general.
 */
public enum TipoCarro {
    CARRO(TipoVehiculo.CARRO), CAMIONETA(TipoVehiculo.CARRO), DEPORTIVO(TipoVehiculo.CARRO);

    private final TipoVehiculo tipoVehiculo;

    /*
     * Constructor privado para inicializar el tipo de carro con el tipo de vehículo asociado.
     */
    private TipoCarro(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /*
     * Retorna el tipo de vehículo asociado al tipo de carro.
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}

