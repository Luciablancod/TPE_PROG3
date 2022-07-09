//package Prog3_TPE2;
package tpVersion26;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;


public class GrafoDirigido<String> implements Grafo<String> {

	private HashMap<String,ArrayList<Arco<String>>> vertices;
	private int cantArcos;



	public GrafoDirigido( int cantArcos) {

		this.vertices = new HashMap<String, ArrayList<Arco<String>>>() ;
		this.cantArcos = 0;
	}

	
	//Agrega un vertice 
	@Override
	public void agregarVertice(String verticeId) {
		if(!contieneVertice(verticeId)){
			vertices.put(verticeId, new ArrayList<Arco<String>>());
		}
	}

	//Comprueba si ya existe el vertice 
	@Override
	public boolean contieneVertice(String verticeId) {
		return vertices.containsKey(verticeId);
	}


	//Crea un arco
	@Override
	public void agregarArco(String verticeId1, String verticeId2, int etiqueta) {
		//if(contieneVertice(verticeId1)&&contieneVertice(verticeId2)){
		if(!existeArco(verticeId1,verticeId2)) {
			Arco<String> newArco1a2 = new Arco<>(verticeId1,verticeId2, etiqueta);
			vertices.get(verticeId1).add(newArco1a2);
			cantArcos++;
		}
	}


	//Borra un arco
	@Override
	public void borrarArco(String verticeId1, String verticeId2) {
		if(existeArco(verticeId1,verticeId2)) {
			ArrayList< Arco<String> >arcos= vertices.get(verticeId1);
			if(arcos!=null) {
				for(int i=0; i<arcos.size();i++) {
					if(arcos.get(i).getVerticeDestino()==verticeId2) {
						arcos.remove(i);
						cantArcos--;
					}
				}
			}	
		}
	}


	//Comprueba si ya hay un arco entre dos vertices
	@Override
	public boolean existeArco(String verticeId1, String verticeId2) {

		if(contieneVertice(verticeId1)) {
			Iterator<Arco<String>> arcos = this.obtenerArcos(verticeId1);
			while(arcos.hasNext()) {
				if(arcos.next().getVerticeDestino().equals(verticeId2)) { 
					return true;
				}	
			}

			return false;
		}
		return false;
	}

	
	//Obtiene un arco entre dos vertices
	@Override
	public Arco<String> obtenerArco(String verticeId1, String verticeId2){ 
		if(contieneVertice(verticeId1)&&contieneVertice(verticeId2)) {
			if(existeArco(verticeId1,verticeId2)) {
				Iterator<Arco<String>> arcos = this.obtenerArcos(verticeId1);
				while(arcos.hasNext()) {
					Arco<String> arco = arcos.next();
					if(arco.getVerticeDestino().equals(verticeId2)) {
						return arco;
					}
				}
				return null;
			}
			return null;				
		}
		return null;
	}



	//Devuelve la cantidad total de vertices
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	//Devuelve la cantidad total de arcos
	@Override
	public int cantidadArcos() {
		return this.cantArcos;
	}

	
	//Devuelve un iterador de vertices
	@Override
	public Iterator<String> obtenerVertices() {
		return vertices.keySet().iterator();

	}

	//Devuelve un iterador de los adyacentes a un vertice
	@Override
	public Iterator<String> obtenerAdyacentes(String verticeId) {
		Iterator <Arco<String>> itInterno = vertices.get(verticeId).iterator();
		return new IteradorAdyacentes<String>(itInterno);
	}
	
	
	//Devuelve un iterador de todos los arcos
	@Override
	public Iterator<Arco<String>> obtenerArcos() {
		Iterator<String> verticesIt = obtenerVertices(); 
		ArrayList<Arco<String>> arcosList = new ArrayList<Arco<String>>();

		while (verticesIt.hasNext()) {		
			String current = verticesIt.next();
			Iterator<Arco<String>> adyacentes = obtenerArcos(current);

			adyacentes.forEachRemaining(arcosList::add);
		}

		return arcosList.iterator(); //O(1)
	}

	
	//Devuelve un iterador de arcos del vertice
	@Override
	public Iterator<Arco<String>> obtenerArcos(String verticeId) {
		ArrayList<Arco<String>> arcosList = new ArrayList<Arco<String>>();

		if (contieneVertice(verticeId)) { 
			arcosList = vertices.get(verticeId);
			return arcosList.iterator();
		}

		return arcosList.iterator();
	}

	//Devuelve los generos más buscados desde un vertice
	public ArrayList<String> generoMasBuscadoA(String generoA, int Ngeneros){
		ArrayList<String> generos = new ArrayList<>();

		ArrayList<Arco<String>> arcos = new ArrayList<>();
		Iterator<Arco<String>> arcosAdya = this.obtenerArcos(generoA);
		arcosAdya.forEachRemaining(arcos::add);
		arcos.sort(Comparator.comparing(Arco<String>::getEtiqueta).reversed());

		for(int i= 0; i< Ngeneros; i++) {
			generos.add(arcos.get(i).getVerticeDestino());
		}
		return generos;
	}
	
	
	//Devuelve la secuencia de vertices de mayor peso desde un vertice
	public ArrayList<String> secuenciaMayorValor(String generoA){
		ArrayList<String> secuenciaMayor = new ArrayList <>();
		String currentGen = generoA;

		while(contieneVertice(currentGen)) { 
			Iterator<Arco<String>> arcosAdya = this.obtenerArcos(currentGen);
			ArrayList<String> genero = generoMasBuscadoA(currentGen, 1);
			secuenciaMayor.add(genero.get(0)); 
		    vertices.remove(currentGen);	
			currentGen = genero.get(0);

		}

		if(!secuenciaMayor.isEmpty()) {
			return secuenciaMayor;
		}
		return null;
	}


	@Override
	public void borrarVertice(String verticeId) {
		vertices.remove(verticeId);
		
	}


	@Override
	public Iterator<Arco<String>> String(String verticeId) {
		return null;
	}
}


