package _651_700._668_Kth_Smallest_Number_in_Multiplication_Table;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.findKthNumber(3, 3, 5));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(6, solution.findKthNumber(2, 3, 6));
  }

  @Test
  public void testFailedCase1() throws Exception {
    assertEquals(126, solution.findKthNumber(42, 34, 401));
  }

  @Test
  public void testTLE() {
    long startTime = System.nanoTime();
    assertEquals(31666344, solution.findKthNumber(9895, 28405, 100787757));
    long endTime = System.nanoTime();
    System.out.println("used time = " + (endTime - startTime) / 1e6 + " ms");
  }
}
