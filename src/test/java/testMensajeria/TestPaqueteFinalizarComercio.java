package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.PaqueteFinalizarComercio;

public class TestPaqueteFinalizarComercio {
	PaqueteFinalizarComercio pfc = new PaqueteFinalizarComercio();

	@Test
	public void test() {
		Assert.assertEquals(pfc.getComando(), Comando.FINALIZARCOMERCIO);
		pfc.setId(23);
		pfc.setIdEnemigo(41);

		Assert.assertEquals(pfc.getId(), 23);
		Assert.assertEquals(pfc.getIdEnemigo(), 41);

		pfc.aceptaIntercambio(true);
		Assert.assertTrue(pfc.aceptaIntercambio());
		pfc.aceptaIntercambio(false);
		Assert.assertFalse(pfc.aceptaIntercambio());

	}
}
