package tpEpecial;

import java.util.ArrayList;

public class Genero {
	private String tipoGenero;
	private ArrayList<Libro> libros;
	
	public Genero(String tipoGenero) {
		super();
		this.tipoGenero = tipoGenero;
		this.libros = new ArrayList<>();
	}
	//O(1)
	public String getTipoGenero() {
		return tipoGenero;
	}

	//O(1)
	public void addTipoGenero(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	//O(1)
	public ArrayList<Libro> getLibrosPorGenero() {
		return libros;
	}

	//O(1)
	public void addLibros(Libro libro) {
			this.libros.add(libro);
		}	

	@Override
	//O(1)
	public String toString() {
		return "Genero " + tipoGenero +  " ";
	}
	
	@Override
	//O(1)
	public boolean equals(Object o) {
		return this.tipoGenero.equals(((Genero)o).getTipoGenero());
		
	}
	


	
	
	
	
	

}
