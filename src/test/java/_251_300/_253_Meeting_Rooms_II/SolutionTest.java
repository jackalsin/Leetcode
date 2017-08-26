package _251_300._253_Meeting_Rooms_II;

import org.junit.Before;
import org.junit.Test;

import utils.Interval;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    Interval[] intervals = new Interval[]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @Test
  public void testOne() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(2, 3)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  public void testOnlineCase() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new
        Interval(15, 20)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @Test
  public void testOverlapEqual() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(13, 15), new Interval(1, 13)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  public void testOnline() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
    assertEquals(1, solution.minMeetingRooms(intervals));

  }
}
