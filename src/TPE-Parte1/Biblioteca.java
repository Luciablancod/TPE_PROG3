package tpEpecial;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Genero> generos;
	private ArrayList<Libro> libros;
	
	public Biblioteca() {
		super();
		this.generos =new ArrayList<>();
		this.libros = new ArrayList<>();
	}
	//O(1)
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	//O(n)
	public boolean contieneGenero(Genero g) {
		boolean contiene = false;
		for(Genero gen: generos) {
			if(gen.getTipoGenero().equals(g.getTipoGenero())){
				contiene = true;
			}
		}
		return contiene;
	}
	//O(1)
	public void addGeneros(String gen) {
		Genero g = new Genero( gen);
		if(generos.isEmpty()) {
			this.generos.add(g);
		}else {
			if(contieneGenero(g)==false) {
					this.generos.add(g);
				}
			}
		}
	//O(n)
	public void addLibroAGenero(Libro libro) {
		for(Genero g: generos) {		
				g.addLibros(libro);
			}
		}	

	//O(n*n)
	public  ArrayList<Libro> listarLibrosXGenero(Genero genero){
		ArrayList<Libro>librosPorGen = new ArrayList<Libro>();
		for(Libro lib: libros) {
			if((lib.getGeneros()).contains(genero.getTipoGenero())) {
				librosPorGen.add(lib);	
			}
		}
		return librosPorGen;
	}
	//O(1)
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	//O(1)
	public void addLibros(Libro libro) {
			this.libros.add(libro);
		}

	@Override
	//O(1)
	public String toString() {
		return " " + libros + "";
	}

	//O(1)
	public String toStringG() {
		return " " + generos + "";
	}
	
	
	
	



	
	
	
	
	

}
