package interviews.microsoft.noodleEssence._403_Frog_Jump;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {0, 1, 3, 5, 6, 8, 12, 17};
    assertTrue(solution.canCross(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {0, 1, 2, 3, 4, 8, 9, 11};
    assertFalse(solution.canCross(input));
  }
}