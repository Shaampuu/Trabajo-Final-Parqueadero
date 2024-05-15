package co.edu.uniquindio.poo;
import java.util.ArrayList;

public class Parqueadero {
    private byte cantidadPuestos;
    private final Puesto[][] puestos;
    private final ArrayList<Vehiculo>  

    public Parqueadero(int filas, int columnas){
        
        this.cantidadPuestos = filas * columnas;

        puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                puestos[i][j] = new Puesto(i,j);
            }
        }
    }

    private void inicializarEspacios(){

        for(int i = 0; i < espacios [0].length; i++){
            espacios[0][i] = new Espacio((i+1),6, Vehiculo.CARRO, true);
        }

        for(int i = 1; i <= 2; i++){
            for(int j = 0; j< espacios[0].length; j++){
                espacios[i][j] = new Espacio((j+1),6, Vehiculo.MOTO, true);
            }
        }
    }

    private Usuario crearUsuario(String nombre, Vehiculo vehiculo,String placa) throws Exception{

        if(nombre == null || nombre.isBlank()){
            throw new Exception("El nombre es obligatorio");
        }

        if(vehiculo == null){
            throw new Exception("El tipo de vehiculo es obligatrio");
        }

        if(placa == null || placa.isBlank()){
            throw new Exception("La placa es obligatoria")
        }

        if(buscarUsuario(placa) != null){
            throw new Exception("El usuario ya existe");
        }

        Usuario usuario = Usuario.builder()
                .nombre(nombre)
                .vehiculo(vehiculo)
                .placa(placa)
                .buid();
        
        usuario.add(usuario);
        return usuario;

    }

    @Override
    public Usuario buscarUsuario(String placa){

        for(Usuario usuario : usuarios){
            if(usuario.getPlaca().equals(placa)){
                return placa;
            }
        }

        return null;
    }

    @Override
    public Espacio buscarEspacio(int numero){
        for(int i = 0; i < espacios.length; i++){
            for(int j = 0; j < espacios[i].length; j++){
                if(espacios[i][j].getNumero() == numero){
                    return espacios[i][j];
                }
            }
        }
        return null;
    }

}