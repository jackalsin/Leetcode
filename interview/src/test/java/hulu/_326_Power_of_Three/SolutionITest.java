package hulu._326_Power_of_Three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testAllPositive(Solution solution) throws Exception {
    int cur = 1;
    for (int i = 0; i <= 19; i++) {
      assertTrue(solution.isPowerOfThree(cur));
      cur *= 3;
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}