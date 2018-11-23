package _0351_0400._352_Data_Stream_as_Disjoint_Intervals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Interval;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
class SummaryRangesTest {
  private SummaryRanges summaryRanges;

  @BeforeEach
  void setUp() {
    summaryRanges = new SummaryRanges();
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
}
