package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;
import lige.grupo03.pr4.modelo.Room;

public class EventoObjetoCogido extends Evento{

	Room habitacion;
	Lista inventarioJugador;
	
	public EventoObjetoCogido(TipoEvento tipo, Room habitacion, Lista inventarioJugador) {
		super(tipo);
		this.habitacion = habitacion;
		this.inventarioJugador = inventarioJugador;
	}

}
