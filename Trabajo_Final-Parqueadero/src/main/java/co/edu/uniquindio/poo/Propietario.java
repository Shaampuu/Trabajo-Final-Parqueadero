package co.edu.uniquindio.poo;

/*
 * La clase Propietario representa el nombre con el cual se identifica el propietario del vehiculo. 
 * Permite definir el nombre del propietario de uno o mas vehiculo.
 * Este solo tiene: una entrada de texto para definir el nombre.
 */
public class Propietario {
    private String nombre;

    /*
     * Se crea su respectivo contructor, el cual contiene un texto definido para el nombre.
     */
    public Propietario(String nombre){
        assert nombre != null && !nombre.isBlank() : "El nombre debe ser diferente de null";

        this.nombre=nombre;
    }

    /*
     * Se generean los getters y setters. 
     */
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    } 

    /*
     * Devuelve el nombre del propietario, lo que proporciona una representación
     * más legible del objeto propietario cuando se imprime o se registra.
     */
    @Override
    public String toString(){
        return nombre;
    }

}
