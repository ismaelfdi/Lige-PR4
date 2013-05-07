package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Game;

/**
 * Clase que representa un Comando SALIR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoSalir extends Comando{
	
	/*Atributo que representa el juego en ejecuci�n*/
	private Game juego;
	
	/**
	 * Constructor parametrizado del Comando SALIR
	 * @param juego Game que representa el juego en ejecuci�n
	 */
	public ComandoSalir(Game juego){
		super(VerbCommands.SALIR);
		this.juego = juego;
	}
	
	/**
	 * Procedimiento especifico del Comando SALIR
	 * 
	 */
	/*
	@Override
	public boolean ejecutar() {
		juego.salir();
		return true;
	}
	*/
}
