package interviews.hulu._326_Power_of_Three;

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
  @MethodSource("solutionProvider")
  public void testAllPositive(Solution solution) throws Exception {
    int cur = 1;
    for (int i = 0; i <= 19; i++) {
      assertTrue(solution.isPowerOfThree(cur));
      cur *= 3;
    }
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}