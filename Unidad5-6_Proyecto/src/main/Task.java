package main;

/**
 * @author Hugo Sanchez Velazquez
 * 2g3B
 * 
 * Lista de tareas
 * @version 1.0
 * */

public class Task {
	private String name;
	private boolean readed;
	
	public Task(String n) {
		this.name = n;
		this.readed = false;
	}
	
	public Task(String n, boolean r) {
		this.name = n;
		this.readed = r;
	}
	
	public String getName() {
		return name;
	}
	
	public Task rename(String d) {
		this.name = d;
		return this;
	}
	
	public boolean wasDidIt() {
		return readed;
	}
	
	public Task did() {
		this.readed = true;
		return this;
	}

}
