package _1301_1350._1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionI implements Solution {
  public int minSteps(String s, String t) {
    if (s == null) {
      assert t == null;
      return 0;
    }
    final int[] counts = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      counts[s.charAt(i) - 'a']++;
      counts[t.charAt(i) - 'a']--;
    }
    int count = 0;
    for (int n : counts) {
      if (n > 0) {
        count += n;
      }
    }
    return count;
  }

}
