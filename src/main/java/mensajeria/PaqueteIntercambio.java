package mensajeria;

import java.io.Serializable;

public class PaqueteIntercambio extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private boolean[] objetosPersonaje = { false, false, false, false, false, false, false, false };
	private boolean[] objetosEnemigo = { false, false, false, false, false, false, false, false };

	public PaqueteIntercambio() {
		setComando(Comando.INTERCAMBIAR);
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

	public void setSeleccionadoPersonaje(int idx, boolean seleccion) {
		this.objetosPersonaje[idx] = seleccion;
	}

	public boolean getSeleccionadoPersonaje(int idx) {
		return objetosPersonaje[idx];
	}
	
	public void setSeleccionadoEnemigo(int idx, boolean seleccion) {
		this.objetosEnemigo[idx] = seleccion;
	}

	public boolean getSeleccionadoEnemigo(int idx) {
		return objetosEnemigo[idx];
	}
}
