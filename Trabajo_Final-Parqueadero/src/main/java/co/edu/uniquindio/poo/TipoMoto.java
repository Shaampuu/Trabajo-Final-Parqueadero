package co.edu.uniquindio.poo;

/*
 * La enumeración TipoMoto representa los diferentes tipos de motos.
 * Cada tipo de moto está asociado a un tipo de vehículo general.
 */
public enum TipoMoto {
    MOTO_CLASICA(TipoVehiculo.MOTO), 
    MOTO_HIBRIDA(TipoVehiculo.MOTO);

    private final TipoVehiculo tipoVehiculo;

    /*
     * Constructor privado para inicializar el tipo de moto con el tipo de vehículo asociado.
     */
    private TipoMoto(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /*
     * Retorna el tipo de vehículo asociado al tipo de moto.
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}

