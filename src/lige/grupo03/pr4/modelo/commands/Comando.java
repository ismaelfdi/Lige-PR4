package lige.grupo03.pr4.modelo.commands;

import lige.grupo03.pr4.VerbCommands;

/**
 * Clase que implementa la interface Command, y que instanciara un Comando desconocido
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class Comando implements Command{
	
	/*Atributo que indica el tipo de comando*/
	private VerbCommands verbo;
	
	/**
	 * Constructor por defecto de Comando que construye un comando desconocido
	 */
	public Comando(){
		this.verbo = VerbCommands.DESCONOCIDO;
	}
	
	/**
	 * Constructor con un parametro
	 * 
	 * @param verbo VerbCommands que inicializa un comando determinado
	 * 
	 */
	public Comando(VerbCommands verbo){
		this.verbo = verbo;
	}
	
	/**
	 * Metodo implementado que obtiene el atributo del verbo
	 * 
	 * @return VerbCommands con el valor del atributo verbo
	 */
	@Override
	public VerbCommands getVerbo() {
		return this.verbo;
	}

	/**
	 * Metodo implementado que determina si un comando es valido
	 * 
	 * @return Booleano verdadero o false segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return !(this.verbo.equals(VerbCommands.DESCONOCIDO));
	}
	
	/**
	 * Nos indica por pantalla que el Comando no se entiende
	 * 
	 */
	
	/*
	public boolean ejecutar() {
		UIConsola.showError("Lo siento, no le he entendido.\n");
		return false;
	}
	*/
}
