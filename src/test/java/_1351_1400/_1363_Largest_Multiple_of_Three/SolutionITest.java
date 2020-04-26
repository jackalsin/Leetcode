package _1351_1400._1363_Largest_Multiple_of_Three;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/25/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] digits = {8, 1, 9};
    assertEquals("981", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] digits = {8, 6, 7, 1, 0};
    assertEquals("8760", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] digits = {1};
    assertEquals("", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] digits = {0, 0, 0, 0};
    assertEquals("0", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int[] digits = {1, 1, 1};
    assertEquals("111", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase6(Solution solution) {
    final int[] digits = {1, 1, 1, 2};
    assertEquals("111", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase7(Solution solution) {
    final int[] digits = {5, 8};
    assertEquals("", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase8(Solution solution) {
    final int[] digits = {9, 8, 6, 8, 6};
    assertEquals("966", solution.largestMultipleOfThree(digits));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase9(Solution solution) {
    final int[] digits = {4, 0, 0, 0};
    assertEquals("0", solution.largestMultipleOfThree(digits));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}