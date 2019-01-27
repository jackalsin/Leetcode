package _0951_1000._982_Triples_with_Bitwise_AND_Equal_To_Zero;

import java.util.HashSet;
import java.util.Set;

public final class MySolution implements Solution {
  public int countTriplets(int[] A) {
    final Set<Integer> all = new HashSet<>();
    for (int a : A) {
      all.add(a);
    }
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i; j < A.length; j++) {
        for (int k = j; k < A.length; k++) {
          if ((A[i] & A[j] & A[k]) == 0) {
            if (i == j && j == k) count++;
            else if (i == j || j == k || k == i) count += 3;
            else {
              count += 6;
            }
          }
        }
      }
    }
    return count;
  }

}
