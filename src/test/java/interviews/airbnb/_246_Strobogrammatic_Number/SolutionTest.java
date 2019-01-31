package interviews.airbnb._246_Strobogrammatic_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/30/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test6() throws Exception {
    assertFalse(solution.isStrobogrammatic("6"));
    assertFalse(solution.isStrobogrammatic("2"));
  }

  @Test
  void test69() throws Exception {
    assertTrue(solution.isStrobogrammatic("69"));
    assertTrue(solution.isStrobogrammatic("88"));
    assertTrue(solution.isStrobogrammatic("818"));
  }
}