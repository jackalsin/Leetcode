package interviews.microsoft._805_Split_Array_With_Same_Average;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionI implements Solution {
  @Override
  public boolean splitArraySameAverage(int[] A) {
    assert A.length >= 1 && A.length <= 30;
    final int N = A.length, m = N / 2; // m denotes the min array length (possible max)
    int totalSum = 0;
    for (int a : A) {
      totalSum += a;
    }

    final List<Set<Integer>> possibleSum = new ArrayList<>();
    for (int i = 0; i <= m; i++) {
      possibleSum.add(new HashSet<>());
    }
    possibleSum.get(0).add(0);
    // loop
    for (int num : A) {
      for (int i = m; i >= 1; i--) {
        final Set<Integer> sumI = possibleSum.get(i);
        for (int sum : possibleSum.get(i - 1)) {
          sumI.add(sum + num);
        }
      }
    }

    for (int i = 1; i <= m; i++) {
      if (totalSum * i % N != 0) {
        continue;
      }
      if (possibleSum.get(i).contains(totalSum * i / N)) {
        return true;
      }
    }
    return false;
  }
}
