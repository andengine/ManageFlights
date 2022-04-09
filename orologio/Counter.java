package orologio;

public class Counter {
	
	private int value;
	
	public Counter(int value) { this.value=value; }
	public Counter() { this(1); }
	
	public int getValue() { return value; }
	public void inc() { value++; }
	public void reset() { value=0; }
	
}
