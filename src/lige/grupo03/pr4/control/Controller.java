package lige.grupo03.pr4.control;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.commands.ComandoCoger;
import lige.grupo03.pr4.modelo.commands.ComandoIr;
import lige.grupo03.pr4.modelo.commands.ComandoSoltar;
import lige.grupo03.pr4.modelo.commands.ComandoUsar;
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


	public void cogerObjeto(String id) {
		ComandoCoger comandoCoger = new ComandoCoger(game, id);
		game.executeCommand(comandoCoger);
	}


	public void usarObjeto(String id) {
		ComandoUsar comandoUsar = new ComandoUsar(game, id);
		game.executeCommand(comandoUsar);
		
	}


	public void soltar(String id) {
		ComandoSoltar comandoSoltar = new ComandoSoltar(game, id);
		game.executeCommand(comandoSoltar);
	}




}
