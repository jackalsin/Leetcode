package _1551_1600._1554_Strings_Differ_by_One_Character;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/12/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] dict = {"abcd", "acbd", "aacd"};
    assertTrue(solution.differByOne(dict));
//    Strings "abcd" and "aacd" differ only by one character in the index 1.
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] dict = {"ab", "cd", "yz"};
    assertFalse(solution.differByOne(dict));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] dict = {"abcd", "cccc", "abyd", "abab"};
    // abcd -> abyd
    assertTrue(solution.differByOne(dict));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new RemoveIthIndexSolutionI(),
        new RobinKarpSolution()
    );
  }
}