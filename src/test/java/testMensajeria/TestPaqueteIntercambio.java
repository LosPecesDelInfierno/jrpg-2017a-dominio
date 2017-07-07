package testMensajeria;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Item;
import dominio.TipoItem;
import mensajeria.Comando;
import mensajeria.PaqueteIntercambio;
import mensajeria.PaquetePersonaje;

public class TestPaqueteIntercambio {
	PaqueteIntercambio pi = new PaqueteIntercambio();

	@Test
	public void comandoPaquete() {
		Assert.assertEquals(Comando.INTERCAMBIAR, pi.getComando());
	}

	@Test
	public void setId() {
		pi.setId(12);
		Assert.assertEquals(12, pi.getId());
	}

	@Test
	public void setNombre() {
		pi.setNombre("paquete");
		Assert.assertEquals("paquete", pi.getNombre());
	}

	@Test
	public void setIdEnemigo() {
		pi.setIdEnemigo(23);
		Assert.assertEquals(23, pi.getIdEnemigo());
	}

	@Test
	public void seleccionandoItems() {
		pi.setSeleccionadoEnemigo(2, true);
		pi.setSeleccionadoEnemigo(3, true);
		pi.setSeleccionadoPersonaje(1, true);
		pi.setSeleccionadoPersonaje(4, true);

		Assert.assertTrue(pi.getSeleccionadoEnemigo(2));
		Assert.assertTrue(pi.getSeleccionadoEnemigo(3));
		Assert.assertTrue(pi.getSeleccionadoPersonaje(1));
		Assert.assertTrue(pi.getSeleccionadoPersonaje(4));
		Assert.assertFalse(pi.getSeleccionadoPersonaje(2));
		Assert.assertFalse(pi.getSeleccionadoEnemigo(4));
	}

	@Test
	public void testDescripcionPersonaje() {
		PaquetePersonaje pp = new PaquetePersonaje();
		Item ip = new Item(1, "Espada", TipoItem.ARMA, 100, 100, 100, "Foto");
		PaquetePersonaje pe = new PaquetePersonaje();
		Item ie = new Item(1, "Escudo", TipoItem.ESCUDO, 100, 100, 100, "Foto");
		pp.agregarItem(ip);
		pe.agregarItem(ie);

		pi.addDescripcionEnemigo(pe.getItem(TipoItem.ESCUDO).getNombre());
		pi.addDescripcionPersonaje(pp.getItem(TipoItem.ARMA).getNombre());

		Assert.assertEquals(pi.getListaEnemigo().get(0), "Escudo");
		Assert.assertEquals(pi.getListaPersonaje().get(0), "Espada");
	}

	@Test
	public void setListaPersonajeEnemigo() {
		LinkedList<String> listaPersonaje = new LinkedList<>();
		LinkedList<String> listaEnemigo = new LinkedList<>();

		listaPersonaje.add("NombreItem1");
		listaPersonaje.add("NombreItem2");
		listaEnemigo.add("ItemEnemigo1");
		listaEnemigo.add("ItemEnemigo2");

		pi.setListaPersonaje(listaPersonaje);
		pi.setListaEnemigo(listaEnemigo);

		Assert.assertEquals(pi.getListaPersonaje().get(0), "NombreItem1");
		Assert.assertEquals(pi.getListaPersonaje().get(1), "NombreItem2");
		Assert.assertEquals(pi.getListaEnemigo().get(0), "ItemEnemigo1");
		Assert.assertEquals(pi.getListaEnemigo().get(1), "ItemEnemigo2");

		pi.reiniciarListas();

		Assert.assertTrue(pi.getListaEnemigo().isEmpty());
		Assert.assertTrue(pi.getListaPersonaje().isEmpty());
	}
}
