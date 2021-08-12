package _0501_0550._520_Detect_Capital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
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