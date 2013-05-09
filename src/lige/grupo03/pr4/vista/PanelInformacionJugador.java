package lige.grupo03.pr4.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import lige.grupo03.pr4.modelo.Lista;

/**
 * Clase que representa el Panel con la informacion del jugador
 * 
 * @author IsmaelLeonidas & Ignacio Lopez
 * @version 1.0
 */
public class PanelInformacionJugador extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable tablaObjetos;
	/*private Object rowData[][];*/
	private Lista inventarioJugador;
	JLabel lblPuntuacion;
	private int vida;
	private int puntuacion;
	
	public PanelInformacionJugador(int vida, int puntuacion, Lista inventarioJugador){
		super();
		this.vida = vida;
		this.puntuacion = puntuacion;
		this.inventarioJugador = inventarioJugador;
		inicializar();
	}
	
	private void inicializar(){

		Border border = BorderFactory.createTitledBorder("Información del jugador");
		this.setBorder(border);
		String mensaje = "Vida: " + vida + "  Puntuación: " + puntuacion;
		lblPuntuacion = new JLabel(mensaje, Label.LEFT);
		
		/*Creacion de la Tabla de puntuacion*/
		String cabecera[] = {"Id", "Descripción"};
		String rowData[][] = inventarioJugador.getRowData(); 
		
		tablaObjetos = new JTable(rowData, cabecera);
		tablaObjetos.setToolTipText("Seleccione el id a usar");
		
		JTableHeader header = tablaObjetos.getTableHeader();
		
		header.setBackground(Color.lightGray);
		
		JScrollPane pane = new JScrollPane(tablaObjetos);
		
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pane.setPreferredSize(tablaObjetos.getPreferredSize());
		
		this.setLayout(new BorderLayout());
		
		this.add(lblPuntuacion, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);		
	}
	
	/**
	 * Metodo que devuelve el texto con la descripcion del item seleccinado
	 * 
	 * @return
	 */
	public String getSelectedITem(){
		
		String [][] rowData = inventarioJugador.getRowData();
		int fila = tablaObjetos.getSelectedRow();
		return (String) rowData[fila][0];	
	}

	/**
	 * @param inventarioJugador the inventarioJugador to set
	 */
	public void setInventarioJugador(Lista inventarioJugador) {
		this.inventarioJugador = inventarioJugador;
	}
	
	public Lista getInventarioJugador(){
		return inventarioJugador;
	}

	public void actualizarEstado(int vida, int puntuacion) {
		
		this.vida = vida;
		this.puntuacion = puntuacion;
		
		this.removeAll();
		inicializar();
		this.updateUI();
	}

	public void actualizarInventario(Lista inventarioJugador) {
		this.inventarioJugador = inventarioJugador;
		this.removeAll();
		inicializar();
		this.updateUI();
	}
}
