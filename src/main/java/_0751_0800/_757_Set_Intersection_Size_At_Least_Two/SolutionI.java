package _0751_0800._757_Set_Intersection_Size_At_Least_Two;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int intersectionSizeTwo(int[][] intervals) {
    /*
      Sort by end, denote max the max in min set, second the max second in min set.
      Scan all the intervals
      1) if largest in the new interval and second of largest in the new interval
          we don't need add to minSet
      2) if largest in the new interval but second of largest not
          we add 1, which is the current largest
      3) if neither in the new interval
          we add 2, safest choice: largest and largest - 1
    */
    /*
    The reason why we need to sort end ascending and reverse start point:
    if we sort start point ascending:
    when we reach
        {11, 18},
        {16, 18}, // second = 11, and largest = 18
        {0, 19},
        {6, 19},
        {7, 19},
        {14, 19},
        {18, 20},
        and we have secondLargest = 11, and largest 18, when we evaluate {16, 18}, after updating:
        second and largest both will become 18, which invalidate the invariant
    * */
    Arrays.sort(intervals, (a, b) -> {
      final int tailCmp = Integer.compare(a[1], b[1]);
      if (tailCmp != 0) return tailCmp;
      return Integer.compare(b[0], a[0]);
    });
    int result = 0, largest = -1, secondLargest = -1;
    for (final int[] interval : intervals) {
      final int a = interval[0], b = interval[1];
      final boolean isLargestInInterval = a <= largest,
          isSecondInInterval = a <= secondLargest;
      if (isLargestInInterval && isSecondInInterval) continue;
      result += (isLargestInInterval ? 1 : 2);
      secondLargest = isLargestInInterval ? largest : b - 1;
      largest = b;
    }
    return result;
  }
}
