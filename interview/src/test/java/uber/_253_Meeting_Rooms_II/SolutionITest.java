package uber._253_Meeting_Rooms_II;

import definition.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void testEmpty() throws Exception {
    Interval[] intervals = new Interval[]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOne() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(2, 3)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnlineCase() throws Exception {
    Interval[] intervals = new Interval[]{
        new Interval(0, 30),
        new Interval(5, 10),
        new Interval(15, 20)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOverlapEqual() throws Exception {
    Interval[] intervals = new Interval[]{
        new Interval(13, 15),
        new Interval(1, 13)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnline() throws Exception {
    Interval[] intervals = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnline2() throws Exception {
    Interval[] intervals = new Interval[]{
        new Interval(1, 5),
        new Interval(8, 9),
        new Interval(8, 9)
    };
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnline3() throws Exception {
    Interval[] intervals = new Interval[]{
        new Interval(2, 11),
        new Interval(6, 16),
        new Interval(11, 16)
    };
    assertEquals(2, solution.minMeetingRooms(intervals));
  }
}