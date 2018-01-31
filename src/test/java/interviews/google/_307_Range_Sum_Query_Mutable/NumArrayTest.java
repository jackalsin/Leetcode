package interviews.google._307_Range_Sum_Query_Mutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class NumArrayTest {
  private NumArray numArray;

  @Before
  public void setUp() throws Exception {
  }

  /**
   * Given nums = [1, 3, 5]
   *
   * sumRange(0, 2) -> 9
   * update(1, 2)
   * sumRange(0, 2) -> 8
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
   * ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange",
   * "sumRange","update"]
   * [[[7,2,7,2,0]],[4,6],  [0,2],    [0,9],  [4,4],      [3,8],  [0,4],      [ 4,1],   [0,3],
   * [0,4],     [0,4]]
   * expectation [null,null,null,null,6,null,32,null,26,27,null]
   */
  @Test
  public void testFailed1() throws Exception {
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

}
