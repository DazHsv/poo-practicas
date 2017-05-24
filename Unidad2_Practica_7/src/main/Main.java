package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de calificaciones para alumnos.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Sistema de Calificacines. Version 1.0");
		String alumnoFormat = "%s - %s %n" + "%s° %s %n" + "Materias: %n%s %n" + "Aprovado: %s";
		
		try(Scanner s = new Scanner(System.in)) {
			Alumno a = new Alumno();
			
			System.out.println("Nueva entrada: Alumno...");
			System.out.print("Nombre: ");
			a.setName(s.nextLine());
			System.out.print("No. Control: ");
			a.setNcontrol(s.nextLine());
			System.out.print("Carrera: ");
			a.setCarrer(s.nextLine());
			System.out.print("Semestre: ");
			a.setSem(s.nextLine());
			
			System.out.println("Nueva entrada: Materias...");
			while(true) {
				Materia m = new Materia();
				System.out.print("Nombre: ");
				m.setName(s.nextLine());
				System.out.print("Calificacion: ");
				m.setNote(Byte.valueOf(s.nextLine()));
				
				if(a.addMateria(m))
					System.out.println("Materia agregada.");
				else
					System.out.println("Problemas al agregar la materia.");
				
				System.out.print("Agregar otra materia? (s/n): ");
				if(s.nextLine().toLowerCase().equals("n")) break;
			}
			
			System.out.println("\nDetalles de la entrada...");
			System.out.format(alumnoFormat,
					a.getNcontrol(), a.getName(), a.getSem(), a.getCarrer(),
					a.getMaterias(), (a.isAprovated() ? "Si" : "No"));
		}
	}
}

class Alumno {
	private String name;
	private String ncontrol;
	private String carrer;
	private String sem;
	private ArrayList<Materia> materias;
	
	public Alumno() {
		this.name = "";
		this.ncontrol = "";
		this.carrer = "";
		this.sem = "";
		this.materias = new ArrayList<>(2);
	}
	
	public void setName(String name) { this.name = name; }
	public void setNcontrol(String ncontrol) {this.ncontrol = ncontrol; }
	public void setCarrer(String carrer) { this.carrer = carrer; }
	public void setSem(String sem) { this.sem = sem; }
	public boolean addMateria(Materia materia) { return this.materias.add(materia); }
	
	public String getName() { return this.name; }
	public String getNcontrol() { return this.ncontrol; }
	public String getCarrer() { return this.carrer; }
	public String getSem() { return this.sem; }
	public String getMaterias() {
		String ms = "";
		for (Materia materia : materias)
			ms += String.format(" %s - %s%n", materia.getName(), Byte.toString(materia.getNote()));
		return ms;
	}
	public boolean isAprovated() {
		short q = 0;
		for (Materia materia : materias)
			q += materia.getNote();
		q /= this.materias.size();
		return !(q < 70);
	}
}

class Materia {
	private String name;
	private byte note;
	
	public Materia() {
		this.name = "";
		this.note = 0;
	}
	
	public void setName(String name) { this.name = name; }
	public void setNote(byte note) { this.note = note; }
	
	public String getName() { return this.name; }
	public byte getNote() { return this.note; }
}