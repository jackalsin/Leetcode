package _0301_0350._315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.List;

public final class MergeSortSolution implements Solution {
  @Override
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    /* During sorting, we don't sort nums, we sort index */
    final int[] count = new int[nums.length], index = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      index[i] = i;
    }

    mergeSort(nums, index, count, 0, nums.length - 1);

    final List<Integer> result = new ArrayList<>();
    for (int c : count) {
      result.add(c);
    }
    return result;
  }

  private void mergeSort(final int[] nums, final int[] index, final int[] count, final int start, final int end) {
    if (start >= end) {
      return;
    }

    int mid = (end - start) / 2 + start;

    mergeSort(nums, index, count, start, mid);
    mergeSort(nums, index, count, mid + 1, end);

    merge(nums, index, count, start, end);
  }

  private void merge(final int[] nums, final int[] index, final int[] count, final int start,
                     final int end) {
    int left = start, mid = start + (end - start) / 2, right = mid + 1;
    final int[] newIndex = new int[end - start + 1];
    int p = 0, rightCount = 0;
    while (left <= mid || right <= end) {
      if (left <= mid && right <= end) {
        if (nums[index[right]] < nums[index[left]]) {
          newIndex[p] = index[right];
          rightCount++;
          right++;
        } else {
          newIndex[p] = index[left];
          count[index[left]] += rightCount;
          left++;
        }
      } else if (left <= mid) {
        newIndex[p] = index[left];
        count[index[left]] += rightCount;
        left++;
      } else {
        newIndex[p] = index[right];
        rightCount++;
        right++;
      }
      p++;
    } // end of while loop

    // copy to old index
    System.arraycopy(newIndex, 0, index, start, end - start + 1);
  }
}
