package lige.grupo03.pr4.modelo.items;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Door;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase que representa un Item Llave
 * 
 * @author IsmaelLeonidas
 * @version 1.0
 */
public class Llave extends Persistente{
	
	/*Atributo puerta, indica la puerta que abre esta llave*/
	private Door puerta;
	
	/**
	 * Constructor parametrizado con 2 parametros
	 * 
	 * @param id String que representa el id de un Item Llave
	 * @param descripcion String que representa la descripción
	 */
	public Llave(String id, String descripcion) {
		super(id, descripcion);
		this.puerta = new Door();
	}
	
	/**
	 * Constructor parametrizado con 3 parametros
	 * 
	 * @param id String que representa el id de un Item Llave
	 * @param descripcion String que representa la descripción
	 * @param puerta Door que representa la puerta que esta llave abre
	 */
	public Llave(String id, String descripcion, Door puerta) {
		super(id, descripcion);
		this.puerta = puerta;
	}
	
	/**
	 * Devuelve una copia de este Item Llave
	 * 
	 * @return Llave que es una copia del Item
	 */
	@Override
	public Llave clone(){
		return new Llave(this.getId(),this.getDescripcion(),this.puerta);
	}

	/**
	 * Metodo concreto que ejecutará el Item Llave al invocar el comando USAR
	 * 
	 * @param who Player que invoca el comando
	 * @param where Habitacion desde donde se invoca el Comando
	 * @return boolean Indicando que se pudo usar el Comando
	 */
	@Override
	public boolean use(Player who, Room where) {
		
		boolean encontrado = false;
		Directions[] direcciones = Directions.values();
		int i = 0;
		while(!encontrado && (i < direcciones.length))
			encontrado = puerta.isInRoom(where, direcciones[i++]);

		if(encontrado)
			puerta.setOpenDoor(true);
				
		return encontrado;
	}
}
