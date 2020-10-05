package _1401_1450._1416_Restore_The_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase0(Solution solution) {
    final String s = "10";
    final int k = 10000, expected = 1, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "1000";
    final int k = 10000, expected = 1, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "1000";
    final int k = 10, expected = 0, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String s = "1317";
    final int k = 2000, expected = 8, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String s = "2020";
    final int k = 30, expected = 1, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String s = "1234567890";
    final int k = 90, expected = 34, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String s = "48486250454844645287030712560644579294181";
    final int k = 989, expected = 829496214, actual = solution.numberOfArrays(s, k);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution2D(),
        new DpSolution1D()
    );
  }
}