package interviews.tableau.rearrangeOrder;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public interface Solution {
  /**
   * 调整一个integer数组。把奇数放在奇数位，偶数放在偶数位，for example: [1, 2, 3, 4, 5, 6] => [2, 1, 4, 3, 6, 5]
   *
   * @param nums
   */
  void rearrange(final int[] nums);
}
