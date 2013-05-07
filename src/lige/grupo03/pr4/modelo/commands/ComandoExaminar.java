/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;
//import lige.grupo03.pr4.entradaSalida.UIConsola;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase que representa un Comando EXAMINAR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoExaminar extends Comando{
	
	/*Atributo que contiene el juego en ejecución*/
	private Room habitacionActual;

	/**
	 * Constructor parametrizado del Comando EXAMINAR
	 * 
	 * @param juego Representa el juego que esta en ejecución
	 */
	public ComandoExaminar(Room habitacionActual){
		super(VerbCommands.EXAMINAR);
		this.habitacionActual = habitacionActual;
	}

	/**
	 * Procedimiento especifico del Comando EXAMINAR
	 * 
	 */
	/*
	@Override
	public boolean ejecutar() {
		UIConsola.printText(habitacionActual.toString());
		return false;
	}
	*/

}
