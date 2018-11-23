package _0351_0400._387_First_Unique_Character_in_a_String;

public class Solution {
  private static final int COUNT = 0, LAST_INDEX = 1;

  public int firstUniqChar(String s) {
    final int[][] count = new int[128][2];
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char chr = charArray[i];
      count[chr][COUNT]++;
      count[chr][LAST_INDEX] = i;
    }
    int minLast = Integer.MAX_VALUE;
    for (int i = 'a'; i <= 'z'; i++) {
      if (count[i][COUNT] == 1) {
        minLast = Math.min(minLast, count[i][LAST_INDEX]);
      }
    }
    return minLast;
  }
}
