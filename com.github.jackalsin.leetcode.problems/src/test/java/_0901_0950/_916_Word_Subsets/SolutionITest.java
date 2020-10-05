package _0901_0950._916_Word_Subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] A = {"amazon", "apple", "facebook", "google", "leetcode"}, B = {"e", "o"};
    final List<String> actual = solution.wordSubsets(A, B);
    final Set<String> expected = Set.of("facebook", "google", "leetcode");
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] A = {"amazon", "apple", "facebook", "google", "leetcode"}, B = {"l", "e"};
    final List<String> actual = solution.wordSubsets(A, B);
    final Set<String> expected = Set.of("apple", "google", "leetcode");
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] A = {"amazon", "apple", "facebook", "google", "leetcode"}, B = {"e", "oo"};
    final List<String> actual = solution.wordSubsets(A, B);
    final Set<String> expected = Set.of("facebook", "google");
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String[] A = {"amazon", "apple", "facebook", "google", "leetcode"}, B = {"lo", "eo"};
    final List<String> actual = solution.wordSubsets(A, B);
    final Set<String> expected = Set.of("google", "leetcode");
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String[] A = {"amazon", "apple", "facebook", "google", "leetcode"}, B = {"ec", "oc", "ceo"};
    final List<String> actual = solution.wordSubsets(A, B);
    final Set<String> expected = Set.of("facebook", "leetcode");
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}