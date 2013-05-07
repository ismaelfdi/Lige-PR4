/**
 * 
 */
package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase abstracta que representa un Item Consumible - Comida u ObjetoValor
 * Los Items Consumibles suman o quitan puntos:
 * 		<ul>
 * 			<li>Item Comida: Suma o resta al Nivel de vida del jugador</li>
 * 			<li>Item ObjetoValor: Siempre suma puntos</li>
 * 		</ul>
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public abstract class Consumible extends Item{
	
	
	/*Atributo que contiene el número de usos del Item*/
	private int numeroVeces;
	
	/**
	 * Constructor parametrizado del Item Consumible
	 * 
	 * @param puntos repesenta el valor que otorga o resta un Item Consumible
	 */
	public Consumible(String id, String descripcion, int numeroVeces) {
		super(id, descripcion);
		this.numeroVeces = numeroVeces;
	}
	
	/**
	 * Devuelve el valor del número de usos de un Item
	 * 
	 * @return Int con el valor del atributo numeroVeces
	 */
	public int getNumeroVeces(){
		return numeroVeces;
	}
	
	/**
	 * Devuelve el valor del número de usos menos uno de un Item
	 * 
	 * @return Int con el valor del atributo numeroVeces restado
	 */
	public int setNumeroVeces(){
		return --numeroVeces;
	}
	
	

	
	/**
	 * Metodo sobreescrito que muestra la informacion del Item Consumible
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String toString(){	
		return super.toString() + "number times are " + numeroVeces;
	}
	

	/**
	 * Metodo abstracto concreto que ejecutará cada Item al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public abstract boolean use(Player who, Room where);
	
	/**
	 * Metodo abstracto que copia un Item
	 *  
	 * @return Item que es una copia del Item original
	 */
	public abstract Item clone();

}
