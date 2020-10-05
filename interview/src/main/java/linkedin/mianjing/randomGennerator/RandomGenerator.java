package linkedin.mianjing.randomGennerator;

public final class RandomGenerator {
  // https://stackoverflow.com/questions/1986859/unbiased-random-number-generator-using-a-biased-one
  private final BiasRandomGenerator g;

  public RandomGenerator(final double p) {
    g = new BiasRandomGenerator(p);
  }

  public int nextInt() {
    int x = g.nextInt(), y = g.nextInt();
    while (x == y) {
      x = g.nextInt();
      y = g.nextInt();
    }
    return x;
  }
}
