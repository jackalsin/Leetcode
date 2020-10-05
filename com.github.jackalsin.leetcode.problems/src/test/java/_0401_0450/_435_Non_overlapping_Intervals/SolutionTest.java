package _0401_0450._435_Non_overlapping_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import definition.Interval;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final Interval[] input = {new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)};
    assertEquals(1, solution.eraseOverlapIntervals(input));
  }

  @Test
  void testOnlineCase2() {
    final Interval[] input = {new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)};
    assertEquals(2, solution.eraseOverlapIntervals(input));
  }

  @Test
  void testOnlineCase3() {
    final Interval[] input = {new Interval(1, 2), new Interval(2, 3)};
    assertEquals(0, solution.eraseOverlapIntervals(input));
  }
}