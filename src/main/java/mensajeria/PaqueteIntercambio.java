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
	private List<String> listaPersonaje = new ArrayList<>();
	private List<String> listaEnemigo = new ArrayList<>();

	public PaqueteIntercambio() {
		setComando(Comando.INTERCAMBIAR);
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
		listaEnemigo.add(new String(desc));
	}
	
	public void setListaPersonaje(List<String> lista) {
		listaPersonaje.addAll(lista);
	}
	
	public void setListaEnemigo(List<String> lista) {
		listaEnemigo.addAll(lista);
	}

	public List<String> getListaPersonaje() {
		return listaPersonaje;
	}
	
	public List<String> getListaEnemigo() {
		return listaEnemigo;
	}
	
	public void reiniciarListas() {
		listaEnemigo.clear();
		listaPersonaje.clear();
	}
}
