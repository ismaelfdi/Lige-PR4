package lige.grupo03.pr4.vista;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


import lige.grupo03.pr4.ModoJuego;
import lige.grupo03.pr4.TipoEvento;
import lige.grupo03.pr4.TipoJugador;
import lige.grupo03.pr4.control.Controller;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaIniciada;


public class ViewGUI extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private Menu barraMenu;
	private PanelInformacionJugador p2;
	private PanelAcciones p1;
	private PanelHabitacion habitacion;
	private PanelMapa mapa;
	private TipoJugador tipoJugador;
	private ModoJuego modoJuego;
	
	public ViewGUI(Controller controller){
		super("Aventura conversacional GUI");
		this.controller = controller;
		initialize();
	
	}

	private void initialize(){
		this.setLayout(new BorderLayout());
		this.barraMenu = new Menu();
		this.setJMenuBar(barraMenu);
		
		this.setSize(1200, 700);
		this.setResizable(false);
		this.setLocation(40, 30);	
	}

	private void reset(){
		p2.removeAll();
		p1.removeAll();
		habitacion.removeAll();
		mapa.removeAll();
		p2.updateUI();
		p1.updateUI();
		habitacion.updateUI();
		mapa.updateUI();
		if(tipoJugador == TipoJugador.JUGADOR_IA);
			//controller.finIA(); AQui reseteamos el modo IA
	}
	
	private void comenzarPartida(){
		controller.solicitaIniciarPartida();
		if(tipoJugador == TipoJugador.JUGADOR_IA);
			//controller.juegoIA();//Aqui iniciamos el juego en modo IA
	}

	/*
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
		
		
	}	
	*/
	
	@Override
	public void update(Observable modelo, Object ev) {
		// TODO Auto-generated method stub
		
		Evento evento = (Evento)ev;
		
		switch (evento.getType()) {
		case EVENTO_PARTIDA_INICIADA:
			EventoPartidaIniciada evNuevaPartida = new EventoPartidaIniciada(TipoEvento.EVENTO_PARTIDA_INICIADA);
			
			
			
			break;
		case EVENTO_GO:
			
			break;
		case EVENTO_USAR:
			
			break;
		default:
			break;
		}
		
		
		
	}
	
/**********************************************************************/
/*                     Clase privada Menu                             */	
/**********************************************************************/
	private class Menu extends JMenuBar
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6476203549966869222L;
		private JMenu menuOpciones;
		private JMenuItem empezar = new JMenuItem("Empezar");
		private JMenuItem finalizar = new JMenuItem("Finalizar");
		private JMenuItem instrucciones = new JMenuItem("Instrucciones");
		private JMenuItem salir = new JMenuItem("Salir");		
		/*JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);*/
		
		public Menu(){
			super();
			menuOpciones = new JMenu("File");
			this.add(menuOpciones);
			
			menuOpciones.add(empezar);
			menuOpciones.add(finalizar);
			menuOpciones.add(instrucciones);
			menuOpciones.add(salir);			
			
			OyenteMenu menuListener = new OyenteMenu();
			
			empezar.addActionListener(menuListener);
			finalizar.addActionListener(menuListener);
			instrucciones.addActionListener(menuListener);
			salir.addActionListener(menuListener);			
		}
		
		
		public void activarEmpezar(){
			empezar.setEnabled(true);
			finalizar.setEnabled(false);
		}
		/*******************************************************/
		/*		OyenteMenu Clase privada del menu 											   */
		/*******************************************************/
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
						JOptionPane.showMessageDialog(null, "No se encuentra el fichero de ayuda");
					}	
					
					/*controller.solicitaMostrarInstrucciones();*/
				}
				
				if(menuItem.equals("Finalizar")){
					
					empezar.setEnabled(true);
					finalizar.setEnabled(false);
					reset();
					JOptionPane.showMessageDialog(null, "reinicio de partida");
				}
				
				if(menuItem.equals("Empezar")){
					empezar.setEnabled(false);
					finalizar.setEnabled(true);
					comenzarPartida();
					//controller.solicitaIniciarPartida();
				}
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
