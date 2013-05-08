package lige.grupo03.pr4.control;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.commands.ComandoIr;
import lige.grupo03.pr4.modelo.commands.Command;

public class Controller {
	
	private Game game;
	
	public Controller(Game game){
		this.game = game;
	}
	

	public void solicitaIniciarPartida() {
		game.iniciarPartida();
	}


	public void go(Directions direccion) {
		
		ComandoIr comandoIr = new ComandoIr(game, direccion);
		game.executeCommand(comandoIr);
		
	}



}
