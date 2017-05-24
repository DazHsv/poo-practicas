package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * CONCENTRA LAS PRATICAS: 12, 13
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int pos = 0, neg = 0, neu = 0;
		Numero n = new Numero();
		
		try(Scanner s = new Scanner(System.in)) {
			System.out.print("Cantidad de numeros: ");
			for(int i = 0, l = Integer.parseInt(s.nextLine()); i < l; i++ ) {
				System.out.print("Numero: ");
				n.add(Integer.parseInt(s.next()));
			}
			
			for (Integer i : n.getNumeros()) {
				if(i < 0) neg++;
				else if(i > 0) pos++;
				else neu++;
			}
		}
		
		System.out.format("%s %n +: %d %n -: %d %n 0: %d", n.toString(), pos, neg, neu);
	}
}

class Numero {
	private ArrayList<Integer> v;
	
	public Numero() { this.v = new ArrayList<>(10); }
	
	public ArrayList<Integer> getNumeros() { return v; }
	public void add(int n) { this.v.add(n); }
	public void set(int n, int index) { this.v.set(index, n); }
	
	@Override
	public String toString() {
		String s = "";
		for (Integer integer : v)
			s += integer + (v.indexOf(integer) == (v.size() - 1) ? "" : ",");
		return s;
	}
}