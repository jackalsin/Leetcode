package _0351_0400._367_Valid_Perfect_Square;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase16() throws Exception {
    assertTrue(solution.isPerfectSquare(16));
  }

  @Test
  public void testOnlineCase14() throws Exception {
    assertFalse(solution.isPerfectSquare(14));
  }

  @Test
  public void testZero() throws Exception {
    assertFalse(solution.isPerfectSquare(0));
  }

  @Test
  public void test2147483647() throws Exception {
    assertFalse(solution.isPerfectSquare(2147483647));
  }
}
