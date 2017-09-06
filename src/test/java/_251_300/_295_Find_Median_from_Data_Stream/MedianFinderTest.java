package _251_300._295_Find_Median_from_Data_Stream;

import org.junit.Before;
import org.junit.Test;

import _101_150._140_Word_Break_II.Solution;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class MedianFinderTest {
  private MedianFinder solution;
  @Before
  public void setUp() throws Exception {
    solution = new MedianFinder();
  }

  @Test
  public void testOdd() throws Exception {
    solution.addNum(2);
    assertEquals(2d, solution.findMedian(), 1E-9);
    solution.addNum(3);
    assertEquals(2.5, solution.findMedian(), 1E-9);
    solution.addNum(4);
    assertEquals(3d, solution.findMedian(), 1E-9);
  }

}
