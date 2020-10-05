package _0951_1000._969_Pancake_Sorting;

import java.util.ArrayList;
import java.util.List;

public final class FourStepsSolution implements Solution {

  /**
   * Time Complexity: O(N^2)
   * Space Complexity: O(1)
   *
   * @param A
   * @return
   */
  public List<Integer> pancakeSort(int[] A) {
    final List<Integer> result = new ArrayList<>();
    for (int leftSort = A.length - 2; leftSort >= 0; leftSort--) {
//      System.out.println(leftSort);
      if (A[leftSort] <= A[leftSort + 1]) continue;
      final int k = lastSmaller(A, A[leftSort], leftSort + 1, A.length - 1);
      result.add(k + 1);
      flip(A, k + 1);
      result.add(k - leftSort);
      flip(A, k - leftSort);
      result.add(k - leftSort + 1);
      flip(A, k - leftSort + 1);
      result.add(k + 1);
      flip(A, k + 1);
//      System.out.println(Arrays.toString(A));
    }
    return result;
  }

  private static int lastSmaller(final int[] nums, int target, int left, int right) {
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    if (nums[left] < target) {
      return left;
    }
    return left - 1;
  }

  static void flip(final int[] nums, int i) {
    int left = 0, right = i - 1;
    while (left < right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      left++;
      right--;
    }
  }
}
