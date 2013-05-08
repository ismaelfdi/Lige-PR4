package lige.grupo03.pr4.vista;

import javax.swing.JButton;

import lige.grupo03.pr4.modelo.Room;

public class BotonGUI extends JButton{
	
	private static final long serialVersionUID = 8640161313551958763L;
	private Room habitacion;
	private boolean activa;
	private boolean visitado;
	
	
	public BotonGUI(){
		habitacion = new Room();
		activa = false;
		visitado = false;
	}


	/**
	 * @return the habitacion
	 */
	public Room getHabitacion() {
		return habitacion;
	}


	/**
	 * @param habitacion the habitacion to set
	 */
	public void setHabitacion(Room habitacion) {
		this.habitacion = habitacion;
	}


	/**
	 * @return the activa
	 */
	public boolean isActiva() {
		return activa;
	}


	/**
	 * @param activa the activa to set
	 */
	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	/**
	 * @return the visitado
	 */
	public boolean isVisitado() {
		return visitado;
	}


	/**
	 * @param visitado the visitado to set
	 */
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}







	
	

}
