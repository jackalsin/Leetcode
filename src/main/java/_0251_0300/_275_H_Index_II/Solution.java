package _0251_0300._275_H_Index_II;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class Solution {
  public int hIndex(int[] citations) {
    int left = 0, right = citations.length - 1, len = citations.length;
    while (left <= right) {
      int mid = (right - left )/2 + left;
      if (citations[mid] >= len - mid) {
        right = mid - 1; // make sure starting from (right + 1), all fits
      } else {
        left = mid + 1;
      }
    }
    return len - right - 1;
  }
}
