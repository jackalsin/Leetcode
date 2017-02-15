package _001_100._034_Search_for_a_Range;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithSingleIndex() throws Exception {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertArrayEquals(new int[]{2, 2}, solution.searchRange(input, 3));
  }

  @Test
  public void testWithNotFoundSingleValue() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4, 5};
    assertArrayEquals(new int[] {-1, -1}, solution.searchRange(input, -1));
  }

  @Test
  public void testWithDupFindValue() throws Exception {
    final int[] input = new int[] {1, 2, 3, 3, 3, 4, 5};
    assertArrayEquals(new int[]{2, 4}, solution.searchRange(input, 3));
  }

  @Test
  public void testWithSingleValueArrayOdd() throws Exception {
    final int[] input = new int[] {1};
    assertArrayEquals(new int[] {0,0}, solution.searchRange(input, 1));
  }

  @Test
  public void testWithSingleValueArrayEven() throws Exception {
    final int[] input = new int[] {2};
    assertArrayEquals(new int[] {0,0}, solution.searchRange(input, 2));
  }
}