package _851_900._898_Bitwise_ORs_of_Subarrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int subarrayBitwiseORs(int[] A) {
    final Set<Integer> result = new HashSet<>();
    Set<Integer> prevSet = new HashSet<>(); // store all the bit wise end here

    for (int i : A) {
      final Set<Integer> newSet = new HashSet<>();
      newSet.add(i);
      for (int j : prevSet) {
        newSet.add(i | j);
      }
      prevSet = newSet;
      result.addAll(newSet);
    }
    return result.size();
  }
}
