package _0301_0350._316_Remove_Duplicate_Letters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/20/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new RecursionSolution(),
        new StackSolution()
    );
  }

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
}
