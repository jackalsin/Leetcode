package interviews.google.longest_common_prefix_suffix;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {
  /**
   * http://www.1point3acres.com/bbs/thread-308110-1-1.html
   *
   * 第三轮：亚裔小哥。KMP。两个数组 [1,2,3,4,5]， [2,3,4,5,6] 求第一个的subfix和第二个prefix相同的最长情况，比如例子里就是[2,3,4,5]
   * 长度为4.
   */
  public int maxPrefixSuffix(final int[] a, final int[] b) {
//    final int[] next = getNext(b);
    final int[] next = new int[a.length + 1];
    for (int pp = 0, sp = 1; sp < a.length; next[++sp] = pp) {
      pp = a[sp] == b[pp] ? pp + 1 : next[pp];
    }
    return next[next.length - 1];
  }

  int[] getNext(final int[] nums) {
    final int[] next = new int[nums.length + 1];
    for (int pp = 0, sp = 1; sp < nums.length; next[++sp] = pp) {
      pp = nums[pp] == nums[sp] ? pp + 1 : next[pp];
    }
    return next;
  }
}
