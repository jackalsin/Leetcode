package _0051_0100._076_Minimum_Window_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase() {
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
  }

}
