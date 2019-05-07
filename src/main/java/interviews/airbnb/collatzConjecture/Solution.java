package interviews.airbnb.collatzConjecture;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public interface Solution {

  /**
   * 比如偶数的话除 2，奇数的话就变成 3*n+1，对于任何一个正数，数学猜想是最
   * 终他会变成 1。每变一步步数加 1，给一个上限，让找出范围内最长步数
   *
   * @param num input number
   * @return max steps
   */
  int findTheLongestStep(final int num);
}
