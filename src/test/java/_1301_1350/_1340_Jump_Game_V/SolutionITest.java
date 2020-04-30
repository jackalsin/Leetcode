package _1301_1350._1340_Jump_Game_V;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int arr[] = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, d = 2,
        expected = 4, actual = solution.maxJumps(arr, d);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int arr[] = {3, 3, 3, 3, 3}, d = 3,
        expected = 1, actual = solution.maxJumps(arr, d);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int arr[] = {7, 6, 5, 4, 3, 2, 1}, d = 1,
        expected = 7, actual = solution.maxJumps(arr, d);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int arr[] = {7, 1, 7, 1, 7, 1}, d = 2,
        expected = 2, actual = solution.maxJumps(arr, d);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int arr[] = {66}, d = 1,
        expected = 1, actual = solution.maxJumps(arr, d);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new ReverseJumpSolution()
    );
  }
}