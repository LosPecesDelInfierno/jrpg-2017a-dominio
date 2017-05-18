package dominio;

public class RandomGeneratorStub extends RandomGenerator {

	@Override
	public double nextDouble() {
		return 0.49;
	}

	@Override
	public int nextInt(int val) {
		return val - 1;
	}

}