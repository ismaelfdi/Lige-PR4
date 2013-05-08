package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;

/**Clase Evento
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 * Clase padre de los diferentes eventos que se enviaran del modelo a la vista
 */
public class Evento {
	private TipoEvento tipo;
	
	/**
	 * Constructor de la clase Evento.
	 * @param tipo tipo de evento del que se trata
	 * 
	 */
	public Evento(TipoEvento tipo) {
		this.tipo = tipo;
	}

	/**Metodo getTipo
	 * Devuelve el tipo de evento que es
	 * @return tipo de evento que es.
	 */
	public TipoEvento getTipo(){
		return tipo;
	}
}
