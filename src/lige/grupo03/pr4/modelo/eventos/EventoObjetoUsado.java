package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;

public class EventoObjetoUsado extends Evento{
	
	private int puntuacion;
	private int vida;
	private Lista inventarioJugador;

	public EventoObjetoUsado(int vida, int puntuacion, Lista inventarioJugador) {
		super(TipoEvento.EVENTO_OBJETO_USADO);
		this.puntuacion = puntuacion;
		this.vida = vida;
		this.inventarioJugador = inventarioJugador;
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
