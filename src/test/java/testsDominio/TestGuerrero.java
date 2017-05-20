package testsDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.RandomGeneratorStub;

public class TestGuerrero {

	private Humano h;
	private Elfo e;

	@Before
	public void setear() {
		h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandomGenerator(new RandomGeneratorStub());
	}

	@Test
	public void testDobleGolpe() {
		Assert.assertEquals(100, e.getSalud());
		Assert.assertTrue(h.habilidadCasta1(e));
		h.serDesenergizado(1500);
		Assert.assertFalse(h.habilidadCasta1(e));
	}

	@Test
	public void testAutoDefensa() {
		Assert.assertEquals(20, h.getDefensa());
		h.setRandomGenerator(new RandomGeneratorStub());
		h.habilidadCasta2(null);
		Assert.assertEquals(65, h.getDefensa());
	}

	@Test
	public void testIgnoraDefensa() {

		Assert.assertEquals(100, e.getSalud());
		Assert.assertTrue(h.habilidadCasta3(e));
		Assert.assertNotEquals(100, e.getSalud());
		Assert.assertEquals(63, e.getSalud());
	}

}
