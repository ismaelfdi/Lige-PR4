package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;
import lige.grupo03.pr4.modelo.Room;

public class EventoObjetoSoltado extends Evento{
	
	private Room habitacion;
	private Lista inventarioJugador;	
	
	public EventoObjetoSoltado(Room habitacion, Lista inventarioJugador) {
		super(TipoEvento.EVENTO_OBJETO_SOLTADO);
		this.setHabitacion(habitacion);
		this.setInventarioJugador(inventarioJugador);
	}

	/**
	 * @return the habitacion
	 */
	public Room getHabitacion() {
		return habitacion;
	}

	/**
	 * @param habitacion the habitacion to set
	 */
	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * @return the inventarioJugador
	 */
	public Lista getInventarioJugador() {
		return inventarioJugador;
	}

	/**
	 * @param inventarioJugador the inventarioJugador to set
	 */
	public void setInventarioJugador(Lista inventarioJugador) {
		this.inventarioJugador = inventarioJugador;
	}


}
