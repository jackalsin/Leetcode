package _0651_0700._657_Judge_Route_Circle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.judgeCircle("UD"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertFalse(solution.judgeCircle("LL"));
  }
}