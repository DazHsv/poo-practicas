package main;

import java.util.Scanner;

/**
* @author Hugo Sanchez Velazquez
* @version 1.0
* Grupo 2g2B
* Programa que imprimer el área de un triángulo.
*/

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Triangulo t = new Triangulo();

		System.out.print("Base: ");
		t.setBase(Double.parseDouble(s.nextLine()));
		System.out.print("Altura: ");
		t.setHeight(Double.parseDouble(s.nextLine()));

		System.out.println("Area: " + t.getArea());
		
		s.close();
	}
}

class Triangulo {
	  private double base;
	  private double height;

	  public Triangulo() {
		  this.base = 0;
		  this.height = 0;
	  }

	  public Triangulo(double base, double height) {
		  this.base = base;
		  this.height = height;
	  }

	  public double getBase() { return this.base; }
	  public double getHeight() { return this.height; }
	  public double getArea() { return (this.base * this.height) / 2; }

	  public void setBase(double base) { this.base = base; }
	  public void setHeight(double height) { this.height = height; }
}