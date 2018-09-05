package interviews.linkedin.mianjing.randomGennerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/4/18
 */
class RandomGeneratorTest {
  private static final double DELTA = 1E-6;

  @Test
  void testOnlineCaseP4() {
    final RandomGenerator g = new RandomGenerator(0.4);
    final int[] count = new int[2];
    final int total = 1_000_000;
    for (int i = 0; i < total; ++i) {
      final int t = g.nextInt();
      count[t]++;
    }

    assertTrue(Math.abs(count[0] - count[1]) < total / 100);
  }

  @Test
  void testOnlineCaseP3() {
    final RandomGenerator g = new RandomGenerator(0.3);
    final int[] count = new int[2];
    final int total = 1_000_000;
    for (int i = 0; i < total; ++i) {
      final int t = g.nextInt();
      count[t]++;
    }

    assertTrue(Math.abs(count[0] - count[1]) < total / 100);
  }
}