package interviews.microsoft._056_Merge_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Util.getIntervals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase1() throws Exception {
    List<Interval> actual = solution.merge(getIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}}));
    assertEquals(getIntervals(new int[][]{{1, 6}, {8, 10}, {15, 18}}), actual);
  }

}