package _0301_0350._307_Range_Sum_Query_Mutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/14/2017.
 */
public class NumArrayTest {
  private NumArray numArray;

  @Before
  public void setUp() throws Exception {
  }

  /**
   * Given nums = [1, 3, 5]
   * <p>
   * sumRange(0, 2) -> 9
   * update(1, 2)
   * sumRange(0, 2) -> 8
   *
   * @throws Exception
   */
  @Test
  public void testOnline() throws Exception {
    final int[] nums = {1, 3, 5};
    numArray = new NumArray(nums);
    assertEquals(9, numArray.sumRange(0, 2));
    numArray.update(1, 2);
    assertEquals(8, numArray.sumRange(0, 2));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] nums = {};
    numArray = new NumArray(nums);

  }

  /**
   * ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
   * [[[7,2,7,2,0]],[4,6],  [0,2],    [0,9],  [4,4],      [3,8],  [0,4],      [ 4,1],   [0,3],    [0,4],     [0,4]]
   * expectation [null,null,null,null,6,null,32,null,26,27,null]
   *
   * @throws Exception
   */
  @Test
  public void testFailed1() {
    final int[] input = {7, 2, 7, 2, 0};
    numArray = new NumArray(input);
    numArray.update(4, 6);
    numArray.update(0, 2);
    numArray.update(0, 9);
    assertEquals(6, numArray.sumRange(4, 4));
    numArray.update(3, 8);
    assertEquals(32, numArray.sumRange(0, 4));
    numArray.update(4, 1);
    assertEquals(26, numArray.sumRange(0, 3));
    assertEquals(27, numArray.sumRange(0, 4));
    numArray.update(0, 4);
  }


  /**
   * ["NumArray",                             "sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
   * [[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
   * expectation                        [null,-121,null,118,-104,null,null,-221,-293,null,null]
   *
   * @throws Exception
   */
  @Test
  public void testFailed2() {
    final int[] input = {-28, -39, 53, 65, 11, -56, -65, -39, -43, 97};
    numArray = new NumArray(input);
    assertEquals(-121, numArray.sumRange(5, 6));
    numArray.update(9, 27);
    assertEquals(118, numArray.sumRange(2, 3));
    assertEquals(-104, numArray.sumRange(6, 7));
  }
}
