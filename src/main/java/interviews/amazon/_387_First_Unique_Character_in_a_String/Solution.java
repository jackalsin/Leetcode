package interviews.amazon._387_First_Unique_Character_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class Solution {
  /**
   * 16ms Solution
   */
  public int firstUniqChar(String s) {
    final int[] counts = new int[256];
    final char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      counts[chars[i]]++;
    }
    for (int i = 0; i < chars.length; i++) {
      if (counts[chars[i]] == 1) {
        return i;
      }
    }
    return -1;
  }
}
