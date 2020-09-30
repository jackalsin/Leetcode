package _0951_1000._955_Delete_Columns_to_Make_Sorted_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 9/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"ca", "bb", "ac"};
    final int expected = 1, actual = solution.minDeletionSize(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"xc", "yb", "za"};
    final int expected = 0, actual = solution.minDeletionSize(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"zyx", "wvu", "tsr"};
    final int expected = 3, actual = solution.minDeletionSize(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String[] input = {"doeeqiy", "yabhbqe", "twckqte"};
    final int expected = 3, actual = solution.minDeletionSize(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String[] input = {"xga", "xfb", "yfa"};
    final int expected = 1, actual = solution.minDeletionSize(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}