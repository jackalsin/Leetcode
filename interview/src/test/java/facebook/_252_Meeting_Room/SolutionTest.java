package facebook._252_Meeting_Room;

import definition.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    final Interval[] input = new Interval[]{};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testOne() {
    final Interval[] input = new Interval[]{new Interval(3, 6)};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testMulti() {
    final Interval[] input = new Interval[]{new Interval(3, 6), new Interval(6, 20)};
    assertTrue(solution.canAttendMeetings(input));
  }

  @Test
  void testNegative() {
    final Interval[] input = new Interval[]{new Interval(3, 6), new Interval(3, 20)};
    assertFalse(solution.canAttendMeetings(input));
  }


}