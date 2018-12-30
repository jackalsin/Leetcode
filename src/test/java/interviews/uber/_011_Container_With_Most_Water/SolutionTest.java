package interviews.uber._011_Container_With_Most_Water;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private final int[] common1 = new int[]{3, 5, 4, 7, 6, 2};
  private final int[] twoElements = new int[]{3, 5};
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testCommon() throws Exception {
    assertEquals(15, solution.maxArea(common1));
  }

  @Test
  void testTwoElement() throws Exception {
    assertEquals(3, solution.maxArea(twoElements));
  }
}