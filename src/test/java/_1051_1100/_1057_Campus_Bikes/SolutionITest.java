package _1051_1100._1057_Campus_Bikes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[][] workers = {{0, 0}, {2, 1}}, bikes = {{1, 2}, {3, 3}};
    final int[] expected = {1, 0}, actual = solution.assignBikes(workers, bikes);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final int[][] workers = {{0, 0}, {1, 1}, {2, 0}}, bikes = {{1, 0}, {2, 2}, {2, 1}};
    final int[] expected = {0, 2, 1}, actual = solution.assignBikes(workers, bikes);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testFailedCase1() {
//    [[0,0],[1,0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,0]]
//[[0,999],[1,999],[2,999],[3,999],[4,999],[5,999],[6,999],[7,999],[8,999]]
    final int[][] workers = {
        {0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}
    }, bikes = {
        {0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}, {5, 999}, {6, 999}, {7, 999}, {8, 999}
    };
    final int[] expected = {0, 1, 2, 3, 4, 5, 6, 7}, actual = solution.assignBikes(workers, bikes);
    assertArrayEquals(expected, actual);
  }
}