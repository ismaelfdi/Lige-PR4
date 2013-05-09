package lige.grupo03.pr4.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import lige.grupo03.pr4.Constantes;
import lige.grupo03.pr4.Directions;
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
	private BotonGUI[][] mapButton;
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
		this.mapButton  = new BotonGUI[Constantes.FILA][Constantes.COLUMNA];
		this.xActual = xActual;
		this.yActual = yActual;
		inicializar(habitacionActual);
	}
	
	private void inicializar(Room habitacionActual){
		Border border = BorderFactory.createTitledBorder("Mapa");
		this.setBorder(border);	
		this.setLayout(new GridLayout(Constantes.FILA, Constantes.COLUMNA));
		OyenteBoton habListener = new OyenteBoton();
	
		for(int i = 0; i < Constantes.FILA; i++){
			for(int j = 0; j < Constantes.COLUMNA; j++){
				BotonGUI boton = new BotonGUI();
				boton.setActionCommand(""+(j + Constantes.FILA*i));
				boton.setToolTipText("Presione para ver la \ndescripcion de la habitacion");
				if((i == xActual)&&(j == yActual)){
					boton.setText("Entrada");
					boton.setActiva(true);
					boton.setVisitado(true);
					boton.setHabitacion(habitacionActual);
					boton.setBackground();
				}
				mapButton[i][j] = boton;
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
	
	public void actualizarEstado(Directions direccion, Room habitacionACtual){
		
		mapButton[xActual][yActual].setActiva(false);
		mapButton[xActual][yActual].setBackground();
		
		switch (direccion) {
		case NORTE:
			xActual--;
			break;
		case SUR:
			xActual++;
			break;
		case ESTE:
			yActual++;
			break;
		case OESTE:
			yActual--;
			break;
		default:
			break;
		}
		
		mapButton[xActual][yActual].setActiva(true);
		mapButton[xActual][yActual].setVisitado(true);
		mapButton[xActual][yActual].setHabitacion(habitacionACtual);
		mapButton[xActual][yActual].setBackground();
		mapButton[xActual][yActual].setText(mapButton[xActual][yActual].descripcion());
		
		mapButton[xActual][yActual].updateUI();
		
		
	}
	
	
	private class OyenteBoton implements ActionListener{
		
		public OyenteBoton(){
		}
		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int numero = Integer.parseInt(e.getActionCommand());
			int x = numero/Constantes.FILA;
			int y = numero%Constantes.COLUMNA;
			
			if(mapButton[x][y].isVisitado()){
				panel.escribe(mapButton[x][y].mostrarInventarioHabitacion());
			}else{
				panel.escribe("");
			}
			
			
			
		}

	}	

}


