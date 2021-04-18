package uber.codeSignal.digitCounts;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
public interface Solution {
  /**
   * 1. 在0-n的范围里，数字0,2,4一共出现了多少次？比如，n=10，答案是4，因为0出现在0，10里；2 出现在 2 里，4 出现在 4里。
   */
  int digitCounts(final int n);
}
