package testsDominio;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dominio.MyRandom;
import dominio.RandomGenerator;
import dominio.RandomGeneratorStub;

public class TestMyRandom {
	
	private static double dobleGenerico;
	private static int valorEntero;
	private RandomGenerator randomGenerator = new RandomGeneratorStub();
	
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
		double aux = randomGenerator.nextDouble();
		
		boolean test = Double.valueOf(aux).equals(Double.valueOf(dobleGenerico));
		assertTrue(test);
	}

	@Test
	public void testNextInt() {
		int proxInt = randomGenerator.nextInt(valorEntero);
		assertEquals(valorEntero-1, proxInt);
	}

}
