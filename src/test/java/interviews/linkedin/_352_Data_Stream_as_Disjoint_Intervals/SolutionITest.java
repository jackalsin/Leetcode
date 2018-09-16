package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
class SolutionITest {
  private SummaryRanges summaryRanges;

  @BeforeEach
  void setUp() {
    summaryRanges = new SolutionI();
  }

  @Test
  void testOnlineCase() {
    summaryRanges.addNum(1);
    assertEquals(List.of(new Interval(1, 1)), summaryRanges.getIntervals());
    summaryRanges.addNum(3);
    assertEquals(List.of(new Interval(1, 1), new Interval(3, 3)), summaryRanges.getIntervals());
    summaryRanges.addNum(7);
    assertEquals(List.of(new Interval(1, 1), new Interval(3, 3), new Interval(7, 7)),
        summaryRanges.getIntervals());
    summaryRanges.addNum(2);
    assertEquals(List.of(new Interval(1, 3), new Interval(7, 7)), summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertEquals(List.of(new Interval(1, 3), new Interval(6, 7)), summaryRanges.getIntervals());
  }


  @Test
  void testFailedCase1() {
//    ["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]
//    [[],[6],[],[6],[],[0],[],[4],[],[8],[],[7],[],[6],[],[4],[],[7],[],[5],[]]
//    [null,null,[[6,6]],null,[[6,6]],null,[[0,0],[6,6]],null,[[0,0],[4,4],[6,6]],null,[[0,0],[4,4],[6,6],[8,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,8]]]
    summaryRanges.addNum(6);
    assertEquals(List.of(new Interval(6, 6)), summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertEquals(List.of(new Interval(6, 6)), summaryRanges.getIntervals());

  }
}