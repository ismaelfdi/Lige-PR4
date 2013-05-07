package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;

public class EventoError extends Evento{
	
	String errorProducido;

	public EventoError(TipoEvento tipo, String errorProducido) {
		super(tipo);
		this.errorProducido = errorProducido;
	}
	
	public String getErrorProducido(){
		return errorProducido;
	}

}
