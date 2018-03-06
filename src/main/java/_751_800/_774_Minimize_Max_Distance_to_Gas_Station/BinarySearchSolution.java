package _751_800._774_Minimize_Max_Distance_to_Gas_Station;

public final class BinarySearchSolution implements Solution {

  /**
   * Time Complexity: O(N Log W), where W is 1E8/1E-6
   */
  @Override
  public double minmaxGasDist(int[] stations, int K) {
    double left = 0, right = 1E8;
    while (right - left > 1E-6) {
      double mid = (left + right) / 2;
      if (possible(mid, stations, K)) {
        right = mid;
      } else {
        left = mid;
      }
    }
//    return left;
    return right;
  }

  /**
   * * Return true if it's possible to use up to <tt>k</tt> stations to minimize the max distance to
   * <tt>mid</tt>
   */
  private boolean possible(double mid, int[] stations, int k) {
    int count = 0;
    for (int i = 0; i < stations.length - 1; i++) {
      count += Math.floor(((double) (stations[i + 1] - stations[i])) / mid);
    }
    return count <= k;
  }
}
