package interviews.linkedin._367_Valid_Perfect_Square;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  //
  @Test
  public void test16Solution() {
    final int num = 16;
    assertTrue(solution.isPerfectSquare(num));
  }
}
