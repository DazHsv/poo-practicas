package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de Factura de Productos.
 * 
 * */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Sistema de factura de productos. Version 1.0");
		String productoFormat = "%s - %s%n " + "%s | $%.02f%n " + "IVA: %.02f%n " +
								"Subtotal: $%.02f | Cantidad: %d | Total: $%.02f%n";
		String facturaFormat = "Factura del dia: %s%n" + "Productos:%n%s%n" + "Productos con IVA: %d%n" +
								"Subtotal: $%.02f | Total: $%.02f";
		String[] productosIva = {"lacteos", "muebles","electronica"};
		Factura factura = new Factura(productosIva);
		
		try(Scanner s = new Scanner(System.in)) {
			while(true) {
				Producto p;
				System.out.println("Etapa: Ingreso de Productos...");
				System.out.print("Clave de Producto: ");
				p = new Producto(s.nextLine().toUpperCase());
				System.out.print("Nombre del producto: ");
				p.setName(s.nextLine().toUpperCase());
				System.out.print("Departamento: ");
				p.setDepartament(s.nextLine().toLowerCase());
				System.out.print("Precio: $");
				p.setPrice(Double.parseDouble(s.nextLine()));
				System.out.print("Cantidad: ");
				
				if(factura.addProduct(p, Integer.parseInt(s.nextLine())))
					System.out.println("Producto agregado.");
				else
					System.out.println("Error al agregar el producto.");
				
				System.out.print("Agregar otro producto? (s/n): ");
				if(s.nextLine().toLowerCase().equals("n")) break;
			}
		}
		
		System.out.println("Etapa: Impresion de factura...");
		
		String facturaBody = "";
		for (Item item : factura.getProductos()) {
			Producto p = item.getProducto();
			double total = item.getQuantity() * (p.getPrice() + (p.getPrice() * p.getIvaPercent()) );
			facturaBody += String.format(productoFormat,
					p.getCproduct(), p.getName(), p.getDepartament(), p.getPrice(), p.getIvaPercent(),
					(p.getPrice() * item.getQuantity()), item.getQuantity(), total);
		}
		
		String f = String.format(facturaFormat,
				factura.getDate(), facturaBody, factura.getHasIva(), factura.getSubtotal(), factura.getTotal());
		
		System.out.println(f);
	}
}