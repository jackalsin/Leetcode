package _0051_0100._056_Merve_Intervals;

import definition.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static definition.Util.getIntervals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase1(Solution solution) {
    List<Interval> actual = solution.merge(getIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}}));
    assertEquals(getIntervals(new int[][]{{1, 6}, {8, 10}, {15, 18}}), actual);
  }

}