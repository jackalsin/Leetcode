package _751_800._787_Cheapest_Flights_Within_K_Stops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DijkstraSolution();
  }

  @Test
  void testOnlineCase1() {
    final int n = 3, edges[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, src = 0, dst = 2, k = 1;
    assertEquals(200, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @Test
  void testOnlineCase2() {
    final int n = 3, edges[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, src = 0, dst = 2, k = 0;
    assertEquals(500, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @Test
  void testOnlineCase3() {
    final int n = 5, edges[][] = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, src = 0, dst = 2, k = 2;
    assertEquals(7, solution.findCheapestPrice(n, edges, src, dst, k));
  }
}