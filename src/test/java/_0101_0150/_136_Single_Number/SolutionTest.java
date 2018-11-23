package _0101_0150._136_Single_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.singleNumber(new int[]{}));
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(1, solution.singleNumber(new int[]{1}));
  }

  @Test
  public void test3ElementsInorder() throws Exception {
    assertEquals(2, solution.singleNumber(new int[]{1, 1, 2}));
  }

  @Test
  public void test3ElementsReversedOrder() throws Exception {
    assertEquals(2, solution.singleNumber(new int[]{2, 1, 1}));
  }

  @Test
  public void test3ElementsPeakOrder() throws Exception {
    assertEquals(2, solution.singleNumber(new int[]{1, 2, 1}));
  }
}
