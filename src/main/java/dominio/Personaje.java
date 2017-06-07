package dominio;

import java.io.Serializable;

import mensajeria.PaqueteAtacar;
/**
 *
 * <p>Clase abstracta encargada de definir los métodos y atributos de un Personaje.<br>
 * Implementa las interfaces Peleable y Serializable</p>
 *
 */
public abstract class Personaje extends SuperPersonaje implements Peleable, Serializable {

	protected int energia;
	protected int ataque; // depende de la fuerza
	protected int magia; // depende de la inteligencia
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	/**
	 * <h3>Metodo getHabilidadesRaza</h3>
	 * @return String[] habilidades
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * <h3>Metodo getHabilidadesCasta</h3>
	 * metodo que devuelve las hhabilidades de casta que posee un personaje
	 * @return String casta
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * <h3>Cargar tabla de niveles</h3>
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
		}
	}

	/**
	 * <h3>Contructor de Personaje</h3>
	 * @param nombre del personaje
	 * @param casta del personaje
	 * @param id del personaje
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		super(nombre, 1);	//nivel = 1;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		fuerza = 10 + casta.getBonusFuerza();
		inteligencia = 10 + casta.getBonusInteligencia();
		destreza = 10 + casta.getBonusDestreza();

		x = 0;
		y = 0;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
		saludTope = 100;
		energiaTope = 100;

	}

	@Override
	public boolean sufreDanioExtra() {
		return true;
	}

	/**
	 * <h3>Contructor de Personaje</h3>
	 * @param nombre del personaje
	 * @param salud del personaje
	 * @param energia del personaje
	 * @param fuerza del personaje
	 * @param destreza del personaje
	 * @param inteligencia del personaje
	 * @param casta del personaje
	 * @param experiencia del personaje
	 * @param nivel del personaje
	 * @param idPersonaje del personaje
	 */
	public Personaje(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {
		super(nombre, nivel);

		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;


		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * <h3>Obtener nombre raza</h3>
	 * @return nombreRaza del personaje
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * <h3>Setear nombre raza</h3>
	 * @param nombreRaza nombre de raza del personaje
	 */
	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * <h3>Obtener ataque de personaje</h3>
	 * @return ataque del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * <h3>setear araque del personaje</h3>
	 * @param ataque del personaje
	 */
	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/**
	 * <h3>Metodo getMagia</h3>
	 * @return int magia del personaje
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * <h3>Metodo setMagia</h3>
	 * @param magia magia a asignar al personaje
	 */
	public void setMagia(final int magia) {
		this.magia = magia;
	}

	/**
	 * <h3>Metodo getClan</h3>
	 * @return Alianza clan al que pertenece el personaje
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * <h3Metodo setClan</h3>
	 * @param clan al que va a pertenecer el personaje
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.anadirPersonaje(this);
	}

	/**
	 * <h3>Metodo getEnergia</h3>
	 * @return int energia
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * <h3>Metodo getDestreza</h3>
	 * @return int destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * <h3>Metodo getInteligencia</h3>
	 * @return int inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * <h3>Metodo getCasta</h3>
	 * @return int casta
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * <h3>Metoodo getExperiencia</h3>
	 * @return int experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * <h3>Metodo getIdPersonaje</h3>
	 * @return int idPersonaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * <h3>Metodo getSaludTope</h3>
	 * @return int saludTope
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * <h3>Metodo getEnergiaTope</h3>
	 * @return int energiaTope
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

/**
 * <h3><u>Método Atacar</u></p>
 * <p>Este método recibirá un objeto del tipo Peleable al cual, el objeto llamador (un Personaje) intentará atacar.<br>
 * En caso de no poder concretar dicho ataque se retornará un int de valor 0. Si es posible el ataque, se procederá
 * y se retornará un int distinto de cero.</p>
 * @param atacado Es un Objeto del tipo Peleable al cual se intenta atacar.
 * @return En caso de No poder concretar el ataque devuelve un cero, caso contrario
 * devuelve un entero distinto de cero.
 */
	public int atacar(final Peleable atacado) {
		if (salud == 0) {
			return 0;
		}
		if (atacado.getSalud() > 0) {
			if (randomGenerator.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpeCritico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/**
	 * <h3>Metodo golpeCritico</h3>
	 * @return int valor del golpe critico
	 */
	public int golpeCritico() {
		return (int) (this.ataque * this.getCasta().getDanioCritico());
	}

	/**
	 * <h3>Metodo puedeAtacar</h3>
	 * @return boolean true/false
	 */
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * <h3>Metodo calcularPuntosDeAtaque</h3>
	 * @return int posibles puntos de ataque
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	/**
	 * <h3>Metodo calcularPuntosDeDefensa</h3>
	 * @return int posibles puntos de defensa
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * <h3>Metodo calcualrPuntosDeMagia</h3>
	 * @return int puntos de inteligencia
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	/**
	 * <h3>Metodo restablecerSalud</h3>
	 * restablece la salud del personaje
	 */
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	/**
	 * <h3>Metodo restablecerEnergia</h3>
	 * restablece la enegia del personaje
	 */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * <h3>Metodo modificarAtributos</h3>
	 * modifica los atributos del personaje
	 */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

/**
 * <h3><u>Método serAtacado </u><h3>
 * <p>Este método será el encargado de proceder a dañar al objeto llamador.<br>
 * Recibirá el daño que se pretende recibir para luego de distintas evaluaciones concretar el ataque recibido.</p>
 * <p>En caso que se pueda evitar el ataque recibido ya sea por defensa oprobabilidad
 * de evitarlo, el método devolverá un cero.
 * Caso contrario se procede a recibir el ataque y luego retornar el daño final.</p>
 * @param danio Es el daño que se pretende recibir (int).
 * @return Se devuelve un int representando el daño recibido (si NO hubo daño sera cero).
 */
	public int serAtacado(final int danio) {
	  int auxDanio = danio;
		if (randomGenerator.nextDouble() >= this.getCasta().getProbabilidadEvitarDanio()) {
		  auxDanio -= this.defensa;
			if (auxDanio > 0) {
				if (salud <= auxDanio) {
					auxDanio = salud;
					salud = 0;
				} else {
					salud -= auxDanio;
				}
				return auxDanio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * <h3>Metodo serRobadoSalud</h3>
	 * @param danio a recibir
	 * @return int danio
	 */
	public int serRobadoSalud(final int danio) {
	  int auxDanio = danio;
	  auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((salud - auxDanio) >= 0) {
			salud -= auxDanio;
		} else {
		  auxDanio = salud; // le queda menos salud que el daño inflingido
			salud = 0;
		}
		return auxDanio;
	}

	/**
	 * <h3>Metodo serDesenergizado</h3>
	 * @param danio recibido
	 * @return int danio
	 */
	public int serDesenergizado(final int danio) {
	  int auxDanio = danio;
	  auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((this.energia - auxDanio) >= 0) {
			this.energia -= auxDanio;
		} else {
		  auxDanio = energia; // le queda menos energia que el daño inflingido
			this.energia = 0;
		}
		return auxDanio;
	}

	/**
	 * <h3>Metodo serCurado</h3>
	 * @param salud a recuperar
	 */
	public void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}

	/**
	 * <h3>Metodo serEnergizado</h3>
	 * @param energia a recibir
	 */
	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}
	}

	/**
	 * <h3>Metodo crearAlianza</h3>
	 * @param nombreAlianza que se va a crear
	 */
	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.anadirPersonaje(this);
	}

	/**
	 * <h3>Metodo salirDeAlianza</h3>
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * <h3>Metodo aliar</h3>
	 * @param nuevoAliado a agregar en la alianza
	 * @return boolean true/false
	 */
	public boolean aliar(Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.anadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.anadirPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <h3>Metodo asignarPuntosSkills</h3>
	 * @param fuerza pj
	 * @param destreza pj
	 * @param inteligencia pj
	 */
	public void asignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.fuerza + fuerza <= 200) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= 200) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= 200) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * <h3>Metodo subirNivel</h3>
	 */
	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * <h3>Metodo ganarExperiencia</h3>
	 * @param exp a asignar
	 * @return boolean true/false
	 */
	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * <h3>Metodo otorgarExp</h3>
	 */
	public int otorgarExp() {
		return this.nivel * 40;
	}

	/**
	 * <h3>Sobrecarga metodo clone</h3>
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * <h3>DistanciaCon</h3>
	 * @param p personaje
	 * @return double distancia
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * <h3>Metodo habilidadCasta1</h3>
	 * @param atacado Peleable
	 * @return boolean true/false
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * <h3>habilidadCasta2</h3>
	 * @param atacado Peleable
	 * @return boolean true/false
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
   * <h3>habilidadCasta3</h3>
   * @param atacado Peleable
   * @return boolean true/false
   */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
   * <h3>habilidadRaza1</h3>
   * @param atacado Peleable
   * @return boolean true/false
   */
	public abstract boolean habilidadRaza1(Peleable atacado);

	/**
   * <h3>habilidadRaza2</h3>
   * @param atacado Peleable
   * @return boolean true/false
   */
	public abstract boolean habilidadRaza2(Peleable atacado);
	
	/**
	 * <h3>Metodo setearAtributosRaza</h3>
	 * @param salud raza
	 * @param energia raza
	 * @param nRaza raza
	 */
	public void setearAtributosRaza(int salud, int energia, String nRaza) {
		saludTope += salud;
		energiaTope += energia;
		nombreRaza = nRaza;
		this.salud = saludTope;
		this.energia = energiaTope;
	}
	
	/**
	 * <h3>metodo refreshAtacado</h3>
	 * <p>Refresca el estado del personaje atacado a partir de un PaqueteAtacar
	 * enviado desde otro cliente</p>
	 * @param paquete
	 */
	public void refreshAtacado(PaqueteAtacar paquete) {
		this.salud = paquete.getNuevaSaludEnemigo();
		this.energia = paquete.getNuevaEnergiaEnemigo();
	}
	
	/**
	 * <h3>metodo refreshAtacado</h3>
	 * <p>Refresca el estado del personaje atacante a partir de un PaqueteAtacar
	 * enviado desde otro cliente</p>
	 * @param paquete
	 */
	public void refreshAtacante(PaqueteAtacar paquete) {
		this.salud = paquete.getNuevaSaludPersonaje();
		this.energia = paquete.getNuevaEnergiaPersonaje();
	}

}
