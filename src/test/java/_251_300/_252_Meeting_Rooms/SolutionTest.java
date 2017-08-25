package _251_300._252_Meeting_Rooms;

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
    final Interval[] input = new Interval[] {};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  public void testOne() throws Exception {
    final Interval[] input = new Interval[] {new Interval(3, 6)};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  public void testMulti() throws Exception {
    final Interval[] input = new Interval[] {new Interval(3, 6), new Interval(6, 20)};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  public void testNegative() throws Exception {
    final Interval[] input = new Interval[] {new Interval(3, 6), new Interval(3, 20)};
    assertFalse(solution.canAttendMeetings(input));
  }

}
