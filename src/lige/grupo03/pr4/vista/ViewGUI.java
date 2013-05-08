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
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.modelo.eventos.EventoGo;
import lige.grupo03.pr4.modelo.eventos.EventoMovimientoRealizado;
import lige.grupo03.pr4.modelo.eventos.EventoObjetoCogido;
import lige.grupo03.pr4.modelo.eventos.EventoObjetoUsado;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaFinalizada;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaIniciada;


public class ViewGUI extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private Menu barraMenu;
	private PanelInformacionJugador p2;
	private PanelAcciones p1;
	private PanelHabitacion panelHabitacion;
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
		panelHabitacion.removeAll();
		mapa.removeAll();
		p2.updateUI();
		p1.updateUI();
		panelHabitacion.updateUI();
		mapa.updateUI();
		if(tipoJugador == TipoJugador.JUGADOR_IA);
			//controller.finIA(); AQui reseteamos el modo IA
	}
	
	private void comenzarPartida(){
		controller.solicitaIniciarPartida();
		if(tipoJugador == TipoJugador.JUGADOR_IA);
			//controller.juegoIA();//Aqui iniciamos el juego en modo IA
	}

	
	@Override
	public void update(Observable modelo, Object ev) {
		// TODO Auto-generated method stub
		
		Evento evento = (Evento)ev;
		
		switch (evento.getTipo()) {
		case EVENTO_PARTIDA_INICIADA:
			procesarIniciarPartida(evento);
			break;
			
		case EVENTO_PARTIDA_FINALIZADA:	
			procesarPartidaFinalizada(evento);
			break;
			
		case EVENTO_MOVIMIENTO_REALIZADO:
			procesarMovimientoRealizado(evento);
			break;
			
		case EVENTO_OBJETO_COGIDO:
			procesarObjetoCogido(evento);
			break;
			
		case EVENTO_OBJETO_USADO:
			procesarObjetoUsado(evento);
			break;
			
		case EVENTO_ERROR:
			procesarError(evento);
			break;
			
		case EVENTO_GO:
			procesarIr(evento);
			break;
		
		default:
			break;
		}
		
		
		
	}
	
	public void procesarIniciarPartida(Evento evento){
		EventoPartidaIniciada evNuevaPartida = (EventoPartidaIniciada)evento;
		
		//this.setLayout(new BorderLayout());
		
		p2 = new PanelInformacionJugador(evNuevaPartida.getVida(), evNuevaPartida.getPuntuacion(), evNuevaPartida.getInventarioJugador());
		p1 = new PanelAcciones(p2,controller);
		
		panelHabitacion = new PanelHabitacion(evNuevaPartida.getHabitacionActual());
		PanelMapa mapa = new PanelMapa(panelHabitacion, evNuevaPartida.getXInicial(), evNuevaPartida.getYinicial(),evNuevaPartida.getHabitacionActual());
		
		JSplitPane jspControl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		jspControl.setDividerLocation(300);
		
		this.add(jspControl,BorderLayout.NORTH);
		this.add(mapa,BorderLayout.CENTER);
		this.add(panelHabitacion,BorderLayout.SOUTH);	
		actualizarGUI();
	}
	
	private void actualizarGUI(){
		p2.updateUI();
		p1.updateUI();
		panelHabitacion.updateUI();
		mapa.updateUI();
	}
	
	private void procesarIr(Evento evento) {
		EventoGo eventoIr = (EventoGo)evento;
			
	}
	
	private void procesarError(Evento evento) {
		EventoError eventoError = (EventoError)evento;
			
	}
	
	private void procesarObjetoUsado(Evento evento) {
		EventoObjetoUsado eventoObjetoUsado = (EventoObjetoUsado)evento;	
	}
	
	private void procesarObjetoCogido(Evento evento) {
		EventoObjetoCogido eventoObjetoCogido = (EventoObjetoCogido)evento;
	}
	
	private void procesarMovimientoRealizado(Evento evento) {
		EventoMovimientoRealizado eventoMovimientoRealizado = (EventoMovimientoRealizado)evento;	
	}
	
	private void procesarPartidaFinalizada(Evento evento) {
		EventoPartidaFinalizada eventoPartidaFinalizada = (EventoPartidaFinalizada)evento;
		
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
