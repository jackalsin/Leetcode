package uber._301_Remove_Invalid_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolutionI(),
        new DfsSolution(),
        new BfsSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "()())()";
    final Set<String> expected = new HashSet<String>() {{
      add("()()()");
      add("(())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "(a)())()";
    final Set<String> expected = new HashSet<String>() {{
      add("(a)()()");
      add("(a())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = ")(";
    final Set<String> expected = new HashSet<String>() {{
      add("");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testLRR(Solution solution) {
    final String input = "())";
    final Set<String> expected = new HashSet<String>() {{
      add("()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }
}