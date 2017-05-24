package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de Nómina para empleados.
 * */

public class Main {
	public static void main(String[] args) {
		System.out.println("Sistema de Nomina. Version 1.0");
		ArrayList<Empleado> empleados = new ArrayList<>(5);
		String empleadoformat = "%s - %s %n" + " Turno: %s | %s %n" + " Salario: %.02f %n" + 
								" ISR: %.02f %n" + " Aumento: %d %n" + " Salario Diario: %.02f %n" +
								" Salario semanal: %.02f %n";
		
		try(Scanner s = new Scanner(System.in)) {
			while(true) {
				System.out.println("Etapa: Ingresar empleados.");
				System.out.println("Creando empleado...");
				Empleado e = new Empleado();
				
				System.out.print("Nombre: ");
				e.setName(s.nextLine().toUpperCase());
				System.out.println("No. Empleado: ");
				e.setNemployed(s.nextLine().toUpperCase());
				System.out.print("Departamento: ");
				e.setDepartament(s.nextLine().toUpperCase());
				System.out.print("Turno (m/v): ");
				e.setTurn(s.nextLine().toUpperCase().charAt(0));
				System.out.print("Salario diario: ");
				e.setSalary(Double.parseDouble(s.nextLine()));
				
				if(empleados.add(e))
					System.out.println("Empleado agregado.");
				else
					System.out.println("Problemas agregando empleado.");
				
				System.out.println("Agregar otro empleado? (s/n): ");
				if(s.nextLine().toLowerCase().equals("n")) break;
			}
		}
		
		System.out.println("Estapa: Listado de nomina...");
		for (Empleado empleado : empleados) {
			double salary = empleado.getSalary(),
					isr = salary * 0.02,
					s = salary - isr + empleado.getPlusByTurn();
			System.out.format(empleadoformat, empleado.getNemployed(), empleado.getName(),
					empleado.getTurn(), empleado.getDepartament(), salary,
					isr, empleado.getPlusByTurn(), s, s * 7);
		}
	}
}

class Empleado {
	private String name;
	private String nemployed;
	private String departament;
	private char turn;
	private double salary;
	
	public Empleado() {
		this.name = "";
		this.nemployed = "";
		this.departament = "";
		this.turn = 'm';
		this.salary = 0;
	}
	
	public void setName(String n) { this.name  = n; }
	public void setNemployed(String ne) { this.nemployed = ne; }
	public void setDepartament(String d) { this.departament = d; }
	public void setTurn(char t) { this.turn = t; }
	public void setSalary(double s) { this.salary = s; }
	
	public String getName() { return this.name; }
	public String getNemployed() { return this.nemployed; }
	public String getDepartament() { return this.departament; }
	public char getTurn() { return this.turn; }
	public double getSalary() { return this.salary; }
	public int getPlusByTurn() { return (this.turn == 'M'? 400 : 600); }
}