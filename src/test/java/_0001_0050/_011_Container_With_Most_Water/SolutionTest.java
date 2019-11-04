package _0001_0050._011_Container_With_Most_Water;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/18.
 */
class SolutionTest {
  private final int[] common1 = new int[]{3, 5, 4, 7, 6, 2};
  private final int[] twoElements = new int[]{3, 5};

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testCommon(Solution solution){
    assertEquals(15, solution.maxArea(common1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElement(Solution solution){
    assertEquals(3, solution.maxArea(twoElements));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(new Solution());
  }
}