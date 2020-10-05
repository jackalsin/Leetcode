package _0901_0950._949_Largest_Time_for_Given_Digits;

/**
 * @author zhixi
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String largestTimeFromDigits(int[] A) {
    String maxHour = "", maxMin = "";
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 4; ++j) {
        if (i == j) continue;
        final String h = "" + A[i] + A[j];
        if (h.compareTo("24") >= 0) continue;
        for (int k = 0; k < 4; ++k) {
          if (k == i || k == j) continue;
          final int l = 6 - i - j - k;
          final String m = "" + A[k] + A[l];
          if (m.compareTo("60") >= 0) continue;
          if (maxHour.compareTo(h) < 0 || maxHour.equals(h) && maxMin.compareTo(m) < 0) {
            maxHour = h;
            maxMin = m;
          }
        }
      }
    }
    return maxHour.isEmpty() ? "" : maxHour + ":" + maxMin;
  }
}
