package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaqueteIntercambio extends Paquete implements Serializable, Cloneable {

	private String nombre;
	private int id;
	private int idEnemigo;
	private boolean[] objetosPersonaje = { false, false, false, false, false, false, false, false };
	private boolean[] objetosEnemigo = { false, false, false, false, false, false, false, false };
	private List<String> listaPersonaje;
	private List<String> listaEnemigo;

	public PaqueteIntercambio() {
		setComando(Comando.INTERCAMBIAR);
		listaPersonaje = new ArrayList<>();
		listaEnemigo = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void addDescripcionPersonaje(String desc) {
		listaPersonaje.add(desc);
	}
	
	public void addDescripcionEnemigo(String desc) {
		listaEnemigo.add(desc);
	}
	
	public List<String> getListaPersonaje() {
		List<String> aux = new ArrayList<String>();
		Collections.copy(aux, listaPersonaje);
		return aux;
	}
	
	public List<String> getListaEnemigo() {
		List<String> aux = new ArrayList<String>();
		Collections.copy(aux, listaEnemigo);
		return aux;
	}
}
