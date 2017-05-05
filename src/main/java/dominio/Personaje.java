package dominio;

import java.io.Serializable;
/**
 *
 * <p>Clase abstracta encargada de definir los métodos y atributos de un Personaje.<br>
 * Implementa las interfaces Peleable y Serializable</p>
 *
 */
public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa; // depende de la destreza
	protected int ataque; // depende de la fuerza
	protected int magia; // depende de la inteligencia

	protected String nombre; // hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	/**
	 * <h3>Metodo getHabilidadesRaza</h3>
	 * metodo que devuelve las habilidades de raza que posee un personaje
	 * @return String habilidades de raza
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * <h3>Metodo getHabilidadesCasta</h3>
	 * metodo que devuelve las hhabilidades de casta que posee un personaje
	 * @return
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
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		casta.mejorarAtributos(this);

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

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

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

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
	 * <h3>Obtener nombre personaje</h3>
	 * @return nombre personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <h3>Setear nombre personaje</h3>
	 * @param nombre  del personaje
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
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
	 *<h3>Metodo getSalud</h3>
	 *Devuelve la salud que posee el personaje
	 *@return int salud 
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * <h3>Metodo setSalud</h3>
	 * @param salud a asignar al personaje
	 */
	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
	 * <h3>Metodo getEnergia</h3>
	 * devuelve la energia que posee el persoaje
	 * @return int energia
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * <h3>Metodo setEnergia</h3>
	 * @param energia a asignar al personaje
	 */
	public void setEnergia(final int energia) {
		this.energia = energia;
	}

	/**
	 * <h3>metodo getFuerza</h3>
	 * @return int fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * <h3>Metodo setFuerza</h3>
	 * @param fuerza a asignar al personaje
	 */
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * <h3>Metodo getDestreza</h3>
	 * @return int destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * <h3>Metodo setDestreza</h3>
	 * @param destreza a asignar al personaje 
	 */
	public void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	/**
	 * <h3>Metodo getInteligencia</h3>
	 * @return int inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * <h3>Metodo setInteligencia</h3>
	 * @param inteligencia a asignar al personaje
	 */
	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * <h3>Metodo getCasta</h3>
	 * @return int casta
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * <h3>Metodo setCasta</h3>
	 * @param casta a asignar al personaje
	 */
	public void setCasta(final Casta casta) {
		this.casta = casta;
	}

	/**
	 * <h3>Metoodo getExperiencia</h3>
	 * @return int experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * <h3>Metoodo setExperiencia</h3>
	 * @param experiencia a asignar al personaje
	 */
	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * <h3>Metodo getNivel</h3>
	 * @return int nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * <h3>Metodo setNivel</h3>
	 * @param nivel a asignar al personaje
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * <h3>Metodo getIdPersonaje</h3>
	 * @return int idPersonaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * <h3>Metodo setIdPersonaje</h3>
	 * @param idPersonaje del personaje
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	/**
	 * <h3>Metodo getDefensa</h3>
	 * @returnint defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * <h3>Metodo setDefensa</h3>
	 * @param defensa a asiganr al personaje
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * <h3>Metodo getSaludTope</h3>
	 * @return int saludTope
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * <h3>Metodo setSaludTope</h3>
	 * @param saludTope que va a poseer el personaje
	 */
	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * <h3>Metodo getEnergiaTope</h3>
	 * @return int energiaTope
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * <h3>Metodo setEnergiaTope</h3>
	 * @param energiaTope que va a poseer el personaje
	 */
	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
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
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
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
	 * <h3>Metodo despues de Turno</h3>
	 */
	public void despuesDeTurno() {

	}

	/**
	 * <h3>Metodo puedeAtacar</h3>
	 * @return boolean atacar / no atacar
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
	 * <h3>Metodo estaVivo</h3>
	 * @return boolean esta o no vivo
	 */
	public boolean estaVivo() {
		return salud > 0;
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
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDanio()) {
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
	 * 
	 * @param danio
	 * @return
	 */
	public int serDesernegizado(final int danio) {
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
	 * 
	 * @param salud
	 */
	public void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}

	/**
	 * 
	 * @param energia
	 */
	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}
	}

	/**
	 * 
	 * @param nombreAlianza
	 */
	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.anadirPersonaje(this);
	}

	/**
	 * 
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * 
	 * @param nuevoAliado
	 * @return
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
	 * 
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 */
	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
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
	 * 
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
	 * 
	 * @param exp
	 * @return
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
	 * 
	 */
	public int otorgarExp() {
		return this.nivel * 40;
	}

	/**
	 * 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * 
	 * @param atacado
	 * @return
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * 
	 * @param atacado
	 * @return
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
	 * 
	 * @param atacado
	 * @return
	 */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * 
	 * @param atacado
	 * @return
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);

	/**
	 * 
	 * @param atacado
	 * @return
	 */
	public abstract boolean habilidadRaza2(Peleable atacado);
}
