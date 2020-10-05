package _0451_0500._465_Optimal_Account_Balancing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] trans = {{0, 1, 10}, {2, 0, 5}};
    assertEquals(2, solution.minTransfers(trans));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] trans = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
    assertEquals(1, solution.minTransfers(trans));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testDfs(Solution solution) {
    final List<Integer> debt = new ArrayList<>(List.of(5, 4, 3, -10, -2));
    assertEquals(4, solution.dfs(debt, 0, 0));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[][] trans = {{2, 0, 5}, {3, 4, 4}};
    assertEquals(2, solution.minTransfers(trans));
  }

}