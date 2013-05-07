package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Room;

public class EventoGo extends Evento{

	private Room habitacion;
	
	public EventoGo(TipoEvento tipo, Room habitacion) {
		super(tipo);
		this.habitacion = habitacion;
	}

}
