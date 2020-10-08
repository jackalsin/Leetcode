package _0951_1000._990_Satisfiability_of_Equality_Equations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"a==b", "b!=a"};
    assertFalse(solution.equationsPossible(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"b==a", "a==b"};
    assertTrue(solution.equationsPossible(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"a==b", "b==c", "a==c"};
    assertTrue(solution.equationsPossible(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String[] input = {"a==b", "b!=c", "c==a"};
    assertFalse(solution.equationsPossible(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String[] input = {"c==c", "b==d", "x!=z"};
    assertTrue(solution.equationsPossible(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}