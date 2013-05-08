package lige.grupo03.pr4.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import lige.grupo03.pr4.Constantes;
import lige.grupo03.pr4.modelo.Room;

/**
 * Clase que representa el Mapa de la GUI
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class PanelMapa extends JPanel{

	private static final long serialVersionUID = 1L;
	/*atributo que representa el Panel con la informacion de la habitacion*/
	private PanelHabitacion panel;
	private BotonGUI[][] matriz;
	private int xActual;
	private int yActual;
	/**
	 * Constructor con 1 parametro
	 * 
	 * @param panel PanelHabitacion que representa el panel de la habitacion de la GUI
	 */
	public PanelMapa(PanelHabitacion panel, int xActual, int yActual, Room habitacionActual){
		super();
		this.panel = panel;	
		this.matriz  = new BotonGUI[Constantes.FILA][Constantes.COLUMNA];
		this.xActual = xActual;
		this.yActual = yActual;
		inicializar(habitacionActual);
	}
	
	private void inicializar(Room habitacionActual){
		Border border = BorderFactory.createTitledBorder("Mapa");
		this.setBorder(border);	
		this.setLayout(new GridLayout(Constantes.FILA, Constantes.COLUMNA));
		OyenteBoton habListener = new OyenteBoton();
	
		for(int i = 1; i <= Constantes.FILA; i++){
			for(int j = 1; j <= Constantes.COLUMNA; j++){
				BotonGUI boton = new BotonGUI();
				//boton.setActionCommand(""+(j + 11*(i-1)));
				boton.setToolTipText("Presione para ver la \ndescripcion de la habitacion");
				if((i == xActual)&&(j == yActual)){
					boton.setText("Entrada");
					boton.setBackground(Color.GREEN);
					boton.setHabitacion(habitacionActual);
					boton.addActionListener(habListener);
				}
				boton.addActionListener(habListener);
				this.add(boton);
			}
		}
	}
	
	private void setXActual(int x){
		this.xActual = x;
	}
	
	private void setYActual(int y){
		this.yActual = y;
	}	
	
	 
	
	private class OyenteBoton implements ActionListener{
		
		public OyenteBoton(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.escribe(e.getActionCommand());
		}

	}	

}


