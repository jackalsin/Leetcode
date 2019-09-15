package _1151_1200._1191_K_Concatenation_Maximum_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/15/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int arr[] = {1, 2}, k = 3, expected = 9;
    assertEquals(expected, solution.kConcatenationMaxSum(arr, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int arr[] = {1, -2, 1}, k = 5, expected = 2;
    assertEquals(expected, solution.kConcatenationMaxSum(arr, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int arr[] = {-1, -2}, k = 7, expected = 0;
    assertEquals(expected, solution.kConcatenationMaxSum(arr, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int arr[] = {-5, 4, -4, -3, 5, -3}, k = 3, expected = 5;
    assertEquals(expected, solution.kConcatenationMaxSum(arr, k));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}