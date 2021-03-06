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
import lige.grupo03.pr4.modelo.eventos.EventoObjetoSoltado;
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
	private JSplitPane jspControl;
	
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
		
		this.getContentPane().removeAll();
		p2.updateUI();
		p1.updateUI();
		panelHabitacion.updateUI();
		mapa.updateUI();
		this.update(getGraphics());
	}
	
	public void setModoJuego(ModoJuego modo) {
		this.modoJuego  = modo;	
	}
	
	/**MÃ©todo mostrarPuntuaciÃ³n
	 * Muestra por pantalla un mensaje con la puntuaciÃ³n final
	 * de la partida.	 
	 * @param puntuacion puntuaciÃ³n de la partida.
	 * @return nada
	 */
	public void mostrarPuntuaciones(float puntuacion)
	{
		JOptionPane.showMessageDialog(null, "Puntuacion Final: "+puntuacion);
	}
	
	
	/**MÃ©todo pedirJugarOtra
	 * Pregunta al usuario si desea jugar otra partida
	 * @param nada
	 * @return Booleano con la respuesta del usuario
	 */
	public boolean pedirJugarOtra()
	{	
		int seleccion = JOptionPane.showOptionDialog(
				   this,
				   "�Desea jugar otra partida?", 
				   "",
				   JOptionPane.YES_NO_OPTION,
				   JOptionPane.QUESTION_MESSAGE,
				   null,
				   new Object[] { "Sí", "No" },
				   "Sí");
		if(seleccion==0)
			return true;
		else
			return false;
	}
	
	private void comenzarPartida(){
		controller.solicitaIniciarPartida();
	}

	
	@Override
	public void update(Observable modelo, Object ev) {
		
		Evento evento = (Evento)ev;
		
		switch (evento.getTipo()) {
		case EVENTO_PARTIDA_INICIADA:
			procesarIniciarPartida(evento);
			break;
			
		case EVENTO_PARTIDA_FINALIZADA:	
			procesarPartidaFinalizada(evento);
			break;
			
		case EVENTO_MOVIMIENTO_REALIZADO:
			procesarIr(evento);
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
		
		case EVENTO_OBJETO_SOLTADO:
			procesarObjetoSoltado(evento);
			break;
			
		case EVENTO_GO:
			//procesarIr(evento);
			break;
		
		default:
			break;
		}	
	}
	
	private void procesarObjetoSoltado(Evento evento) {
		
		EventoObjetoSoltado evObjetoSoltado = (EventoObjetoSoltado)evento;
		p2.actualizarInventario(evObjetoSoltado.getInventarioJugador());
		panelHabitacion.actualizarEstado(evObjetoSoltado.getHabitacion());
	}

	private void procesarIniciarPartida(Evento evento){
		EventoPartidaIniciada evNuevaPartida = (EventoPartidaIniciada)evento;
		
		//this.setLayout(new BorderLayout());
		
		p2 = new PanelInformacionJugador(evNuevaPartida.getVida(), evNuevaPartida.getPuntuacion(), evNuevaPartida.getInventarioJugador());
		p1 = new PanelAcciones(p2,controller);
		
		panelHabitacion = new PanelHabitacion(evNuevaPartida.getHabitacionActual());
		mapa = new PanelMapa(panelHabitacion, evNuevaPartida.getXInicial(), evNuevaPartida.getYinicial(),evNuevaPartida.getHabitacionActual());
		
		jspControl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		jspControl.setDividerLocation(300);
		
		this.add(jspControl,BorderLayout.NORTH);
		this.add(mapa,BorderLayout.CENTER);
		this.add(panelHabitacion,BorderLayout.SOUTH);	
		actualizarGUI();
	}
	
	private void actualizarGUI(){
		p2.updateUI();
		p1.updateUI();
		jspControl.updateUI();
		panelHabitacion.updateUI();
		mapa.updateUI();
	}
	
	private void procesarIr(Evento evento) {
		EventoMovimientoRealizado evMovRealizado = (EventoMovimientoRealizado)evento;
		//JOptionPane.showMessageDialog(null, "Pasando por aqui...");
		p2.actualizarEstado(evMovRealizado.getVida(),evMovRealizado.getPuntuacion());
		mapa.actualizarEstado(evMovRealizado.getDireccion(), evMovRealizado.getHabitacion());
		panelHabitacion.actualizarEstado(evMovRealizado.getHabitacion());
	}
	
	public void procesarError(Evento evento) {
		EventoError eventoError = (EventoError)evento;
		
		JOptionPane.showMessageDialog(null, eventoError.getErrorProducido());
			
	}
	
	private void procesarObjetoUsado(Evento evento) {
		EventoObjetoUsado evObjetoUsado = (EventoObjetoUsado)evento;
		p2.actualizarInventario(evObjetoUsado.getInventarioJugador());
		p2.actualizarEstado(evObjetoUsado.getVida(), evObjetoUsado.getPuntuacion());
		
	}
	
	private void procesarObjetoCogido(Evento evento) {
		EventoObjetoCogido evObjetoCogido = (EventoObjetoCogido)evento;
		
		p2.actualizarInventario(evObjetoCogido.getInventarioJugador());
		panelHabitacion.actualizarEstado(evObjetoCogido.getHabitacion());
	}
	
	private void procesarPartidaFinalizada(Evento evento) {
		EventoPartidaFinalizada evPartidaFinalizada = (EventoPartidaFinalizada)evento;
		p2.actualizarEstado(evPartidaFinalizada.getVida(), evPartidaFinalizada.getPuntuacion());
		
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
				    String message = "�Desea salir realmente del Juego?";
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
