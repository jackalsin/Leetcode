package _0051_0100._097_Interleaving_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testAaab() throws Exception {
    final String aa = "aa";
    final String ab = "ab";
    final String expected = "aaba";

    assertTrue(solution.isInterleave(aa, ab, expected));
  }

}
