package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Room;

public class EventoMovimientoRealizado extends Evento{
	
	Room habitacion;
	int vida;
	Directions direccion;

	public EventoMovimientoRealizado(TipoEvento tipo, Room habitacion, int vida, Directions direccion) {
		super(tipo);
		this.habitacion = habitacion;
		this.vida = vida;
		this.direccion = direccion;
		// TODO Auto-generated constructor stub
	}

}
