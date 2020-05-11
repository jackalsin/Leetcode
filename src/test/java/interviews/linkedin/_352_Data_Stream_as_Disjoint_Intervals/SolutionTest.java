package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(SummaryRanges summaryRanges) {
    summaryRanges.addNum(1);
    assertArrayEquals(new int[][]{{1, 1}}, summaryRanges.getIntervals());
    summaryRanges.addNum(3);
    assertArrayEquals(new int[][]{{1, 1}, {3, 3}}, summaryRanges.getIntervals());
    summaryRanges.addNum(7);
    assertArrayEquals(new int[][]{{1, 1}, {3, 3}, {7, 7}}, summaryRanges.getIntervals());
    summaryRanges.addNum(2);
    assertArrayEquals(new int[][]{{1, 3}, {7, 7}}, summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{1, 3}, {6, 7}}, summaryRanges.getIntervals());
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(SummaryRanges summaryRanges) {
//    ["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum",
//    "getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals",
//    "addNum","getIntervals","addNum","getIntervals"]
//    [[],[6],[],[6],[],[0],[],[4],[],[8],[],[7],[],[6],[],[4],[],[7],[],[5],[]]
//    [null,null,[[6,6]],null,[[6,6]],null,[[0,0],[6,6]],null,[[0,0],[4,4],[6,6]],null,[[0,0],[4,4],[6,6],[8,8]],
//    null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,0],[4,4],[6,8]],null,[[0,
//    0],[4,8]]]
    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{6, 6}}, summaryRanges.getIntervals());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(SummaryRanges summaryRanges) {
//["addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals",
//[[6],      [],            [6],     [],            [0],      [],           [4],        [],
//    "addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum",
//    "getIntervals","addNum","getIntervals"]
//    [8],      [],               [7],    [],           [6],      [],           [4],      [],           [7],      [],
//    [5],      []]

    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(0);
    assertArrayEquals(new int[][]{{0, 0}, {6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(4);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(4);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 6}}, summaryRanges.getIntervals());
    summaryRanges.addNum(8);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 6}, {8, 8}}, summaryRanges.getIntervals());
    summaryRanges.addNum(7);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 8}}, summaryRanges.getIntervals());
    summaryRanges.addNum(6);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 8}}, summaryRanges.getIntervals());
    summaryRanges.addNum(4);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 8}}, summaryRanges.getIntervals());
    summaryRanges.addNum(7);
    assertArrayEquals(new int[][]{{0, 0}, {4, 4}, {6, 8}}, summaryRanges.getIntervals());
    summaryRanges.addNum(5);
    assertArrayEquals(new int[][]{{0, 0}, {4, 8}}, summaryRanges.getIntervals());
  }

  static Stream<SummaryRanges> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}