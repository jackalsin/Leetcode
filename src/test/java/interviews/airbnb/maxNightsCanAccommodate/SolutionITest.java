package interviews.airbnb.maxNightsCanAccommodate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {5, 1, 1, 5};
    assertEquals(10, solution.maxNightsCanAccommodate(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {3, 6, 4};
    assertEquals(7, solution.maxNightsCanAccommodate(input));
  }

  @Test
  void testOnlineCase3() {
    final int[] input = {4, 10, 3, 1, 5};
    assertEquals(15, solution.maxNightsCanAccommodate(input));
  }
}