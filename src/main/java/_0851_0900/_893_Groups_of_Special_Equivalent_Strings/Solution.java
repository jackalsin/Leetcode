package _0851_0900._893_Groups_of_Special_Equivalent_Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int numSpecialEquivGroups(String[] A) {
    final Set<String> result = new HashSet<>();
    for (String s : A) {
      final int[] odds = new int[26], even = new int[26];
      for (int i = 0; i < s.length(); i++) {
        final char chr = s.charAt(i);
        if (i % 2 == 0) even[chr - 'a']++;
        else {
          odds[chr - 'a']++;
        }
      }
      result.add(Arrays.toString(odds) + Arrays.toString(even));
    }
    return result.size();
  }
}
