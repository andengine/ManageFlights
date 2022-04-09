package orologio;

public class Orologio {
	
	private Counter ore, minuti, secondi;
	
	/**
	 * Costruttori
	 * @param h ore
	 * @param m minuti
	 * @param s secondi
	 * @return orologio
	 * 
	 * @author Andi Hystuna
	 */

	public Orologio(int h, int m, int s) {
		ore = new Counter(h);
		minuti = new Counter(m);
		secondi = new Counter(s);
		//eventualmente anche this(h,m,s)
	}
	
	public Orologio(int h, int m) {this(h,m,0);}
	
	public Orologio(int h) {this(h,0,0);}
	
	public Orologio() {this(0,0,0);}
	
	public int getHours() {return ore.getValue();}
	
	public int getMinutes() {return minuti.getValue();}
	
	public int getSeconds() {return secondi.getValue();}
	

	@Override
	// questa è una toString italica, in altri paesi non gli andrebbe bene questo formato
	public String toString() {
		return ""
				+ (getHours()<10? "0" : "")
				+ getHours() + ":"
				+ (getMinutes()<10? "0" : "")
				+ getMinutes() + ":"
				+ (getSeconds()<10? "0" : "")
				+ getSeconds();
	}
	
	public void tic() {
		secondi.inc();
		if (secondi.getValue()>=60) {
			secondi.reset(); minuti.inc();
		}
		if (minuti.getValue()>=60) {
			minuti.reset(); ore.inc();
		}
		if (ore.getValue()>=60) {
			ore.reset(); ore.inc();
		}
		//se ci fosse incrementiamo la data ora
	}
	
}
