package interviews.microsoft._567_Permutation_in_String;

public class Solution { // TODO:

  public boolean checkInclusion(String s1, String s2) {
    final int[] map = new int[26];
    int count = 0;
    for (char chr : s1.toCharArray()) {
      if (map[chr - 'a'] == 0) {
        count++;
      }
      map[chr - 'a']++;
    }

    for (int end = 0, start = 0; end < s2.length(); end++) {

    }
    return false;
  }
}
