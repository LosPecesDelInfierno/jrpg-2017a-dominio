package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import dominio.RandomGeneratorStub;

public class TestOrco {

	@Test
	public void testGolpeDefensivo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);
		
		Assert.assertEquals(105, h.getSalud());
		h.setRandomGenerator(new RandomGeneratorStub());
		o.habilidadRaza1(h);
		Assert.assertEquals(95, h.getSalud());
		o.perderDefensa();
		o.habilidadRaza1(h);
		Assert.assertEquals(95, h.getSalud());
		o.serDesenergizado(95);
		o.habilidadRaza1(h);
		Assert.assertEquals(95, h.getSalud());
	}

	@Test
	public void testMordiscoDeVida() {
		Humano h = new Humano("Nico", 5, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertEquals(5, h.getSalud());
		h.setRandomGenerator(new RandomGeneratorStub());
		Assert.assertTrue(o.habilidadRaza2(h));
		Assert.assertEquals(5, h.getSalud());
		
	}
}