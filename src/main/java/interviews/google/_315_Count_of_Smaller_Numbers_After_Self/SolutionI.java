package interviews.google._315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/1/2020
 */
public final class SolutionI implements Solution {

  private int[] newIndex;

  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    final int N = nums.length;
    final int[] count = new int[N],
        index = new int[N];
    newIndex = new int[N];
    for (int i = 0; i < N; ++i) {
      index[i] = i;
    }
    mergeSort(nums, count, index, 0, N - 1);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < N; ++i) {
      result.add(count[i]);
    }
    return result;
  }

  private void mergeSort(final int[] nums, final int[] result, final int[] index, final int start, final int end) {
    if (start >= end) {
      return;
    }
    final int mid = (end - start) / 2 + start;
    mergeSort(nums, result, index, start, mid);
    mergeSort(nums, result, index, mid + 1, end);

    merge(nums, result, index, start, end);
  }

  private void merge(final int[] nums, final int[] result, final int[] sortIndex, final int start, final int end) {
    int left = start, mid = (end - start) / 2 + start, right = mid + 1;
    int rightCount = 0;
    for (int newIndexPtr = left; left <= mid || right <= end; newIndexPtr++) {
      if (left <= mid && right <= end) {
        if (nums[sortIndex[left]] <= nums[sortIndex[right]]) {
          newIndex[newIndexPtr] = sortIndex[left];
          result[sortIndex[left]] += rightCount;
          left++;
        } else {
          newIndex[newIndexPtr] = sortIndex[right];
          rightCount++;
          right++;
        }
      } else if (left <= mid) {
        newIndex[newIndexPtr] = sortIndex[left];
        result[sortIndex[left]] += rightCount;
        left++;
      } else {
        newIndex[newIndexPtr] = sortIndex[right];
        right++;
      }
    }
    System.arraycopy(newIndex, start, sortIndex, start, end - start + 1);
  }
}
