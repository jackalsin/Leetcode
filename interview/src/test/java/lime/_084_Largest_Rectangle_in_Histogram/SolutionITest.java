package lime._084_Largest_Rectangle_in_Histogram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final int[] heights = new int[]{2, 1, 5, 6, 2, 3};
    assertEquals(10, solution.largestRectangleArea(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLastIsBig(Solution solution) {
    final int[] heights = new int[]{0};
    assertEquals(0, solution.largestRectangleArea(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testDuplicate(Solution solution) {
    final int[] heights = new int[]{5, 6, 7, 5, 6, 7, 5, 6, 7};
    assertEquals(45, solution.largestRectangleArea(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int[] heights = new int[]{0, 9};
    assertEquals(9, solution.largestRectangleArea(heights));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int[] heights = new int[]{1, 2, 1};
    assertEquals(3, solution.largestRectangleArea(heights));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}