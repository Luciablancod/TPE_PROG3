package tpEpecial;


import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


public class CSVWritter {

	private String path;

	public void generarCSV(LinkedList<Libro> libros) {

		BufferedWriter bw = null;
		try {
			File file = new File(this.path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			Iterator<Libro> itLib= libros.iterator();
			
			while(itLib.hasNext()) {
				bw.write(itLib.next().getTitulo());
				bw.newLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}

	}

	public void setPath(String path) {

		this.path=path;
	}
}
