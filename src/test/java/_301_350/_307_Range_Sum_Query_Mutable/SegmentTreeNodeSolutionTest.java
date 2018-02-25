package _301_350._307_Range_Sum_Query_Mutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeNodeSolutionTest {
  private SegmentTreeNodeSolution solution;

  /**
   * Given nums = [1, 3, 5]
   * <p>
   * sumRange(0, 2) -> 9
   * update(1, 2)
   * sumRange(0, 2) -> 8
   */
  @Test
  void testOnline() {
    final int[] nums = {1, 3, 5};
    solution = new SegmentTreeNodeSolution(nums);
    assertEquals(9, solution.sumRange(0, 2));
    solution.update(1, 2);
    assertEquals(8, solution.sumRange(0, 2));
  }

  @Test
  void testEmpty() {
    final int[] nums = {};
    solution = new SegmentTreeNodeSolution(nums);

  }

  /**
   * ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
   * [[[7,2,7,2,0]],[4,6],  [0,2],    [0,9],  [4,4],      [3,8],  [0,4],      [ 4,1],   [0,3],    [0,4],     [0,4]]
   * expectation [null,null,null,null,6,null,32,null,26,27,null]
   *
   * @throws Exception
   */
  @Test
  void testFailed1() {
    final int[] input = {7, 2, 7, 2, 0};
    solution = new SegmentTreeNodeSolution(input);
    solution.update(4, 6);
    solution.update(0, 2);
    solution.update(0, 9);
    assertEquals(6, solution.sumRange(4, 4));
    solution.update(3, 8);
    assertEquals(32, solution.sumRange(0, 4));
    solution.update(4, 1);
    assertEquals(26, solution.sumRange(0, 3));
    assertEquals(27, solution.sumRange(0, 4));
    solution.update(0, 4);
  }
}