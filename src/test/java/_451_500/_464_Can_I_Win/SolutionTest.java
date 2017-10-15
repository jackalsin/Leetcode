package _451_500._464_Can_I_Win;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new DPSolution();
    solution = new MemoSolution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    assertFalse(solution.canIWin(10, 11));
  }

  @Test
  public void test1() throws Exception {
    assertTrue(solution.canIWin(10, 1));
  }

  @Test
  public void test2() throws Exception {
    assertTrue(solution.canIWin(10, 2));
  }

  @Test
  public void test3() throws Exception {
    assertTrue(solution.canIWin(10, 3));
  }

  @Test
  public void test4() throws Exception {
    assertTrue(solution.canIWin(10, 4));
  }

  @Test
  public void test40And10() throws Exception {
    assertFalse(solution.canIWin(10, 40));
  }

  @Test
  public void test5And50() throws Exception {
    assertFalse(solution.canIWin(5, 50));
  }

  @Test
  public void test1And10() throws Exception {
    assertTrue(solution.canIWin(10, 1));
  }
}
