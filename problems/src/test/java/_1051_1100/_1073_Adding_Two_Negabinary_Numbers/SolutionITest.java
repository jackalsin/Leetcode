package _1051_1100._1073_Adding_Two_Negabinary_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] arr1 = {1, 1, 1, 1, 1}, arr2 = {1, 0, 1},
        expected = {1, 0, 0, 0, 0}, actual = solution.addNegabinary(arr1, arr2);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] arr1 = {0}, arr2 = {0},
        expected = {0}, actual = solution.addNegabinary(arr1, arr2);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] arr1 = {0}, arr2 = {1},
        expected = {1}, actual = solution.addNegabinary(arr1, arr2);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] arr1 = {1}, arr2 = {1},
        expected = {1, 1, 0}, actual = solution.addNegabinary(arr1, arr2);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}