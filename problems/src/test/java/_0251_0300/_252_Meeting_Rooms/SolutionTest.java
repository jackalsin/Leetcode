package _0251_0300._252_Meeting_Rooms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[][] input = new int[][]{};
    assertTrue(solution.canAttendMeetings(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    final int[][] input = {{3, 6}};
    assertTrue(solution.canAttendMeetings(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMulti(Solution solution) {
    final int[][] input = {{3, 6}, {6, 20}};
    assertTrue(solution.canAttendMeetings(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNegative(Solution solution) {
    final int[][] input = {{3, 6}, {3, 20}};
    assertFalse(solution.canAttendMeetings(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}
