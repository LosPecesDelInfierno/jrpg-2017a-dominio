package dominio;
/**
 *
 * Clase encargada de la creacion de un pseudo-random.
 *
 */
public class MyRandom {

/**
 * Genera un double
 * @return Devuelve un double de valor {@literal 0.49}
 */
	public static double nextDouble() {
		return 0.49;
	}
	/**
	 * Se encarga de generar un nuevo int a partir del int recibido.
	 * @param val Valor (int) en el que se basará para la creacion de un nuevo entero.
	 * @return Devuelve un int de valor igual a (val-1);
	 */
	public static int nextInt(final int val) {
		return val - 1;
	}

}
