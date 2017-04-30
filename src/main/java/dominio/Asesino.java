package dominio;
/**
 * 
 * Clase que define a un tipo Asesino, la misma hereda de la clase 
 * abstracta Casta por lo que se definen los métodos abstractos declarados en Casta y 
 * se define al nombreCasta como "Asesino".
 *
 */
public class Asesino extends Casta {

	public Asesino(double prob_crit, double evasion, double danio_crit) {
		super(prob_crit, evasion, danio_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	// Golpe Crítico
	/**
	 * <h3><u>Golpe Critico</u></h3>
	 * Implementacion del método abstracto habilidad1 declarado en la clase abstracta Casta.<p>
	 * En este caso el método es el encargado de producir un Golpe Critico 
	 * por parte de un asesino hacia un objeto Peleable.<br>
	 * Nótese que en este caso el Personaje (Asesino) que ataca es parámetro.
	 * @param caster De tipo Personaje (Asesino) encargado de obtener y setear energías.
	 * @param atacado De tipo Peleable a ser atacado por el Asesino.
	 * @return Si el caster tiene suficiente energia para realizar el ataque devuelve un boolean true, caso 
	 * contrario devuelve false.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanioCritico())) > 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	/**
	 * <h3><u>Aumentar Evasión</u></h3>
	 * Se redefine el método abstracto habilidad2 heredado.<p>
	 * El objetivo de dicho método es el de aumentar la probabilidad de evasión de 
	 * los personajes pertenecientes a dicha casta. (Asesinos)
	 * @param caster De tipo Personaje encargado de obtener y setear energías.
	 * @param atacado De tipo Peleable (no se utiliza)
	 * @return boolean, true en caso de poder aumentar la evasion, false en caso contrario.
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDanio() + 0.15 < 0.5)
				this.probabilidadEvitarDanio += 0.15;
			else
				this.probabilidadEvitarDanio = 0.5;
			return true;
		}
		return false;
	}

	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
