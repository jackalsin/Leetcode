package interviews.google._939_Minimum_Area_Rectangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
    };
    assertEquals(4, solution.minAreaRect(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
    };
    assertEquals(2, solution.minAreaRect(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {1, 2}, {3, 2}, {1, 3}, {3, 3}, {3, 0}, {1, 4}, {4, 2}, {4, 0}
    };
    assertEquals(2, solution.minAreaRect(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}