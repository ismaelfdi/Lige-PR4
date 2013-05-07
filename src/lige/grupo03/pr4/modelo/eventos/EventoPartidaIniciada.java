package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;
import lige.grupo03.pr4.modelo.Room;

public class EventoPartidaIniciada extends Evento{

	int puntuacion;
	int vida;
	Lista inventarioJugador;
	Room habitacionActual;
	
	public EventoPartidaIniciada(TipoEvento tipo, int puntuacion, int vida, Lista inventarioJugador, Room habitacionActual) {
		super(tipo);
		this.puntuacion = puntuacion;
		this.vida = vida;
		this.inventarioJugador = inventarioJugador;
		this.habitacionActual = habitacionActual;
		
	}
	
	
	

}
