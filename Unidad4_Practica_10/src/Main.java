import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Practica 10, Unidad 4.
 * @author Hugo Sánchez Velázquez Grupo 2g2B
 * @version 1.0
 * */

public class Main {
	public static void main(String[] args) {
		Nomina n = new Nomina();
		
		while(true) {
			
			try {
				switch (input("Tipo de empleado: \n 1) Administrativo \n 2) Mantenimiento \n 3) Operativo")) {
				case "1":
					Administrativo a =  new Administrativo(input("Nombre: "), input("Numero emplado: "));
					a.setAntiguedad(input("Antigüedad: "));
					a.setDireccion(input("Dirección: "));
					a.setTelefono(input("Telefono: "));
					a.setSalario(Double.parseDouble(input("Salario diario: ")));
					
					n.add(a);
					break;
				case "2":
					Mantenimiento m =  new Mantenimiento(input("Nombre: "), input("Numero emplado: "));
					m.setAntiguedad(input("Antigüedad: "));
					m.setDireccion(input("Dirección: "));
					m.setTelefono(input("Telefono: "));
					m.setSalario(Double.parseDouble(input("Salario diario: ")));
					
					n.add(m);
					break;
				case "3":
					Operativo o =  new Operativo(input("Nombre: "), input("Numero emplado: "));
					o.setAntiguedad(input("Antigüedad: "));
					o.setDireccion(input("Dirección: "));
					o.setTelefono(input("Telefono: "));
					o.setSalario(Double.parseDouble(input("Salario diario: ")));
					
					n.add(o);
					break;
				default:
					System.out.println("Opcion invalida.");
					break;
				}
			} catch(NumberFormatException e) {
				System.err.println("Salario invalido, no se pudo guardar el empleado.");
			}
			
			if(input("Continuar? s/n:").toLowerCase().equals("n")) break;
		}
		
		System.out.println(n.get());
	}
	
	private static String input(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
}

class Nomina {
	private ArrayList<Personal> lista;
	
	public Nomina() {
		lista = new ArrayList<>();
	}
	
	public void add(Personal p) {
		lista.add(p);
	}
	
	public String get() {
		String nomina = "";
		double aumento = 0;
		
		for (Personal personal : lista) {
			if(personal instanceof Administrativo)
				aumento = personal.getSalario() * 2;
			else if(personal instanceof Mantenimiento)
				aumento = personal.getSalario() * 3;
			else if(personal instanceof Operativo)
				aumento = personal.getSalario() * 4;
			
			nomina += String.format(
					"(%s) %s [%s] | %s años trabajando" +
					"%n $ diario: %.02f | $ semanal: %.02f | $ aumento: %.02f | $ total: %.02f %n %s",
					personal.getNempleado(), personal.getNombre(), personal.getTelefono(),
					personal.getAntiguedad(), personal.getSalario(), personal.getSalario() * 7,
					aumento, (personal.getSalario() * 7) + aumento, personal.getDireccion());
		}
		
		return nomina;
	}
}

class Personal {
	protected final String nombre;
	protected final String nempleado;
	protected String direccion;
	protected String telefono;
	protected String antiguedad;
	protected double salario;
	
	public Personal(String nombre, String nempleado) {
		this.nombre = nombre;
		this.nempleado = nempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNempleado() {
		return nempleado;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public double getSalario() {
		return salario;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}

class Administrativo extends Personal {

	public Administrativo(String nombre, String nempleado) {
		super(nombre, nempleado);
	}
	
}

class Mantenimiento extends Personal {

	public Mantenimiento(String nombre, String nempleado) {
		super(nombre, nempleado);
	}
	
}

class Operativo extends Personal {

	public Operativo(String nombre, String nempleado) {
		super(nombre, nempleado);
	}
	
}