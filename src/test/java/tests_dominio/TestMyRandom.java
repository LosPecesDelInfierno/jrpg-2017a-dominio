package tests_dominio;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dominio.MyRandom;

public class TestMyRandom {
	
	private static double dobleGenerico;
	private static int valorEntero;
	
	@BeforeClass
	public static void testVarGenerator(){
		valorEntero = (int) Math.random();
		dobleGenerico = 0.49;
	}
	
	@Test
	public void testMyRandom(){
		assertNotNull(new MyRandom());
	}
	
	@Test
	public void testNextDouble() {
		double aux = MyRandom.nextDouble();
		
		boolean test = Double.valueOf(aux).equals(Double.valueOf(dobleGenerico));
		assertTrue(test);
	}

	@Test
	public void testNextInt() {
		int proxInt = MyRandom.nextInt(valorEntero);
		assertEquals(valorEntero-1, proxInt);
	}

}
