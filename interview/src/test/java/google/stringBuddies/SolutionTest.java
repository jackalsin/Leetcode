package google.stringBuddies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testValidBuddies() throws Exception {
    final String a = "converse", b = "conserve";
    assertTrue(solution.isBuddies(a, b));
  }

  @Test
  public void testInvalidBuddiesWithMoreSwap() throws Exception {
    final String a = "converse", b = "conserev";
    assertFalse(solution.isBuddies(a, b));
  }

  @Test
  public void testInvalidBuddiesWithNotOccurred() throws Exception {
    final String a = "converse", b = "consere";
    assertFalse(solution.isBuddies(a, b));
    assertFalse(solution.isBuddies(b, a));
  }

  @Test
  public void testInvalidBuddiesWithTheSameString() throws Exception {
    final String a = "converse";
    assertFalse(solution.isBuddies(a, a));
  }
}
