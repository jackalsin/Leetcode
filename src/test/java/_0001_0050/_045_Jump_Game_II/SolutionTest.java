package _0001_0050._045_Jump_Game_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    final int[] input = new int[]{2, 3, 1, 1, 4};
    assertEquals(2, solution.jump(input));
  }

  @Test
  public void testWithSingleElement() throws Exception {
    final int[] input = new int[]{1};
    assertEquals(0, solution.jump(input));
  }

  @Test
  public void testWith123() throws Exception {
    final int[] input = new int[]{1, 2, 3};
    assertEquals(2, solution.jump(input));
  }

  @Test
  public void testWith12() throws Exception {
    final int[] input = new int[]{1, 2};
    assertEquals(1, solution.jump(input));
  }
}