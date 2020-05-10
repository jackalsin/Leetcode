package _0451_0500._470_Implement_Rand10_Using_Rand7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvanceSolutionITest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new AdvanceSolutionI(),
        new Lee215Solution()
    );
  }

  private static final int MAX_COUNT = 10_000_000;

  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] counts = new int[11];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.rand10()]++;
    }

    for (int i = 1; i <= 10; ++i) {
      assertEquals(0.1d, counts[i] / (double) MAX_COUNT, BIAS);
    }
  }

}