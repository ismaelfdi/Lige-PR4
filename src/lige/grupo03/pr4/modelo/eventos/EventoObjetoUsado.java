package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;

public class EventoObjetoUsado extends Evento{
	
	int puntuacion;
	int vida;
	Lista inventarioJugador;

	public EventoObjetoUsado(TipoEvento tipo, int puntuacion, int vida) {
		super(tipo);
		this.puntuacion = puntuacion;
		this.vida = vida;
	}

}
