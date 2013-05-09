package lige.grupo03.pr4;

import javax.swing.JOptionPane;

import lige.grupo03.pr4.control.Controller;
import lige.grupo03.pr4.modelo.Game;
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.vista.ViewGUI;
import lige.grupo03.pr4.vista.ViewUIConsole;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ModoJuego modo = ModoJuego.NORMAL;
		ViewUIConsole viewUIConsole = null;
		
		if(args.length > 1){
			JOptionPane.showMessageDialog(null,"No de parametros incorrecto" + args[0]);
			return;
		}else if(args.length == 1){
			
			if(!args[0].equals("-c")){
				JOptionPane.showMessageDialog(null,"Valor de parametro incorrecto " + args[0] );
				return;			
			}else{
				modo = ModoJuego.CONSOLA;
			}
		}		
		
		
		
		
		/*Creamos el modelo*/
		Game modelo = new Game();
		
		/*Creamos el controlador*/
		Controller controller = new Controller(modelo);
		
		/*Creamos las vistas*/
		ViewGUI viewGUI = new ViewGUI(controller);
		
		if(modo == ModoJuego.CONSOLA)
			viewUIConsole = new ViewUIConsole(controller);
				
		/*Registra las vistas como observadoras del modelo*/
		modelo.addObserver(viewGUI);
		modelo.addObserver(viewUIConsole);
		
		viewGUI.setVisible(true);	
	
	}

}
