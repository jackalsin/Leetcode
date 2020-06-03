package _1451_1500._1453_Maximum_Number_of_Darts_Inside_of_a_Circular_Dartboard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int points[][] = {{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, r = 2;
    assertEquals(4, solution.numPoints(points, r));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int points[][] = {{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}}, r = 5;
    assertEquals(5, solution.numPoints(points, r));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int points[][] = {{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, r = 1;
    assertEquals(1, solution.numPoints(points, r));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int points[][] = {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}}, r = 2;
    assertEquals(4, solution.numPoints(points, r));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final int points[][] = {{2, -3}, {-5, 1}, {-3, -2}, {-1, -4}, {-4, -5}, {-2, -2}, {4, 1}}, r = 3;
    assertEquals(4, solution.numPoints(points, r));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int points[][] = {{9, 26}, {24, 30}, {-16, -21}, {-30, -22}, {-8, -30}, {23, 12}, {4, -11}, {2, 26}, {-14,
        13}, {-3, -3}, {-8, 28}, {-24, 11}, {7, 6}, {13, 16}, {-20, 18}, {5, 22}, {-15, -15}, {-15, 18}, {-30, -3},
        {20, -30}, {19, 24}, {0, 1}, {15, -7}, {12, 0}, {24, 16}, {-8, 26}, {21, 10}, {-23, 18}, {-25, 11}}, r = 23;
    assertEquals(19, solution.numPoints(points, r));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ON3Solution(),
        new ON2LogNSolution()
    );
  }
}