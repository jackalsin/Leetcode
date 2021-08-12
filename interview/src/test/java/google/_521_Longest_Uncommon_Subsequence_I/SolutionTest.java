package google._521_Longest_Uncommon_Subsequence_I;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/17/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String a = "aba", b = "cdc";
    assertEquals(3, solution.findLUSlength(a, b));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String a = "aaa", b = "aaa";
    assertEquals(-1, solution.findLUSlength(a, b));
  }
}
