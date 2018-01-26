package interviews.google._768_Max_Chunks_To_Make_Sorted_II;

/**
 * @author jacka
 * @version 1.0 on 1/26/2018.
 */
public final class Solution {
  public int maxChunksToSorted(int[] arr) {
    final int len = arr.length;
    final int[] maxLeft = new int[arr.length], minRight = new int[arr.length];
    maxLeft[0] = arr[0];
    for (int i = 1; i < maxLeft.length; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
    }

    minRight[len - 1] = arr[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      minRight[i] = Math.min(minRight[i + 1], arr[i]);
    }

    int res = 0;
    for (int i = 0; i + 1 < len; i++) {
      if (maxLeft[i] <= minRight[i + 1]) {
        res++;
      }
    }
    return res + 1;
  }
}
