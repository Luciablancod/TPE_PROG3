package tpEpecial;

import java.util.ArrayList;

public class Libro {
	private String titulo;
	private String autor;
	private String cantPaginas;
	private ArrayList<String> generos;
	
	
	
	public Libro(String titulo, String autor, String cantPaginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.cantPaginas = cantPaginas;
		this.generos = new ArrayList<>();
	}
	
	//O(1)
	public String getTitulo() {
		return titulo;
	}
	//O(1)
	public void addTitulo(String titulo) {
		this.titulo = titulo;
	}
	//O(1)
	public String getAutor() {
		return autor;
	}
	//O(1)
	public void addAutor(String autor) {
		this.autor = autor;
	}
	//O(1)
	public String getCantPaginas() {
		return cantPaginas;
	}
	//O(1)
	public void addCantPaginas(String cantPaginas) {
		this.cantPaginas = cantPaginas;
	}
	//O(1)
	public ArrayList<String> getGeneros() {
		return generos;
	}
	//O(1)
	public void addGenero(String genero) {
		this.generos.add(genero);
	}

	@Override
	//O(1)
	public String toString() {
		return "libro [titulo=" + titulo + ", autor=" + autor + ", cantPaginas=" + cantPaginas + ", generos=" + generos
				+ "]";
	}
	
	@Override
	//O(1)
	public boolean equals(Object o) {
		return this.titulo.equals(((Libro)o).titulo);
		
	}
	

	

}
