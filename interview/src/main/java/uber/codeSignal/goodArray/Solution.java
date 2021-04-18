package uber.codeSignal.goodArray;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
public interface Solution {
  /**
   * 有一个数组arr，里边有奇数偶数。一个subarray是“好的”的条件是：奇数偶数肩并肩交叉排列，比如[0,1,2,3], [0,1],[0],[1]... 这些都是合法的，但是[0,0],[2,3,3]
   * 就不是“好的”。问：给了一个arr，里边“好的”subarray有多少个？
   */
  int goodSubarray(final int[] nums);
}
