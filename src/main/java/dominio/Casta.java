package dominio;

import java.io.Serializable;
/**
 * <h3><u>Clase Abstracta Casta</u></h3>
 * Clase abstracta que define distintos tipos de miembros y métodos
 * heredables por aquellas clases que la extiendan.<p>
 * Contiene 3 métodos abstractos: habilidad1, habilidad2, habilidad3.
 * Contiene getters y setters.
 * (Implementa la interfaz Serializable)
 */
public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDanio;
	protected double danioCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * <h3>Constructor por defecto</h3>
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDanio = 0.2;
		this.danioCritico = 1.5;
	}
/**
 * <h3><u>Constructor Casta por parámetros</u></h3>
 * Asigna los parámetros indicados a cada miembro correspondiente de la clase.
 * @param probCrit Es un double que representa la probabilidad de dar un golpe crítico.
 * @param evasion Idem parámetro prob_crit pero para evitar un ataque.
 * @param danioCrit Double que representa el dañoCrítico deseado para la para casta en cracion.
 */
	public Casta(final double probCrit, final double evasion, final double danioCrit) {
		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDanio = evasion;
		this.danioCritico = danioCrit;
	}

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * <h3>Método getNombreCasta</h3>
	 * Método que devuelve el nombre de la casta
	 * @return
	 */
	public String getNombreCasta() {
		return this.nombreCasta;
	}

	/**
	 * <h3>Método getHabilidadesCasta</h3>
	 * Método que devuelve las habilidades que posee la casta
	 * @return
	 */
	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	/**
	 * <h3>Método getProbabilidadGolpeCritico</h3>
	 * Método que devuelve las probalidades de golpe critico
	 * @return
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * <h3>Método setProbabilidadGolpeCritico</h3>
	 * Método que setea la probalidad de colpe critico de una casta
	 * @param probabilidadGolpeCritico
	 */
	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

  /**
   * <h3>Método getProbabilidadEvitarDanio</h3>
   * Método que devuelve la probabilidad de evitar el danio de una casta
   * @return
   */
	public double getProbabilidadEvitarDanio() {
		return probabilidadEvitarDanio;
	}

	/**
	 * <h3>Método setProbabilidadEvitarDanio</h3>
	 * Métodoque setea la probabilidad que tiene ua casta de evitar un danio
	 * @param probabilidadEvitarDanio
	 */
	public void setProbabilidadEvitarDanio(final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

	/**
	 * <h3>Método getDanioCritico</h3>
	 * Método que devuelve el danio critico de una casta
	 * @return
	 */
	public double getDanioCritico() {
		return danioCritico;
	}

  /**
   * <h3><u>Método setter de dañoCrítico</u></h3>
   * Setea el dañoCrítico deseado para la casta mediante el parámetro recibido.
   * @param danioCritico Es el double que representa el nuevo dañoCrítico deseado
   */
	public void setDanioCritico(final double danioCritico) {
		this.danioCritico = danioCritico;
	}
}
