package interviews.linkedin._076_Minimum_Window_Substring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testA(Solution solution) {
    final String s = "a";
    final String t = "a";
    assertEquals(s, solution.minWindow(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testAAndAA(Solution solution) {
    final String s = "a";
    final String t = "aa";
    assertEquals("", solution.minWindow(s, t));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testADOBECODEBANC(Solution solution) {
    final String s = "ADOBECODEBANC";
    final String t = "ABC";
    assertEquals("BANC", solution.minWindow(s, t));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}
