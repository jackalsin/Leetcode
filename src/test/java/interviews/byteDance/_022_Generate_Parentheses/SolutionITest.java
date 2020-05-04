package interviews.byteDance._022_Generate_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/3/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith0(Solution solution) {
    assertEquals(Collections.singletonList(""), solution.generateParenthesis(0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith1(Solution solution) {
    assertEquals(Collections.singletonList("()"), solution.generateParenthesis(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith2(Solution solution) {
    final List<String> sampleAns = Arrays.asList("()()", "(())");
    final List<String> actualAns = solution.generateParenthesis(2);
    assertEquals(new HashSet<>(sampleAns), new HashSet<>(actualAns));
    assertEquals(sampleAns.size(), actualAns.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testWith3(Solution solution) {
    final List<String> sampleInOrderAns =
        Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    final List<String> actualAns = solution.generateParenthesis(3);
    assertEquals(
        new HashSet<>(sampleInOrderAns),
        new HashSet<>(actualAns)
    );
    assertEquals(sampleInOrderAns.size(), actualAns.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}