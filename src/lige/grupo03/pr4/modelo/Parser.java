package lige.grupo03.pr4.modelo;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.modelo.Player;
import lige.grupo03.pr4.modelo.commands.Comando;
import lige.grupo03.pr4.modelo.commands.ComandoCoger;
import lige.grupo03.pr4.modelo.commands.ComandoIr;
import lige.grupo03.pr4.modelo.commands.ComandoSalir;
import lige.grupo03.pr4.modelo.commands.ComandoSoltar;
import lige.grupo03.pr4.modelo.commands.ComandoUsar;
import lige.grupo03.pr4.modelo.commands.Command;

/**
Clase que transforma un String en un objeto de la clase Command, asimismo se
encarga de generar el mensaje de ayuda. 
@author Ismael Ventura & Ignacio Lopez
@version 2.0
*/

public class Parser {
	
	/**
	Metodo que transforma el String pasado como parametro en un objeto Command
	@param cadena String a convertir en objeto Command
	@return Command objeto Command valido
	*/
	public static Command parsear(Game juego, String cadena, Room habitacionActual, Player jugador){	
		
		cadena = cadena.toUpperCase();
		
		if(cadena.equals(VerbCommands.SALIR.toString()) || cadena.equals(VerbCommands.EXIT.toString())){
			return new ComandoSalir(juego);
		}else{
			String[] trozos = cadena.split(" ");			
			
			if (trozos.length == 2){
				if(trozos[0].equals(VerbCommands.IR.toString()) || trozos[0].equals(VerbCommands.GO.toString())){
					String dir = trozos[1];
					
					switch (dir) {
					case "NORTE" :
						return new ComandoIr(juego, Directions.NORTE);
					case "SUR" :
						return new ComandoIr(juego, Directions.SUR);
					case "ESTE" :
						return new ComandoIr(juego, Directions.ESTE);
					case "OESTE" :
						return new ComandoIr(juego, Directions.OESTE);
					default:
						return new Comando();
					}		
				}else if(trozos[0].equals(VerbCommands.COGER.toString()) || trozos[0].equals(VerbCommands.CATCH.toString())){
					return new ComandoCoger(juego, trozos[1].toLowerCase());
				}else if(trozos[0].equals(VerbCommands.USAR.toString()) || trozos[0].equals(VerbCommands.USE.toString())){
					return new ComandoUsar(juego, trozos[1].toLowerCase());
				}else if(trozos[0].equals(VerbCommands.SOLTAR.toString()) || trozos[0].equals(VerbCommands.DROP.toString()))
					return new ComandoSoltar(juego, trozos[1].toLowerCase());
			}		
		}
		
		return new Comando();
	}
	
	/**
	* Metodo privado que coloca las direcciones en una sola cadena.
	*
	* @return String conteniendo la cadena con las direcciones.
	*/
	private static String direcciones(){
		String cadena = " {";
		Directions[] dirs = Directions.values();
		
		for (int i = 0; i < dirs.length - 2; i++){
			cadena += dirs[i].toString() + " | ";
		}		
		
		return cadena + dirs[dirs.length-2].toString() + "}";
	}
	
	
	/**
	* Metodo que devuelve cadena con el mensaje de Ayuda.
	*
	* @return String que contiene la ayuda con todos los comandos disponibles.
	*/
	public static String mensajeAyuda(){
		
		String mensaje = "Los comandos disponibles en el juego son:\n";
		VerbCommands[] comandos = VerbCommands.values();
		
		for (int i = 0; i < comandos.length - 1; i++){
			if(comandos[i].equals(VerbCommands.IR))
				mensaje += "\t" + comandos[i].toString() + direcciones() + "\n";
			else if(comandos[i].equals(VerbCommands.COGER) || comandos[i].equals(VerbCommands.USAR))
				mensaje += "\t" + comandos[i].toString() + " <<id>>" + "\n";
			else if(comandos[i].equals(VerbCommands.MIRAR))
				mensaje += "\t" + comandos[i].toString() + " [<<id>>]" + "\n";
			else
				mensaje += "\t" + comandos[i].toString() + "\n";
		}
		
		return mensaje;
	}
	
	
	/*
	public static void main(String[] args){
		
		Command micomando = new ComandoAyuda();
		
		String cadena = "AYUDA";
		
		if(cadena.equals(VerbCommands.AYUDA.toString()))
			System.out.println("Correcto");
		else
			System.out.println("Incorrecto");
		
		
		
		//Parser miParser = new Parser();
		System.out.println(Parser.mensajeAyuda());
		
		VerbCommands comandito = null;
		for(int i = 0; i < 10; i++){
			Random aleatorio = new Random();
		}
		
		
		System.out.println("La cantidad de valores es: " + VerbCommands.values().length);
		VerbCommands[] comandos = VerbCommands.values();
		for (int i = 0; i < comandos.length; i++){
			
			System.out.println(comandos[i].toString() + " :::  typeOf: " + comandos[i].toString().getClass().getName() );
			
			
		}
	
		
		//System.out.println(Parser.mensajeAyuda());
		
		
		
		
		
	}
	*/

}
