package _1001_1050._1023_Binary_String_With_Substrings_Representing_1_To_N;

public class Solution {
  public boolean queryString(String S, int N) {
    for (int i = N; i > N / 2; i--) {
      final String s = Integer.toBinaryString(i);
      if (!S.contains(s)) {
        return false;
      }
    }
    return true;
  }
}
