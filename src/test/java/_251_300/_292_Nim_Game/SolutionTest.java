package _251_300._292_Nim_Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test4() throws Exception {
    assertFalse(solution.canWinNim(4));
  }

  @Test
  public void test5() throws Exception {
    /* take 1, left 4 */
    assertTrue(solution.canWinNim(5));
  }

  @Test
  public void test6() throws Exception {
    /* Take 2, left 4*/
    assertTrue(solution.canWinNim(6));
  }

  @Test
  public void test7() throws Exception {
    /* Take 3 left 4*/
    assertTrue(solution.canWinNim(7));
  }

  @Test
  public void test8() throws Exception {
    /* Take 3 left 4*/
    assertFalse(solution.canWinNim(8));
  }

  @Test
  public void testTLESolution() throws Exception {
    long start = System.nanoTime() / 1_000_000;
    assertFalse(solution.canWinNim(1348820612));
    long end = System.nanoTime() / 1_000_000;
    System.out.println((end - start) + "ms" );
  }
}
