package _051_100._056_Merve_Intervals;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import utils.Interval;

import static org.junit.Assert.assertEquals;
import static utils.Util.getIntervals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase1() throws Exception {
    List<Interval> actual = solution.merge(getIntervals(new int[][]{ {1,3}, {2, 6}, {8, 10}, {15,
    18}}));
    assertEquals(getIntervals(new int[][]{{1,6}, {8, 10}, {15, 18}}), actual);
  }


}