package _0351_0400._375_Guess_Number_Higher_or_Lower_II;

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
  public void testOnlineCase() throws Exception {
    assertEquals(16, solution.getMoneyAmount(10));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(0, solution.getMoneyAmount(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(1, solution.getMoneyAmount(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(2, solution.getMoneyAmount(3));
  }

  /**
   * Spend 1 and 3
   *
   * @throws Exception
   */
  @Test
  public void test4() throws Exception {
    assertEquals(4, solution.getMoneyAmount(4));
  }

  @Test
  public void test5() throws Exception {
    assertEquals(6, solution.getMoneyAmount(5));
  }


}