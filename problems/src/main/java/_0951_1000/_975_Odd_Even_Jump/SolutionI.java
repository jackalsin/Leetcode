package _0951_1000._975_Odd_Even_Jump;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhixi
 * @version 1.0 on 3/27/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int oddEvenJumps(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int N = A.length;
    final int[] nextOdd = new int[N],
        nextEven = new int[N];
    Arrays.fill(nextOdd, -1);
    Arrays.fill(nextEven, -1);
    final TreeMap<Integer, Integer> valToIndex = new TreeMap<>();
    for (int i = N - 1; i >= 0; --i) {
      final Map.Entry<Integer, Integer> oddEntry = valToIndex.ceilingEntry(A[i]),
          evenEntry = valToIndex.floorEntry(A[i]);
      if (oddEntry != null) {
        nextOdd[i] = oddEntry.getValue();
      }
      if (evenEntry != null) {
        nextEven[i] = evenEntry.getValue();
      }
      valToIndex.put(A[i], i);
    }
//    System.out.println(Arrays.toString(nextOdd));
//    System.out.println(Arrays.toString(nextEven));
    int count = 0;
    nextStart:
    for (int start = 0; start < N; start++) {
      for (int i = start, times = 1; i < N; times++) {
        if (i == -1) {
          continue nextStart;
        }
        if (i == N - 1) {
          count++;
          continue nextStart;
        }
        if (times % 2 != 0) {
          i = nextOdd[i];
        } else {
          i = nextEven[i];
        }
      }
    }
    return count;
  }
}
