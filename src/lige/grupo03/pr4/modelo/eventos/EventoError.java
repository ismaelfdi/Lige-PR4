package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.TipoEvento;

public class EventoError extends Evento{
	
	private String errorProducido;

	public EventoError(String errorProducido) {
		super(TipoEvento.EVENTO_ERROR);
		this.errorProducido = errorProducido;
	}
	
	public String getErrorProducido(){
		return errorProducido;
	}

}
