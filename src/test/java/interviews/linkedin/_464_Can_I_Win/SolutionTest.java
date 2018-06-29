package interviews.linkedin._464_Can_I_Win;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new SolutionI();
    solution = new SolutionII();
  }

  @Test
  public void testOnlineCase() throws Exception {
    assertFalse(solution.canIWin(10, 11));
  }

  @Test
  public void testFailedOnDuplication() {
    assertTrue(solution.canIWin(10, 0));
  }

  @Test
  public void testFailed10And1() {
    assertTrue(solution.canIWin(10, 1));
  }

  @Test
  public void testFailed10And40() {
    assertFalse(solution.canIWin(10, 40));
  }

  @Test
  public void testFailed20And210() {
    final long start = System.nanoTime();
    assertFalse(solution.canIWin(20, 210));
    final long end = System.nanoTime();
    System.out.println((end - start) / 1e6 + " ms");
  }

  @Test
  public void testFailed5And50() {
    final long start = System.nanoTime();
    assertFalse(solution.canIWin(5, 50));
    final long end = System.nanoTime();
    System.out.println((end - start) / 1e6 + " ms");
  }
}
