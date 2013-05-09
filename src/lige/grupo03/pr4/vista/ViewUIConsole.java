package lige.grupo03.pr4.vista;

import java.util.Observable;
import java.util.Observer;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.control.Controller;
import lige.grupo03.pr4.modelo.Room;
import lige.grupo03.pr4.modelo.eventos.Evento;
import lige.grupo03.pr4.modelo.eventos.EventoError;
import lige.grupo03.pr4.modelo.eventos.EventoMovimientoRealizado;
import lige.grupo03.pr4.modelo.eventos.EventoObjetoCogido;
import lige.grupo03.pr4.modelo.eventos.EventoObjetoUsado;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaFinalizada;
import lige.grupo03.pr4.modelo.eventos.EventoPartidaIniciada;

public class ViewUIConsole implements Observer{

	private Controller controlador;
	private String mensaje;
	
	public ViewUIConsole(Controller controller) {
		this.controlador = controller;
	}

	
	
	
	
	
	@Override
	public void update(Observable o, Object ev) {
		
		Evento evento = (Evento)ev;
		
		switch (evento.getTipo()) {
		case EVENTO_PARTIDA_INICIADA:
			consolaIniciarPartida(evento);
			break;
			
		case EVENTO_PARTIDA_FINALIZADA:	
			consolaPartidaFinalizada(evento);
			break;
			
		case EVENTO_MOVIMIENTO_REALIZADO:
			consolaIr(evento);
			break;
			
		case EVENTO_OBJETO_COGIDO:
			consolaObjetoCogido(evento);
			break;
			
		case EVENTO_OBJETO_USADO:
			consolaObjetoUsado(evento);
			break;
			
		case EVENTO_ERROR:
			consolaError(evento);
			break;
		
		case EVENTO_OBJETO_SOLTADO:
			consolaObjetoSoltado(evento);
			break;
			
		case EVENTO_GO:
			//procesarIr(evento);
			break;
		
		default:
			break;
		}				
	}

	private void consolaObjetoSoltado(Evento evento) {
		printText("Has soltado un objeto");
		
	}

	private void consolaError(Evento evento) {
		EventoError evtError = (EventoError)evento;
		printText(evtError.getErrorProducido());
	}

	private void consolaObjetoUsado(Evento evento){
		EventoObjetoUsado evtObjetoUsado = (EventoObjetoUsado)evento;
		int vida = evtObjetoUsado.getVida();
		int puntuacion = evtObjetoUsado.getPuntuacion();
		
		mensaje = "\nAlgo ha cambiado ... \n" + strPuntuacion(vida, puntuacion);
		printText(mensaje);
	}

	private void consolaObjetoCogido(Evento evento) {
		
		EventoObjetoCogido evtObjetoCogido = (EventoObjetoCogido)evento;
		
		printText("\nHas cogido el objeto.\n");
		
	}

	private void consolaIr(Evento evento) {	
		EventoMovimientoRealizado evtMovimiento = (EventoMovimientoRealizado)evento;
		Directions direccion = evtMovimiento.getDireccion();
		Room habitacion = evtMovimiento.getHabitacion();
		mensaje = "...moviéndonos al " + direccion.toString() + "\n";
		mensaje += habitacion.toString();
		
		printText(mensaje);
		
	}

	private void consolaPartidaFinalizada(Evento evento) {	
		EventoPartidaFinalizada evPartidaFinalizada = (EventoPartidaFinalizada)evento;
		int vida = evPartidaFinalizada.getVida();
		int puntuacion = evPartidaFinalizada.getPuntuacion();
		mensaje = "\nGracias por jugar... \n" + strPuntuacion(vida, puntuacion);
		printText(mensaje);
	}

	private void consolaIniciarPartida(Evento evento) {
		EventoPartidaIniciada evPartidaIniciada = (EventoPartidaIniciada)evento;
		Room habitacion = evPartidaIniciada.getHabitacionActual();
		mensaje = "Comienza el juego:\n" + habitacion.toString();
		
		printText(mensaje);
	}

	private String strPuntuacion(int vida, int puntuacion){
		return "VIDA = " + vida + " : PUNTUACION = " + puntuacion;
	}
	
	
	/** método printText: muestra por pantalla una cadena que se le pasa
	 *  como parámetro.
	 *  @param cadena String que se mostrara por pantalla.
	 */
	public void printText(String cadena){
		System.out.print(cadena);
	}
}
