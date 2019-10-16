package interviews.oracle._253_Meeting_Rooms_II;

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
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final int[][] intervals = new int[][]{};
    assertEquals(0, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOne(Solution solution) {
    final int[][] intervals = {{2, 3}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
    assertEquals(2, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOverlapEqual(Solution solution) {
    final int[][] intervals = {{13, 15}, {1, 13}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline(Solution solution) {
    final int[][] intervals = {{7, 10}, {2, 4}};
    assertEquals(1, solution.minMeetingRooms(intervals));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}