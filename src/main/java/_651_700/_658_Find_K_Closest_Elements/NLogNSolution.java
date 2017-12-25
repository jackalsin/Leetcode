package _651_700._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

public final class NLogNSolution implements Solution {
  @Override
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int lo = 0, hi = arr.length - k;
    while (lo < hi) {
      int mid = (hi - lo) / 2 + lo;
      if (x - arr[mid] > arr[mid + k] - x) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = lo; i < lo + k; i++) {
      result.add(arr[i]);
    }
    return result;
  }
}
