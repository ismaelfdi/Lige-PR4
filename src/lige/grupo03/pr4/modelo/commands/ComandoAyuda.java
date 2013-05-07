/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;
//import lige.grupo03.pr4.entradaSalida.UIConsola;
//import lige.grupo03.pr4.modelo.Parser;

/**
 * Clase que representa un Comando AYUDA
 * 
 * @author IsmaelLeonidas
 * @version 2.0
 */
public class ComandoAyuda extends Comando{
	
	/**
	 * Constructor por defecto, construye un objeto Comando del tipo AYUDA
	 */
	public ComandoAyuda(){
		super(VerbCommands.AYUDA);
	}
	
	/**
	 * Procedimiento especifico del Comando Ayuda, que muestra por pantalla la 
	 * informacion de ayuda al usuario
	 * 
	 */
	/*
	@Override
	public boolean ejecutar() {
		UIConsola.printText(Parser.mensajeAyuda());
		return false;
	}
	*/
}
