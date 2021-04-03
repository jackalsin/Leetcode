package lime._850_Rectangle_Area_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int input[][] = {{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}},
        expected = 6, actual = solution.rectangleArea(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int input[][] = {{0, 0, 1000000000, 1000000000}},
        expected = 49, actual = solution.rectangleArea(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int input[][] = {{0, 1, 2, 2}, {1, 3, 2, 4}},
        expected = 3, actual = solution.rectangleArea(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}