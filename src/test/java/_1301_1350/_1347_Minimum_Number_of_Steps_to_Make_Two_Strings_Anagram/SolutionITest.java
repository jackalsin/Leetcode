package _1301_1350._1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String s = "bab", t = "aba";
    assertEquals(1, solution.minSteps(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String s = "leetcode", t = "practice";
    assertEquals(5, solution.minSteps(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String s = "anagram", t = "mangaar";
    assertEquals(0, solution.minSteps(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String s = "xxyyzz", t = "xxyyzz";
    assertEquals(0, solution.minSteps(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String s = "friend", t = "family";
    assertEquals(4, solution.minSteps(s, t));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}