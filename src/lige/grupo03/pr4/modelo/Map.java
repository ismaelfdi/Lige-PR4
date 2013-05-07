package lige.grupo03.pr4.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import lige.grupo03.pr4.Directions;

/**
Clase que se ocupa del vector de puertas posibles en una partida. 
@author Ismael Ventura & Ignacio Lopez
@version 1.0
*/
public class Map {
	
	/*vector de puertas posibles*/
	private ArrayList<Door> puertas = new ArrayList<Door>();
	
	/**
	Metodo que agrega una puerta al vector
	@param puerta valor que se agregará al mapa de puertas
	*/
	public void agregarPuerta(Door puerta){	
		puertas.add(puerta);
	}
	
	/**
	Metodo que devuelve una puerta si existe en el mapa
	@param habitacion valor donde buscaremos la puerta
	@param direccion ubicacion donde estaría la puerta en esta habitacion
	@return Door que contiene la puerta si la encontro o null si no.
	*/
	public Door devolverPuerta(Room habitacion, Directions direccion){
		
		boolean encontrado = false;
		Door puerta = null;
		Iterator<Door> iteratorPuertas = puertas.iterator();
		
		while(!encontrado && iteratorPuertas.hasNext()){
			puerta = iteratorPuertas.next();
			encontrado = puerta.isInRoom(habitacion, direccion);
		}
		
		if(!encontrado)
			return null;
		else
			return puerta;
	}
	
	
	
	
}
