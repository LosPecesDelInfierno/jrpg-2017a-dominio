package dominio;
import java.util.Random;

/**
 *
 * Clase encargada de la creacion de un pseudo-random.
 *
 */
public class MyRandom extends RandomGenerator {

	private Random random;
	/**
	 * <h3>Costructor por defecto</h3>
	 */
	public MyRandom() {
		this.random = new Random();
	}

	/**
	 * Genera un double
	 * @return Devuelve un double de valor aleatorio
	 */
	@Override
	public double nextDouble() {
		return this.random.nextDouble();
	}

	/**
	 * Genera un nuevo int a partir del int recibido.
	 * @param val Valor (int) en el que se basará para la creacion de un nuevo entero.
	 * @return int de valor menor que val.
	 */
	@Override
	public int nextInt(final int val) {
		return this.random.nextInt(val);
	}

}
