package lige.grupo03.pr4.control;

import lige.grupo03.pr4.modelo.Game;

public class Controller {
	
	private Game game;
	
	public Controller(Game game){
		this.game = game;
	}
	

	public void solicitaIniciarPartida() {
		game.iniciarPartida();
	}


	public void solicitaMostrarInstrucciones() {
		game.mostrarInstrucciones();
	}

}
