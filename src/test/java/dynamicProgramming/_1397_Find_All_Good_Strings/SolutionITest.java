package dynamicProgramming._1397_Find_All_Good_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 2;
    final String s1 = "aa", s2 = "da", evil = "b";
    assertEquals(51, solution.findGoodStrings(n, s1, s2, evil));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int n = 8;
    final String s1 = "leetcode", s2 = "leetgoes", evil = "leet";
    assertEquals(0, solution.findGoodStrings(n, s1, s2, evil));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int n = 2;
    final String s1 = "gx", s2 = "gz", evil = "x";
    assertEquals(2, solution.findGoodStrings(n, s1, s2, evil));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}