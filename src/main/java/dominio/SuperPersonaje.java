package dominio;

public abstract class SuperPersonaje {

	protected int salud;
	protected String nombre;
	protected int fuerza;
	protected int defensa;
	protected int nivel;

	/**
	 * <h3>Constructor SuperPersonaje</h3>
	 * @param nombre personaje
	 * @param nivel personaje
	 */
	public SuperPersonaje(final String nombre, final int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}

	/**
	 * <h3>Obtener nombre personaje</h3>
	 * @return nombre personaje
	 */
	public String getNombre() {
		return nombre;
	} 								

	/**
	 * <h3>Setear nombre personaje</h3>
	 * @param nombre personaje
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	   * <h3>Método getSalud</h3>
	   * @return int salud
	   */ 
	public int getSalud() {
		return salud;
	}

	 /**
	   * <h3>Método setSalud</h3>
	   * @param salud del personaje
	   */ 
	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
   * <h3>Método despuesDeTurno</h3>
   */
	public void despuesDeTurno() { }
	/**
   * <h3>Método getFuerza</h3>
   * @return int fuerza
   */
	public int getFuerza() {
		return fuerza;
	}
	/**
   * <h3>Método setFuerza</h3>
   * @param fuerza del personaje
   */
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}
	/**
   * <h3>Método getDefensa</h3>
   * @return int defensa
   */
	public int getDefensa() {
		return defensa;
	}
	/**
   * <h3>Método setDefensa</h3>
   * @param defensa del personaje
   */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}
	 /**
   * <h3>Método estaVivo</h3>
   * @return boolean
   */
	public boolean estaVivo() {
		return salud > 0;
	}
	/**
   * <h3>Método getNivel</h3>
   * @return nivel
   */
	public int getNivel() {
		return nivel;
	}
	/**
   * <h3>Método setNivel</h3>
   * @param nivel del personaje
   */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

}
