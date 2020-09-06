package _0801_0850._845_Longest_Mountain_in_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int input[] = {2, 1, 4, 7, 3, 2, 5}, expected = 5, actual = solution.longestMountain(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int input[] = {2, 2, 2}, expected = 0, actual = solution.longestMountain(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int input[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, expected = 0, actual = solution.longestMountain(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new StateSolution()
    );
  }
}