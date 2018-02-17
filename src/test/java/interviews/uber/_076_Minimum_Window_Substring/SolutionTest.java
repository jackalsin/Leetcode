package interviews.uber._076_Minimum_Window_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/16/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  /**
   * |  A | D | O | B | E | C | O  |  D  |  E  |  B  |  A  |  N  |  C  |
   * |  0 | 1 | 2 | 3 | 4 | 5 | 6  |  7  |  8  |  9  |  10 |  11 |  12 |
   *
   * @throws Exception
   */
  @Test
  void testWithOnlineCase() {
    assertEquals("BANC", solution.minWindow(
        "ADOBECODEBANC", "ABC"));
  }
}
