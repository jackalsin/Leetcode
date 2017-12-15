package _501_550._520_Detect_Capital;

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
    assertTrue(solution.detectCapitalUse("USA"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertTrue(solution.detectCapitalUse("leetcode"));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertTrue(solution.detectCapitalUse("Google"));
    assertTrue(solution.detectCapitalUse("G"));
    assertFalse(solution.detectCapitalUse("GGo"));
  }

  @Test
  public void testEmpty() throws Exception {
    assertTrue(solution.detectCapitalUse(""));
  }
}