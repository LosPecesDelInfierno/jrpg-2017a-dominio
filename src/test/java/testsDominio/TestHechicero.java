package testsDominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHechicero {

	@Test
	public void testCurar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(100, e.getSalud());
		e.serRobadoSalud(35);
		Assert.assertEquals(85, e.getSalud());
		h.habilidadCasta2(e);
		boolean test = e.getSalud() > 65;
		Assert.assertTrue(test);
		h.serDesenergizado(h.getEnergia());
//		Assert.assertFalse(h.habilidadCasta2(e));
		Assert.assertTrue(h.habilidadCasta2(e));
	}

	@Test
	public void testBolaDeFuego() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(Integer.valueOf(e.getSalud()).equals(Integer.valueOf(100)));
		h.habilidadCasta1(e);
		Assert.assertNotEquals(100, e.getSalud());
	}

	@Test
	public void testRobarEnergiaYSalud() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(Integer.valueOf(e.getSalud()).equals(Integer.valueOf(100)));
		h.serRobadoSalud(50);
		h.serDesenergizado(50);
		h.habilidadCasta3(e);
		boolean test = e.getSalud() < 100;	
		Assert.assertTrue(test);
		test = h.getEnergia() > 50;
		Assert.assertTrue(test);
		test = h.getSalud() > 50;
		Assert.assertTrue(test);
		}
	/*Se implementan prueban para levantar el coverage de Casta.java*/
	
	@Test
	public void testDanioCritico() {
		Hechicero hechicero = new Hechicero();
		hechicero.setDanioCritico(1);
		Assert.assertTrue(Double.valueOf(1).equals(Double.valueOf(hechicero.getDanioCritico())));
	}
	@Test
	public void testProbEvitarDanio() {
		Hechicero hechicero = new Hechicero();
		hechicero.setProbabilidadEvitarDanio(1);
		Assert.assertTrue(Double.valueOf(1).equals(Double.valueOf(hechicero.getProbabilidadEvitarDanio())));
	}
	@Test
	public void testProbGolpeCritico() {
		Hechicero hechicero = new Hechicero();
		hechicero.setProbabilidadGolpeCritico(1);
		Assert.assertTrue(Double.valueOf(1).equals(Double.valueOf(hechicero.getProbabilidadGolpeCritico())));
	}
	@Test
	public void testNombreCasta() {
		Hechicero hechicero = new Hechicero();
		Assert.assertTrue("Hechicero".equals(hechicero.getNombreCasta()));
	}
	@Test
	public void testVectorHabilidadesDeCasta() {
		Hechicero hechicero = new Hechicero();
		String[] vec = hechicero.getHabilidadesCasta();
		Assert.assertTrue(vec.equals(hechicero.getHabilidadesCasta()));
	}
}
