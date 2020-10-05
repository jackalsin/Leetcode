package uber._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    final List<Integer> result = new ArrayList<>();
    if (arr == null || arr.length <= k) {
      for (int a : arr) {
        result.add(a);
      }
      return result;
    }

    int left = 0, right = arr.length - k;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (x - arr[mid] <= arr[mid + k] - x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    } // end while

    for (int i = left; i < left + k; i++) {
      result.add(arr[i]);
    }
    return result;
  }
}
