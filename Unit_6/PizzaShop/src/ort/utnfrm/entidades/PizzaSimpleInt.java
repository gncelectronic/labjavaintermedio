package ort.utnfrm.entidades;
/**
 * Asumimos que las pizzas se pueden agregar o sacar del menu pero no editar, es decir
 * no se puede cambiar el nombre o el precio.
 * por lo que tenemos dos metodos para la  interface de pizza
 * @author Gaston
 *
 */
public interface PizzaSimpleInt {
	
	public String getNombre();
	
	public double getPrecio();

}
