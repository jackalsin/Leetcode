package interviews.oracle._315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/19/2019
 */
public final class SolutionI implements Solution {
  private int[] newIndex;

  public List<Integer> countSmaller(int[] nums) {
    final List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    final int n = nums.length;
    final int[] count = new int[n], index = new int[n];
    newIndex = new int[n];
    for (int i = 0; i < index.length; ++i) {
      index[i] = i;
    }
    mergeSort(nums, count, index, 0, n - 1);
    for (int value : count) {
      result.add(value);
    }
    return result;
  }

  private void mergeSort(final int[] nums, final int[] count, final int[] index, final int start,
                         final int end) {
    if (start == end) {
      return;
    }

    final int mid = start + (end - start) / 2;
    mergeSort(nums, count, index, start, mid);
    mergeSort(nums, count, index, mid + 1, end);
    merge(nums, count, index, start, end);
  }

  private void merge(int[] nums, int[] count, int[] index, final int start, final int end) {
    int left = start, mid = start + (end - start) / 2, right = mid + 1, p = start, rightCount = 0;
    while (left <= mid || right <= end) {
      if (left <= mid && right <= end) {
        if (nums[index[left]] <= nums[index[right]]) {
          newIndex[p++] = index[left];
          count[index[left++]] += rightCount;
        } else {
          newIndex[p++] = index[right++];
          rightCount++;
        }
      } else if (left <= mid) {
        newIndex[p++] = index[left];
        count[index[left++]] += rightCount;
      } else {
        newIndex[p++] = index[right++];
        rightCount++;
      }
    }
    assert p == end + 1;
    System.arraycopy(newIndex, start, index, start, end - start + 1);
  }

}
