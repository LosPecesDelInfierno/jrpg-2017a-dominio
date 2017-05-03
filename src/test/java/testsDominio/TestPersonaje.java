package testsDominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(Integer.valueOf(h.getSalud()).equals(Integer.valueOf(105)));
		Assert.assertTrue(Integer.valueOf(h.getEnergia()).equals(Integer.valueOf(105)));
		Assert.assertTrue(Integer.valueOf(h.getFuerza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(h.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(h.getInteligencia()).equals(Integer.valueOf(10)));

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(Integer.valueOf(h2.getSalud()).equals(Integer.valueOf(105)));
		Assert.assertTrue(Integer.valueOf(h2.getEnergia()).equals(Integer.valueOf(105)));
		Assert.assertTrue(Integer.valueOf(h2.getFuerza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(h2.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(h2.getInteligencia()).equals(Integer.valueOf(15)));

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		int aux = h3.getSalud();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(105)));
		aux = h3.getEnergia();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(105)));
		Assert.assertTrue(Integer.valueOf(h3.getFuerza()).equals(Integer.valueOf(10)));	
		Assert.assertTrue(Integer.valueOf(h3.getDestreza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(h3.getInteligencia()).equals(Integer.valueOf(10)));
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(Integer.valueOf(e.getSalud()).equals(Integer.valueOf(100)));
		Assert.assertTrue(Integer.valueOf(e.getEnergia()).equals(Integer.valueOf(110)));
		Assert.assertTrue(Integer.valueOf(e.getFuerza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(e.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(e.getInteligencia()).equals(Integer.valueOf(10)));

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(Integer.valueOf(e2.getSalud()).equals(Integer.valueOf(100)));
		Assert.assertTrue(Integer.valueOf(e2.getEnergia()).equals(Integer.valueOf(110)));
		Assert.assertTrue(Integer.valueOf(e2.getFuerza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(e2.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(e2.getInteligencia()).equals(Integer.valueOf(15)));

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		int aux = e3.getSalud();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(100)));
		aux = e3.getEnergia();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(110)));
		Assert.assertTrue(Integer.valueOf(e3.getFuerza()).equals(Integer.valueOf(10)));	
		Assert.assertTrue(Integer.valueOf(e3.getDestreza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(e3.getInteligencia()).equals(Integer.valueOf(10)));
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(Integer.valueOf(o.getSalud()).equals(Integer.valueOf(110)));
		Assert.assertTrue(Integer.valueOf(o.getEnergia()).equals(Integer.valueOf(100)));
		Assert.assertTrue(Integer.valueOf(o.getFuerza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(o.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(o.getInteligencia()).equals(Integer.valueOf(10)));

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(Integer.valueOf(o2.getSalud()).equals(Integer.valueOf(110)));
		Assert.assertTrue(Integer.valueOf(o2.getEnergia()).equals(Integer.valueOf(100)));
		Assert.assertTrue(Integer.valueOf(o2.getFuerza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(o2.getDestreza()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(o2.getInteligencia()).equals(Integer.valueOf(15)));

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		int aux = o3.getSalud();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(110)));
		aux = o3.getEnergia();
		Assert.assertTrue(Integer.valueOf(aux).equals(Integer.valueOf(100)));
		Assert.assertTrue(Integer.valueOf(o3.getFuerza()).equals(Integer.valueOf(10)));	
		Assert.assertTrue(Integer.valueOf(o3.getDestreza()).equals(Integer.valueOf(15)));
		Assert.assertTrue(Integer.valueOf(o3.getInteligencia()).equals(Integer.valueOf(10)));
	}
	@Test
	public void testSetYGetNombreRaza(){
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setNombreRaza("nombre");
		assertEquals("nombre",o3.getNombreRaza());
	}
	@Test
	public void testSetYGetNombre(){
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setNombre("nombre");
		assertEquals("nombre",o3.getNombre());
	}
	@Test
	public void testSaludTope(){
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setSaludTope(5);
		assertEquals(5,o3.getSaludTope());
	}
	@Test
	public void testSetEnergiaTope(){
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setEnergiaTope(5);
		assertEquals(5,o3.getEnergiaTope());
	}
	@Test
	public void testReestablecerSaludYEnergia() {
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setEnergiaTope(5);
		o3.setSaludTope(2);
		o3.restablecerEnergia();
		o3.restablecerSalud();
		assertEquals(5,o3.getEnergia());
		assertEquals(2,o3.getSalud());
	}
	
	@Test
	public void testSerRobadoSalud() {
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		o3.setDefensa(0);
		o3.setSalud(5);
		assertEquals(5, o3.serRobadoSalud(50));
		assertEquals(0, o3.serRobadoSalud(0));
	}
	@Test
	public void testSerAtacado() {
		Asesino casta = new Asesino();
		Orco o3 = new Orco("Hernan", casta, 3);
		casta.setProbabilidadEvitarDanio(0.7);
		assertEquals(0, o3.serAtacado(15));
	}
	@Test
	public void testSerDesenergizado() {
		Asesino casta = new Asesino();
		Orco o3 = new Orco("Hernan", casta, 3);
		assertEquals(0, o3.serDesernegizado(0));
		o3.setEnergia(15);
		o3.setDefensa(0);
		assertEquals(15, o3.serDesernegizado(50));
	}
	@Test
	public void testCrearAlianza() {
		Asesino casta = new Asesino();
		Orco o3 = new Orco("Hernan", casta, 3);
		o3.crearAlianza("nombreAlianza");
		assertEquals("nombreAlianza", o3.getClan().obtenerNombre());
	}
	@Test
	public void testSalirDeAlianza() {
		Asesino casta = new Asesino();
		Orco o3 = new Orco("Hernan", casta, 3);
		o3.crearAlianza("nombreAlianza");
		assertEquals("nombreAlianza", o3.getClan().obtenerNombre());
		o3.salirDeAlianza();
		assertNull(o3.getClan());
	}
	@Test
	public void testSerEnergizado() {
		Asesino casta = new Asesino();
		Orco o3 = new Orco("Hernan", casta, 3);
		o3.setEnergiaTope(5);
		o3.setEnergia(3);
		o3.serEnergizado(10);
		assertEquals(5, o3.getEnergia());
	}
}
