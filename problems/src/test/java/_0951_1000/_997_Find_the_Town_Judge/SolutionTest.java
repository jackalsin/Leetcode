package _0951_1000._997_Find_the_Town_Judge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int N = 2;
    final int[][] trust = {{
        1, 2
    }};
    assertEquals(2, solution.findJudge(N, trust));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int N = 3;
    final int[][] trust = {
        {1, 3}, {2, 3}
    };
    assertEquals(3, solution.findJudge(N, trust));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int N = 3;
    final int[][] trust = {
        {1, 3}, {2, 3}, {3, 1}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int N = 3;
    final int[][] trust = {
        {1, 2}, {2, 3}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int N = 4;
    final int[][] trust = {
        {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}
    };
    assertEquals(3, solution.findJudge(N, trust));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final int N = 2;
    final int[][] trust = {
        {1, 2}, {2, 1}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

}