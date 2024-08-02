package Programa;

import java.awt.EventQueue;
import TDAColaConPrioridad.*;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import TDALista.*;
public class GUI {
    
	private PriorityQueue<String,String>cola; 
	private JFrame frame;
	private JFrame frameLista;
	private JTextField textEntrada;
	private JTextField textSalida;
    private PositionList<String>list,list1,list2;
    private ComparadorString<String>comp;
    private Comparador2<String>comp2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Palabreitor 2000");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Programa programa=new Programa();
		textEntrada = new JTextField();
		textEntrada.setBounds(10, 121, 197, 20);
		frame.getContentPane().add(textEntrada);
		textEntrada.setColumns(10);
		
		JLabel lblIngreseElementos = new JLabel("Panel Entrada");
		lblIngreseElementos.setBounds(42, 96, 165, 14);
		frame.getContentPane().add(lblIngreseElementos);

		JButton btnMostrarLista = new JButton("Mostrar Lista");
		JButton btnAgregrarElemento = new JButton("Agregrar elemento");
		
		JButton btnMostarOrdenAlfabtico;
		 btnMostarOrdenAlfabtico = new JButton("Mostar en orden Alfab\u00E9tico");
		 btnMostarOrdenAlfabtico.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		comp=new ComparadorString<String>();
		 		cola=new Heap<String,String>(list.size()+1,comp);
		 	try{
		 		for(Position<String>pos: list.positions())
		 			cola.insert(pos.element(),pos.element());
		 		 
		 		    list1=programa.heapSort(comp, list);
		 		    String s="";
		 		    for(Position<String>pos: list1.positions())
		 		    	s+=pos.element()+"\n";
		 		  textSalida.setText(s);  
		 		    
		 	   }
		 	catch(InvalidKeyException e1){System.out.println(e1.getMessage());}
		 	
		 	}
		 });
			btnMostarOrdenAlfabtico.setEnabled(false);
			btnMostarOrdenAlfabtico.setBounds(532, 348, 188, 23);
			frame.getContentPane().add(btnMostarOrdenAlfabtico);
			
			JButton btnNewButton = new JButton("Mostrar en orden Alfab\u00E9tico inverso");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comp2=new Comparador2<String>();
			 		cola=new Heap<String,String>(list.size()+1,comp2);
			 	try{
			 		for(Position<String>pos: list.positions())
			 			cola.insert(pos.element(),pos.element());
			 		 
			 		    list1=programa.heapSort(comp2, list);
			 		    String s="";
			 		    for(Position<String>pos: list1.positions())
			 		    	s+=pos.element()+"\n";
			 		  textSalida.setText(s);  
			 		    
			 	   }
			 	catch(InvalidKeyException e1){System.out.println(e1.getMessage());}
				}
			});
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(532, 388, 252, 23);
			frame.getContentPane().add(btnNewButton);
	

		btnAgregrarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.addLast(textEntrada.getText());
				textEntrada.setText("");
				btnMostrarLista.setEnabled(true);
				btnMostarOrdenAlfabtico.setEnabled(true);
				btnNewButton.setEnabled(true);
				
			
			}
		});
		btnAgregrarElemento.setBounds(239, 120, 181, 23);
		frame.getContentPane().add(btnAgregrarElemento);
		btnAgregrarElemento.setEnabled(false);
		
		textSalida = new JTextField();
		textSalida.setBounds(10, 232, 476, 255);
		frame.getContentPane().add(textSalida);
		textSalida.setColumns(10);
		
		
		JButton btnCrearLista = new JButton("Crear Lista");
		btnCrearLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			list=new SingleLinkedList<String>();
				JOptionPane.showMessageDialog(null, "La lista fue creada ya puede cargarle datos", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE); 
				btnAgregrarElemento.setEnabled(true);
				
			}
		});
		btnCrearLista.setBounds(253, 11, 167, 23);
		frame.getContentPane().add(btnCrearLista);
		
		JLabel lblPanelDeSalida = new JLabel("Panel de salida");
		lblPanelDeSalida.setBounds(97, 207, 111, 14);
		frame.getContentPane().add(lblPanelDeSalida);
		
		JButton btnBorrarPanel = new JButton("Borrar Panel");
		btnBorrarPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textSalida.setText("");
			
			}
		});
		btnBorrarPanel.setBounds(532, 257, 143, 23);
		frame.getContentPane().add(btnBorrarPanel);
		
		
		
		btnMostrarLista.setEnabled(false);
		btnMostrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux ="\n";
				for(Position<String>pos: list.positions())
				  aux+=" "+pos.element()+"\n";
				  textSalida.setText(aux);}
		});
		btnMostrarLista.setBounds(532, 302, 143, 23);
		frame.getContentPane().add(btnMostrarLista);
		
		
		
		
	}
}
