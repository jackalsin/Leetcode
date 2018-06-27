package interviews.linkedin._198_House_Robber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 3, 1};
    assertEquals(4, solution.rob(nums));
  }
}