package _1001_1050._1023_Binary_String_With_Substrings_Representing_1_To_N;

public class Solution {
  public boolean queryString(String s, int N) {
//    for (int i = N; i > N / 2; i--) {
//      final String s = Integer.toBinaryString(i);
//      if (!S.contains(s)) {
//        return false;
//      }
//    }
//    return true;

    boolean[] seen = new boolean[N + 1];
    int seenCnt = 0;
    final int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') continue;
      for (int j = i, num = 0; num <= N && j < n; j++) {
        num = (num << 1) + s.charAt(j) - '0';
        if (num >= 1 && num <= N && !seen[num]) {
          seen[num] = true;
          seenCnt++;
          if (seenCnt == N)
            return true;
        }
      }
    }
    return false;
  }
}
