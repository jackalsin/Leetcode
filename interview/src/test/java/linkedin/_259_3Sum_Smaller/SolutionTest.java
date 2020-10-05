package linkedin._259_3Sum_Smaller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] input = new int[]{-2, 0, 1, 3};
    assertEquals(2, solution.threeSumSmaller(input, 2));
  }

}