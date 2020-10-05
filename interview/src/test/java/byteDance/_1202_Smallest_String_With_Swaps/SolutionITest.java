package byteDance._1202_Smallest_String_With_Swaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "dcab", expected = "bacd";
    final List<List<Integer>> pairs = List.of(
        List.of(0, 3),
        List.of(1, 2)
    );
    assertEquals(expected, solution.smallestStringWithSwaps(input, pairs));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "dcab", expected = "abcd";
    final List<List<Integer>> pairs = List.of(
        List.of(0, 3),
        List.of(1, 2),
        List.of(0, 2)
    );
    assertEquals(expected, solution.smallestStringWithSwaps(input, pairs));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "cba", expected = "abc";
    final List<List<Integer>> pairs = List.of(
        List.of(0, 1),
        List.of(1, 2)
    );
    assertEquals(expected, solution.smallestStringWithSwaps(input, pairs));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}