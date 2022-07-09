//package Prog3_TPE2;
package tpVersion26;

import java.util.Comparator;

public class Arco<String>  {

	private String verticeOrigen;
	private String verticeDestino;
	private int etiqueta;

	public Arco(String verticeOrigen, String verticeDestino, int etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public String getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public String getVerticeDestino() {
		return verticeDestino;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(int etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public java.lang.String toString() {
		return "Arco [verticeOrigen=" + verticeOrigen + ", verticeDestino=" + verticeDestino + ", etiqueta=" + etiqueta
				+ "]";
	}
	
}
