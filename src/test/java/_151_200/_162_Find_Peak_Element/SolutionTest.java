package _151_200._162_Find_Peak_Element;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(0, solution.findPeakElement(new int[]{Integer.MIN_VALUE}));
    assertEquals(0, solution.findPeakElement(new int[]{0}));
  }

  @Test
  public void testTwoElementLeadingPeak() throws Exception {
    assertEquals(0, solution.findPeakElement(new int[]{1, 0}));
  }

  @Test
  public void testTwoElementTrailingPeak() throws Exception {
    assertEquals(1, solution.findPeakElement(new int[]{0, 1}));
  }
}
