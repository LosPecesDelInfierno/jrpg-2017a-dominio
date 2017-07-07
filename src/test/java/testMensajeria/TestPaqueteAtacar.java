package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.PaqueteAtacar;

public class TestPaqueteAtacar {
	PaqueteAtacar pa;

	@Test
	public void testSeters() {
		pa = new PaqueteAtacar(3, 2, 200, 89, 19, 13);
		Assert.assertEquals(3, pa.getId());
		Assert.assertEquals(2, pa.getIdEnemigo());
		Assert.assertEquals(200, pa.getNuevaSaludPersonaje());
		Assert.assertEquals(89, pa.getNuevaEnergiaPersonaje());
		Assert.assertEquals(19, pa.getNuevaSaludEnemigo());
		Assert.assertEquals(13, pa.getNuevaEnergiaEnemigo());

		pa.setComando(Comando.ATACAR);
		pa.setId(23);
		pa.setIdEnemigo(22);
		pa.setIp("192.111.200");
		pa.setMensaje("mensajePrueba");
		pa.setNuevaEnergiaEnemigo(100);
		pa.setNuevaEnergiaPersonaje(200);
		pa.setNuevaSaludEnemigo(120);
		pa.setNuevaSaludPersonaje(230);

		Assert.assertEquals(Comando.ATACAR, pa.getComando());
		Assert.assertEquals("192.111.200", pa.getIp());
		Assert.assertEquals("mensajePrueba", pa.getMensaje());
		Assert.assertEquals(23, pa.getId());
		Assert.assertEquals(22, pa.getIdEnemigo());
		Assert.assertEquals(230, pa.getNuevaSaludPersonaje());
		Assert.assertEquals(200, pa.getNuevaEnergiaPersonaje());
		Assert.assertEquals(120, pa.getNuevaSaludEnemigo());
		Assert.assertEquals(100, pa.getNuevaEnergiaEnemigo());

	}
}
