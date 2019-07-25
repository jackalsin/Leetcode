package interviews.linkedin._464_Can_I_Win;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    assertFalse(solution.canIWin(10, 11));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedOnDuplication(Solution solution) {
    assertTrue(solution.canIWin(10, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed10And1(Solution solution) {
    assertTrue(solution.canIWin(10, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed10And40(Solution solution) {
    assertFalse(solution.canIWin(10, 40));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed20And210(Solution solution) {
    final long start = System.nanoTime();
    assertFalse(solution.canIWin(20, 210));
    final long end = System.nanoTime();
    System.out.println((end - start) / 1e6 + " ms");
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed5And50(Solution solution) {
    final long start = System.nanoTime();
    assertFalse(solution.canIWin(5, 50));
    final long end = System.nanoTime();
    System.out.println((end - start) / 1e6 + " ms");
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}
