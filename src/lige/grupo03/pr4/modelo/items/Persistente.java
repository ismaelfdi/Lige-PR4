/**
 * 
 */
package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase abstracta que representa un Item Persistente
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public abstract class Persistente extends Item{

	/**
	 * Constructor parametrizado de una clase Persistente
	 * 
	 * @param id String que representa el identificador de un Item
	 * @param descripcion String que representa la descripcion de un Item
	 */
	public Persistente(String id, String descripcion) {
		super(id, descripcion);
	}

	/**
	 * Implementacion del metodo abstracto para un Item Persistente
	 * 
	 * @return boolean indicando si un Item Persistente puede ser usado o no
	 */
	@Override
	public boolean canBeUsed(){
		return true;
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
