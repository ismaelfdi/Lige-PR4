package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase que representa el Item Consumible Comida
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class Comida extends Consumible{
	
	
	/*Atributo que indica el número de vidas que te proporciona dicha comida*/
	private int vida;

	/**
	 * Constructor parametrizado con 4 parametros
	 * 
	 * @param id String que representa el identificador
	 * @param descripcion String que representa la descripcion
	 * @param puntos int que almacena el valor que otorga al nivel de vida
	 * @param numeroVeces int que almacena el numero de veces a usar el objeto
	 */
	public Comida(String id, String descripcion, int vida, int numeroUsos) {
		super(id, descripcion, numeroUsos);
		this.vida = vida;
	}

	
	/**
	 * Devuelve el valor del número de vida que te queda
	 * 
	 * @return Int con el valor del atributo vida
	 */
	public int getVida(){
		return vida;
	}
	
	/**
	 * Metodo sobreescrito que muestra la informacion del Item Consumible
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String toString(){	
		return "--item[" + super.getId() + "]=This " + super.getDescripcion() + " value is " + getVida() + "//" + super.getNumeroUsos();
	}

	/**
	 * Metodo concreto que ejecuta el Item Comida al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.sumarVida(getVida());
			super.decrementarNumeroUsos();
			return true;
		}else
			return false;
	}

	/**
	 * Metodo abstracto que copia un Item
	 *  
	 * @return Item que es una copia del Item original
	 */
	@Override
	public Comida clone() {
		return new Comida(this.getId(),this.getDescripcion(),this.getNumeroUsos(), vida);
	}

}
