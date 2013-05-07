package lige.grupo03.pr4.modelo;

import java.util.ArrayList;

import lige.grupo03.pr4.modelo.items.Item;


/**
Clase que representa una habitación indicando una descripción y si es una salida.
@author Ismael Ventura & Ignacio Aguirre
@version 1.0
*/
public class Room {
	/*Descripcion de la habitacion*/
	private String descripcion;
	/*Indica si es una habitacion de salida */
	private boolean salida;
	/*ArrayList conteniendo el inventario de una habitacion*/
	private Lista inventarioHabitacion;
	/**
	Constructor por defecto 
	*/
	public Room(){
		this.descripcion = null;
		this.salida = false;
		this.inventarioHabitacion = new Lista();
	};
	
	/**
	Constructor con 2 parametros 
	@param descripcion String con la descripcion de la habitación.
	@param salida TRUE o FALSE segun sea el caso.
	*/
	public Room(String descripcion, boolean salida){
		this.descripcion = descripcion;
		this.salida = salida;
		this.inventarioHabitacion = new Lista();
	}

	/**
	 * Constructor con 3 parametros
	 * @param descripcion
	 * @param salida
	 * @param inventarioHabitacion
	 */
	public Room(String descripcion, boolean salida, Lista inventarioHabitacion){
		this.descripcion = descripcion;
		this.salida = salida;
		this.inventarioHabitacion = inventarioHabitacion;
	}
	
	/**
	 * Mutador de la lista de objetos a partir de un ArrayLis<Item>
	 * 
	 * @param lista
	 */
	public void setInventarioHabitacion(ArrayList<Item> lista) {
		this.inventarioHabitacion = new Lista(lista);
	}

	/**
	Indica si la habitacion es una habitacion de salida.
	@return boolean TRUE o FALSE segun sea el caso.
	*/
	public boolean getSalida(){
		return salida;
	}
	
	/**
	 * Agrega un Item al inventario de la habitacion
	 * 
	 * @param item Item a agregar al inventario de la habitacion
	 * @return boolean indicando si el Item se agrego al inventario
	 */
	public boolean agregarItem(Item item){		
		return inventarioHabitacion.addItem(item);
	}

	/**
	 * Devuelve un objeto del inventario por medio de su identificador
	 * 
	 * @param id String que representa el identificador del Item a buscar
	 * @return Item con identificador id
	 */
	public Item obtenerObjeto(String id){
		return inventarioHabitacion.obtenerItem(id);
	}

	/**
	 * Indica si un Item se encuentra en el inventario de la habitacion
	 * 
	 * @param id String que representa el identificador del Item
	 * @return boolean verdero o falso segun sea el caso
	 */
	public boolean estaObjeto(String id){
		return inventarioHabitacion.estaItem(id);
	}
	
	/**
	 * Coge el objeto del inventario de la habitacion
	 * 
	 * @param id Representa el identificador del Item
	 * @return Item que hemos cogido
	 */
	public Item cogerObjeto(String id){
		return inventarioHabitacion.cogerObjeto(id);
	}

	/**
	 * Muestra la informacion de los itens del inventario de la habitacion
	 * 
	 * @return String con la informacion de todos los items de la habitacion
	 */
	public String toString(){
		
		String cadena = inventarioHabitacion.toString();
		
		if(!cadena.equals(""))
			cadena = descripcion + "\nLa habitación contiene los siguientes objetos:\n" + cadena;
		else
			cadena = "\nLa habitación está vacía.\n";
		
		return cadena;
	}
}
