package lige.grupo03.pr4.modelo.eventos;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.modelo.Room;

public class EventoMovimientoRealizado extends Evento{
	
	private Room habitacion;
	private int vida;
	private Directions direccion;

	public EventoMovimientoRealizado(Room habitacion, int vida, Directions direccion) {
		super(TipoEvento.EVENTO_MOVIMIENTO_REALIZADO);
		this.habitacion = habitacion;
		this.vida = vida;
		this.direccion = direccion;
	}
	
	public Room getHabitacion(){
		return habitacion;
	}
	
	public int getVida(){
		return vida;
	}
	
	public Directions getDireccion(){
		return direccion;
	}

}
