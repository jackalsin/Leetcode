package _0801_0850._836_Rectangle_Overlap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] rec1 = {0, 0, 2, 2}, rec2 = {1, 1, 3, 3};
    assertTrue(solution.isRectangleOverlap(rec1, rec2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] rec1 = {0, 0, 1, 1}, rec2 = {1, 0, 2, 1};
    assertFalse(solution.isRectangleOverlap(rec1, rec2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] rec1 = {7, 8, 13, 15}, rec2 = {10, 8, 12, 20};
    assertTrue(solution.isRectangleOverlap(rec1, rec2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}