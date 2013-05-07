package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;

public class EventoPartidaFinalizada extends Evento{

	int puntuacion;
	int vida;
	boolean haGanado;
	
	public EventoPartidaFinalizada(TipoEvento tipo, int puntuacion, int vida, boolean haGanado) {
		super(tipo);
		this.puntuacion = puntuacion;
		this.vida = vida;
		this.haGanado = haGanado;
	}

}
