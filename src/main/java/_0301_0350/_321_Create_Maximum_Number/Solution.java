package _0301_0350._321_Create_Maximum_Number;

/**
 * @author jacka
 * @version 1.0 on 9/24/2017.
 */
public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] max = new int[k];
    for(int leftK = 0; leftK <= k; ++leftK) {
      // ranmge  check
      if (leftK > nums1.length || (k - leftK) > nums2.length) continue;
      int[] left = findMaxNDigits(nums1, leftK);
      int[] right = findMaxNDigits(nums2, k - leftK);

      int[] merged = merge(left, right);
      if (mergeIsGreater(max, merged)) {
        max = merged;
      }
    }
    return max;
  }

  private boolean mergeIsGreater(int[] max, int[] merged) {
    for (int i = 0; i < max.length; ++i) {
      if (max[i] != merged[i]) {
        return merged[i] > max[i];
      }
    }
    return false;
  }

  private int[] merge(int[] left, int[] right) {
    final int[] result = new int[left.length + right.length];
    int i = 0, leftIndex = 0, rightIndex = 0;
    while (leftIndex != left.length || rightIndex != right.length) {
      if (leftIndex == left.length) {
        System.arraycopy(right, rightIndex, result, i, right.length - rightIndex);
        break;
      } else if (rightIndex == right.length) {
        System.arraycopy(left, leftIndex, result, i, left.length - leftIndex);
        break;
      } else {
        if (left[leftIndex] > right[rightIndex]) {
          result[i++] = left[leftIndex++];
        } else if (left[leftIndex] < right[rightIndex]) {
          result[i++] = right[rightIndex++];
        } else { // equals
          if (leftIsEventuallyGreater(left, leftIndex, right, rightIndex)) {
            result[i++] = left[leftIndex++];
          } else {
            result[i++] = right[rightIndex++];
          }
        }
      }
    }
    return result;
  }

  private boolean leftIsEventuallyGreater(int[] left, int leftIndex, int[] right, int rightIndex) {
    while (leftIndex < left.length && rightIndex <right.length && left[leftIndex] == right[rightIndex]) {
      leftIndex++; rightIndex++;
    }
    if (leftIndex == left.length && rightIndex == right.length) {
      return false;
    } else if (leftIndex != left.length && rightIndex == right.length) {
      return true;
    } else if (leftIndex == left.length) {
      return false;
    } else {
      return left[leftIndex] > right[rightIndex];
    }
  }

  static int[] findMaxNDigits(int[] nums, int digits) {
    final int[] result = new int[digits];
    findMaxNDigits(nums, result, 0, 0);
    return result;
  }

  private static void findMaxNDigits(int[] nums, int[] result, int pos, int start) {
    if (pos == result.length) return;
    int max = nums[start], maxPos = start, remain = result.length - pos;
    for (int i = start; i <= nums.length - remain; i++) {
      if (max < nums[i]) {
        max = nums[i];
        maxPos = i;
      }
    }
    result[pos] = max;
    findMaxNDigits(nums, result, pos + 1, maxPos + 1);
  }
}
