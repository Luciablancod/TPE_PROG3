//package Prog3_TPE2;
package tpVersion26;
import java.util.Iterator;

public class IteradorAdyacentes<String> implements Iterator<String> {
	
	private Iterator<Arco<String>> it;
	
	

	public IteradorAdyacentes(Iterator<Arco<String>> it) {
		super();
		this.it = it;
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public String next() {
		return it.next().getVerticeDestino();
	}

}
