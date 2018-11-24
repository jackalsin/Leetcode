package _0051_0100._057_Insert_Interval;

import org.junit.Before;
import org.junit.Test;
import utils.Interval;
import utils.Util;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase1() throws Exception {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 3}, {6, 9}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}, {6, 9}});
    assertEquals(expected, solution.insert(input, new Interval(2, 5)));
  }

  @Test
  public void testWithOnlineCase2() throws Exception {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    assertEquals(expected, solution.insert(input, new Interval(4, 9)));
  }

  @Test
  public void testWithMissingLastIndex() throws Exception {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 5}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}});
    assertEquals(expected, solution.insert(input, new Interval(2, 3)));
  }
}