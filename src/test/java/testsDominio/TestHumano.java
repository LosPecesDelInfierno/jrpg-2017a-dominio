package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(37, e.getAtaque());
		h.habilidadRaza1(e);
		Assert.assertNotEquals(37, e.getAtaque());
	}

	@Test
	public void testGolpeFatal() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(100, h.getEnergia());
		Assert.assertEquals(100, h.getSalud());
		if (h.habilidadRaza2(e)) {
			Assert.assertEquals(70, e.getSalud());
			Assert.assertEquals(50, h.getEnergia());
		} else {
			//Assert.assertTrue(h.getEnergia() == 90);
			//Assert.assertTrue(e.getSalud() == 100);
		}
		h.serDesenergizado(0);
		Assert.assertFalse(h.habilidadRaza2(e));
	}
}
