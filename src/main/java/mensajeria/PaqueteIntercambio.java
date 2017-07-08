package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Paquete Utilizado a la hora de hacer Intercambios
 *
 */
public class PaqueteIntercambio extends Paquete implements Serializable, Cloneable {

	private String nombre;
	private int id;
	private int idEnemigo;
	private boolean[] objetosPersonaje = {false, false, false, false, false, false, false, false };
	private boolean[] objetosEnemigo = {false, false, false, false, false, false, false, false };
	private List<String> listaPersonaje = new ArrayList<>();
	private List<String> listaEnemigo = new ArrayList<>();
	/**
	 * Constructor PaqueteIntercambio.
	 * setComando(Comando.INTERCAMBIAR)
	 */
	public PaqueteIntercambio() {
		setComando(Comando.INTERCAMBIAR);
	}
	/**
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *
	 * @param nombre String
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	/**
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *
	 * @param id int
	 */
	public void setId(final int id) {
		this.id = id;
	}
	/**
	 *
	 * @return idEnemigo
	 */
	public int getIdEnemigo() {
		return idEnemigo;
	}
	/**
	 * seteo id enemigo
	 * @param idEnemigo int
	 */
	public void setIdEnemigo(final int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
	/**
	 * Setea objetosPersona[idx] = seleccion
	 * @param idx int
	 * @param seleccion boolean
	 */
	public void setSeleccionadoPersonaje(final int idx, final boolean seleccion) {
		this.objetosPersonaje[idx] = seleccion;
	}
	/**
	 *
	 * @param idx int
	 * @return objetosPersonaje[idx]
	 */
	public boolean getSeleccionadoPersonaje(final int idx) {
		return objetosPersonaje[idx];
	}
	/**
	 *
	 * @param idx int
	 * @param seleccion boolean
	 */
	public void setSeleccionadoEnemigo(final int idx, final boolean seleccion) {
		this.objetosEnemigo[idx] = seleccion;
	}
	/**
	 *
	 * @param idx int
	 * @return objetosEnemgio[idx]
	 */
	public boolean getSeleccionadoEnemigo(final int idx) {
		return objetosEnemigo[idx];
	}
	/**
	 * Agrega descripcion Personaje en lista
	 * @param desc String
	 */
	public void addDescripcionPersonaje(final String desc) {
		listaPersonaje.add(desc);
	}
	/**
	 * Agrega descripcion enemigo en listaEnemigo
	 * @param desc String
	 */
	public void addDescripcionEnemigo(final String desc) {
		listaEnemigo.add(new String(desc));
	}
	/**
	 * Agrega a lista personaje el param lista
	 * @param lista list<String>
	 */
	public void setListaPersonaje(final List<String> lista) {
		listaPersonaje.addAll(lista);
	}
	/**
	 * Agrega a lista enemigo el param lista
	 * @param lista list<String>
	 */
	public void setListaEnemigo(final List<String> lista) {
		listaEnemigo.addAll(lista);
	}
	/**
	 *
	 * @return listaPersonaje
	 */
	public List<String> getListaPersonaje() {
		return listaPersonaje;
	}
	/**
	 * devuelve lista enemigo
	 * @return listaEnemigo
	 */
	public List<String> getListaEnemigo() {
		return listaEnemigo;
	}
	/**
	 * Reinicia las listas
	 */
	public void reiniciarListas() {
		listaEnemigo.clear();
		listaPersonaje.clear();
	}
}
