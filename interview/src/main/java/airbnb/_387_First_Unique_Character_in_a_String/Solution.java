package airbnb._387_First_Unique_Character_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 2/7/2019.
 */
public class Solution {
  public int firstUniqChar(String s) {
    final int[] freq = new int[26];
    final char[] chars = s.toCharArray();
    for (char chr : chars) {
      freq[chr - 'a']++;
    }

    for (int i = 0; i < chars.length; i++) {
      final char chr = chars[i];
      if (freq[chr - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
