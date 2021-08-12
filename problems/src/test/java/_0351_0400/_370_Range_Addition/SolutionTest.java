package _0351_0400._370_Range_Addition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] expected = new int[]{-2, 0, 3, 5, 3};
    final int[][] updates = {
        {1, 3, 2},
        {2, 4, 3},
        {0, 2, -2}
    };
    assertArrayEquals(expected, solution.getModifiedArray(5, updates));
  }

}