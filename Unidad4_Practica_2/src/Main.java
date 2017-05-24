import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Practica 2, Unidad 4.
 * @author Hugo Sánchez Velázquez Grupo 2g2B
 * @version 1.0
 * */

public class Main {
	public static void main(String[] args) {
		// Prueba de productos
		ArrayList<Producto> lista = new ArrayList<>();
		lista.add(new Producto("Celular","Electronica",'1',2550));
		lista.add(new Producto("Lavadora","Linea Blanca",'A',6780));
		lista.add(new Producto("Secadora","Linea Blanca",'B',5679));
		
		while(true) {
			try {
				lista.add(new Producto(
						input("Nombre:"),
						input("Departamento:"),
						input("Clave:").charAt(0),
						Double.parseDouble(input("Precio:"))
				));
			} catch(NumberFormatException e) {
				System.err.print("Precio incorrecto.");
			}
			
			if(input("Continuar? (s/n)").toLowerCase().equals("n")) break;
		}
		
		for (Producto producto : lista)
			System.out.format("%s - %s | %s (%s iva) - %.02f %n",
					producto.departamento(), producto.clave(), producto.nombre(), (producto.precio().iva() * 100) + "%",
					producto.precio().precio());
	}
	
	private static String input(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
}

class Producto {
	private final String nombre;
	private final String departamento;
	private final char clave;
	private Precio precio;
	
	public Producto(String nombre, String departamento, char clave, double precio) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.clave = clave;
		this.precio = new Precio(precio, clave, departamento.toLowerCase());
	}

	public Precio precio() {
		return precio;
	}

	public void precio(double precio) {
		this.precio = new Precio(precio, this.clave, this.departamento);
	}

	public String nombre() {
		return nombre;
	}

	public String departamento() {
		return departamento;
	}

	public char clave() {
		return clave;
	}
	
	
}

class Precio {
	private double precio;
	private double iva;
	private Iva[] ivas = {
			new Iva('1',"electronica",0.10),
			new Iva('A',"linea blanca",0.15)
	};
	
	public Precio(double precio, char clave, String departamento) {
		iva = 0;
		for (Iva i : ivas)
			if(clave == i.clave() && departamento.equals(i.departamento()))
				iva = i.iva();
		
		this.precio = precio + (precio * iva);
	}
	
	public double precio() {
		return precio;
	}
	
	public double iva() {
		return iva;
	}
}

class Iva {
	private char clave;
	private String departamento;
	private double iva;
	
	public Iva(char clave, String departamento, double iva) {
		super();
		this.clave = clave;
		this.departamento = departamento;
		this.iva = iva;
	}

	public char clave() {
		return clave;
	}

	public String departamento() {
		return departamento;
	}

	public double iva() {
		return iva;
	}
}