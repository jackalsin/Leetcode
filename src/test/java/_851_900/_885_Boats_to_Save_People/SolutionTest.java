package _851_900._885_Boats_to_Save_People;

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
    final int[] input = {1, 2};
    assertEquals(1, solution.numRescueBoats(input, 3));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {3, 2, 2, 1};
    assertEquals(3, solution.numRescueBoats(input, 3));
  }

  @Test
  void testOnlineCase3() {
    final int[] input = {3, 5, 3, 4};
    assertEquals(4, solution.numRescueBoats(input, 5));
  }

  @Test
  void testOnlineCase4() {
    final int[] input = {3, 2, 3, 2, 2};
    assertEquals(3, solution.numRescueBoats(input, 6));
  }

}