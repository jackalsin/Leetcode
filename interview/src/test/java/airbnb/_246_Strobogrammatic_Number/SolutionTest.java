package airbnb._246_Strobogrammatic_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/30/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test6(Solution solution) {
    assertFalse(solution.isStrobogrammatic("6"));
    assertFalse(solution.isStrobogrammatic("2"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test69(Solution solution) {
    assertTrue(solution.isStrobogrammatic("69"));
    assertTrue(solution.isStrobogrammatic("88"));
    assertTrue(solution.isStrobogrammatic("818"));
  }
}