package apple._787_Cheapest_Flights_Within_K_Stops;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/27/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 3, edges[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, src = 0, dst = 2, k = 1;
    assertEquals(200, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 3, edges[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, src = 0, dst = 2, k = 0;
    assertEquals(500, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 5, edges[][] = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, src = 0, dst = 2
        , k = 2;
    assertEquals(7, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int n = 3, edges[][] = {{0, 1, 2}, {1, 2, 1}, {2, 0, 10}},
        src = 1, dst = 2, k = 1;
    assertEquals(1, solution.findCheapestPrice(n, edges, src, dst, k));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DijkstraSolution(),
        new BellmanFordSolution()
    );
  }
}