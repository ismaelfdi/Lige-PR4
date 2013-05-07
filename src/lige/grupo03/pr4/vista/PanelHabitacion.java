package lige.grupo03.pr4.vista;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

/**
 * Clase que representa el panel de habitacines de la GUI
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class PanelHabitacion extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/*Atributo que representa l area donde se escribira la informacion de la habitacion*/
	private JTextArea informacion;
	
	/**
	 * Constructor por defecto
	 */
	public PanelHabitacion(){
		super();
		inicializar();
	}
	
	private void inicializar(){
		Border border = BorderFactory.createTitledBorder("Habitación");
		informacion = new JTextArea(6,106);
		informacion.setToolTipText("Aqui se muestra la informacion de la habitacion seleccionada");
		
		JScrollPane pane = new JScrollPane(informacion);
		
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(pane);
		this.setBorder(border);
	}
	
	/**
	 * Metodo que escribe en el area de texto del PanelHabitacion
	 * 
	 * @param texto String que se escribira en el area de texto.
	 */
	void escribe(String texto){
		informacion.setText(texto);
	}

}
