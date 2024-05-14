package co.edu.uniquindio.poo;
import java.util.Objects;

public class Usuario {
    
    private final String nombre;
    private final Vehiculo vehiculo;
    private final String placa;

    public Usuario(String nombre, Vehiculo vehiculo, String placa){
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.placa = placa;

    }

    public String getNombre(){
        return nombre;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public String getPlaca(){
        return placa;
    } 

    @Override
    public String toString(){
        return "Usuario{" +
                "nombre='" + nombre + '\''+
                ", vehiculo='" + vehiculo + '\''+
                ", placa='" + placa + '\''+
                '}';
    }

    @Override 
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(placa, usuario.placa);
    }

    @Override
    public int hashCode(){
        return placa != null ? placa.hashCode() : 0;
    }
}
