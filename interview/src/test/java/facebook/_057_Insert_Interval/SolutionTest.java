package facebook._057_Insert_Interval;

import definition.Interval;
import definition.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase1() {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 3}, {6, 9}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}, {6, 9}});
    assertEquals(expected, solution.insert(input, new Interval(2, 5)));
  }

  @Test
  void testWithOnlineCase2() {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    assertEquals(expected, solution.insert(input, new Interval(4, 9)));
  }

  @Test
  void testWithMissingLastIndex() {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 5}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}});
    assertEquals(expected, solution.insert(input, new Interval(2, 3)));
  }
}