package _051_100._056_Merve_Intervals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import utils.Interval;

import static org.junit.Assert.*;

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

  private List<Interval> getIntervals(int[][] array) {
    List<Interval> result = new ArrayList<>();
    for (int[] child: array) {
      result.add(new Interval(child[0], child[1]));
    }
    return result;
  }
}