package airbnb._269_Alien_Dictionary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testExample1(Solution solution) {
    assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testExample2(Solution solution) {
    assertEquals("zx", solution.alienOrder(new String[]{"z", "x"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testExample3(Solution solution) {
    assertEquals("", solution.alienOrder(new String[]{"z", "x", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed(Solution solution) {
    final Set<String> expected = Set.of("acb", "cab");
    final String actual = solution.alienOrder(new String[]{"ac", "ab", "b"});
    assertTrue(expected.contains(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed2(Solution solution) {
    // ab, zc,
    final Set<String> expected = Set.of("abzc", "azcb", "azbc");
    final String actual = solution.alienOrder(new String[]{"za", "zb", "ca", "cb"});
    assertTrue(expected.contains(actual), "actual = " + actual);
  }

  /**
   * 自环还是valid，其他是invalid
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed3(Solution solution) {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed4(Solution solution) {
    assertEquals("", solution.alienOrder(new String[]{"abc", "ab"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed5(Solution solution) {
    final String[] input = {"z", "x", "a", "zb", "zx"};
    assertEquals("", solution.alienOrder(input));
  }
}