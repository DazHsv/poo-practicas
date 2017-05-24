package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * CONCENTRA LAS PRACTICAS: 14, 19
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Vect v;
		try(Scanner s = new Scanner(System.in)) {
			v = new Vect();
			
			while(true) {
				System.out.print("Numero (A): ");
				v.addToA(Integer.parseInt(s.nextLine()));
				System.out.print("Numero (B): ");
				v.addToB(Integer.parseInt(s.nextLine()));
				
				System.out.print("Agregar otro? (s/n):");
				if(s.nextLine().toLowerCase().equals("n")) break;
			}
		}
		
		System.out.println("Suma total:");
		for (Integer i : v.getSumArray()) System.out.print(i + " ");
	}
}

class Vect {
	private ArrayList<Integer> a;
	private ArrayList<Integer> b;
	private ArrayList<Integer> c;
	
	public Vect() {
		this.a = new ArrayList<>();
		this.b = new ArrayList<>();
		this.c = new ArrayList<>();
	}
	
	public ArrayList<Integer> getSumArray() {
		sum();
		return this.c;
	}
	public int size() {
		return (a.size() < b.size()? b.size() : a.size());
	}
	
	public void addToA(int x) { this.a.add(x); }
	public void addToB(int x) { this.b.add(x); }
	
	private void sum() {
		int index = 0, s = size();
		do {
			c.add(a.get(index)+b.get(index));
			index++;
		} while(index < s);
	}
}