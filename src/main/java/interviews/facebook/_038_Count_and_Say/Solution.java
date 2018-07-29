package interviews.facebook._038_Count_and_Say;

public class Solution {

  public String countAndSay(int n) {
    int i = 1;
    String res = "1";
    while (i++ < n) {
      final StringBuilder nextRes = new StringBuilder();
      for (int start = 0; start < res.length(); start++) {
        int end = start;
        while (end + 1 < res.length() && res.charAt(end + 1) == res.charAt(start)) {
          end++;
        }
        final int count = end - start + 1;
        nextRes.append(count).append(res.charAt(start));
        start = end;
      }
      res = nextRes.toString();
    }
    return res;
  }
}
