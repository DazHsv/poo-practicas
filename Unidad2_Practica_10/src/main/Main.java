package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * CONCENTRA LAS PRACTICAS: 3, 5, 6, 10
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] acciones = {"Cuadrado","Rectangulo","Triangulo","Circulo"};
		try(Scanner s = new Scanner(System.in)) {
			System.out.println("Area de: ");
			byte index = 1;
			for (String accion : acciones) {
				System.out.println(index + ") " + accion);
				index++;
			}
			
			System.out.println("Elija una opcion: ");
			String resultado = "";
			switch (s.nextLine()) {
			case "1":
				double base = input("Base: ", s);
				resultado = String.valueOf(new Cuadrado(base, base).getArea());
				break;
			case "2":
				resultado = String.valueOf(new Rectangulo(input("Base: ",s), input("Altura: ",s)).getArea());
				break;
			case "3":
				resultado = String.valueOf(new Triangulo(input("Base: ", s), input("Altura: ", s)).getArea());
				break;
			case "4":
				resultado = String.valueOf(new Circulo(input("Radio: ", s)).getArea());
				break;
				
			default:
				resultado = "Error.";
				break;
			}
			
			System.out.println("Resultado: " + resultado);
		}
	}
	
	private static double input(String msg, Scanner s) {
		System.out.print(msg);
		return Double.parseDouble(s.nextLine());
	}
}

class Poligono {
	private double altura;
	private double base;
	
	public Poligono(double b, double a) {
		this.altura = a;
		this.base = b;
	}
	
	public double getAltura() { return altura; }
	public double getBase() { return base; }
	public double getArea() { return base * altura; }
	
	public void setAltura(double altura) { this.altura = altura; }
	public void setBase(double base) { this.base = base; }
}

class Cuadrado extends Poligono { public Cuadrado(double b, double a) { super(b,a); } }

class Rectangulo extends Poligono { public Rectangulo(double b, double a) { super(b,a); } }

class Triangulo extends Poligono {
	public Triangulo(double b, double a) { super(b,a); }
	
	@Override
	public double getArea() { return (super.getBase() * super.getAltura()) / 2; }
}

class Circulo {
	private double radio;
	
	public Circulo(double r) { this.radio = r; }
	
	public double getRadio() { return radio; }
	public double getArea() { return Math.PI * Math.pow(radio, 2); }
	
	public void setRadio(double radio) { this.radio = radio; }
}