package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaFinalizada;

/**
 * Clase que representa un Comando SALIR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoSalir extends Comando{
	
	/*Atributo que representa el juego en ejecución*/
	private Game juego;
	
	/**
	 * Constructor parametrizado del Comando SALIR
	 * @param juego Game que representa el juego en ejecución
	 */
	public ComandoSalir(Game juego){
		super(VerbCommands.SALIR);
		this.juego = juego;
	}
	
	/**
	 * Procedimiento especifico del Comando SALIR
	 * 
	 */
	
	@Override
	public Evento execute() {
		// TODO Auto-generated method stub
		return null;//new EventoPartidaFinalizada("Error en el proceso");
	}
}
