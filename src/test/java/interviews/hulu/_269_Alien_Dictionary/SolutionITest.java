package interviews.hulu._269_Alien_Dictionary;

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
  @MethodSource("solutionProvider")
  void testExample1(Solution solution) {
    assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testExample2(Solution solution) {
    assertEquals("zx", solution.alienOrder(new String[]{"z", "x"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testExample3(Solution solution) {
    assertEquals("", solution.alienOrder(new String[]{"z", "x", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed(Solution solution) {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed2(Solution solution) {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed3(Solution solution) {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed4(Solution solution) {
    assertEquals("z", solution.alienOrder(new String[]{"z", "z", "z"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed5(Solution solution) {
    assertEquals("zf", solution.alienOrder(new String[]{"z", "z", "f"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed6(Solution solution) {
    assertEquals("abcd", solution.alienOrder(new String[]{"ab", "adc"}));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
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

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}