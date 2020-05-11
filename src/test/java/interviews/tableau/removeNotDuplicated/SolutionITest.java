package interviews.tableau.removeNotDuplicated;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 1, 2, 3, 4, 5};
    final int[] expected = {1, 1, 2, 3, 4, 5};
    assertEquals(2, solution.removeNotDuplicated(input));
    assertArrayEquals(expected, input);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {2, 3, 4, 5, 1, 1};
    final int[] expected = {1, 1, 2, 3, 4, 5};
    assertEquals(2, solution.removeNotDuplicated(input));
    assertEquals(1, input[0]);
    assertEquals(1, input[1]);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}