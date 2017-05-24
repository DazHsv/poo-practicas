package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * @version 1.0
 * GRUPO 2g2B
 * SISTEMA DE PRODUCTOS COMPLETO
 * CONCENTRA LAS PRACTICAS: 4, 9, 21
 * */

public class Main {
	public static void main(String[] args) {
		Bill bill = new Bill();
		try(Scanner s =  new Scanner(System.in)){
			System.out.println("Etapa: Creacion de producto...");
			while(true) {
				Product p = new Product(input("Clave: ",s),
						input("Nombre: ",s), input("Departamento: ",s),
						Double.parseDouble(input("Precio inicial: ", s)));
				
				while(true) {
					if(p.addPrice(Double.parseDouble(input("Nuevo precio: ", s))))
						System.out.println("Precio agregado.");
					else
						System.out.println("Problema al agregar el precio.");
					
					if(input("Agregar otro precio al historial? (s/n): ", s).toLowerCase().equals("n"))
						break;
				}
				
				if(bill.addProduct(p))
					System.out.println("Producto agregado.");
				else
					System.out.println("Problema al agregar el producto.");
				
				if(input("Agregar otro producto? (s/n): ", s).toLowerCase().equals("n"))
					break;
			}
		}
		
		System.out.println("Etapa: Desglose de informacion...");
		String productFormat = "";
		byte promPriceOverT = 0;
		for (Product p : bill.getProducts()) {
			if(p.getPriceProm() > 1000) promPriceOverT++;
			String priceFormat = "";
			byte index = 0;
			for (double d : p.getPriceHistory()) {
				priceFormat += String.format("  %d) %.02f %n", index, d);
				index++;
			}
			
			productFormat += String.format("%s | %s %n %s %n Historial de precios:%n%s "+
					"Promedio de precios: %.02f %n IVA: %.02f %n Subtotal: %.02f %n Total: %.02f %n",
					p.getKey().toUpperCase(), p.getName().toUpperCase(), p.getDepartament().toUpperCase(),
					priceFormat, p.getPriceProm(), p.getIva() ,p.getPrice(), p.getPrice() + p.getIva());
		}
		
		System.out.format("Fecha: %s %n Productos:%n %s %n"
				+ "%d%s de los productos tuvieron un precio promedio mayor a $1000%n",
				bill.getDate(), productFormat, (promPriceOverT / bill.getProducts().size()) * 100, "%");
	}
	
	private static String input(String msg, Scanner s) {
		System.out.print(msg);
		return s.nextLine();
	}
}

class Product {
	private final String name;
	private final String key;
	private final String departament;
	private ArrayList<Double> priceHistory;
	
	public Product(String k, String n, String d, double p) {
		this.name = n;
		this.key = k;
		this.departament = d;
		this.priceHistory = new ArrayList<>();
		addPrice(p);
	}
	
	public boolean addPrice(double p) { return priceHistory.add(p); }
	
	public String getName() { return name; }
	public String getKey() { return key; }
	public String getDepartament() { return departament; }
	public ArrayList<Double> getPriceHistory() { return priceHistory; }
	public double getPrice() { return priceHistory.get(priceHistory.size() - 1);}
	public double getPriceProm() {
		double d = 0;
		for (Double p : priceHistory) d += p;
		return (d / priceHistory.size());
	}
	public double getIva() { return getPrice() * 0.10; }
}

class Bill {
	private final String date;
	private ArrayList<Product> products;
	
	public Bill() {
		this.date = createDate();
		this.products = new ArrayList<>();
	}
	
	public boolean addProduct(Product p) { return products.add(p); }
	
	public String getDate() { return date; }
	public ArrayList<Product> getProducts() { return products; }
	
	private String createDate() {
		Calendar c = Calendar.getInstance();
		return String.format("%s/%s/%s", c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.MONTH), c.get(Calendar.YEAR));
	}
}