package _0751_0800._753_Cracking_the_Safe;

/**
 * @author jacka
 * @version 1.0 on 1/6/2018.
 */
public interface Solution {
  /**
   * @param k k choice
   */
  String crackSafe(int n, int k);
  /*
  此题解法似乎容易想到，根据题意，最后n位，k个candidate
  假设所有的combination 为一个vertex，那么对于每个vertex有
  1）k indegree 头n - 1个相同，
  2) k outdegree 最后n - 1个相同
  那么也就是必定存在一个欧拉路径，那直接暴力找，找到就是
  */
}
