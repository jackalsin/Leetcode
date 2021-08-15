package _1251_1300._1284_Minimum_Number_of_Flips_to_Convert_Binary_Matrix_to_Zero_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] mat = {
        {0, 0},
        {0, 1}};
    final int expected = 3, actual = solution.minFlips(mat);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] mat = {{0}};
    final int expected = 0, actual = solution.minFlips(mat);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] mat = {
        {1, 1, 1}, {1, 0, 1}, {0, 0, 0}};
    final int expected = 6, actual = solution.minFlips(mat);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[][] mat = {
        {1, 0, 0},
        {1, 0, 0}};
    final int expected = -1, actual = solution.minFlips(mat);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}