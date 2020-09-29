package _0951_1000._953_Verifying_an_Alien_Dictionary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String words[] = {"hello", "leetcode"}, order = "hlabcdefgijkmnopqrstuvwxyz";
    assertTrue(solution.isAlienSorted(words, order));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String words[] = {"word", "world", "row"}, order = "worldabcefghijkmnpqstuvxyz";
    assertFalse(solution.isAlienSorted(words, order));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String words[] = {"apple", "app"}, order = "abcdefghijklmnopqrstuvwxyz";
    assertFalse(solution.isAlienSorted(words, order));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}