package _0651_0700._692_Top_K_Frequent_Words;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2018.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"i", "love", "leetcode", "i", "love", "leetcode"};
    final List<String> expected = List.of("i", "leetcode");
    final List<String> actual = solution.topKFrequent(input, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
    final List<String> expected = List.of("i", "love");
    final List<String> actual = solution.topKFrequent(input, 2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    final List<String> expected = List.of("the", "is", "sunny", "day");
    final List<String> actual = solution.topKFrequent(input, 4);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new TrieSolution(),
        new BucketSolution()
    );
  }
}
