package tpVersion26;

public class Timer {
	
	private double startTime;

	public Timer() {
		startTime = 0;
	}
	

	public void start() {
		startTime = System.nanoTime();
	}
	
	public double stop() {
		double stopTime = System.nanoTime();
		return (stopTime - startTime) / 1000000.0;
	}

}
