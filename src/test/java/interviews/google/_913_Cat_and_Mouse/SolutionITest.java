package interviews.google._913_Cat_and_Mouse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/12/2020
 */
class SolutionITest {

  @Disabled
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}
    };
    assertEquals(0, solution.catMouseGame(input));
  }

  @Disabled
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {6}, {4, 11}, {9, 12}, {5}, {1, 5, 11}, {3, 4, 6}, {0, 5, 10}, {8, 9, 10}, {7}, {2, 7, 12}, {6, 7}, {1, 4},
        {2, 9}
    };
    assertEquals(1, solution.catMouseGame(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}