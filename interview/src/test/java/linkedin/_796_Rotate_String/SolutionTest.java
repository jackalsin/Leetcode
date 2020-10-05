package linkedin._796_Rotate_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String A = "abcde", B = "cdeab";
    assertTrue(solution.rotateString(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String A = "abcde", B = "abced";
    assertFalse(solution.rotateString(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String A = "aa", B = "a";
    assertFalse(solution.rotateString(A, B));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new KmpSolution(),
        new KmpSolutionI(),
        new KmpSolutionII(),
        new KmpSolutionIII(),
        new SolutionI()
    );
  }
}
