package lige.grupo03.pr4.vista;

import java.util.Scanner;

/**
 * @author Ignacio Lopez Aguirre de Carcer
 * Clase UIConsola: Es la clase encargado de leer todo lo que el usuario escriba 
 * por la consola, ademas tambien es la encargada de mostrar todos los mensajes 
 * por la consola.
 */
public class UIConsola {
	
	/**
	 * Atributo de tipo Scanner, lo creamos aquí para no tener que crearlo cada
	 * vez que queramos utilizarlo.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	
	/** 
	 * askCommand: Metodo que solicita un comando y devuelve la cadena
	 * introducida por el usuario.
	 * @return String que contiene el comando ingresado por consola.
	*/
	public static String askComand(){
		System.out.print("\n\t> ");
		return scanner.nextLine();
	
	}
	
	
	/** método printText: muestra por pantalla una cadena que se le pasa
	 *  como parámetro.
	 *  @param cadena String que se mostrara por pantalla.
	 */
	public static void printText(String cadena){
		System.out.print(cadena);
	}
	
	
	/** método showError: muestra por pantalla un error que se le pasa
	 *  como parámetro en modo de cadena de texto.
	 *  @param error String indicando el error generado.
	 */
	public static void showError(String error){
		System.out.println(error);
	}

}
