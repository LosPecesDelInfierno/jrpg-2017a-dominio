package testsDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.RandomGeneratorStub;

public class TestHumano {

	private Humano hhh;
	private Elfo eee;
	
	@Before
	public void inicializar() {
		hhh = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		eee = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		eee.setRandomGenerator(new RandomGeneratorStub());
	}
		
	@Test
	public void testIncentivar() {
		Assert.assertEquals(37, eee.getAtaque());
		hhh.habilidadRaza1(eee);
		Assert.assertNotEquals(37, eee.getAtaque());
	}

	@Test
	public void testGolpeFatal() {
		
		Assert.assertEquals(100, hhh.getEnergia());
		Assert.assertEquals(100, hhh.getSalud());
		if (hhh.habilidadRaza2(eee)) {
			Assert.assertEquals(70, eee.getSalud());
			Assert.assertEquals(70, hhh.getEnergia());
		} else {
			//Assert.assertTrue(h.getEnergia() == 90);
			//Assert.assertTrue(e.getSalud() == 100);
		}
		//hhh.serDesenergizado(0);
		//Assert.assertFalse(h.habilidadRaza2(e));
		Assert.assertTrue(hhh.habilidadRaza2(eee));
	}
}
