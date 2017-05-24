
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Practica 4, Unidad 4.
 * @author Hugo Sánchez Velázquez Grupo 2g2B
 * @version 1.0
 * */

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Figura> lista = new ArrayList<>();
		
		while(true) {
			switch(input("Menu - Crear un: \n 1) Cuadrado \n 2) Rectangulo \n 3) Triangulo \n 0) Salir \n Opcion:")) {
			case "0":
				break;
			case "1":
				lista.add(new Cuadrado(Double.parseDouble(input("Base:"))));
				break;
			case "2":
				lista.add(new Rectangulo(
						Double.parseDouble(input("Base:")),
						Double.parseDouble(input("Altura:"))));
				break;
			case "3":
				lista.add(new Triangulo(
						Double.parseDouble(input("Base:")),
						Double.parseDouble(input("Altura:"))));
				break;
				default:
					System.err.println("No es una opcion valida.");
			}
			
			if(input("continuar? (s/n)").toLowerCase().equals("n")) break;
		}
		
		for (Figura figura : lista) {
			if(figura instanceof Cuadrado)
				System.out.print("Cuadrado");
			else if(figura instanceof Rectangulo)
				System.out.print("Rectangulo");
			else if(figura instanceof Triangulo)
				System.out.print("Triangulo");
			System.out.println(", Base: " + figura.b + ", Altura: " + figura.h + ", Area: " + figura.area());
		}
	}
	
	private static String input(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
}

class Figura implements Estructura {
	protected double b,h;
	
	public Figura(double b, double h) {
		this.b = b;
		this.h = h;
	}
	
	@Override
	public double base() {
		return b;
	}

	@Override
	public double altura() {
		return h;
	}

	@Override
	public void base(double b) {
		this.b = b;
	}

	@Override
	public void altura(double h) {
		this.h = h;
	}
	
	@Override
	public double area() {
		return b * h;
	}
}

interface Estructura {
	double base();
	double altura();
	double area();
	void base(double b);
	void altura(double h);
}

class Cuadrado extends Figura  {

	public Cuadrado(double b) {
		super(b, b);
	}

	@Override
	public double area() {
		return super.b * super.b;
	}
	
}

class Rectangulo extends Figura {

	public Rectangulo(double b, double h) {
		super(b, h);
	}
}

class Triangulo extends Figura {

	public Triangulo(double b, double h) {
		super(b, h);
	}

	@Override
	public double area() {
		return (super.b * super.h) / 2;
	}
	
}