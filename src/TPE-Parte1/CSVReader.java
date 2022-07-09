package tpEpecial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "C:/Users/celes/eclipse-workspace/datasets/dataset1"
        		+ ".csv";
        String line = "";
        String cvsSplitBy = ",";
        Timer timer = new Timer();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	Biblioteca biblio = new Biblioteca();
        	 br.readLine();
            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                
                String titulo = items[0];
                String autor = items[1];
                String paginas = items[2];
                String[] gen = items[3].split(" ");
                
                //creo un libro
                Libro lib = new Libro (titulo,autor,paginas);
               
              
                for(int i=0; i< gen.length ; i++ ) {
                	lib.addGenero(gen[i]);                	
                	biblio.addGeneros(gen[i]); 
                }
                
                biblio.addLibros(lib);
                biblio.addLibroAGenero(lib);
               
            //System.out.println(Arrays.toString(items));            
            }
           
            timer.start();
            
            Genero musica = new Genero("música");
            System.out.println(biblio.listarLibrosXGenero(musica));
            
	        Double elapsedTime = timer.stop();
	        System.out.println("Tiempo Transcurrido: ");
	        System.out.println(elapsedTime+" ms ");
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}