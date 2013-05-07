package lige.grupo03.pr4;

import lige.grupo03.pr4.control.Controller;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.vista.ViewGUI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Creamos el modelo*/
		Game modelo = new Game();
		
		/*Creamos el controlador*/
		Controller controller = new Controller(modelo);
		
		/*Creamos las vistas*/
		ViewGUI viewGUI = new ViewGUI(controller);
		
		/*Registra las vistas como observadoras del modelo*/
		modelo.addObserver(viewGUI);
		
		viewGUI.setVisible(true);
		
	}

}
