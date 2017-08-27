package _251_300._259_3Sum_Smaller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[] {-2, 0, 1, 3};
    assertEquals(2, solution.threeSumSmaller(input, 2));
  }
}
