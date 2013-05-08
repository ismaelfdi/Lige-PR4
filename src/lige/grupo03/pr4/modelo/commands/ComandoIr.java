/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Door;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;


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
		
		Evento evento = null;
		Door puerta = juego.getDoor(direccion);
		return evento;
	}

}
