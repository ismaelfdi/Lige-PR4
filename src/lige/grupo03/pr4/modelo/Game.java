package lige.grupo03.pr4.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Random;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.modelo.Door;
import lige.grupo03.pr4.modelo.Map;
import lige.grupo03.pr4.modelo.Room;
import lige.grupo03.pr4.modelo.commands.ComandoIr;
import lige.grupo03.pr4.modelo.commands.Command;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaIniciada;
import lige.grupo03.pr4.modelo.items.Comida;
import lige.grupo03.pr4.modelo.items.Item;
import lige.grupo03.pr4.modelo.items.Llave;
import lige.grupo03.pr4.modelo.items.ObjetoValor;

public class Game extends Observable{
	
	public Game(){
	}
	/**
	Room[] createRooms: Crea un array con las habitaciones de la
	aventura. La primera habitación será siempre la de partida.
	*/
	private static Room[][] createRooms(int n, int m){
		
		//int numHabitaciones = n*m;
		Room[][] habitaciones = new Room[n][m];
		boolean salida;
		String descripcion;
		
		//habitaciones[0] = new Room("Room 0", false);
		for(int i = 0; i < n ; i++)
		{
			for(int j = 0; j < m; j++)
			{
				int k = new Random().nextInt(2);
				salida = (k == 0)?false:true;
				descripcion = "Room[" + i + "][" + j + "]";
				habitaciones[i][j] = new Room(descripcion, salida);
			}
		}
		//habitaciones[5][5] = new Room("Room[5][5]" , true);
		//habitaciones.add(new Room("Room" + n , false));
		
		return habitaciones;
	}


	private static ArrayList<Door> createDoors(Room[][] habitaciones){

		ArrayList<Door> puertas = new ArrayList<Door>();
		
		puertas.add(new Door(habitaciones[5][5],Directions.NORTE,habitaciones[4][5], false));
		puertas.add(new Door(habitaciones[6][5],Directions.NORTE,habitaciones[5][5], false));
		puertas.add(new Door(habitaciones[4][5],Directions.OESTE,habitaciones[4][4], false));
		puertas.add(new Door(habitaciones[4][5],Directions.ESTE,habitaciones[4][6], false));
		puertas.add(new Door(habitaciones[4][5],Directions.NORTE,habitaciones[3][5], false));
		puertas.add(new Door(habitaciones[4][4],Directions.OESTE,habitaciones[4][3], false));
		puertas.add(new Door(habitaciones[4][4],Directions.SUR,habitaciones[5][4], false));
		puertas.add(new Door(habitaciones[4][6],Directions.NORTE,habitaciones[3][6], false));
		puertas.add(new Door(habitaciones[4][6],Directions.ESTE,habitaciones[4][7], false));
		puertas.add(new Door(habitaciones[4][6],Directions.SUR,habitaciones[5][6], false));
		puertas.add(new Door(habitaciones[3][5],Directions.NORTE,habitaciones[2][5], false));
		puertas.add(new Door(habitaciones[3][5],Directions.OESTE,habitaciones[3][4], false));
		puertas.add(new Door(habitaciones[3][4],Directions.NORTE,habitaciones[2][4], false));
		puertas.add(new Door(habitaciones[2][4],Directions.ESTE,habitaciones[2][5], false));
		puertas.add(new Door(habitaciones[2][5],Directions.ESTE,habitaciones[2][6], false));
		
		return puertas;	
	}
	

	
	
	private static ArrayList<Item> crearListaInicial(ArrayList<Item> listaObjetos){
		
		ArrayList<Item> lista = new ArrayList<Item>();
		
		lista.add(listaObjetos.get(0));
		lista.add(listaObjetos.get(1));
		lista.add(listaObjetos.get(2));
		lista.add(listaObjetos.get(3));
		lista.add(listaObjetos.get(4));
		lista.add(listaObjetos.get(15));
		lista.add(listaObjetos.get(18));
		lista.add(listaObjetos.get(23));
		
		return lista;
	}


	
	private static ArrayList<Item> crearLista(ArrayList<Item> listaObjetos) {
	
		ArrayList<Item> lista = new ArrayList<Item>();
		Date d = new Date();
		Random generator = new Random(d.getTime());
		int n = generator.nextInt(5);
		int m = 0;
		for(int i = 0; i <= n; i++){
			m = generator.nextInt(listaObjetos.size());
			if(!lista.contains(listaObjetos.get(m)))
			    lista.add(listaObjetos.get(m).clone());
		}
		
		return lista;
	}

	/**
	Añade las puertas del juego en el mapa.
	@param m Mapa donde añadir las puertas
	@param habitaciones habitaciones del juego
	*/
	private static void insertDoors(Map m, Room[][] habitaciones){
		
		ArrayList<Door> puertas = createDoors(habitaciones);

		for(Door puerta:puertas)
			m.agregarPuerta(puerta);
		
		ArrayList<Item> listaObjetos = new ArrayList<Item>();
		listaObjetos.add(new Llave("key0", "This key opens the door 0", puertas.get(0)));
		listaObjetos.add(new Llave("key1", "This key opens the door 1", puertas.get(1)));
		listaObjetos.add(new Llave("key2", "This key opens the door 2", puertas.get(2)));
		listaObjetos.add(new Llave("key3", "This key opens the door 3", puertas.get(3)));
		listaObjetos.add(new Llave("key4", "This key opens the door 4", puertas.get(4)));
		listaObjetos.add(new Llave("key5", "This key opens the door 5", puertas.get(5)));
		listaObjetos.add(new Llave("key6", "This key opens the door 6", puertas.get(6)));
		listaObjetos.add(new Llave("key7", "This key opens the door 7", puertas.get(7)));
		listaObjetos.add(new Llave("key8", "This key opens the door 8", puertas.get(8)));
		listaObjetos.add(new Llave("key9", "This key opens the door 9", puertas.get(9)));
		listaObjetos.add(new Llave("key10", "This key opens the door 10", puertas.get(10)));
		listaObjetos.add(new Llave("key11", "This key opens the door 11", puertas.get(11)));
		listaObjetos.add(new Llave("key12", "This key opens the door 12", puertas.get(12)));
		listaObjetos.add(new Llave("key13", "This key opens the door 13", puertas.get(13)));
		listaObjetos.add(new Llave("key14", "This key opens the door 14", puertas.get(14)));
		listaObjetos.add(new Comida("food0", "Bebida", 40, 5));
		listaObjetos.add(new Comida("food1", "Comida ligera", 50, 3));
		listaObjetos.add(new Comida("food2", "Comida rapida", 100, 1));
		listaObjetos.add(new Comida("food3", "Comida", 80, 4));
		listaObjetos.add(new Comida("food4", "Comida", -20, 1));
		listaObjetos.add(new ObjetoValor("honor1", "Gold coin", 200));
		listaObjetos.add(new ObjetoValor("valor1", "Silver coin", 150));
		listaObjetos.add(new ObjetoValor("fuerza", "Bronze coin", 100));
		listaObjetos.add(new ObjetoValor("astucia", "Any coin", 120));
		listaObjetos.add(new ObjetoValor("coraje", "Steel coin", 250));
		
		
		
		for(Room[] vector:habitaciones){
			for(Room habitacion: vector){
				ArrayList<Item> lista = crearLista(listaObjetos);
				habitacion.setInventarioHabitacion(lista);
			}
		}
		
		ArrayList<Item> listaInicial = crearListaInicial(listaObjetos);
		habitaciones[5][5].setInventarioHabitacion(listaInicial);
			
	}
	

	public void iniciarPartida() {
		
		int puntuacion = 0;
		int vida = 100;
		int xInicial = 5;
		int yInicial = 5;
		
		Map m = new Map();
		//Se crean las habitaciones
		Room[][] habitaciones = createRooms(11,11); 
		
		//Se crean las puertas
		insertDoors(m, habitaciones);
		
		Room habitacionActual = habitaciones[xInicial][yInicial];
		
		//Se crean los objetos
		Lista inventarioJugador = new Lista();
		
		this.setChanged();
	
		this.notifyObservers(new EventoPartidaIniciada(xInicial, yInicial, puntuacion, vida, inventarioJugador, habitacionActual));
		
	}
	public void executeCommand(Command comando) {
		comando.execute();
	}
	public Door getDoor(Directions direccion) {
		// TODO Auto-generated method stub
		return null;
	}

}
