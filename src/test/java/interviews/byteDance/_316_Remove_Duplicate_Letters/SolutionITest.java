package interviews.byteDance._316_Remove_Duplicate_Letters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBcabc(Solution solution) {
    final String input = "bcabc";
    assertEquals("abc", solution.removeDuplicateLetters(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testCbacdcbc(Solution solution) {
    final String input = "cbacdcbc";
    assertEquals("acdb", solution.removeDuplicateLetters(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBaa(Solution solution) {
    final String input = "baa";
    assertEquals("ba", solution.removeDuplicateLetters(input));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBaab(Solution solution) {
    final String input = "baab";
    assertEquals("ab", solution.removeDuplicateLetters(input));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBaabc(Solution solution) {
    final String input = "bababc";
    assertEquals("abc", solution.removeDuplicateLetters(input));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testabacb(Solution solution) {
    final String input = "abacb";
    assertEquals("abc", solution.removeDuplicateLetters(input));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testbabcb(Solution solution) {
    final String input = "babcb";
    assertEquals("abc", solution.removeDuplicateLetters(input));

  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}