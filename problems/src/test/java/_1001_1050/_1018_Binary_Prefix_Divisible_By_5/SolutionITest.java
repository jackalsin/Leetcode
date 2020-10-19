package _1001_1050._1018_Binary_Prefix_Divisible_By_5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {0, 1, 1};
    final List<Boolean> expected = List.of(true, false, false),
        actual = solution.prefixesDivBy5(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 1, 1};
    final List<Boolean> expected = List.of(false, false, false),
        actual = solution.prefixesDivBy5(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {0, 1, 1, 1, 1, 1};
    final List<Boolean> expected = List.of(true, false, false, false, true, false),
        actual = solution.prefixesDivBy5(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}