package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.RandomGeneratorStub;

public class TestAsesino {

	@Test
	public void testRobar() { }
	
	@Test
	public void testCritico() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);

		Assert.assertEquals(105, h2.getSalud());
		h2.setRandomGenerator(new RandomGeneratorStub());
		Assert.assertTrue(h.habilidadCasta1(h2));
		h.serDesenergizado(Integer.valueOf(1500));
		Assert.assertFalse(h.habilidadCasta1(h2));
	}

	@Test
	public void testProbEvasion() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertTrue(0.3 == h.getCasta().getProbabilidadEvitarDanio());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDanio(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5 == h.getCasta().getProbabilidadEvitarDanio());
	}
}
