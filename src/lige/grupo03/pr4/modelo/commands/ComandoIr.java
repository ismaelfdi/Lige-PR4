/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Door;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.Room;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.modelo.eventos.EventoGo;
import lige.grupo03.pr4.modelo.eventos.EventoMovimientoRealizado;


/**
 * Clase que representa un Comando IR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoIr extends Comando{
	
	/*Atributo que representa una direccion pasada por consola*/
	private Directions direccion;
	/*Atributo que representa el juego que esta ejecución*/
	private Game juego;
	
	private Room habitacionActual;

	/**
	 * Constructor parametrizado del Comando IR
	 * @param juego Game que representa el juego que esta en ejecución
	 * @param direccion Directions que representa la dirección
	 */
	public ComandoIr(Game juego, Directions direccion){
		super(VerbCommands.IR);
		this.direccion = direccion;
		this.juego = juego;
	}
	
	/**
	 * Indica si un Comando es valido
	 * 
	 * @return Booleano verdero o falso segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return super.esValido() && !(direccion.equals(Directions.DESCONOCIDO));
	}
	
	/**
	 * Procedimiento especifico del Comando IR
	 * 
	 */
	/*
	@Override
	public boolean ejecutar() {
		boolean salir=false;
		juego.cambiarHabitacion(direccion, salir);
		if (salir=true){
			return true;
		}
		
		else{
			return false;
		}
	}
	*/
	@Override
	public Evento execute() {
		
		Evento evento;
		Door puerta = juego.getDoor(direccion);
		
		if(puerta == null)
			evento = new EventoError("No existe puerta en la direccion indicada");
		else
			if(puerta.isOpenDoor()){
				juego.cambiarHabitacion(direccion);
				evento = new EventoMovimientoRealizado(juego.getHabitacionActual(),juego.vida(), juego.puntuacion(), direccion);
			}else
				evento = new EventoError("La puerta se encuentra cerrada");
				
		
		return evento;
	}

}
