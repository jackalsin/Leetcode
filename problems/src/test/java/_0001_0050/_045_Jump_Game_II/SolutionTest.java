package _0001_0050._045_Jump_Game_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/24/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase(Solution solution) {
    final int[] input = new int[]{2, 3, 1, 1, 4};
    assertEquals(2, solution.jump(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithSingleElement(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(0, solution.jump(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith123(Solution solution) {
    final int[] input = new int[]{1, 2, 3};
    assertEquals(2, solution.jump(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith12(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.jump(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new DynameicProgrammingSolution()
    );
  }
}