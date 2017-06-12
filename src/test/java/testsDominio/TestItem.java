package testsDominio;

import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.AtributoModificable;
import dominio.Humano;
import dominio.Item;
import dominio.ModificadorItem;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestItem {

	private Humano h;
	private Item item;
	@Before
	public void setear() {
		item = new Item(1, "Espada", 4, 10, 10, 10, "Foto");
		h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
	}
	
	@Test
	public void addItemInventario() {
		ModificadorItem fuerza = new ModificadorItem(AtributoModificable.FUERZA, 10, false);
		item.addModificador(fuerza);
		Assert.assertTrue(Integer.valueOf(25).equals(Integer.valueOf(h.getFuerza())));
		h.addItemInventario(item);
		Assert.assertTrue(Integer.valueOf(35).equals(Integer.valueOf(h.getFuerza())));
	}
	
	@Test
	public void ModificadorItemConPorcentaje() {
		ModificadorItem inteligencia = new ModificadorItem(AtributoModificable.INTELIGENCIA, 20, true);
		item.addModificador(inteligencia);
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(h.getInteligencia())));
		h.addItemInventario(item);
		Assert.assertTrue(Integer.valueOf(36).equals(Integer.valueOf(h.getInteligencia())));
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
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(h.getInteligencia())));
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(h.getSalud())));
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(h.getEnergia())));
		Assert.assertTrue(Integer.valueOf(25).equals(Integer.valueOf(h.getFuerza())));
		h.addItemInventario(item);
		Assert.assertTrue(Integer.valueOf(34).equals(Integer.valueOf(h.getInteligencia())));
		Assert.assertTrue(Integer.valueOf(110).equals(Integer.valueOf(h.getSalud())));
		Assert.assertTrue(Integer.valueOf(105).equals(Integer.valueOf(h.getEnergia())));
		Assert.assertTrue(Integer.valueOf(27).equals(Integer.valueOf(h.getFuerza())));
	}
	
	@Test
	public void personajeConVariosItems() {
		Item item2 = new Item(2, "Botas", 6, 10, 10, 10, "Foto");
		Item item3 = new Item(3, "Escudo", 5, 10, 10, 10, "Foto");
		Item item4 = new Item(4, "Armadura", 2, 10, 10, 10, "Foto");
		ModificadorItem salud1 = new ModificadorItem(AtributoModificable.SALUD, 15, true);
		ModificadorItem salud2 = new ModificadorItem(AtributoModificable.SALUD, 10, false);
		ModificadorItem salud3 = new ModificadorItem(AtributoModificable.SALUD, 5, false);
		ModificadorItem salud4 = new ModificadorItem(AtributoModificable.SALUD, 10, true);
		item.addModificador(salud1);
		item2.addModificador(salud2);
		item3.addModificador(salud3);
		item4.addModificador(salud4);
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(h.getSalud())));
		h.addItemInventario(item);
		h.addItemInventario(item2);
		h.addItemInventario(item3);
		h.addItemInventario(item4);
		System.out.println(h.getSalud());
		Assert.assertTrue(Integer.valueOf(141).equals(Integer.valueOf(h.getSalud())));
	}
	
	@Test
	public void PJAtributosNoSuficientes() {
		Humano g = new Humano("Nico", 100, 100, 10, 10, 5, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		ModificadorItem salud = new ModificadorItem(AtributoModificable.SALUD, 10, false);
		item.addModificador(salud);
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(g.getSalud())));
		g.addItemInventario(item);
		Assert.assertTrue(Integer.valueOf(100).equals(Integer.valueOf(g.getSalud())));
		
	}
}
