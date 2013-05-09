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
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaFinalizada;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaIniciada;
import lige.grupo03.pr4.modelo.items.Comida;
import lige.grupo03.pr4.modelo.items.Item;
import lige.grupo03.pr4.modelo.items.Llave;
import lige.grupo03.pr4.modelo.items.ObjetoValor;

public class Game extends Observable{
	
	/*Atributo que almacena las puertas*/
	private Map m;
	/*Atributo que representa la habitacion actual*/
	private Room habitacionActual;
	private Player jugador;	
	/*
	private int vida;
	private int puntuacion;
	*/
	public Game(){
		m = new Map();
		habitacionActual = new Room();
		jugador = new Player();		
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
		
		puertas.add(new Door(habitaciones[5][5],Directions.NORTE,habitaciones[4][5], true));
		puertas.add(new Door(habitaciones[6][5],Directions.NORTE,habitaciones[5][5], true));
		puertas.add(new Door(habitaciones[4][5],Directions.OESTE,habitaciones[4][4], true));
		puertas.add(new Door(habitaciones[4][5],Directions.ESTE,habitaciones[4][6], true));
		puertas.add(new Door(habitaciones[4][5],Directions.NORTE,habitaciones[3][5], true));
		puertas.add(new Door(habitaciones[4][4],Directions.OESTE,habitaciones[4][3], true));
		puertas.add(new Door(habitaciones[4][4],Directions.SUR,habitaciones[5][4], true));
		puertas.add(new Door(habitaciones[4][6],Directions.NORTE,habitaciones[3][6], true));
		puertas.add(new Door(habitaciones[4][6],Directions.ESTE,habitaciones[4][7], true));
		puertas.add(new Door(habitaciones[4][6],Directions.SUR,habitaciones[5][6], true));
		puertas.add(new Door(habitaciones[3][5],Directions.NORTE,habitaciones[2][5], true));
		puertas.add(new Door(habitaciones[3][5],Directions.OESTE,habitaciones[3][4], true));
		puertas.add(new Door(habitaciones[3][4],Directions.NORTE,habitaciones[2][4], true));
		puertas.add(new Door(habitaciones[2][4],Directions.ESTE,habitaciones[2][5], true));
		puertas.add(new Door(habitaciones[2][5],Directions.ESTE,habitaciones[2][6], true));
		
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
		
		jugador.setPuntuacion(0);
		jugador.setVida(100);
		
		int xInicial = 5;
		int yInicial = 5;
		
		//Map m = new Map();
		//Se crean las habitaciones
		Room[][] habitaciones = createRooms(11,11); 
		
		//Se crean las puertas
		insertDoors(m, habitaciones);
		
		habitacionActual = habitaciones[xInicial][yInicial];
		
		//Se crean los objetos
		//Lista inventarioJugador = new Lista();
		
		this.setChanged();
	
		this.notifyObservers(new EventoPartidaIniciada(xInicial, yInicial, jugador.getPuntuacion(), jugador.getVida(), jugador.getInventarioPlayer(), habitacionActual));
		
	}
	
	
	public void executeCommand(Command comando) {
		Evento evento = comando.execute();
		
		switch (comando.getVerbo()) {
			case IR:		
					this.setChanged();
					this.notifyObservers(evento);
					
					if(habitacionActual.isSalida()){
						this.setChanged();
						this.notifyObservers(new EventoPartidaFinalizada(jugador.getPuntuacion(), jugador.getVida(), true));
					}else if(!jugador.tieneNivelVida()){
						this.setChanged();
						this.notifyObservers(new EventoPartidaFinalizada(jugador.getPuntuacion(), jugador.getVida(), false));
					}
					break;
					
			case COGER:
					this.setChanged();
					this.notifyObservers(evento);
				break;
				
			case USAR:
					this.setChanged();
					this.notifyObservers(evento);
					if(!jugador.tieneNivelVida()){
						this.setChanged();
						this.notifyObservers(new EventoPartidaFinalizada(jugador.getPuntuacion(), jugador.getVida(), false));
					}
				break;
			case SOLTAR:
					this.setChanged();
					this.notifyObservers(evento);
				break;
				/*
			case IR:
				
				break;
			case IR:
				
				break;
			case IR:
				
				break;*/
			default:
				break;
		}
		

			
		
		
	}
	public Door getDoor(Directions direccion) {
		return m.devolverPuerta(habitacionActual, direccion);
	}
	
	public Room getHabitacionActual(){
		return habitacionActual;
	}
	
	public Player getJugador(){
		return jugador;
	}
	
	public int vida(){
		return jugador.getVida();
	}
	
	public int puntuacion(){
		return jugador.getPuntuacion();
	}
	

	public void cambiarHabitacion(Directions direccion){

		String mensaje = "...moviéndonos al " + direccion.toString() + "\n";	
		Door puerta = m.devolverPuerta(habitacionActual, direccion);

		habitacionActual = puerta.nextRoom(habitacionActual);
		jugador.restarVida();

		
	}

	public boolean estaEnHabitacionActual(String id){
		return habitacionActual.estaObjeto(id);
	}
	
	public boolean estaEnInventarioJugador(String id){
		return jugador.tieneEnInventario(id);
	}

	public void cogerId(String id){
		Item item = habitacionActual.cogerObjeto(id);
		jugador.agregaObjeto(item);				
	}
	
	public Lista inventarioJugador(){
		return jugador.getInventarioPlayer();
	}
	
	public void usarObjeto(String id){
		
		Item item = jugador.obtenerObjeto(id);
			
		if(item.use(jugador, habitacionActual)){
			if(!item.canBeUsed()){
					jugador.borrarItem(id);
			}
		}
		
	}	

	
	public void soltarId(String id) {
		
		
		if(!habitacionActual.estaObjeto(id)){
			Item item = jugador.obtenerObjeto(id);
			jugador.borrarItem(id);
			habitacionActual.agregarItem(item);	
		}	
	}

/*	
	

	public void mostrarInventarioHabitacion(){
		UIConsola.printText(habitacionActual.mostrarInventario());
	}



	public void usarObjeto(String id){
		if(jugador.tieneEnInventario(id)){
			Item item = jugador.obtenerObjeto(id);
			
			if(item.use(jugador, habitacionActual)){
				UIConsola.printText("Algo ha cambiado...");
				if(!item.canBeUsed()){
					jugador.borrarItem(id);
					UIConsola.printText("\n" + item.getId() + " ha sido borrado de tu inventario.\n");
					UIConsola.printText(jugador.mostrarPuntuacion());
				}
			}
			else
				UIConsola.printText("Como no fuiste a clase de LIGe la semana pasada no " +
									"sabes cómo usar los objetos de forma adecuada...");
			
		}else
			UIConsola.showError("Alguien robo tu " + id + ".");
	}
	

	public void cogerId(String id){
		if(habitacionActual.estaObjeto(id)){
			if(!jugador.tieneEnInventario(id)){
				Item item = habitacionActual.cogerObjeto(id);
				jugador.agregaObjeto(item);
			}else{
				UIConsola.showError("Ya tienes otro " + id + " en tu inventario.");
			}
		}else{
			UIConsola.showError("El objeto " + id + " no está en esta habitación.");
		}		
	}
	

	public void salir() {
		UIConsola.printText("GAME OVER!!\nGracias por jugar.\n");
		UIConsola.printText( jugador.mostrarPuntuacion());	
	}
	

	public void mirarId(String id) {
		if(id.equals(""))
			UIConsola.printText(jugador.mostrarInventario());
		else
			UIConsola.printText(jugador.mostrarItem(id));
		
	}


	public void soltarId(String id) {
		
		if(jugador.tieneEnInventario(id)){
			if(!habitacionActual.estaObjeto(id)){
				Item item = jugador.obtenerObjeto(id);
				jugador.borrarItem(id);
				habitacionActual.agregarItem(item);
				
			}else
				UIConsola.showError("El objeto " + id + " ya existe en esta habitacion.");	
		}else
			UIConsola.showError("No tienes " + id + " en tu inventario.");
		
	}
	



	public void comenzarJuego(){
		
		Command comando = new Comando();
		String entrada;
		
		UIConsola.printText(habitacionActual.mostrarInventario());
		UIConsola.printText(jugador.mostrarPuntuacion());
		while(!(comando.getVerbo().equals(VerbCommands.SALIR) || habitacionActual.getSalida() || !jugador.tieneNivelVida())){	
			entrada = UIConsola.askComand();
			comando = Parser.parsear(this, entrada);
			comando.ejecutar();
		}
				
		if(habitacionActual.getSalida())
			UIConsola.printText("\nHa ganado!!!");
	}

	
	
	
	
*/
	
}
