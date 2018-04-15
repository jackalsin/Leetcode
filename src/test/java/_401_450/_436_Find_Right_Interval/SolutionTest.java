package _401_450._436_Find_Right_Interval;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final Interval[] intervals = {new Interval(1, 2)};
    assertArrayEquals(new int[]{-1}, solution.findRightInterval(intervals));
  }

  @Test
  void testOnlineCase2() {
    final Interval[] intervals = {
        new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)};
    assertArrayEquals(new int[]{-1, 0, 1}, solution.findRightInterval(intervals));
  }

  @Test
  void testOnlineCase3() {
    final Interval[] intervals = {
        new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)
    };
    assertArrayEquals(new int[]{-1, 2, -1}, solution.findRightInterval(intervals));
  }
}