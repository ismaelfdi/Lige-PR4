package lige.grupo03.pr4.vista;

import java.awt.BorderLayout;
import java.awt.Color;
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
		JLabel lblPuntuacion = new JLabel(mensaje, Label.LEFT);
		
		/*Creacion de la Tabla de puntuacion*/
		String cabecera[] = {"Id", "Descripción"};
		String rowData[][] = inventarioJugador.getRowData(); 
		
		/*
		rowData = new Object[][]{{"Id1", "--item[Id1]=Descripcion1//1"},
							  {"Id2", "--item[Id2]=Descripcion2//2"},
							  {"Id3", "--item[Id3]=Descripcion3//1"},
							  {"Id4", "--item[Id4]=Descripcion4//1"},
							  {"Id5", "--item[Id5]=Descripcion5//1"},
							  {"Id9", "--item[Id9]=Descripcion9//1"},
							  {"Id9", "--item[Id9]=Descripcion9//1"},
							  {"Id10", "--item[Id10]=Descripcion10//1"}};
		*/
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
		return (String) rowData[fila][1];	
	}

	/**
	 * @param inventarioJugador the inventarioJugador to set
	 */
	public void setInventarioJugador(Lista inventarioJugador) {
		this.inventarioJugador = inventarioJugador;
	}
}
