package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;

public class EventoObjetoUsado extends Evento{
	
	private int puntuacion;
	private int vida;
	private Lista inventarioJugador;

	public EventoObjetoUsado(int puntuacion, int vida) {
		super(TipoEvento.EVENTO_OBJETO_USADO);
		this.puntuacion = puntuacion;
		this.vida = vida;
	}
	
	public int getPuntuacion(){
		return puntuacion;
	}
	
	public int getVida(){
		return vida;
	}
	
	public Lista getInventarioJugador(){
		return inventarioJugador;
	}

}
