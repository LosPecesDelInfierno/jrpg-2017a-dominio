package testsDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Hechicero;
import dominio.Humano;
import dominio.NonPlayableCharacter;

public class TestNPC {
	NonPlayableCharacter npc;
	
	@Before
	public void setUpBeforeTests(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
	}
	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(npc.otorgarExp())));
		//Assert.assertTrue(30 == npc.otorgarExp());
	}
	@Test
	public void testAtacar(){
		Humano humano = new Humano("Lautaro", new Hechicero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertNotEquals(0, (npc.atacar(humano))); //20 de danio
	}
	@Test
	public void testSerAtacado(){
		Humano humano = new Humano("Lautaro", new Hechicero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertNotEquals(0, (humano.atacar(npc))); //13 de danio
		Assert.assertEquals(0, npc.serAtacado(0));
	}
	@Test
	public void testDespuesDeTurno(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.despuesDeTurno();
		Assert.assertNotNull(npc);
	}
	@Test
	public void testGanarExperiencia(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.ganarExperiencia((int)Math.random());
		Assert.assertNotNull(npc);
	}
	@Test
	public void testsetYGetAtaque(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.setAtaque(20);
		Assert.assertEquals(20, npc.getAtaque());
	}
	@Test
	public void testsetYGetFuerza(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.setFuerza(20);
		Assert.assertEquals(20, npc.getFuerza());
	}
	@Test
	public void testsetYGetNivel(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.setNivel(20);
		Assert.assertEquals(20, npc.getNivel());
	}
	@Test
	public void testsetYGetNombre(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.setNombre("Lautaro");
		Assert.assertEquals("Lautaro", npc.getNombre());
	}
	@Test
	public void testsetYGetSalud(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 1); //Pruebo caso nivel 1
		npc.setSalud(5);
		Assert.assertEquals(5, npc.getSalud());
	}
	@Test
	public void testsetYGetDefensa(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		npc.setDefensa(7);
		Assert.assertEquals(7, npc.getDefensa());
	}
}
