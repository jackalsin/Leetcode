package _151_200._164_Maximum_Gap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/27/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZeroElement() throws Exception {
    assertEquals(0, solution.maximumGap(new int[]{}));
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(0, solution.maximumGap(new int[]{1}));
  }

  @Test
  public void testTwoElement() throws Exception {
    assertEquals(1, solution.maximumGap(new int[]{1, 2}));
    assertEquals(1, solution.maximumGap(new int[]{2, 1}));
  }

  @Test
  public void testRadixSort() throws Exception {
    final int[] input = new int[]{ 1, 13, 4, 51, 3 };
    final int[] expect = new int[] {1, 3, 4, 13, 51};
    Solution.radixSort(input);
    assertArrayEquals(expect, input);
  }
}
