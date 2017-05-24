package main;

/**
 * @author Hugo Sanchez Velazquez
 * 2g3B
 * 
 * Lista de tareas
 * @version 1.0
 * */

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Init {

	public static void main(String[] args) {
		ArrayList<Task> items = null;
		try {
			items = FileHelper.readFrom(FileHelper.FILENAME);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error abriendo el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
			items = new ArrayList<>(0);
		}
		
		MainFrame mf = new MainFrame("Lista de tareas", MainFrame.EXIT_ON_CLOSE, items);
		mf.setVisible(true);
	}

}
