package interviews.byteDance._011_Container_With_Most_Water;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
class SolutionITest {

  private final int[] common1 = new int[]{3, 5, 4, 7, 6, 2};
  private final int[] twoElements = new int[]{3, 5};

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testCommon(Solution solution) {
    assertEquals(15, solution.maxArea(common1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElement(Solution solution) {
    assertEquals(3, solution.maxArea(twoElements));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}