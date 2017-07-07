package mensajeria;

import java.io.Serializable;

public class PaqueteFinalizarComercio extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private boolean aceptado;
	
	public PaqueteFinalizarComercio(){
		setComando(Comando.FINALIZARCOMERCIO);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
	
	public boolean aceptaIntercambio() {
		return this.aceptado;
	}

	public void aceptaIntercambio(boolean aceptado) {
		this.aceptado = aceptado;
	}
}
