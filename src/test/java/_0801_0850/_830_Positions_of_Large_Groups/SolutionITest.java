package _0801_0850._830_Positions_of_Large_Groups;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(3, 6)
    ), actual = solution.largeGroupPositions("abbxxxxzzy");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> expected = List.of(
    ), actual = solution.largeGroupPositions("abc");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(3, 5),
        List.of(6, 9),
        List.of(12, 14)
    ), actual = solution.largeGroupPositions("abcdddeeeeaabbbcd");
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}