package mensajeria;

import java.io.Serializable;

public class PaqueteComercio extends Paquete implements Serializable, Cloneable {
	
	private int id;
	private int idEnemigo;
	private boolean miTurno;
	
	public PaqueteComercio() {
		setComando(Comando.COMERCIO);
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

	public boolean isMiTurno() {
		return miTurno;
	}

	public void setMiTurno(boolean miTurno) {
		this.miTurno = miTurno;
	}
}
