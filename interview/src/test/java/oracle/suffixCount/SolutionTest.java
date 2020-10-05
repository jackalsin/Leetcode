package oracle.suffixCount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
class SolutionTest {
  private static final String[] WORDS = {"abc", "abd", "abcd", "bcd", "bcde", "bcdef"};

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution, String[] words, final String suffix, final int expected) {
    assertEquals(expected, solution.suffixCount(words, suffix));
  }

  static Stream<Arguments> solutionStream() {
    return Stream.of(
        Arguments.of(new SolutionI(), WORDS, "abc", 2),
        Arguments.of(new SolutionI(), WORDS, "abcd", 1),
        Arguments.of(new SolutionI(), WORDS, "bcd", 3),
        Arguments.of(new SolutionI(), WORDS, "bcde", 2),
        Arguments.of(new SolutionI(), WORDS, "bcdef", 1)
    );
  }
}