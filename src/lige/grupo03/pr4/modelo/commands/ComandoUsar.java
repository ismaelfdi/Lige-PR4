/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.modelo.eventos.EventoObjetoUsado;

/**
 * Clase que representa el Comando USAR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoUsar extends Comando{

	/*Atributo que representa el identificador del Item a usar*/
	private String id;
	/*Atributo que representa el juego en ejecucion*/
	private Game juego;
	
	/**
	 * Constructor parametrizado del Comando USAR
	 * 
	 * @param juego Game que representa el juego que esta en ejecución
	 * @param id String que representa el identificador del Item a usar
	 */
	public ComandoUsar(Game juego, String id){
		super(VerbCommands.USAR);
		this.id = id;
		this.juego = juego;
	}
	
	/**
	 * Metodo sobrecargado que determina si el Comando es valido
	 * 
	 * @return Booleano verdadero o falso segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return super.esValido() && (!id.equals(""));
	}

	/**
	 * Procedimiento especifico del Comando USAR
	 * 
	 */
	@Override
	public Evento execute() {
		Evento evento;
		int vidaAC = juego.vida();
		int puntAC = juego.puntuacion();
		juego.usarObjeto(id);
		int vidaDC = juego.vida();
		int puntDC = juego.puntuacion();
		evento = new EventoObjetoUsado(juego.vida(), juego.puntuacion(), juego.inventarioJugador());
		
		return evento;
	}
}
