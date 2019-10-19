package _0251_0300._253_Meeting_Rooms_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Interval;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    Interval[] intervals = new Interval[]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOne(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(2, 3)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new
        Interval(15, 20)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOverlapEqual(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(13, 15), new Interval(1, 13)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new TwoArraySolution(),
        new PriorityQueueSolution()
    );
  }
}