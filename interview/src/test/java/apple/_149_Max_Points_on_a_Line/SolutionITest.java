package apple._149_Max_Points_on_a_Line;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/14/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCountSelf(Solution solution) {
    final int[][] points = {{0, 0}};
    assertEquals(1, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[][] points = {};
    assertEquals(0, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[][] points = {{0, 0}, {1, 1}, {0, 0}};
    assertEquals(3, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    //Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    final int[][] points = {{1, 1}, {3, 2},
        {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    assertEquals(4, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase3(Solution solution) {
    final int[][] points = {{15, 12}, {9, 10}, {-16, 3}, {-15, 15}, {11, -10}, {-5, 20}, {-3, -15}, {-11, -8},
        {-8, -3}, {3, 6}, {15, -14}, {-16, -18}, {-6, -8}, {14, 9}, {-1, -7},
        {-1, -2}, {3, 11}, {6, 20}, {10, -7}, {0, 14}, {19, -18}, {-10, -15}, {-17, -1}, {8, 7}, {20, -18}, {-4, -9},
        {-9, 16}, {10, 14}, {-14, -15}, {-2, -10}, {-18, 9}, {7, -5}, {-12, 11}, {-17, -6}, {5, -17}, {-2, -20}, {15,
        -2}, {-5, -16}, {1, -20}, {19, -12}, {-14, -1}, {18, 10}, {1, -20}, {-15, 19}, {-18, 13}, {13, -3}, {-16,
        -17}, {1, 0}, {20, -18}, {7, 19}, {1, -6}, {-7, -11}, {7, 1}, {-15, 12}, {-1, 7}, {-3, -13}, {-11, 2}, {-17,
        -5}, {-12, -14}, {15, -3}, {15, -11}, {7, 3}, {19, 7}, {-15, 19}, {10, -14}, {-14, 5}, {0, -1}, {-12, -4}, {4
        , 18}, {7, -3}, {-5, -3}, {1, -11}, {1, -1}, {2, 16}, {6, -6}, {-17, 9}, {14, 3}, {-13, 8}, {-9, 14}, {-5,
        -1}, {-18, -17}, {9, -10}, {19, 19}, {16, 7}, {3, 7}, {-18, -12}, {-11, 12}, {-15, 20}, {-3, 4}, {-18, 1},
        {13, 17}, {-16, -15}, {-9, -9}, {15, 8}, {19, -9}, {9, -17}};
    assertEquals(6, solution.maxPoints(points));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}