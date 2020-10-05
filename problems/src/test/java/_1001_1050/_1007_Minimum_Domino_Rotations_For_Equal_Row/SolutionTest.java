package _1001_1050._1007_Minimum_Domino_Rotations_For_Equal_Row;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] A = {2, 1, 2, 4, 2, 2}, B = {5, 2, 6, 2, 3, 2};
    assertEquals(2, solution.minDominoRotations(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] A = {3, 5, 1, 2, 3}, B = {3, 6, 3, 3, 4};
    assertEquals(-1, solution.minDominoRotations(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] A = {1, 2, 1, 1, 1, 2, 2, 2}, B = {2, 1, 2, 2, 2, 2, 2, 2};
    assertEquals(1, solution.minDominoRotations(A, B));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}