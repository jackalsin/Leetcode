package interviews.airbnb._787_Cheapest_Flights_Within_K_Stops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
class BellmantFordSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BellmantFordSolution();
  }

  @Test
  void testOnlineCase1() {
    final int n = 3;
    final int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    final int src = 0;
    final int dst = 2;
    final int k = 1;
    assertEquals(200, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @Test
  void testOnlineCase2() {
    final int n = 3;
    final int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    final int src = 0;
    final int dst = 2;
    final int k = 0;
    assertEquals(500, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @Test
  void testOnlineCase3() {
    final int n = 5;
    final int[][] edges = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
    final int src = 0;
    final int dst = 2;
    final int k = 2;
    assertEquals(7, solution.findCheapestPrice(n, edges, src, dst, k));
  }
}