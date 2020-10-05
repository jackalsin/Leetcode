package hulu._269_Alien_Dictionary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
class SolutionITest {

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
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed2(Solution solution) {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed3(Solution solution) {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed4(Solution solution) {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed5(Solution solution) {
    assertEquals("zf", solution.alienOrder(new String[]{"z", "z", "f"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed6(Solution solution) {
    assertEquals("abcd", solution.alienOrder(new String[]{"ab", "adc"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed7(Solution solution) {
    final String actual = solution.alienOrder(new String[]{"za", "zb", "ca", "cb"});
    final Set<String> expected = Set.of(
        "abzc",
        "azbc",
        "azcb",
        "zcab",
        "zacb",
        "zabc"
    );
    assertTrue(expected.contains(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}