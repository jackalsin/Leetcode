package uber._759_Employee_Free_Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 2), new Interval(5, 6)),
        List.of(new Interval(1, 3)),
        List.of(new Interval(4, 10))
    );

    final List<Interval> expected = List.of(new Interval(3, 4));
    final List<Interval> actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final List<List<Interval>> input = List.of(
        List.of(new Interval(1, 3), new Interval(6, 7)),
        List.of(new Interval(2, 4)),
        List.of(new Interval(2, 5), new Interval(9, 12))
    );

    final List<Interval> expected = List.of(
        new Interval(5, 6), new Interval(7, 9)
    );
    final List<Interval> actual = solution.employeeFreeTime(input);
    assertEquals(expected, actual);
  }

}