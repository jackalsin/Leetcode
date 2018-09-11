package interviews.linkedin._056_Merge_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Util.getIntervals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIII();
  }

  @Test
  void testWithOnlineCase1() {
    List<Interval> actual = solution.merge(getIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}}));
    assertEquals(getIntervals(new int[][]{{1, 6}, {8, 10}, {15, 18}}), actual);
  }

}