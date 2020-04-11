package _0901_0950._943_Find_the_Shortest_Superstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"alex", "loves", "leetcode"};
    final Set<String> expected = Set.of(
        "alex" + "loves" + "leetcode",
        "alex" + "leetcode" + "loves",
        "loves" + "alex" + "leetcode",
        "loves" + "leetcode" + "alex",
        "leetcode" + "alex" + "loves",
        "leetcode" + "loves" + "alex"
    );
    final String actual = solution.shortestSuperstring(input);
    assertTrue(expected.contains(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    // gctactattccaatgc
    final String[] input = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
    final String expected = "gctaagttcatgcatc";
    assertEquals(expected, solution.shortestSuperstring(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    // gctactattccaatgc
    final String[] input = {"ppgortnmsy", "czmysoeeyugbiylso", "nbfzpppvhbjydtx", "rnzynedhoiunkpon",
        "ornzynedhoiunkpo",
        "ylsomoktkyfgljcf", "jtvkrornzynedhoiunk", "hvhhihwdffmxnczmyso", "ktkyfgljcfbkqcpp", "nzynedhoiunkponbfz",
        "nedhoiunkponbfzpppvh"};
    final String expected =
        "jtvkrornzynedhoiunkponbfzpppvhbjydtxhvhhihwdffmxnczmysoeeyugbiylsomoktkyfgljcfbkqcppgortnmsy";
    assertEquals(expected, solution.shortestSuperstring(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new PqSolutionI(),
        new PqSolutionII(),
        new DpSolution()
    );
  }
}