package lige.grupo03.pr4.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	
	/**
	 * Constructor con 1 parametro
	 * 
	 * @param panel PanelHabitacion que representa el panel de la habitacion de la GUI
	 */
	public PanelMapa(PanelHabitacion panel){
		super();
		this.panel = panel;	
		inicializar();
	}
	
	private void inicializar(){
		Border border = BorderFactory.createTitledBorder("Mapa");
		this.setBorder(border);	
		this.setLayout(new GridLayout(11, 11));
		OyenteBoton habListener = new OyenteBoton();
	
		for(int i = 1; i <= 11; i++){
			for(int j = 1; j <= 11; j++){
				JButton boton = new JButton();
				boton.setActionCommand(""+(j + 11*(i-1)));
				boton.setToolTipText("Presione para ver la \ndescripcion de la habitacion");
				boton.addActionListener(habListener);
				this.add(boton);
			}
		}
	}
	
	
	private class OyenteBoton implements ActionListener{
		
		public OyenteBoton(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.escribe("Has seleccionado habitacion " + e.getActionCommand() + "\n");
		}

	}	

}


