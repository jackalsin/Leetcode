package _0501_0550._522_Longest_Uncommon_Subsequence_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] strs = {"aabbcc", "aabbcc", "cb"};
    assertEquals(2, solution.findLUSlength(strs));
  }


  @Test
  public void testFailedCase1() throws Exception {
    final String[] strs = {"aaa", "aaa", "aa"};
    assertEquals(-1, solution.findLUSlength(strs));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String[] strs = {"aabbcc", "aabbcc", "c"};
    assertEquals(-1, solution.findLUSlength(strs));
  }

  @Test
  public void testIsSub() {
    final String str = "aabbcc";
    assertTrue(Solution.isSub(str, str));
  }
}