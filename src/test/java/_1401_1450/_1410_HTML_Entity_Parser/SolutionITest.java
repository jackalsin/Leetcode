package _1401_1450._1410_HTML_Entity_Parser;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String text = "&amp; is an HTML entity but &ambassador; is not.",
        expected = "& is an HTML entity but &ambassador; is not.",
        actual = solution.entityParser(text);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String text = "Stay home! Practice on Leetcode :)",
        expected = "Stay home! Practice on Leetcode :)",
        actual = solution.entityParser(text);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String text = "x &gt; y &amp;&amp; x &lt; y is always false",
        expected = "x > y && x < y is always false",
        actual = solution.entityParser(text);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String text = "leetcode.com&frasl;problemset&frasl;all",
        expected = "leetcode.com/problemset/all",
        actual = solution.entityParser(text);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}