package _0951_1000._991_Broken_Calculator;

/**
 * @author jacka
 * @version 1.0 on 10/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int brokenCalc(int src, int target) {
    /* 初步观察可得
    1. 当 x <= 1/2 * Y时，应当仅考虑 * 2
    2. 对于任何一个数字，至多只需要 -1 一次
    <a href='https://leetcode.com/problems/broken-calculator/discuss/234484/JavaC%2B%2BPython-Change-Y-to-X-in-1-Line
    ' />
    所以倒过来想，从 Y -> X
    1)  / 2
    2) +1
     */
//    System.out.println("src = " + src + ", target = " + target);
    return src >= target ? src - target : 1 + (target % 2) + brokenCalc(src, (target + 1) / 2);
  }
}
