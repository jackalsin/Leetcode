package _0201_0250._213_House_Robber_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 8/9/2017.
 */
public class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Solution solution) {
    assertEquals(0, solution.rob(new int[]{}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOne(Solution solution) {
    assertEquals(1, solution.rob(new int[]{1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTwo(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertEquals(2, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testThree(Solution solution) {
    final int[] input = new int[]{1, 2, 3};
    assertEquals(3, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test131(Solution solution) {
    final int[] input = new int[]{1, 3, 1};
    assertEquals(3, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1(Solution solution) {
    final int[] input = new int[]{1};
    assertEquals(1, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testMaxHead(Solution solution) {
    final int[] input = new int[]{6, 1, 5};
    assertEquals(6, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testMaxTail(Solution solution) {
    final int[] input = new int[]{6, 1, 11};
    assertEquals(11, solution.rob(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailed1(Solution solution) {
    final int[] input = new int[]{1, 2, 1, 0};
    assertEquals(2, solution.rob(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }
}
