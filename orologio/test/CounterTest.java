package orologio.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import orologio.Counter;

class CounterTest {

	@Test
	void testOK_Ctor1() {
		Counter c1 = new Counter(12);
		assertEquals(12, c1.getValue());
	}

	@Test
	void testOK_CtorDefault() {
		Counter c1 = new Counter();
		assertEquals(1, c1.getValue());
	}
	
	@Test
	void testOK_inc() {
		Counter c1 = new Counter(13);
		assertEquals(13, c1.getValue());
		c1.inc();
		assertEquals(14, c1.getValue());
	}
	
}
