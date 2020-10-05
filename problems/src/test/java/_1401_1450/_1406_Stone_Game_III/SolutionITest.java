package _1401_1450._1406_Stone_Game_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] values = {1, 2, 3, 7};
    final String expected = "Bob", actual = solution.stoneGameIII(values);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] values = {1, 2, 3, -9};
    final String expected = "Alice", actual = solution.stoneGameIII(values);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] values = {1, 2, 3, 6};
    final String expected = "Tie", actual = solution.stoneGameIII(values);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] values = {1, 2, 3, -1, -2, -3, 7};
    final String expected = "Alice", actual = solution.stoneGameIII(values);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[] values = {-1, -2, -3};
    final String expected = "Tie", actual = solution.stoneGameIII(values);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionII()
    );
  }
}