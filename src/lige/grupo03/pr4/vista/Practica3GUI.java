package lige.grupo03.pr4.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.w3c.dom.events.Event;

public class Practica3GUI extends JFrame{

	/**
	 * Clase GUI principal donde se ubica el main
	 * 
	 * @author Ismael Ventura & Ignacio Lopez
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Practica3GUI(){
		super("Aventura Conversacional GUI");
		inicializar();
	}
	
	private void inicializar(){
		this.setLayout(new BorderLayout());
		
		PanelInformacionJugador p2 = new PanelInformacionJugador();
		PanelAcciones p1 = new PanelAcciones(p2);
		
		PanelHabitacion habitacion = new PanelHabitacion();
		PanelMapa mapa = new PanelMapa(habitacion);
		
		JSplitPane jspControl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		jspControl.setDividerLocation(300);
		
		this.add(jspControl,BorderLayout.NORTH);
		this.add(mapa,BorderLayout.CENTER);
		this.add(habitacion,BorderLayout.SOUTH);
		
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		
		JMenu menu = new JMenu("Menu");
		JMenuItem instrucciones = new JMenuItem("Instrucciones");
		JMenuItem salir = new JMenuItem("Salir");
		menu.add(instrucciones);
		menu.add(salir);
		OyenteMenu menuListener = new OyenteMenu();
		
		instrucciones.addActionListener(menuListener);
		salir.addActionListener(menuListener);
		bar.add(menu);
		
		this.setSize(1200, 700);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Practica3GUI ventana = new Practica3GUI();
		ventana.setResizable(false);
		ventana.setLocation(40, 30);
	}
	
	private class OyenteMenu implements ActionListener{

		/**
		 * Metodo sobrecargado de la interfaz ActionListener
		 */
		@Override
		public void actionPerformed(ActionEvent e) {			
			String menuItem = (String)e.getActionCommand();
			
			if (menuItem.equals("Salir"))
			{
			    String message = "¿Desea salir realmente del Juego?";
			    String title = "Really Quit?";
			    // desplegamos el JOptionPane showConfirmDialog
			    int respuesta = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
			    if (respuesta == JOptionPane.YES_OPTION)
			    {
			      System.exit(0);
			    }
			}
			
			
			if(menuItem.equals("Instrucciones")){
			
				JTextArea textoAyuda = new JTextArea(30,50);
				
				FileReader fr;
				try {
					fr = new FileReader("Ayuda.txt");
					BufferedReader br = new BufferedReader(fr);
					String linea = br.readLine();
					
					while(linea != null){
						System.out.println(linea);
						textoAyuda.append(linea + "\n");
						linea = br.readLine();
					}
					br.close();
					textoAyuda.setSize(600, 600);
					JScrollPane ayuda = new JScrollPane(textoAyuda);
					
					JPanel panelAyuda = new JPanel();
					panelAyuda.setLayout(new BorderLayout());
					panelAyuda.add(ayuda, BorderLayout.CENTER);
					
					
					JOptionPane.showMessageDialog(new JFrame(), panelAyuda);					
				} catch (Exception e2) {
					e2.printStackTrace();
				}		
				
				
				
				
				
			}	
		}
	}
	

}
