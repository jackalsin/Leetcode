package _0051_0100._057_Insert_Interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Interval;
import utils.Util;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase1(Solution solution) {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 3}, {6, 9}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}, {6, 9}});
    assertEquals(expected, solution.insert(input, new Interval(2, 5)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineCase2(Solution solution) {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    assertEquals(expected, solution.insert(input, new Interval(4, 9)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithMissingLastIndex(Solution solution) {
    List<Interval> input = Util.getIntervals(new int[][]{{1, 5}});
    List<Interval> expected = Util.getIntervals(new int[][]{{1, 5}});
    assertEquals(expected, solution.insert(input, new Interval(2, 3)));
  }
}