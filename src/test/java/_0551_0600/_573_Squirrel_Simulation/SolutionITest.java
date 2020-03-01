package _0551_0600._573_Squirrel_Simulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] tree = {2, 2}, squirrel = {4, 4};
    final int[][] nuts = {{3, 0}, {2, 5}};
    assertEquals(12, solution.minDistance(5, 7, tree, squirrel, nuts));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new OnePassSolution(),
        new TwoPassSolution()
    );
  }
}