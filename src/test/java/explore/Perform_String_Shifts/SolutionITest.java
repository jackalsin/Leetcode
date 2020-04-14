package explore.Perform_String_Shifts;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String s = "abc", expected = "cab";
    final int[][] shift = {{0, 1}, {1, 2}};
    assertEquals(expected, solution.stringShift(s, shift));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String s = "abcdefg", expected = "efgabcd";
    final int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
    assertEquals(expected, solution.stringShift(s, shift));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}