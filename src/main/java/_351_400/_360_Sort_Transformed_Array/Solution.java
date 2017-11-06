package _351_400._360_Sort_Transformed_Array;

import java.util.Arrays;


/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class Solution {

  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    final int[] result = new int[nums.length];
    int left = 0, right = nums.length - 1, i = a >= 0 ? nums.length - 1 : 0;
    while (left <= right) {
      if (a >= 0) {
        if (actualVal(nums[left], a, b, c) <= actualVal(nums[right], a, b, c)) {
          result[i--] = actualVal(nums[right--], a, b, c);
        } else {
          result[i--] = actualVal(nums[left++], a, b, c);
        }
      } else {
        if (actualVal(nums[left], a, b, c) <= actualVal(nums[right], a, b, c)) {
          result[i++] = actualVal(nums[left++], a, b, c);
        } else {
          result[i++] = actualVal(nums[right--], a, b, c);
        }
      }
    }
    return result;
  }
  private int actualVal(int num, int a, int b, int c) {
    return a * num * num + b * num + c;
  }
}
