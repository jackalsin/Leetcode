package _451_500._470_Implement_Rand10_Using_Rand7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NaiveSolutionTest {
  private Solution solution;
  private static final int MAX_COUNT = 10_000_000;
  private static final double BIAS = 1E-3;

  @BeforeEach
  void setup() {
    solution = new NaiveSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] counts = new int[11];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.rand10()]++;
    }
//    System.out.println(Arrays.toString(counts));
    for (int i = 1; i <= 10; ++i) {
      assertEquals(0.1d, counts[i] / (double) MAX_COUNT, BIAS);
    }
  }

}