package uber._568_Maximum_Vacation_Days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[][] flights = {
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0}
    }, days = {
        {1, 3, 1},
        {6, 0, 3},
        {3, 3, 3}
    };
    assertEquals(12, solution.maxVacationDays(flights, days));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[][] flights = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    }, days = {
        {1, 1, 1},
        {7, 7, 7},
        {7, 7, 7}
    };
    assertEquals(3, solution.maxVacationDays(flights, days));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{7, 0, 0}, {0, 7, 0}, {0, 0, 7}};
    assertEquals(21, solution.maxVacationDays(flights, days));
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[][] flights = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 0},
        {1, 0, 0, 0, 0},
        {1, 1, 1, 1, 0}
    }, days = {
        {0, 1, 1, 0, 0},
        {1, 2, 2, 1, 2},
        {2, 0, 0, 2, 1},
        {0, 2, 1, 2, 2},
        {0, 1, 1, 1, 0}
    };
    assertEquals(2, solution.maxVacationDays(flights, days));
  }
}