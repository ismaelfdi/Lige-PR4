/**
 * 
 */
package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase abstracta que representa un Objeto Generico
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public abstract class Item {
	
	/*Atributo que representa el identificador de un Item*/
	private String id;
	/*Atributo que almacena la descripcion de un Item*/
	private String descripcion;
	
	/**
	 * Constructor parametrizado 
	 * 
	 * @param id String que representa el identificador de un Item
	 * @param descripcion String con la descripcion de un Item
	 */
	public Item(String id, String descripcion){
		this.id = id;
		this.descripcion = descripcion;
	}
	
	/**
	 * Devuelve el atributo id
	 * 
	 * @return String con el valor del atributo id
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Devuelve el atributo descripción
	 * 
	 * @return String con el valor del atributo id
	 */
	public String getDescripcion(){
		return descripcion;
	}
	
	/**
	 * Devuelve la informacion del Item
	 * 
	 * @return String con la informacion del Item debidamente presentada
	 */
	public String toString(){
		return "--item[" + id + "]=" + descripcion;
	}
	
	/**
	 * Metodo abstracto que copia un Item
	 *  
	 * @return Item que es una copia del Item original
	 */
	public abstract Item clone();
	
	/**
	 * Metodo abstracto concreto que ejecutará cada Item al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	public abstract boolean use(Player who, Room where);
	
	/**
	 * Metodo abstracto que indica si un Item se puede usar o no
	 * 
	 * @return Boolean verdadero o falso segun sea el caso
	 */
	public abstract boolean canBeUsed();
	
}
