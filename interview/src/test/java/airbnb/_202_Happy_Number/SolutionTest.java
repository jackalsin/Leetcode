package airbnb._202_Happy_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testIsHappy() throws Exception {
    assertTrue(solution.isHappy(19));
  }

  @Test
  void test887() throws Exception {
    assertFalse(solution.isHappy(887));
  }
}