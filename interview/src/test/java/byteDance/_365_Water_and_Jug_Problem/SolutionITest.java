package byteDance._365_Water_and_Jug_Problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    assertTrue(solution.canMeasureWater(3, 5, 4));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    assertFalse(solution.canMeasureWater(2, 6, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    assertTrue(solution.canMeasureWater(0, 0, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedOnGcd(Solution solution) {
    assertTrue(solution.canMeasureWater(1, 2, 3));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}