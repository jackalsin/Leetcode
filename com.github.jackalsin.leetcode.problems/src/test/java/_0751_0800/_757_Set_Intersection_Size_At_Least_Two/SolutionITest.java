package _0751_0800._757_Set_Intersection_Size_At_Least_Two;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] intervals = {
        {1, 3}, {1, 4}, {2, 5}, {3, 5}
    };
    assertEquals(3, solution.intersectionSizeTwo(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] intervals = {
        {1, 3},
        {6, 7},
        {10, 11},
        {7, 12},
        {0, 13},
        {1, 13},
        {1, 16},
        {10, 16},
        {8, 17},
        {11, 18},
        {16, 18},
        {0, 19},
        {6, 19},
        {7, 19},
        {14, 19},
        {18, 20},
        {10, 22},
        {7, 23},
        {11, 23},
        {15, 23},
        {4, 24},
        {23, 25},
    };
    assertEquals(11, solution.intersectionSizeTwo(intervals));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}