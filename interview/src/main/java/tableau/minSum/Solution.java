package tableau.minSum;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
public interface Solution {
  /**
   * 给一个数组，任选两个数求和并累加，再把和放回数组再选两个数求和并累加，直到数组只剩一个数为止，求最小的累加和，和LC一千差不多，区别是任意选两个数而不是顺序选两个数，手撸了一个暴力解，结果不对，debug半天一直segv
   * ，结果面试官说可能是他们写的输出函数有点问题，自己手动输出，找到bug，改完，到点，没继续做优化，虽然可以加cache空间换时间，但是没想到什么特别好的表示数组状态的节省空间的方法，有好的idea望不吝赐教
   *
   * @param nums
   * @return
   */
  int minSum(final int[] nums);
}
