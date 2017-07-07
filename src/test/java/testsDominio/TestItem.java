package testsDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.AtributoModificable;
import dominio.Humano;
import dominio.Item;
import dominio.ModificadorItem;
import dominio.TipoItem;
import mensajeria.PaquetePersonaje;

public class TestItem {

	private Humano h;
	private Item item;
	private PaquetePersonaje pp;

	@Before
	public void setear() {
		item = new Item(1, "Espada", TipoItem.ARMA, 10, 10, 10, "Foto");
		h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		pp = new PaquetePersonaje();
	}

	@Test
	public void Item() {
		Item aux = new Item();
		Assert.assertFalse(aux.equals(item));
		aux = item;
		Assert.assertTrue(aux.equals(item));

		Assert.assertTrue(Integer.valueOf(item.getId()).equals(Integer.valueOf(1)));
		Assert.assertEquals("Espada", item.getNombre());
		Assert.assertTrue(Integer.valueOf(item.getIdTipoItem()).equals(Integer.valueOf(TipoItem.ARMA)));
		Assert.assertTrue(Integer.valueOf(item.getFuerzaRequerida()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(item.getDestrezaRequerida()).equals(Integer.valueOf(10)));
		Assert.assertTrue(Integer.valueOf(item.getInteligenciaRequerida()).equals(Integer.valueOf(10)));
		Assert.assertEquals("Foto", item.getFoto());
	}

	@Test
	public void testDescripcion() {
		ModificadorItem fuerza = new ModificadorItem(AtributoModificable.FUERZA, 10, false);
		item.addModificador(fuerza);
		ModificadorItem inteligencia = new ModificadorItem(AtributoModificable.INTELIGENCIA, 11, false);
		item.addModificador(inteligencia);
		ModificadorItem destreza = new ModificadorItem(AtributoModificable.DESTREZA, 23, false);
		item.addModificador(destreza);
		ModificadorItem salud = new ModificadorItem(AtributoModificable.SALUD, 14, false);
		item.addModificador(salud);
		ModificadorItem energia = new ModificadorItem(AtributoModificable.ENERGIA, 12, false);
		item.addModificador(energia);
		Assert.assertEquals(
				"Espada (+10 de Fuerza, +11 de Inteligencia, +23 de Destreza, +14 de Salud, +12 de Energía)",
				item.getDescripcionItem());
	}

	@Test
	public void addItemInventario() {
		ModificadorItem fuerza = new ModificadorItem(AtributoModificable.FUERZA, 10, false);
		item.addModificador(fuerza);
		pp.setFuerza(25);
		Assert.assertTrue(Integer.valueOf(pp.getFuerza()).equals(Integer.valueOf(25)));
		pp.agregarItem(item);
		Assert.assertTrue(Integer.valueOf(pp.getFuerza()).equals(Integer.valueOf(35)));
	}

	@Test
	public void ModificadorItemConPorcentaje() {
		ModificadorItem inteligencia = new ModificadorItem(AtributoModificable.INTELIGENCIA, 20, true);
		item.addModificador(inteligencia);
		pp.setInteligencia(25);
		Assert.assertTrue(Integer.valueOf(25).equals(Integer.valueOf(pp.getInteligencia())));
		pp.agregarItem(item);
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(pp.getInteligencia())));
	}

	@Test
	public void ItemConVariosModificadores() {
		ModificadorItem inteligencia = new ModificadorItem(AtributoModificable.INTELIGENCIA, 15, true);
		ModificadorItem salud = new ModificadorItem(AtributoModificable.SALUD, 10, false);
		ModificadorItem energia = new ModificadorItem(AtributoModificable.ENERGIA, 5, false);
		ModificadorItem fuerza = new ModificadorItem(AtributoModificable.FUERZA, 10, true);
		item.addModificador(inteligencia);
		item.addModificador(salud);
		item.addModificador(energia);
		item.addModificador(fuerza);
		pp.setSaludTope(100); // Salud base pasa a ser 100
		pp.setInteligencia(60);
		pp.setEnergiaTope(75); // Energia base pasa a ser 75
		pp.setFuerza(30);
		Assert.assertTrue(Integer.valueOf(60).equals(Integer.valueOf(pp.getInteligencia())));
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(pp.getSaludTope())));
		Assert.assertTrue(Integer.valueOf(75).equals(Integer.valueOf(pp.getEnergiaTope())));
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(pp.getFuerza())));
		pp.agregarItem(item);
		Assert.assertNotEquals(pp.getInteligenciaBase(), pp.getInteligencia());
		Assert.assertNotEquals(pp.getSaludBase(), pp.getSaludTope());
		Assert.assertNotEquals(pp.getFuerzaBase(), pp.getFuerza());
		Assert.assertNotEquals(pp.getEnergiaBase(), pp.getEnergiaTope());
		Assert.assertTrue(Integer.valueOf(69).equals(Integer.valueOf(pp.getInteligencia())));
		Assert.assertTrue(Integer.valueOf(110).equals(Integer.valueOf(pp.getSaludTope())));
		Assert.assertTrue(Integer.valueOf(80).equals(Integer.valueOf(pp.getEnergiaTope())));
		Assert.assertTrue(Integer.valueOf(33).equals(Integer.valueOf(pp.getFuerza())));
	}

	@Test
	public void personajeConVariosItems() {
		Item item2 = new Item(2, "Botas", 6, 10, 10, 10, "Foto");
		Item item3 = new Item(3, "Escudo", 5, 10, 10, 10, "Foto");
		Item item4 = new Item(4, "Armadura", 2, 10, 10, 10, "Foto");
		ModificadorItem salud1 = new ModificadorItem(AtributoModificable.SALUD, 5, false);
		ModificadorItem salud2 = new ModificadorItem(AtributoModificable.SALUD, 10, false);
		ModificadorItem salud3 = new ModificadorItem(AtributoModificable.SALUD, 5, true);
		ModificadorItem salud4 = new ModificadorItem(AtributoModificable.SALUD, 10, false);
		item.addModificador(salud1);
		item2.addModificador(salud2);
		item3.addModificador(salud3);
		item4.addModificador(salud4);
		pp.setSaludTope(180); // Salud Base es 180
		Assert.assertTrue(Integer.valueOf(180).equals(Integer.valueOf(pp.getSaludTope())));
		pp.agregarItem(item);
		pp.agregarItem(item2);
		pp.agregarItem(item3);
		pp.agregarItem(item4);
		Assert.assertNotEquals(pp.getSaludBase(), pp.getSaludTope());
		Assert.assertTrue(Integer.valueOf(214).equals(Integer.valueOf(pp.getSaludTope())));
	}

	@Test
	public void tipoItem() {
		TipoItem t = new TipoItem();
		Assert.assertEquals(4, t.ARMA);
	}
}
