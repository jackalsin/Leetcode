package airbnb._198_House_Robber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
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
  void testEmpty(Solution solution) {
    final int[] input = new int[]{};
    assertEquals(0, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(1, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwo(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertEquals(2, solution.rob(input));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testThree(Solution solution) {
    final int[] input = new int[]{1, 2, 3};
    assertEquals(4, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test131(Solution solution) {
    final int[] input = new int[]{1, 3, 1};
    assertEquals(3, solution.rob(input));
  }
}