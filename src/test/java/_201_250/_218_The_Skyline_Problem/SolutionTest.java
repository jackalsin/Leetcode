package _201_250._218_The_Skyline_Problem;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFailedCase() throws Exception {
    final int[][] input = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    final List<int[]> expected = Arrays.asList(new int[]{2,10}, new int[]{3,15}, new int[]{7,12},
     new int[]{12,0}, new int[]{15,10}, new int[]{20,8}, new int[]{24, 0});
    solution.getSkyline(input);
  }
}
