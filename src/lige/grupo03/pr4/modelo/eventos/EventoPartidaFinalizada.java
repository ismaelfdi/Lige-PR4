package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;

public class EventoPartidaFinalizada extends Evento{

	private int puntuacion;
	private int vida;
	private boolean haGanado;
	
	public EventoPartidaFinalizada(int puntuacion, int vida, boolean haGanado) {
		super(TipoEvento.EVENTO_PARTIDA_FINALIZADA);
		this.puntuacion = puntuacion;
		this.vida = vida;
		this.haGanado = haGanado;
	}
	
	public int getPuntuacion(){
		return puntuacion;
	}

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * @return the haGanado
	 */
	public boolean isHaGanado() {
		return haGanado;
	}


	
	
	

}
