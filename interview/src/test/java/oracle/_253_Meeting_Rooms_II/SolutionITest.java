package oracle._253_Meeting_Rooms_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2019
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[][] intervals = new int[][]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    final int[][] intervals = {{2, 3}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOverlapEqual(Solution solution) {
    final int[][] intervals = {{13, 15}, {1, 13}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Solution solution) {
    final int[][] intervals = {{7, 10}, {2, 4}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline4(Solution solution) {
    final int[][] intervals = {{5, 8}, {6, 8}};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline5(Solution solution) {
    final int[][] intervals ={{0,30},{5,10},{15,20}};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}