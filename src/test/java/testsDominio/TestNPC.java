package testsDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Hechicero;
import dominio.Humano;
import dominio.NonPlayableCharacter;
import dominio.RandomGeneratorStub;

public class TestNPC {
	NonPlayableCharacter npc;
	Humano humano;
	
	@Before
	public void setUpBeforeTests(){
		npc = new NonPlayableCharacter("Gigante", 1, -1);
		humano = new Humano("Lautaro", new Hechicero(), 1);
		humano.setRandomGenerator(new RandomGeneratorStub());
		npc.setRandomGenerator(new RandomGeneratorStub());
	}
	@Test
	public void testOtorgarExp() {
		Assert.assertTrue(Integer.valueOf(30).equals(Integer.valueOf(npc.otorgarExp())));
		//Assert.assertTrue(30 == npc.otorgarExp());
	}
	@Test
	public void testAtacar(){
		humano = new Humano("Lautaro", 5, 5, 2, 0, 0, new Hechicero(), 0, 0, 1);
		humano.setRandomGenerator(new RandomGeneratorStub());
		Assert.assertNotEquals(0, (npc.atacar(humano))); //20 de danio
	}
	@Test
	public void testSerAtacado(){
		Assert.assertNotEquals(0, (humano.atacar(npc))); //13 de danio
		Assert.assertEquals(0, npc.serAtacado(0));
	}
	@Test
	public void testDespuesDeTurno(){
		npc.despuesDeTurno();
		Assert.assertNotNull(npc);
	}
	@Test
	public void testGanarExperiencia(){
		npc.ganarExperiencia((int)Math.random());
		Assert.assertNotNull(npc);
	}
	@Test
	public void testsetYGetAtaque(){
		npc.setAtaque(20);
		Assert.assertEquals(20, npc.getAtaque());
	}
	@Test
	public void testsetYGetNombre(){
		npc.setNombre("Lautaro");
		Assert.assertEquals("Lautaro", npc.getNombre());
	}
	 
	@Test
	public void testDificulades() {
		NonPlayableCharacter npc0 = new NonPlayableCharacter("Gigante0", 1, 0);
		NonPlayableCharacter npc1 = new NonPlayableCharacter("Gigante1", 1, 1);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante2", 1, 2);
		
		Assert.assertEquals(10, npc0.getFuerza());
		Assert.assertEquals(30, npc0.getSalud());
		Assert.assertEquals(2, npc0.getDefensa());
		
		Assert.assertEquals(20, npc1.getFuerza());
		Assert.assertEquals(40, npc1.getSalud());
		Assert.assertEquals(5, npc1.getDefensa());
		
		Assert.assertEquals(30, npc2.getFuerza());
		Assert.assertEquals(50, npc2.getSalud());
		Assert.assertEquals(4, npc2.getDefensa());
	}
}
