package _551_600._568_Maximum_Vacation_Days;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] flights = {
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0}
    }, days = {
        {1, 3, 1},
        {6, 0, 3},
        {3, 3, 3}};
    assertEquals(12, solution.maxVacationDays(flights, days));
  }

  @Test
  public void testOnlineCase2() throws Exception {
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
  public void testOnlineCase3() throws Exception {
    final int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, days = {{7, 0, 0}, {0, 7, 0}, {0, 0, 7}};
    assertEquals(21, solution.maxVacationDays(flights, days));
  }

  @Test
  public void testFailedCase1() throws Exception {
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
