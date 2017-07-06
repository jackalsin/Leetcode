package _101_150._137_Single_Number_II;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;

    for (int i : nums) {
      ones = (ones ^ i) & ~twos;
      twos = (twos ^ i) & ~ones;
      System.out.println("one = " + Integer.toBinaryString(ones));
      System.out.println("two = " + Integer.toBinaryString(twos));
    }
    return ones;
  }

  public static void main(String[] args) {
    final int[] nums = new int[] {7, 7, 7};
    System.out.println(new Solution().singleNumber(nums));
  }

}
