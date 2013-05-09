package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.Room;

public class EventoGo extends Evento{

	private Room habitacion;
	private Directions direccion;
	private Player player;
	
	public EventoGo(Room habitacion, Player player, Directions direccion) {
		super(TipoEvento.EVENTO_GO);
		this.habitacion = habitacion;
		this.direccion = direccion;
		this.player = player;
	}
	
	public Room getHabitacion(){
		return habitacion;
	}
	
	public Directions getDireccion(){
		return direccion;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}



}
