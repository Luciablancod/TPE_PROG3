//package Prog3_TPE2;
package tpVersion26;
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
	import java.util.List;


	public class GenerosCiclo {
		private Grafo <String> grafo;
		private HashMap<String,String>colores;
		private HashSet<String> verticesAfines;
		private Grafo <String> grafoCopia;
		
		public GenerosCiclo (Grafo <String> grafo) {
			this.grafo = grafo;
			this.verticesAfines = new HashSet<>();
			this.grafoCopia =  new GrafoDirigido<>(0);
		}
		
		//RESUELTO CON BACKTRACKING

		public Grafo ciclosDesde(String generoA) {
			HashSet <String> caminoParcial = new HashSet<String>();
			generosAfines(generoA,generoA,caminoParcial);
			
			List<String> vertices = new ArrayList<String>(verticesAfines);

//			System.out.println(vertices);
			
			for(int i=0; i< (vertices.size()-1) ; i++ ) {
				grafoCopia.agregarVertice(vertices.get(i));
				grafoCopia.agregarVertice(vertices.get(i+1));
				grafoCopia.agregarArco(vertices.get(i),vertices.get(i+1), 1);
			}
			return this.grafoCopia;
		}

		public  void  generosAfines(String vertice, String generoA,HashSet<String> caminoParcial ){
			Iterator<String> it = this.grafo.obtenerAdyacentes(vertice);
			while(it.hasNext()) {
				String adyacente = it.next();

				if(adyacente.equals(generoA)) {
					this.verticesAfines.addAll(caminoParcial);

				}else if(!caminoParcial.contains(adyacente)){
					caminoParcial.add(adyacente);
					generosAfines(adyacente,generoA, caminoParcial);
					caminoParcial.remove(adyacente);
				}
			}
		}
		
		//INTENTO CON DFS
		
		public  ArrayList<String> hayCiclo(String generoA) {
			
			Iterator<String> it = this.grafo.obtenerVertices();
			while (it.hasNext()) {
				String verticeId = it.next();
				colores.put(verticeId, "blanco");
			}
			ArrayList<String> caminoParcial = new ArrayList<String>();
			verticesAfines  = dfs_visit(generoA,generoA,caminoParcial);
			return verticesAfines;	
		}
		
		public  ArrayList<String>   dfs_visit(String vertice, String generoA,ArrayList<String> caminoParcial ){
			colores.put(vertice, "amarillo");
			Iterator<String> it = this.grafo.obtenerAdyacentes(vertice);
			
			while(it.hasNext()) {
				String adyacente = it.next();
				
				if(colores.get(adyacente).equals("blanco")) { 
					caminoParcial=dfs_visit(adyacente,generoA,caminoParcial);
					 caminoParcial.add(0,vertice);	
				}
				
				else if (colores.get(adyacente).equals("amarillo")&& adyacente.equals(generoA)) { 
					System.out.println("lo encontre");
					//caminoParcial.add((caminoParcial.size()-1),adyacente);
					this.verticesAfines.addAll(caminoParcial);
					return caminoParcial; 
				}
			}
			
			return caminoParcial;
			
		}
		
		
	}

