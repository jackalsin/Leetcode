package interviews.airbnb._295_Find_Median_from_Data_Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
class MedianFinderTest {
  private MedianFinder solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new MedianFinder();
  }

  @Test
  void testOdd() {
    solution.addNum(2);
    assertEquals(2d, solution.findMedian(), 1E-9);
    solution.addNum(3);
    assertEquals(2.5, solution.findMedian(), 1E-9);
    solution.addNum(4);
    assertEquals(3d, solution.findMedian(), 1E-9);
  }

  @Test
  void testFailedCase1() {
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

}