package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;
import lige.grupo03.pr4.modelo.Room;

public class EventoObjetoCogido extends Evento{

	private Room habitacion;
	private Lista inventarioJugador;
	
	public EventoObjetoCogido(Room habitacion, Lista inventarioJugador) {
		super(TipoEvento.EVENTO_OBJETO_COGIDO);
		this.habitacion = habitacion;
		this.inventarioJugador = inventarioJugador;
	}
	
	public Room getHabitacion(){
		return habitacion;
	}
	
	public Lista getInventarioJugador(){
		return inventarioJugador;
	}

}
