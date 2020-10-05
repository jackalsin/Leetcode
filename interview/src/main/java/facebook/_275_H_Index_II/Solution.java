package facebook._275_H_Index_II;

public class Solution {

  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }

    if (citations[citations.length - 1] == 0) {
      return 0;
    }

    int left = 0, right = citations.length - 1, len = citations.length;
    // h  = (left,right) / 2, citations[h] >= nums.length - 1 - h + 1
    // last occurrence
    while (left < right) {
      final int mid = left + (right - left) / 2, h = len - mid;

      if (citations[mid] >= h) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return len - left;
  }
}
