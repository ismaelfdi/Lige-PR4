package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase que representa un Item ObjetoValor
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class ObjetoValor extends Consumible{
	
	/*Atributo que contiene los puntos que otorga o resta un Item Consumible*/
	private int puntos;

	/**
	 * Constructor parametrizado con 3 parametros
	 * 
	 * @param id String que almacena el identificador del Item ObjetoValor
	 * @param descripcion String que almacena la descripcion del Item ObjetoValor
	 * @param puntos int que almacena los puntos que otorga
	 */
	public ObjetoValor(String id, String descripcion, int puntos) {
		super(id, descripcion, 1);
		this.puntos = puntos;
	}
	
	/**
	 * Metodo sobreescrito que muestra la informacion del Item ObjetoValor
	 * 
	 * @return String con la informacion del Item debidamente presentado
	 */
	@Override
	public String toString(){
		return "--item[" + super.getId() + "]=" + super.getDescripcion() + " " + getPuntos() + "//1";
}

	/**
	 * Metodo concreto que ejecutará el Item ObjetoValor al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public boolean use(Player who, Room where) {
		
		if(canBeUsed()){
			who.agregaPuntuacion(getPuntos());
			setPuntos(0);
			return true;
		}else
			return false;
	}
	
	/**
	 * Implementacion del metodo abstracto para un Item Consumible
	 * 
	 * @return boolean indicando si un Item Consumible puede ser usado o no
	 */
	@Override
	public boolean canBeUsed() {
		return (puntos > 0);
	}
	
	/**
	 * Devuelve el valor de los puntos que otorga un Item
	 * 
	 * @return Int con el valor del atributo puntos
	 */
	public int getPuntos(){
		return puntos;
	}
	
	/**
	 * Modifica el atributo puntos de un Item al consumirse
	 * 
	 * @param puntos int que se asignara al atributo puntos
	 */
	public void setPuntos(int puntos){
		this.puntos = puntos;
	}

	/**
	 * Implementacion del metodo abstracto clone
	 * 
	 * @return ObjetoValor que es una copia exacta del original
	 */
	@Override
	public ObjetoValor clone() {
		return new ObjetoValor(this.getId(), this.getDescripcion(), this.getPuntos());
	}
	
	
	

}
