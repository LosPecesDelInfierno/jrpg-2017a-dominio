package mensajeria;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dominio.AtributoModificable;
import dominio.Item;

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

	public PaquetePersonaje() {
		estado = 0; // Estado.estadoOffline;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getMapa() {
		return idMapa;
	}

	public void setMapa(int mapa) {
		idMapa = mapa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCasta() {
		return casta;
	}

	public void setCasta(String casta) {
		this.casta = casta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getSaludTope() {
		return saludTope + bonusSalud;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope + bonusEnergia;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	public int getFuerza() {
		return fuerza + bonusFuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza  + bonusDestreza;
	}

	public int getInteligencia() {
		return inteligencia + bonusInteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public int getSaludBase() {
	  return this.saludTope;
	}
	
	public int getEnergiaBase() {
    return this.energiaTope;
  }
	
	public int getFuerzaBase() {
    return this.fuerza;
  }
	
	public int getDestrezaBase() {
    return this.destreza;
  }
	
	public int getInteligenciaBase() {
    return this.inteligencia;
  }
	
	public boolean ganoBatalla() {
		return this.ganoBatalla;
	}
	
	public void setGanoBatalla(boolean val) {
		this.ganoBatalla = val;
	}
	
	public String getUsuario() {
		return this.idUsuario;
	}
	
	public void setUsuario(String usuario) {
		this.idUsuario = usuario;
	}

	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
	
	public void equipar(List<Item> items) {
	  for (Item item : items) {
      this.agregarItem(item);
    }
	  calcularBonusItems();
	}

	public void agregarItem(Item item) {
		this.inventario.put(item.getIdTipoItem(), item);
		calcularBonusItems();
	}
	
	private void calcularBonusItems() {
	  reiniciarBonusItems();
    for (Item item : inventario.values()) {
      this.incrementarAtributos(item);
    }
	}
	
	private void incrementarAtributos(Item item) {
    this.bonusFuerza += item.incrementar(this.fuerza, AtributoModificable.FUERZA);
    this.bonusSalud += item.incrementar(this.saludTope, AtributoModificable.SALUD);
    this.bonusInteligencia += item.incrementar(this.inteligencia, AtributoModificable.INTELIGENCIA);
    this.bonusDestreza += item.incrementar(this.destreza, AtributoModificable.DESTREZA);
    this.bonusEnergia += item.incrementar(this.energiaTope, AtributoModificable.ENERGIA);
  }
	
	private void reiniciarBonusItems() {
	  this.bonusFuerza = 0;
	  this.bonusSalud = 0;
	  this.bonusInteligencia = 0;
    this.bonusDestreza = 0;
    this.bonusEnergia = 0;
	}
	
	public Collection<Item> getInventario() {
	  return this.inventario.values();
	}
}
