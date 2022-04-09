package orologio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import orologio.Orologio;

class OrologioTests {

	@Test
	void testOK1() {
		Orologio prova = new Orologio(12,30,20);
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
		assertEquals(20, prova.getSeconds());
	}
	
	@Test
	void testOK2() {
		Orologio prova = new Orologio(12,30);
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
	}
	
	@Test
	void testOK3() {
		Orologio prova = new Orologio(12);
		assertEquals(12, prova.getHours());
	}
	
	@Test
	void testCtorDiscutibile() {
		Orologio prova = new Orologio(65,88,76);
		assertEquals(65, prova.getHours());
		assertEquals(88, prova.getMinutes());
		assertEquals(76, prova.getSeconds());
	}
	
	@Test
	void testOKString() {
		Orologio prova = new Orologio(12,30,45);
		assertEquals("12:30:45", prova.toString());
	}
	
	@Test
	void testOK2String() {
		Orologio prova = new Orologio(7,3,5);
		assertEquals("07:03:05", prova.toString());
	}
	
	@Test
	void testOK_Tic() {
		Orologio prova = new Orologio(12,30,20);
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
		assertEquals(20, prova.getSeconds());
		prova.tic();
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
		assertEquals(21, prova.getSeconds());
	}
	
	@Test
	void testOK2_Tic() {
		Orologio prova = new Orologio(12,30,58);
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
		assertEquals(58, prova.getSeconds());
		prova.tic();
		assertEquals(12, prova.getHours());
		assertEquals(30, prova.getMinutes());
		assertEquals(59, prova.getSeconds());
		prova.tic();
		assertEquals(12, prova.getHours());
		assertEquals(31, prova.getMinutes());
		assertEquals(0, prova.getSeconds());
	}
	
	@Test
	void testOK3_Tic() {
		Orologio prova = new Orologio(12,59,59);
		assertEquals(12, prova.getHours());
		assertEquals(59, prova.getMinutes());
		assertEquals(59, prova.getSeconds());
		prova.tic();
		assertEquals(13, prova.getHours());
		assertEquals(0, prova.getMinutes());
		assertEquals(0, prova.getSeconds());
		prova.tic();
		assertEquals(13, prova.getHours());
		assertEquals(0, prova.getMinutes());
		assertEquals(01, prova.getSeconds());
	}
	
	@Test
	void testOK4_Tic() {
		Orologio prova = new Orologio(12,59,58);
		assertEquals(12, prova.getHours());
		assertEquals(59, prova.getMinutes());
		assertEquals(58, prova.getSeconds());
		prova.tic();
		assertEquals(12, prova.getHours());
		assertEquals(59, prova.getMinutes());
		assertEquals(59, prova.getSeconds());
		prova.tic();
		assertEquals(13, prova.getHours());
		assertEquals(0, prova.getMinutes());
		assertEquals(0, prova.getSeconds());
	}
	
}
