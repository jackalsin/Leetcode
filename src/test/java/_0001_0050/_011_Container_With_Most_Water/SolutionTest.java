package _0001_0050._011_Container_With_Most_Water;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/18.
 */
public class SolutionTest {
  private final int[] common1 = new int[]{3, 5, 4, 7, 6, 2};
  private final int[] twoElements = new int[]{3, 5};
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testCommon() throws Exception {
    assertEquals(15, solution.maxArea(common1));
  }

  @Test
  public void testTwoElement() throws Exception {
    assertEquals(3, solution.maxArea(twoElements));
  }
}