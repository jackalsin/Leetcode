package _201_250._207_Course_Schedule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testPossible() throws Exception {
    assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
  }

  @Test
  public void testImpossible() throws Exception {
    assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }

}
