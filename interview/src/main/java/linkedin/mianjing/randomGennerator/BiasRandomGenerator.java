package linkedin.mianjing.randomGennerator;

import java.util.Random;

public final class BiasRandomGenerator {
  private final double p;
  private final Random random = new Random();

  public BiasRandomGenerator(final double p) {
    this.p = p;
  }

  public int nextInt() {
    return random.nextDouble() < p ? 0 : 1;
  }
}
