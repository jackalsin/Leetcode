package _0151_0200._152_Maximum_Product_Subarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline(Solution solution) {
    final int[] input = new int[]{2, 3, -2, 4};
    assertEquals(6, solution.maxProduct(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline2(Solution solution) {
    final int[] input = new int[]{-4, -3, -2};
    assertEquals(12, solution.maxProduct(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
