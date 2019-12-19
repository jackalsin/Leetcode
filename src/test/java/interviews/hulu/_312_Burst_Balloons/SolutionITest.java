package interviews.hulu._312_Burst_Balloons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void onlineCase(Solution solution) throws Exception {
    final int[] input = {3, 1, 5, 8};
    assertEquals(167, solution.maxCoins(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}