package _1401_1450._1408_String_Matching_in_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] words = {"mass", "as", "hero", "superhero"};
    final Set<String> expected = Set.of("as", "hero");
    final List<String> actual = solution.stringMatching(words);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] words = {"leetcode", "et", "code"};
    final Set<String> expected = Set.of("et", "code");
    final List<String> actual = solution.stringMatching(words);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] words = {"blue", "green", "bu"};
    final Set<String> expected = Set.of();
    final List<String> actual = solution.stringMatching(words);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}