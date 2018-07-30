package _051_100._056_Merve_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static utils.Util.getIntervals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase1() {
    List<Interval> actual = solution.merge(getIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}}));
    assertEquals(getIntervals(new int[][]{{1, 6}, {8, 10}, {15, 18}}), actual);
  }


}