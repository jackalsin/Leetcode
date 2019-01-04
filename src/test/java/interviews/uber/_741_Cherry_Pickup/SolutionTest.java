package interviews.uber._741_Cherry_Pickup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }


  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {0, 1, -1},
        {1, 0, -1},
        {1, 1, 1}
    };
    assertEquals(5, solution.cherryPickup(input));
  }

  @Test
  void testFailedCase1() {
    final int[][] input = {
        {1, 1, -1},
        {1, -1, 1},
        {-1, 1, 1}
    };
    assertEquals(0, solution.cherryPickup(input));
  }
}