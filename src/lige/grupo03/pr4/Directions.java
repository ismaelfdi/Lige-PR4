package lige.grupo03.pr4;
/**
Enumerado que contiene las direcciones en las cuales una habitacion tiene una puerta y 
por lo tanto hacia donde puede moverse un jugador.
@author Ismael Ventura & Ignacio Lopez
*/
public enum Directions {NORTE,SUR,ESTE,OESTE,DESCONOCIDO;

	/**
	Metodo que devuelve la direccion opuesta de una direccion dada.
	@return Directions que contiene la direccion opuesta a la indicada.
	*/
	public Directions direccionOpuesta(){
		
		switch (this) {
		case NORTE:
			return SUR;	
		case SUR:
			return NORTE;
		case ESTE:
			return OESTE;
		case OESTE:
			return ESTE;
		default:
			return DESCONOCIDO;
		}
	}

}