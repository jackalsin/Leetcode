package _051_100._066_Plus_One;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/25/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithNoCarry() throws Exception {
    assertArrayEquals(new int[]{1, 0, 1}, solution.plusOne(new int[] {1, 0, 0}));
  }


  @Test
  public void testWithWithCarry() throws Exception {
    assertArrayEquals(new int[]{1, 1, 0}, solution.plusOne(new int[] {1, 0, 9}));
  }
}