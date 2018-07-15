package interviews.microsoft._055_Jump_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase1() throws Exception {
    assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
  }


  @Test
  void testWithOnlineCase2() throws Exception {
    assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
  }

  @Test
  void testWithOnlineCase3() throws Exception {
    assertTrue(solution.canJump(new int[]{1, 2, 3}));
  }

}