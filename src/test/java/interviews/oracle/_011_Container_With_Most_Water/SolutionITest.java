package interviews.oracle._011_Container_With_Most_Water;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
class SolutionITest {
  private final int[] common1 = new int[]{3, 5, 4, 7, 6, 2};
  private final int[] twoElements = new int[]{3, 5};

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testCommon(Solution solution) {
    assertEquals(15, solution.maxArea(common1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElement(Solution solution) {
    assertEquals(3, solution.maxArea(twoElements));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    assertEquals(49, solution.maxArea(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}