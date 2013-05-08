package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Lista;
import lige.grupo03.pr4.modelo.Room;

public class EventoPartidaIniciada extends Evento{

	private int xInicial;
	private int yInicial;
	private int puntuacion;
	private int vida;
	private Lista inventarioJugador;
	private Room habitacionActual;
	
	public EventoPartidaIniciada(int xInicial, int yInicial, int puntuacion, int vida, Lista inventarioJugador, Room habitacionActual) {
		super(TipoEvento.EVENTO_PARTIDA_INICIADA);
		this.xInicial = xInicial;
		this.yInicial = yInicial;
		this.puntuacion = puntuacion;
		this.vida = vida;
		this.inventarioJugador = inventarioJugador;
		this.habitacionActual = habitacionActual;
	}
	
	public int getXInicial(){
		return xInicial;
	}
	
	public int getYinicial(){
		return yInicial;
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
	
	public Room getHabitacionActual(){
		return habitacionActual;
	}
	
	

}
