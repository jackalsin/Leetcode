package _101_150._123_Best_Time_to_Buy_and_Sell_Stock_III;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.maxProfit(new int[] {}));
  }

  @Test
  public void test2TransMax() throws Exception {
    final int[] input = new int[] {1, 5, 0, 1, 5};
    assertEquals(9, solution.maxProfit(input));
  }

  @Test
  public void test1TransMax() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4, 5};
    assertEquals(4, solution.maxProfit(input));
  }

  @Test
  public void testMultiMaxLater() throws Exception {
    final int[] input = new int[] {3,3,5,0,0,3,1,4};
    assertEquals(6, solution.maxProfit(input));
  }

  @Test
  public void testMultiTransMaxContinuous() throws Exception {
    final int[] input = new int[] {1,2,4,2,5,7,2,4,9,0};
    assertEquals(13, solution.maxProfit(input));
  }
}
