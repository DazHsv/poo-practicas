package main;

/**
 * @author Hugo Sanchez Velazquez
 * 2g3B
 * 
 * Lista de tareas
 * @version 1.0
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {
	public static final String FILENAME = "list.store";
	public static final String BACKUP_FILENAME = "list.backup";
	public static final String ICON = "icon.png";

	public static void writeTo(Task[] i, String fn) throws IOException {
		File f = new File(fn);
		try(FileWriter fw = new FileWriter(f, false)) {
			for (Task item : i) {
				fw.write(String.format("%s,%b%n", item.getName(), item.wasDidIt()));
			}
		}
	}

	public static ArrayList<Task> readFrom(String fn) throws IOException {
		ArrayList<Task> items = new ArrayList<>();
		File f = new File(fn);
		String[] aux;
		String temp = "";
		int c = 0;
		
		try(FileReader fr = new FileReader(f)) {
			Task i;
			while(c != -1) {
				while(true) {
					c = fr.read();
					if(c == 10 || c == -1)
						break;
					temp += (char) c;
				}
				
				if(c != -1) {
					aux = temp.split(",");
					i = new Task(aux[0]);
					if(aux[1].compareTo("true") == 1)
						i = i.did();
					items.add(i);
					temp = "";
				}
			}
			
		} catch (FileNotFoundException fnf) {
			f.createNewFile();
		}
		
		return items;
	}

}
