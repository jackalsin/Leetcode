package microsoft.noodleEssence._295_Find_Median_from_Data_Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {
  private MedianFinder solution;

  @BeforeEach
  void setUp() {
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

}