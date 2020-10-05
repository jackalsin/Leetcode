package _0751_0800._760_Find_Anagram_Mappings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/8/2018.
 */
public class Solution {
  public int[] anagramMappings(int[] A, int[] B) {
    final Map<Integer, List<Integer>> valueToIndex = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      valueToIndex.putIfAbsent(B[i], new ArrayList<>());
      valueToIndex.get(B[i]).add(i);
    }
    final int[] res = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      int val = A[i];
      final List<Integer> candidates = valueToIndex.get(val);
      res[i] = candidates.remove(candidates.size() - 1);
    }
    return res;
  }
}
