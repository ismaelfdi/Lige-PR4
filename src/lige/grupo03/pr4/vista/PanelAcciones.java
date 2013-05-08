package lige.grupo03.pr4.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.control.Controller;

/**
 * Clase que representa el panel donde se ubican las acciones del jugador
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class PanelAcciones extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelInformacionJugador panel;
	private JComboBox<Directions> cbxDireccion;
	private JTextField txtId;
	private Controller controlador;
	
	/**
	 * Constructor con 1 parametro
	 * 
	 * @param panel Representa el panel con la informacion del jugador
	 */
	public PanelAcciones(PanelInformacionJugador panel, Controller controlador){	
		super();
		this.panel = panel;
		this.controlador = controlador;
		inicializar();
	}
	
	private void inicializar(){
		Border border = BorderFactory.createTitledBorder("Acciones");
		this.setBorder(border);
		
		this.setLayout(new GridLayout(3,2,2,2));
		JButton btnIr, btnCoger, btnUsar, btnSoltar;

		
		btnIr = new JButton("IR");
		btnCoger = new JButton("COGER");
		btnUsar = new JButton("USAR");
		btnSoltar = new JButton("SOLTAR");
		
		btnIr.setToolTipText("Presione para ir a la direccion indicada");
		btnCoger.setToolTipText("Presione para Coger el objeto indicado");
		btnUsar.setToolTipText("Presione para usar el objeto seleccionado");
		btnSoltar.setToolTipText("Suelta el objeto seleccionado de tu inventario");
		
		Directions[] direcciones = Directions.values();
		
		cbxDireccion = new JComboBox<Directions>(direcciones);
		txtId = new JTextField();
		
		cbxDireccion.setToolTipText("Seleccion la direccion adonde quiere ir");
		txtId.setToolTipText("Escriba el id a coger");
		
		this.add(btnIr);
		this.add(cbxDireccion);
		this.add(btnCoger);
		this.add(txtId);
		this.add(btnUsar);
		this.add(btnSoltar);
		
		OyenteBotonAccion btnAccionListener = new OyenteBotonAccion();
		
		btnCoger.addActionListener(btnAccionListener);
		btnIr.addActionListener(btnAccionListener);
		btnUsar.addActionListener(btnAccionListener);	
		btnSoltar.addActionListener(btnAccionListener);
		
	}
	
	private Directions getSelectedItem(){
		return ((Directions)cbxDireccion.getSelectedItem());
	}
	
	public String getText(){
		return txtId.getText();
	}
	
	private class OyenteBotonAccion implements ActionListener{

		public OyenteBotonAccion(){
		}
		
		/**
		 * Metodo sobrecargado que de la accion que realizael boton
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nombreBoton = (String)e.getActionCommand();
			Directions direccion = getSelectedItem();
			String id = getText();
			
			if(nombreBoton.equals("COGER")){
				if(!id.equals(""))
					JOptionPane.showMessageDialog(new JFrame(), "COGER " + id );
				
				else
					JOptionPane.showMessageDialog(new JFrame(), "Por favor ingresa el id del objeto" );
			}
			
			if(nombreBoton.equals("IR"))
				//JOptionPane.showMessageDialog(new JFrame(), "Has seleccionado el comando IR " + direccion.toString() );
				controlador.go(direccion);
			if(nombreBoton.equals("USAR")){
				try {
					String data = panel.getSelectedITem();
					JOptionPane.showMessageDialog(new JFrame(), "USAR " + data );
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Selecciona un Objeto de tu inventario" );
				}
				
			}
			
			if(nombreBoton.equals("SOLTAR")){
				JOptionPane.showMessageDialog(null, "Soltamos este objeto");
			}
		}

	}

}
