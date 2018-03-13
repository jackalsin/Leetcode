package interviews.uber.patternCheck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String str = "programming", pattern = "gra";
    assertFalse(solution.isMatch(str, pattern));
  }

  @Test
  void testOnlineCase2() {
    final String str = "programming", pattern = "ra";
    assertTrue(solution.isMatch(str, pattern));
  }

  /**
   * Unused char in pattern
   */
  @Test
  void testOnlineCase3() {
    final String str = "programming", pattern = "vra";
    assertTrue(solution.isMatch(str, pattern));
  }

  /**
   * duplicated continuous char in pattern
   */
  @Test
  void testOnlineCase4() {
    final String str = "programming", pattern = "rra";
    assertTrue(solution.isMatch(str, pattern));
  }

  /**
   * duplicated continuous char in pattern
   */
  @Test
  void testOnlineCase5() {
    final String str = "programming", pattern = "rar";
    assertFalse(solution.isMatch(str, pattern));
  }

}
