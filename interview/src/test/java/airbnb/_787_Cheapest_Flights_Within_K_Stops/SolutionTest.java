package airbnb._787_Cheapest_Flights_Within_K_Stops;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DijkstraSolutionI(),
        new DijkstraSolution(),
        new BellmanFordSolutionI(),
        new BellmantFordSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 3;
    final int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    final int src = 0;
    final int dst = 2;
    final int k = 1;
    assertEquals(200, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 3;
    final int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    final int src = 0;
    final int dst = 2;
    final int k = 0;
    assertEquals(500, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 5;
    final int[][] edges = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
    final int src = 0;
    final int dst = 2;
    final int k = 2;
    assertEquals(7, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTLE(Solution solution) {
    final int n = 13;
    final int[][] edges = {{11, 12, 74}, {1, 8, 91}, {4, 6, 13}, {7, 6, 39}, {5, 12, 8}, {0, 12, 54}, {8, 4, 32}, {0,
        11, 4}, {4, 0, 91}, {11, 7, 64}, {6, 3, 88}, {8, 5, 80}, {11, 10, 91}, {10, 0, 60}, {8, 7, 92}, {12, 6, 78}, {6,
        2, 8}, {4, 3, 54}, {3, 11, 76}, {3, 12, 23}, {11, 6, 79}, {6, 12, 36}, {2, 11, 100}, {2, 5, 49}, {7, 0, 17}, {5
        , 8, 95}, {3, 9, 98}, {8, 10, 61}, {2, 12, 38}, {5, 7, 58}, {9, 4, 37}, {8, 6, 79}, {9, 0, 1}, {2, 3, 12}, {7,
        10, 7}, {12, 10, 52}, {7, 2, 68}, {12, 2, 100}, {6, 9, 53}, {7, 4, 90}, {0, 5, 43}, {11, 2, 52}, {11, 8, 50},
        {12, 4, 38}, {7, 9, 94}, {2, 7, 38}, {3, 7, 88}, {9, 12, 20}, {12, 0, 26}, {10, 5, 38}, {12, 8, 50}, {0, 2,
        77}, {11, 0, 13}, {9, 10, 76}, {2, 6, 67}, {5, 6, 34}, {9, 7, 62}, {5, 3, 67}};
    final int src = 10;
    final int dst = 1;
    final int k = 10;
    assertEquals(-1, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int n = 3;
    final int[][] edges = {
        {0, 1, 2}, {1, 2, 1}, {2, 0, 10}
    };
    final int src = 1;
    final int dst = 2;
    final int k = 1;
    assertEquals(1, solution.findCheapestPrice(n, edges, src, dst, k));
  }
}