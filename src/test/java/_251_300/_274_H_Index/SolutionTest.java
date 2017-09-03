package _251_300._274_H_Index;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = new int[] {3, 0, 6, 1, 5};
    assertEquals(3, solution.hIndex(input));
  }

  @Test
  public void testOne() throws Exception {
    final int[] input = new int[] {0};
    assertEquals(0, solution.hIndex(input));
  }

}
