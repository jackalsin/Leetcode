package _0451_0500._493_Reverse_Pairs;

import java.util.Arrays;

public class BinaryIndexTreeSolution implements Solution {
  @Override
  public int reversePairs(int[] nums) {
    final int[] sorted = Arrays.copyOf(nums, nums.length);
    final int[] binaryIndexTree = new int[nums.length + 1];

    Arrays.sort(sorted);
    int result = 0;
    for (int element : nums) {
      int index1 = index(sorted, 2L * element + 1);
      result += search(binaryIndexTree, index1);
      insert(binaryIndexTree, index(sorted, element));
    }
    return result;
  }

  private int search(int[] bit, int i) {
    int sum = 0;

    while (i < bit.length) {
      sum += bit[i];
      i += i & -i;
    }

    return sum;
  }

  private void insert(int[] bit, int i) {
    while (i > 0) {
      bit[i] += 1;
      i -= i & -i;
    }
  }

  private int index(int[] sorted, long val) {
    int left = 0, right = sorted.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (sorted[mid] >= val) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left + 1;
  }
}
