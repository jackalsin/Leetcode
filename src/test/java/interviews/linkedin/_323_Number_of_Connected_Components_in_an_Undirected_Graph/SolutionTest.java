package interviews.linkedin._323_Number_of_Connected_Components_in_an_Undirected_Graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
    assertEquals(2, solution.countComponents(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    assertEquals(1, solution.countComponents(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 5;
    final int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {3, 4}};
    assertEquals(2, solution.countComponents(5, edges));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}