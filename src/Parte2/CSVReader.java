//package Prog3_TPE2;
package tpVersion26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;



public class CSVReader {

    public static void main(String[] args) {
//     String csvFile = "C://Users//celes//OneDrive//Documents//TUDAI 2022//PROGRAMACION 3//dataset2.csv";
        String csvFile = "C:/Users/LangTenologia/Documents/prog3/datasetTPE2/dataset4.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"ISO_8859_1"))) { //ahora si lo lee bien 
        	
        	GrafoDirigido<String> grafo = new GrafoDirigido<>(0);
        	br.readLine();
        	 
            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                           
                for(int i=0; i< (items.length-1) ; i++ ) {
                	
                	grafo.agregarVertice(items[i]);
                	grafo.agregarVertice(items[i+1]);

                	if(grafo.existeArco(items[i], items[i+1])){
                			Arco<String> arco = grafo.obtenerArco(items[i],  items[i+1]);
                			arco.setEtiqueta(arco.getEtiqueta()+1);
                	} 
                	else 
                		grafo.agregarArco(items[i],items[i+1], 1);
                }
//            System.out.println(Arrays.toString(items));
            }
//           Arco<String> arco =grafo.obtenerArco("viajes", "informática");
//           System.out.println(arco);  
            
            
//            GenerosMasBuscados generos = new GenerosMasBuscados();
//            System.out.println(generos.generoMasBuscadoA("viajes", 3));
            
//            System.out.println(grafo.generoMasBuscadoA("viajes", 2)); //funciona
            
//            System.out.println(grafo.secuenciaMayorValor("viajes"));
           System.out.println(grafo.cantidadVertices());
           System.out.println(grafo.cantidadArcos());
            
//            Timer tiempo = new Timer();
//            tiempo.start();	
//            
//            GenerosCiclo generos = new GenerosCiclo(grafo);
//    		generos.ciclosDesde("thriller");
//            
//            System.out.println("Tiempo de ejecución: " + tiempo.stop() +" ms");
                        
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}