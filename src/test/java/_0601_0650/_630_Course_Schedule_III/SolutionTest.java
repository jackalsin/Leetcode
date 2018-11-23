package _0601_0650._630_Course_Schedule_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
    assertEquals(3, solution.scheduleCourse(input));
  }

  @Test
  void testFailedCase() {
    final int[][] input = {{1, 2}, {2, 3}};
    assertEquals(2, solution.scheduleCourse(input));
  }

  @Test
  void testFailedCase2() {
    final int[][] input = {{5, 5}, {4, 6}, {2, 6}};
    assertEquals(2, solution.scheduleCourse(input));
  }
}