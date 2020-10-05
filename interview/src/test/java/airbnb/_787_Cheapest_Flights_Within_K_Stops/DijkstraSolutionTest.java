package airbnb._787_Cheapest_Flights_Within_K_Stops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
class DijkstraSolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DijkstraSolution();
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

  @Test
  void testOnlineCase4() {
    final int n = 5;
    final int[][] edges = {
        {4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}
    };
    final int src = 2;
    final int dst = 1;
    final int k = 1;
    assertEquals(-1, solution.findCheapestPrice(n, edges, src, dst, k));
  }
}