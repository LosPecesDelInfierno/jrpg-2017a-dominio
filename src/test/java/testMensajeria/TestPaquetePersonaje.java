package testMensajeria;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.AtributoModificable;
import dominio.Item;
import dominio.ModificadorItem;
import dominio.TipoItem;
import mensajeria.PaquetePersonaje;

public class TestPaquetePersonaje {

	PaquetePersonaje pp = new PaquetePersonaje();

	@Test
	public void testSetCasta() {
		pp.setCasta("Humano");
		Assert.assertEquals("Humano", pp.getCasta());
	}

	@Test
	public void testEquiparItem() {
		LinkedList<Item> items = new LinkedList<>();
		Item item1 = new Item(1, "Espada", TipoItem.ARMA, 10, 10, 10, "Foto");
		Item item2 = new Item(2, "Escudo", TipoItem.ESCUDO, 10, 10, 10, "Foto2");
		items.add(item1);
		items.add(item2);
		pp.equipar(items);
		Assert.assertEquals(pp.getItem(TipoItem.ARMA), item1);
		Assert.assertEquals(pp.getItem(TipoItem.ESCUDO), item2);
	}

	@Test
	public void testGanoBatalla() {
		Assert.assertEquals(false, pp.ganoBatalla());
		pp.setGanoBatalla(true);
		Assert.assertEquals(true, pp.ganoBatalla());
	}

	@Test
	public void testSetUsuario() {
		pp.setUsuario("User1");
		Assert.assertEquals("User1", pp.getUsuario());
	}

	@Test
	public void testSetDestreza() {
		pp.setDestreza(10);
		Assert.assertEquals(10, pp.getDestreza());
	}

	@Test
	public void testBonus() {
		Item item2 = new Item(2, "Escudo", TipoItem.ESCUDO, 10, 10, 10, "Foto2");
		ModificadorItem m = new ModificadorItem(AtributoModificable.ENERGIA, 12, false);
		ModificadorItem m1 = new ModificadorItem(AtributoModificable.DESTREZA, 14, false);
		ModificadorItem m2 = new ModificadorItem(AtributoModificable.FUERZA, 16, false);
		ModificadorItem m3 = new ModificadorItem(AtributoModificable.INTELIGENCIA, 12, false);
		ModificadorItem m4 = new ModificadorItem(AtributoModificable.SALUD, 13, false);
		item2.addModificador(m);
		item2.addModificador(m1);
		item2.addModificador(m2);
		item2.addModificador(m3);
		item2.addModificador(m4);
		pp.agregarItem(item2);
		Assert.assertTrue(Integer.valueOf(12).equals(Integer.valueOf(pp.getBonusEnergia())));
		Assert.assertTrue(Integer.valueOf(14).equals(Integer.valueOf(pp.getBonusDestreza())));
		Assert.assertTrue(Integer.valueOf(16).equals(Integer.valueOf(pp.getBonusFuerza())));
		Assert.assertTrue(Integer.valueOf(12).equals(Integer.valueOf(pp.getBonusInteligencia())));
		Assert.assertTrue(Integer.valueOf(13).equals(Integer.valueOf(pp.getBonusSalud())));
	}

	@Test
	public void testSetMapa() {
		pp.setMapa(2);
		Assert.assertEquals(2, pp.getMapa());
	}

	@Test
	public void testSetComando() {
		pp.setComando(3);
		Assert.assertEquals(3, pp.getComando());
	}

	@Test
	public void testSetEnergiaTope() {
		pp.setEnergiaTope(18);
		Assert.assertEquals(18, pp.getEnergiaTope());
	}

	@Test
	public void testSetNivel() {
		pp.setNivel(4);
		Assert.assertEquals(4, pp.getNivel());
	}

	@Test
	public void testSetNombre() {
		pp.setNombre("Prueba");
		Assert.assertEquals("Prueba", pp.getNombre());
	}

	@Test
	public void testSetRaza() {
		pp.setRaza("Raza");
		Assert.assertEquals("Raza", pp.getRaza());
	}

	@Test
	public void testSetExperiencia() {
		pp.setExperiencia(10);
		Assert.assertEquals(10, pp.getExperiencia());
	}

	@Test
	public void testDestrezaBase() {
		pp.setDestreza(10);
		Assert.assertEquals(10, pp.getDestrezaBase());
	}

	@Test
	public void testID() {
		pp.setId(2);
		Assert.assertEquals(2, pp.getId());
	}

	@Test
	public void testEstado() {
		pp.setEstado(3);
		Assert.assertEquals(3, pp.getEstado());
	}

	@Test
	public void testExtraerItem() {
		Item item = new Item(2, "Casco", TipoItem.CASCO, 10, 10, 10, "Foto");
		pp.agregarItem(item);
		Assert.assertFalse(pp.getInventario().isEmpty());

		Item ret = pp.extraerItem(TipoItem.CASCO);
		Assert.assertEquals(ret.getNombre(), "Casco");

		Assert.assertTrue(pp.getInventario().isEmpty());
	}
}
