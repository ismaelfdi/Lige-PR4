package lige.grupo03.pr4.modelo;
import lige.grupo03.pr4.Directions;

/**
 * Clase Door : Representa una puerta que une dos habitaciones.
 * 
 * @author Ismael Leonidas & Ignacio Lopez
 * @version 2.0
 */
public class Door {
	
	/*Habitacion de Origen*/
	private Room habitacionOrigen;
	/*Direccion hacia donde se encuentra la puerta de Destino*/
	private Directions direccion; 
	/*Habitacion de Destino*/
	private Room habitacionDestino;
	/*Atributo que indica si la puerta esta abierta o cerrada*/
	private boolean openDoor;
	
	/** 
	Constructor por defecto
    */
	public Door(){
		this.habitacionOrigen = new Room();
		this.habitacionDestino = new Room();
		this.direccion = Directions.DESCONOCIDO;
		this.openDoor = false;
	}
	
	/** Constructor con parametros de la clase Door.
	@param origen Habitacion de Origen.
	@param destino Habitacion de Destino.
	@param direccion direccion de la puerta en la habitacion Destino.
	 */
	public Door(Room origen, Directions direccion, Room destino, boolean openDoor){
		this.habitacionOrigen = origen;
		this.habitacionDestino = destino;
		this.direccion = direccion;
		this.openDoor = openDoor;
	}
	
	/**
	Mutador del atributo habitacionOrigen
	@param habitacionOrigen valor que se le asigna a la habitacion  de origen
	*/
	public void setHabitacionOrigen(Room habitacionOrigen){
		this.habitacionOrigen = habitacionOrigen;
	}
	
	/**
	Mutador del atributo habitacionDestino
	@param habitacionDestino valor que se le asigna a la habitacion de destino
	*/
	public void setHabitacionDestino(Room habitacionDestino){
		this.habitacionDestino = habitacionDestino;
	}
	
	/**
	Mutador del atributo openDoor
	@param openDoor valor que se le asigna a openDoor
	*/
	public void setOpenDoor(boolean openDoor){
		this.openDoor = openDoor;
	}
	
	/**
	 * Indica si una puerta esta abierta
	 * 
	 * @return boolean verdadero o falso segun sea el caso
	 */
	public boolean isOpenDoor(){
		return openDoor;
	}
	
	/** isInRoom: Nos tiene que decir si la puerta pertenece a la habitación pasada por 
	parámetro y se encuentra en la dirección pasada por parámetro.
	
	@param habitacion : Habitacion donde se ubica la puerta, puede ser Origen o Destino.
	@param dir : Direccion en la cual se encuentra la puerta 
	@return boolean indicando si la puerta pertenece a la habitacion.
	*/
	public boolean isInRoom(Room habitacion, Directions dir){
		
		if(habitacion.equals(habitacionOrigen))
			return (direccion == dir);
		else if (habitacion.equals(habitacionDestino))
			return (direccion == dir.direccionOpuesta());
		else
			return false;
	}
	
	
	/** nextRoom: Devuelve la siguiente habitación con la que comunica la puerta
	si es que la puerta se encuentra en la habitación pasada como parámetro.
	@param habitacion : Habitacion de la cual hallaremos su siguiente habitacion.
	@return Room que es la habitacion a la cula comunica.
	*/
	public Room nextRoom(Room habitacion){
		
		if(habitacionOrigen.equals(habitacion))
			return habitacionDestino;
		else if (habitacionDestino.equals(habitacion))
			return habitacionOrigen;
		else
			return null;
	}
	

}
