package _351_400._352_Data_Stream_as_Disjoint_Intervals;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import utils.Interval;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class SummaryRangesTest {
  private SummaryRanges summaryRanges;
  @Before
  public void setUp() throws Exception {
    summaryRanges = new SummaryRanges();
  }

  @Test
  public void testOnlineCase() throws Exception {
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
