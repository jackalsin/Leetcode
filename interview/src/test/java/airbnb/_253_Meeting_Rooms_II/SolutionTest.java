package airbnb._253_Meeting_Rooms_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    int[][] intervals = new int[][]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    int[][] intervals = {{2, 3}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOverlapEqual(Solution solution) {
    int[][] intervals = {{13, 15}, {1, 13}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Solution solution) {
    int[][] intervals = {{7, 10}, {2, 4}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline3(Solution solution) {
    int[][] intervals = {{6, 17}, {8, 9}, {11, 12}, {6, 9}};
    assertEquals(3, solution.minMeetingRooms(intervals));
  }
}