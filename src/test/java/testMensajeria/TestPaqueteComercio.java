package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.PaqueteComercio;

public class TestPaqueteComercio {

	PaqueteComercio pc = new PaqueteComercio();

	@Test
	public void test() {
		Assert.assertEquals(pc.getComando(), Comando.COMERCIO);
		pc.setId(23);
		pc.setIdEnemigo(41);

		Assert.assertEquals(pc.getId(), 23);
		Assert.assertEquals(pc.getIdEnemigo(), 41);

		Assert.assertFalse(pc.isMiTurno());
		pc.setMiTurno(true);
		Assert.assertTrue(pc.isMiTurno());
	}
}
