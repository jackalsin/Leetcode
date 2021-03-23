package byteDance._295_Find_Median_from_Data_Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class MedianFinderTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOdd(MedianFinder solution) {
    solution.addNum(2);
    assertEquals(2d, solution.findMedian(), 1E-9);
    solution.addNum(3);
    assertEquals(2.5, solution.findMedian(), 1E-9);
    solution.addNum(4);
    assertEquals(3d, solution.findMedian(), 1E-9);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(MedianFinder solution) {
    solution.addNum(-1);
    assertEquals(-1, solution.findMedian(), 1E-9);
    solution.addNum(-2);
    assertEquals(-1.5, solution.findMedian(), 1E-9);
    solution.addNum(-3);
    assertEquals(-2, solution.findMedian(), 1E-9);
    solution.addNum(-4);
    assertEquals(-2.5, solution.findMedian(), 1E-9);
    solution.addNum(-5);
    assertEquals(-3.0, solution.findMedian(), 1E-9);
  }

  static Stream<MedianFinder> solutionStream() {
    return Stream.of(
        new MedianFinderI(),
        new MedianFinderII()
    );
  }
}