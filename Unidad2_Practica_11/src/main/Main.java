package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Calculadora de expresiones aritmeticas con mismo operador y multiples operandos.
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			System.out.println("Ingrese la expresion aritmetica: ");
			System.out.println("(Operadores: +, -, x, /)");
			String expresion = s.nextLine();
			String resultado = "";
			
			if(expresion.contains("+")) {
				int x = 0;
				for(String n : expresion.split("[+]"))
					x += Double.parseDouble(n);
				resultado = "" + x;
			} else if(expresion.contains("-")) {
				int x = 0;
				for(String n : expresion.split("[-]"))
					x -= Double.parseDouble(n);
				resultado = "" + x;
			} else if(expresion.contains("x")) {
				int x = 1;
				for(String n : expresion.split("[x]"))
					x *= Double.parseDouble(n);
				resultado = "" + x;
			} else if(expresion.contains("/")) {
				int x = 0;
				for(String n : expresion.split("[/]"))
					x /= Double.parseDouble(n);
				resultado = "" + x;
			} else {
				resultado = expresion;
			}
			
			System.out.println("Resultado: " + resultado);
		}
	}
}
