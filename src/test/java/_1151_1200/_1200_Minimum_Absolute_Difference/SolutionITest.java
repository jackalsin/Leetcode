package _1151_1200._1200_Minimum_Absolute_Difference;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {4, 2, 1, 3};
    final List<List<Integer>> expected = List.of(
        List.of(1, 2),
        List.of(2, 3),
        List.of(3, 4)
    ), actual = solution.minimumAbsDifference(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 3, 6, 10, 15};
    final List<List<Integer>> expected = List.of(
        List.of(1, 3)
    ), actual = solution.minimumAbsDifference(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {3, 8, -10, 23, 19, -4, -14, 27};
    final List<List<Integer>> expected = List.of(
        List.of(-14, -10),
        List.of(19, 23),
        List.of(23, 27)
    ), actual = solution.minimumAbsDifference(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}