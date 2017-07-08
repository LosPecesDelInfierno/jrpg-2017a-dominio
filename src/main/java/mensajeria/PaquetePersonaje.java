package mensajeria;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dominio.AtributoModificable;
import dominio.Item;

/**
*
* <p>
* Clase que define el paquete donde estan los datos de los personajes
* </p>
*
*/
public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

  private int id;
  private String idUsuario;
  private int idMapa;
  private int estado;
  private String casta;
  private String nombre;
  private String raza;
  private int saludTope;
  private int energiaTope;
  private int fuerza;
  private int destreza;
  private int inteligencia;
  private int nivel;
  private int experiencia;
  private boolean ganoBatalla;
  private Map<Integer, Item> inventario = new HashMap<Integer, Item>();

  private int bonusFuerza;
  private int bonusSalud;
  private int bonusInteligencia;
  private int bonusEnergia;
  private int bonusDestreza;

	/**
	 * <h3>Contructor de PaquetePersonaje</h3>
	 */
	public PaquetePersonaje() {
    estado = 0; // Estado.estadoOffline;
  }

	/**
	 * <h3>Metodo getBonusFuerza</h3>
	 *
	 * @return bonusFuerza
	 */
  public int getBonusFuerza() {
    return this.bonusFuerza;
  }

	/**
	 * <h3>Metodo getBonusSalud</h3>
	 *
	 * @return bonusSalud
	 */
  public int getBonusSalud() {
    return this.bonusSalud;
  }

	/**
	 * <h3>Metodo getBonusInteligencia</h3>
	 *
	 * @return bonusInteligencia
	 */
  public int getBonusInteligencia() {
    return this.bonusInteligencia;
  }

	/**
	 * <h3>Metodo getBonusEnergia</h3>
	 *
	 * @return bonusEnergia
	 */
  public int getBonusEnergia() {
    return this.bonusEnergia;
  }

	/**
	 * <h3>Metodo getBonusDestreza</h3>
	 *
	 * @return bonusDestreza
	 */
  public int getBonusDestreza() {
    return this.bonusDestreza;
  }

	/**
	 * <h3>Metodo getFuerzaBase</h3>
	 *
	 * @return fuerza
	 */
  public int getFuerzaBase() {
    return this.fuerza;
  }

	/**
	 * <h3>Metodo getSaludBase</h3>
	 *
	 * @return saludTope
	 */
  public int getSaludBase() {
    return this.saludTope;
  }

	/**
	 * <h3>Metodo getEnergiaBase</h3>
	 *
	 * @return energiaTope
	 */
  public int getEnergiaBase() {
    return this.energiaTope;
  }

	/**
	 * <h3>Metodo getDestrezaBase</h3>
	 *
	 * @return destreza
	 */
  public int getDestrezaBase() {
    return this.destreza;
  }

	/**
	 * <h3>Metodo getInteligenciaBase</h3>
	 *
	 * @return inteligencia
	 */
  public int getInteligenciaBase() {
    return this.inteligencia;
  }

	/**
	 * <h3>Metodo getEstado</h3>
	 *
	 * @return estado
	 */
  public int getEstado() {
    return estado;
  }

  public void setEstado(final int estado) {
    this.estado = estado;
  }

	/**
	 * <h3>Metodo getMapa</h3>
	 *
	 * @return idMapa
	 */
  public int getMapa() {
    return idMapa;
  }

	/**
	 * <h3>Metodo setMapa</h3>
	 *
	 * @param mapa del paquete
	 */
  public void setMapa(final int mapa) {
    idMapa = mapa;
  }

	/**
	 * <h3>Metodo getNivel</h3>
	 *
	 * @return nivel
	 */
  public int getNivel() {
    return nivel;
  }

	/**
	 * <h3>Metodo setNivel</h3>
	 *
	 * @param nivel del personaje
	 */
  public void setNivel(final int nivel) {
    this.nivel = nivel;
  }

	/**
	 * <h3>Metodo getExperiencia</h3>
	 *
	 * @return experiencia
	 */
  public int getExperiencia() {
    return experiencia;
  }

	/**
	 * <h3>Metodo setExperiencia</h3>
	 *
	 * @param experiencia del personaje
	 */
  public void setExperiencia(final int experiencia) {
    this.experiencia = experiencia;
  }

	/**
	 * <h3>Metodo getId</h3>
	 *
	 * @return id
	 */
  public int getId() {
    return id;
  }

	/**
	 * <h3>Metodo setId</h3>
	 *
	 * @param id del personaje
	 */
  public void setId(final int id) {
    this.id = id;
  }

	/**
	 * <h3>Metodo getCasta</h3>
	 *
	 * @return casta
	 */
  public String getCasta() {
    return casta;
  }

	/**
	 * <h3>Metodo setCasta</h3>
	 *
	 * @param casta del personaje
	 */
  public void setCasta(final String casta) {
    this.casta = casta;
  }

	/**
	 * <h3>Metodo getNombre</h3>
	 *
	 * @return nombre
	 */
  public String getNombre() {
    return nombre;
  }

	/**
	 * <h3>Metodo setNombre</h3>
	 *
	 * @param nombre del personaje
	 */
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }

	/**
	 * <h3>Metodo getRaza</h3>
	 *
	 * @return raza
	 */
  public String getRaza() {
    return raza;
  }

	/**
	 * <h3>Metodo setRaza</h3>
	 *
	 * @param raza del personaje
	 */
  public void setRaza(final String raza) {
    this.raza = raza;
  }

	/**
	 * <h3>Metodo getSaludTope</h3>
	 *
	 * @return saludTope + bonusSalud
	 */
  public int getSaludTope() {
    return saludTope + bonusSalud;
  }

	/**
	 * <h3>Metodo setSaludTope</h3>
	 *
	 * @param saludTope del personaje
	 */
  public void setSaludTope(final int saludTope) {
    this.saludTope = saludTope;
  }

	/**
	 * <h3>Metodo getEnergiaTope</h3>
	 *
	 * @return energiaTope + bonusEnergia
	 */
  public int getEnergiaTope() {
    return energiaTope + bonusEnergia;
  }

	/**
	 * <h3>Metodo setEnergiaTope</h3>
	 *
	 * @param energiaTope del personaje
	 */
  public void setEnergiaTope(final int energiaTope) {
    this.energiaTope = energiaTope;
  }

	/**
	 * <h3>Metodo getFuerza</h3>
	 *
	 * @return fuerza + bonusFuerza
	 */
  public int getFuerza() {
    return fuerza + bonusFuerza;
  }

	/**
	 * <h3>Metodo setFuerza</h3>
	 *
	 * @param fuerza del personaje
	 */
  public void setFuerza(final int fuerza) {
    this.fuerza = fuerza;
  }

	/**
	 * <h3>Metodo getDestreza</h3>
	 *
	 * @return destreza + bonusDestreza
	 */
  public int getDestreza() {
    return destreza + bonusDestreza;
  }

	/**
	 * <h3>Metodo setDestreza</h3>
	 *
	 * @param destreza del personaje
	 */
  public void setDestreza(final int destreza) {
    this.destreza = destreza;
  }

	/**
	 * <h3>Metodo getInteligencia</h3>
	 *
	 * @return inteligencia + bonusInteligencia
	 */
  public int getInteligencia() {
    return inteligencia + bonusInteligencia;
  }

	/**
	 * <h3>Metodo setInteligencia</h3>
	 *
	 * @param inteligencia del personaje
	 */
  public void setInteligencia(final int inteligencia) {
    this.inteligencia = inteligencia;
  }

	/**
	 * <h3>Metodo ganoBatalla</h3>
	 *
	 * @return ganoBatalla
	 */
  public boolean ganoBatalla() {
    return this.ganoBatalla;
  }

	/**
	 * <h3>Metodo setGanoBatalla</h3>
	 *
	 * @param val de la batalla
	 */
  public void setGanoBatalla(final boolean val) {
    this.ganoBatalla = val;
  }

	/**
	 * <h3>Metodo getUsuario</h3>
	 *
	 * @return idUsuario
	 */
  public String getUsuario() {
    return this.idUsuario;
  }

	/**
	 * <h3>Metodo setUsuario</h3>
	 *
	 * @param setUsuario del personaje
	 */
  public void setUsuario(final String usuario) {
    this.idUsuario = usuario;
  }

	/**
	 * <h3>Metodo clone</h3>
	 *
	 * @return Object
	 */
  public Object clone() {
    Object obj = null;
    obj = super.clone();
    return obj;
  }

	/**
	 * <h3>Metodo equipar</h3>
	 *
	 * @param items a equipar
	 */
  public void equipar(List<Item> items) {
    for (Item item : items) {
      this.agregarItem(item);
    }
    calcularBonusItems();
  }

	/**
	 * <h3>Metodo agregarItem</h3>
	 *
	 * @param item del personaje
	 */
  public void agregarItem(Item item) {
    this.inventario.put(item.getIdTipoItem(), item);
    calcularBonusItems();
  }

	/**
	 * <h3>Metodo calcularBonusItems</h3>
	 */
  private void calcularBonusItems() {
    reiniciarBonusItems();
    for (Item item : inventario.values()) {
      this.incrementarAtributos(item);
    }
  }

	/**
	 * <h3>Metodo incrementarAtributos</h3>
	 *
	 * @param item incrementador
	 */
  private void incrementarAtributos(Item item) {
    this.bonusFuerza += item.incrementar(this.fuerza, AtributoModificable.FUERZA);
    this.bonusSalud += item.incrementar(this.saludTope, AtributoModificable.SALUD);
    this.bonusInteligencia += item.incrementar(this.inteligencia, AtributoModificable.INTELIGENCIA);
    this.bonusDestreza += item.incrementar(this.destreza, AtributoModificable.DESTREZA);
    this.bonusEnergia += item.incrementar(this.energiaTope, AtributoModificable.ENERGIA);
  }

	/**
	 * <h3>Metodo incrementarAtributos</h3>
	 */
  private void reiniciarBonusItems() {
    this.bonusFuerza = 0;
    this.bonusSalud = 0;
    this.bonusInteligencia = 0;
    this.bonusDestreza = 0;
    this.bonusEnergia = 0;
  }

	/**
	 * <h3>Metodo incrementarAtributos</h3>
	 * 
	 * @return inventario.values()
	 */
  public Collection<Item> getInventario() {
    return this.inventario.values();
  }
  
	/**
	 * <h3>Metodo getItem</h3>
	 *
	 * @return inventario.get(tipo)
	 */
  public Item getItem(int tipo) {
	  return inventario.get(tipo);
  }
  
  public Item extraerItem(int tipo) {
	  Item aux = inventario.remove(tipo);
	  calcularBonusItems();
	  return aux;
  }
}
