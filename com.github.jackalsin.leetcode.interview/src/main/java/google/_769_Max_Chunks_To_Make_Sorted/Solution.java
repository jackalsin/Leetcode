package google._769_Max_Chunks_To_Make_Sorted;

/**
 * @author jacka
 * @version 1.0 on 1/25/2018.
 */
public class Solution {
  public int maxChunksToSorted(int[] arr) {
    return maxChunksToSorted(arr, 0);
  }

  private int maxChunksToSorted(final int[] arr, int start) {
    if (start == arr.length) {
      return 0;
    }
    int lastIndex = arr[start];
    while (start <= lastIndex) {
      lastIndex = Math.max(lastIndex, arr[start]);
      start++;
    }
    return maxChunksToSorted(arr, start) + 1;
  }
}
