package _1001_1050._1024_Video_Stitching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int clips[][] = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, T = 10, expected = 3,
        actual = solution.videoStitching(clips, T);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int clips[][] = {{0, 1}, {1, 2}}, T = 5, expected = -1,
        actual = solution.videoStitching(clips, T);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int clips[][] = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2
        , 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, T = 9, expected = 3,
        actual = solution.videoStitching(clips, T);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int clips[][] = {{0, 4}, {2, 8}}, T = 5, expected = 2,
        actual = solution.videoStitching(clips, T);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int clips[][] = {{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}}, T = 5, expected = 1,
        actual = solution.videoStitching(clips, T);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}