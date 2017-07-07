package dominio;

import java.util.HashMap;
import java.util.Map;

public abstract class SuperPersonaje {

	protected int salud;
	protected String nombre;
	protected int fuerza;
	protected int defensa;
	protected int bonusFuerza;
	protected int bonusSalud;
	protected int nivel;
	protected RandomGenerator randomGenerator;
	
	
	/**
	 * <h3>Constructor SuperPersonaje</h3>
	 * 
	 * @param nombre
	 *            personaje
	 * @param nivel
	 *            personaje
	 */
	public SuperPersonaje(final String nombre, final int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.randomGenerator = new MyRandom();
	}

	public void setRandomGenerator(RandomGenerator randomGenerator) {
		this.randomGenerator = (RandomGeneratorStub) randomGenerator;
	}

	/**
	 * <h3>Obtener nombre personaje</h3>
	 * 
	 * @return nombre personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <h3>Setear nombre personaje</h3>
	 * 
	 * @param nombre
	 *            personaje
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	public int getFuerzaBase() {
	  return fuerza;
	}
	
	/**
	 * <h3>Método getSalud</h3>
	 * 
	 * @return int salud
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * <h3>Método despuesDeTurno</h3>
	 */
	public void despuesDeTurno() {
	}

	/**
	 * <h3>Método getFuerza</h3>
	 * 
	 * @return int fuerza
	 */
	public int getFuerza() {
		return fuerza + bonusFuerza;
	}

	/**
	 * <h3>Método getDefensa</h3>
	 * 
	 * @return int defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * <h3>Método mejorarDefensa</h3>
	 * <p>
	 * Aumenta el nivel de defensa del personaje
	 * </p>
	 * 
	 * @param aumento
	 *            de nivel de defensa del personaje
	 */
	public void mejorarDefensa(final int defensa) {
		this.defensa += defensa;
	}

	/**
	 * <h3>Método perderDefensa</h3>
	 * <p>
	 * Deja al personaje sin defensas
	 */
	public void perderDefensa() {
		this.defensa = 0;
	}

	/**
	 * <h3>Método estaVivo</h3>
	 * 
	 * @return boolean
	 */
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * <h3>Método getNivel</h3>
	 * 
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

}
