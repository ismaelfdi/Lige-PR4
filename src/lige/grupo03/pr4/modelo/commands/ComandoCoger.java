/**
 * 
 */
package lige.grupo03.pr4.modelo.commands;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;

/**
 * Clase que representa un Comando COGER
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoCoger extends Comando{
	
	/*Atributo que almacena el id del Objeto a coger*/
	private String id;
	
	/*Atributo que contiene el juego en ejecucion*/
	private Game juego;

	/**
	 * Constructor parametrizado del Comando COGER
	 * 
	 * @param juego Es el juego que esta en ejecución
	 * @param id Identificador del Item a coger.
	 */
	public ComandoCoger(Game juego, String id){
		super(VerbCommands.COGER);
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
	 * Procedimiento especifico del Comando Coger, que ejecuta la accion de coger un id
	 * 
	 */
	@Override
	public Evento execute() {
		// TODO Auto-generated method stub
		return new EventoError("Error en el proceso");
	}
}
