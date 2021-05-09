package google.minStepBy3Operations;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public interface Solution {
  /**
   * 1. 第一轮是个三哥，但出的题目挺友好的。
   * 给你一个整数，有三种操作：除二，除三，减一，问最少需要多少步能到达1。
   * 简单dp. followup是为什么选择dp而不是greedy, 这两种方法的对比.
   *
   * @param num
   * @return
   */
  int minSteps(int num);
}
