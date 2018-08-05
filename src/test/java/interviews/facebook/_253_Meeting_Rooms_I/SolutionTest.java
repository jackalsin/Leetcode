package interviews.facebook._253_Meeting_Rooms_I;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new PqSolution();
  }

  @Test
  void testEmpty() {
    Interval[] intervals = new Interval[]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOne() {
    Interval[] intervals = new Interval[]{new Interval(2, 3)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnlineCase() {
    Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new
        Interval(15, 20)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOverlapEqual() {
    Interval[] intervals = new Interval[]{new Interval(13, 15), new Interval(1, 13)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnline() {
    Interval[] intervals = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
    assertEquals(1, solution.minMeetingRooms(intervals));

  }

  @Test
  void testOnline2() {
    //                  [[9,10],[4,9],[4,17]]
    Interval[] intervals = new Interval[]{new Interval(9, 10), new Interval(4, 9), new Interval(4, 17)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @Test
  void testOnline3() {
    //                  [[5,8],[6,8]]
    Interval[] intervals = new Interval[]{new Interval(5, 8), new Interval(6, 8)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }
}