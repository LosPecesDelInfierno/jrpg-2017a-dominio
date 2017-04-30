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

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDanio() {
		return probabilidadEvitarDanio;
	}

	public void setProbabilidadEvitarDanio(final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

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
