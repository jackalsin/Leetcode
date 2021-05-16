package uber._1249_Minimum_Remove_to_Make_Valid_Parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "lee(t(c)o)de)", actual = solution.minRemoveToMakeValid(s);
    final Set<String> expected = Set.of("lee(t(c)o)de", "lee(t(co)de)", "lee(t(c)ode)");
    assertTrue(expected.contains(actual), "actual = " + actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "a)b(c)d", actual = solution.minRemoveToMakeValid(s);
    final Set<String> expected = Set.of("ab(c)d");
    assertTrue(expected.contains(actual), "actual = " + actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String s = "))((", actual = solution.minRemoveToMakeValid(s);
    final Set<String> expected = Set.of("");
    assertTrue(expected.contains(actual), "actual = " + actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String s = "(a(b(c)d)", actual = solution.minRemoveToMakeValid(s);
    final Set<String> expected = Set.of("a(b(c)d)");
    assertTrue(expected.contains(actual), "actual = " + actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}