package _101_150._128_Longest_Consecutive_Sequence;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[] {100, 4, 200, 1, 3, 2};
    assertEquals(4, solution.longestConsecutive(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
    final int[] dup = new int[input.length];
    System.arraycopy(input, 0, dup, 0, dup.length);
    Arrays.sort(dup);
    System.out.println(Arrays.toString(dup));
    assertEquals(5, solution.longestConsecutive(input));
  }
}