package airbnb._336_Palindrome_Pairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
class TrieSolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new TrieSolutionI(),
        new TrieSolution(),
        new MapSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final String[] words = {"bat", "tab", "cat"};
    final List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.palindromePairs(words)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    //                        0,      1,      2,    3,    4
    final String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
    final List<List<Integer>> expected = List.of(
        List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)
    ), actual = solution.palindromePairs(words);
//    System.out.println(actual);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.palindromePairs(words)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testDuplicated(Solution solution) {
    final String[] words = {"a", ""};
    final List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
    assertEquals(expected, solution.palindromePairs(words));
  }

}