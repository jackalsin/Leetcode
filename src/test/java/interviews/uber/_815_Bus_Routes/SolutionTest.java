package interviews.uber._815_Bus_Routes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] routes = {
        {1, 2, 7}, {3, 6, 7}
    };
    final int actual = solution.numBusesToDestination(routes, 1, 6);
    assertEquals(2, actual);
  }

  /**
   * The same route, no change
   */
  @Test
  void testOnlineCase2() {
    final int[][] routes = {
        {1, 2, 7}, {3, 6, 7}
    };
    final int actual = solution.numBusesToDestination(routes, 6, 3);
    assertEquals(1, actual);
  }

  /**
   * The same route, no change
   */
  @Test
  void testFailedCase1() {
//    [[1,9,12,20,23,24,35,38],
//    [10,21,24,31,32,34,37,38,43],
//    [10,19,28,37],
//    [8],
//    [14,19],
//    [11,17,23,31,41,43,44],
//    [21,26,29,33],
//    [5,11,33,41],
//    [4,5,8,9,24,44]]
//    37
//    28
    final int[][] routes = {
        {1, 9, 12, 20, 23, 24, 35, 38},
        {10, 21, 24, 31, 32, 34, 37, 38, 43},
        {10, 19, 28, 37},
        {8},
        {14, 19},
        {11, 17, 23, 31, 41, 43, 44},
        {21, 26, 29, 33},
        {5, 11, 33, 41},
        {4, 5, 8, 9, 24, 44}
    };
    final int actual = solution.numBusesToDestination(routes, 37, 28);
    assertEquals(1, actual);
  }

  @Test
  void testFailedCase2() {
    final int[][] routes = {
        {1, 7}, {3, 5}
    };
    final int actual = solution.numBusesToDestination(routes, 5, 5);
    assertEquals(0, actual);
  }

  @Test
  void testFailedCase3() {
    final int[][] routes = {
        {10, 13, 22, 28, 32, 35, 43}, // 43 here
        {2, 11, 15, 25, 27},
        {6, 13, 18, 25, 42},
        {5, 6, 20, 27, 37, 47}, // 37 here
        {7, 11, 19, 23, 35},
        {7, 11, 17, 25, 31, 43, 46, 48}, // 43 here
        {1, 4, 10, 16, 25, 26, 46},
        {7, 11},
//        {3, 9, 19, 20, 21, 24, 32, 45, 46, 49},
        {11, 41}
    };

    // 37 -> 6 -> 25 -> 43
    final int actual = solution.numBusesToDestination(routes, 37, 43);
    assertEquals(3, actual);
  }
}