package facebook._493_Reverse_Pairs;

import java.util.Arrays;


public final class BinaryIndexTreeSolution implements Solution {

  public int reversePairs(int[] nums) {
    final int[] tree = new int[nums.length + 1];
    final int[] sorted = new int[nums.length];
    System.arraycopy(nums, 0, sorted, 0, nums.length);
    Arrays.sort(sorted);
    int res = 0;

    // BIT[i] indicates the count of element in sorted
    // that has been inserted to BIT
    for (int j = 0; j < nums.length; j++) {
      // 这个index之后的都符合
      final int index = index(sorted, 2L * nums[j] + 1);
      res += search(tree, index);
      insert(tree, index(sorted, nums[j]));
    }

    return res;
  }

  private void insert(int[] tree, int i) {
    ++i;
    while (i > 0) {
      tree[i] += 1;
      i -= i & -i;
    }
  }

  private int search(int[] tree, int i) {
    ++i;
    int res = 0;
    while (i < tree.length) {
      res += tree[i];
      i += i & -i;
    }
    return res;
  }

  private int index(int[] nums, long val) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == val) {
        return mid;
      } else if (nums[mid] < val) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left + 1;
  }

}
