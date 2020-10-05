package facebook._253_Meeting_Rooms_I;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Interval;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    Interval[] intervals = new Interval[]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(2, 3)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new
        Interval(15, 20)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOverlapEqual(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(13, 15), new Interval(1, 13)};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Solution solution) {
    Interval[] intervals = new Interval[]{new Interval(7, 10), new Interval(2, 4)};
    assertEquals(1, solution.minMeetingRooms(intervals));

  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline2(Solution solution) {
    //                  [[9,10],[4,9],[4,17]]
    Interval[] intervals = new Interval[]{new Interval(9, 10), new Interval(4, 9), new Interval(4, 17)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline3(Solution solution) {
    //                  [[5,8],[6,8]]
    Interval[] intervals = new Interval[]{new Interval(5, 8), new Interval(6, 8)};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }
}