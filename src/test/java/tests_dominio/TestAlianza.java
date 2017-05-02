package testsDominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dominio.Alianza;
import dominio.Casta;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Peleable;
import dominio.Personaje;

public class TestAlianza {

	private static Alianza alianzaPrueba;
	private static LinkedList<Personaje> listaAux = new LinkedList<Personaje>();
	private static Humano humano1;
	private static Humano humano2;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		alianzaPrueba = new Alianza("Alianza Probadora");
		humano1 = new Humano("Lautaro", new Hechicero(0.5, 0.2, 0.8), 1);
		humano2 = new Humano("Nicolas", new Hechicero(0.5, 0.2, 0.8), 1);
		alianzaPrueba.anadirPersonaje(humano1);
	}

	@Test
	public void testAlianza() {
		assertNotNull(alianzaPrueba);
	}

	@Test
	public void testGetAliados() {
		assertNotNull(alianzaPrueba.getAliados());
	}

	@Test
	public void testSetAliados() {
		listaAux.add(humano2);
		alianzaPrueba.setAliados(listaAux);
		assertEquals(listaAux, alianzaPrueba.getAliados());
	}

	@Test
	public void testObtenerNombre() {
		assertEquals("Alianza Probadora", alianzaPrueba.obtenerNombre());
	}

	@Test
	public void testEliminarPersonaje() {
		alianzaPrueba.eliminarPersonaje(humano1);
		listaAux = alianzaPrueba.getAliados();
		boolean test = listaAux.contains(humano1);
		assertFalse(test);
	}

	@Test
	public void testAnadirPersonaje() {
		alianzaPrueba.anadirPersonaje(humano2);
		listaAux = alianzaPrueba.getAliados();
		boolean test = listaAux.contains(humano2);
		assertTrue(test);
	}

}
