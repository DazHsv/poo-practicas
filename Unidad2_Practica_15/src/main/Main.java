package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de califiaciones COMPLETO
 * Concentra las practicas: 7, 15, 16, 17, 18, 20 
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Sistema de calificaciones de Alumnos. Version 1.0");
		ArrayList<Student> students = new ArrayList<>();
		try(Scanner s = new Scanner(System.in)) {
			while(true) {
				System.out.println("Etapa: Ingreso de alumno...");
				Student student = new Student(input("No. Control: ", s), input("Nombre: ", s));
				student.setSem(input("Semestre: ", s));
				student.setCarrer(input("Carrera: ", s));
				
				System.out.println("\nEtapa: Ingreso de calificaciones...");
				while(true) {
					Asignature a = new Asignature(input("Nombre: ", s));
					for(byte i = 0;  i < 5; i++)
						a.addNote(Byte.valueOf(input("Calificacion (" + i + "): ", s)));
					
					if(student.addAsignature(a))
						System.out.println("Materia agregada.");
					else
						System.out.println("Problemas al agregar la materia.");
					
					if(input("Agregar otra materia? (s/n): ", s).toLowerCase().equals("n"))
						break;
				}
				
				if(students.add(student))
					System.out.println("Alumno agregado.");
				else
					System.out.println("Problemas para agregar el alumno.");
				
				if(input("Agregar otro alumno? (s/n): ", s).toLowerCase().equals("n"))
					break;
			}
		}
		
		System.out.println("\nEtapa: Desglose de archivo...");
		for (Student student : students) {
			String asignaturesBody = "";
			for (Asignature asignature : student.getAsignatures())
				asignaturesBody += " | " + asignature.getName().toUpperCase() + " - " +
									asignature.getProm() + "\n";
			
			System.out.format("%s - %s %n %s° | %s %n "
					+ "Desglose de materias:%n%s %n Promedio: %d %n Aprovado: %s%n%n",
					student.getNcontrol(), student.getName().toUpperCase(), student.getSem(),
					student.getCarrer().toUpperCase(), asignaturesBody, student.getProm(),
					(student.isAprovated() ? "Si" : "No"));
		}
	}
	
	private static String input(String msg, Scanner s) {
		System.out.print(msg);
		return s.nextLine();
	}
}

class Student {
	private final String ncontrol;
	private final String name;
	private String sem;
	private String carrer;
	private ArrayList<Asignature> asignatures;
	private byte prom;
	
	public Student(String nc, String n) {
		this.ncontrol = nc;
		this.name = n;
		this.sem = "";
		this.carrer = "";
		this.asignatures = new ArrayList<>();
		this.prom = 0;
	}
	
	public void setSem(String sem) { this.sem = sem; }
	public void setCarrer(String carrer) { this.carrer = carrer; }
	public boolean addAsignature(Asignature a) {
		return this.asignatures.add(a);
	}
	public void removeAsignature(Asignature a) { this.asignatures.remove(a); }
	public void setProm(byte prom) { this.prom = prom; }
	
	public String getNcontrol() { return ncontrol; }
	public String getName() { return name; }
	public String getSem() { return sem; }
	public String getCarrer() { return carrer; }
	public ArrayList<Asignature> getAsignatures() { return asignatures; }
	public byte getProm() {
		prom();
		return prom;
	}
	public boolean isAprovated() { return !(this.prom < 70); }
	
	private void prom() {
		int z = 0;
		for (Asignature asignature : asignatures) z += asignature.getProm();
		this.prom = (byte) (z / asignatures.size());
	}
}

class Asignature {
	private final String name;
	private ArrayList<Byte> notes;
	
	public Asignature(String n) {
		this.name = n;
		this.notes = new ArrayList<>();
	}
	
	public void addNote(byte note) { this.notes.add(note); }
	
	public String getName() { return name; }
	public ArrayList<Byte> getNotes() { return notes; }
	public byte getNote(int index) { return notes.get(index); }
	public byte getProm() {
		int z = 0;
		for (Byte n : notes) z += n;
		return (byte) (z / notes.size());
	}
}