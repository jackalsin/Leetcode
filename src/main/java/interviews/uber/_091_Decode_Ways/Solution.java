package interviews.uber._091_Decode_Ways;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int numDecodings(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    final List<String> result = new ArrayList<>();
    dfs(result, s, "", 0);
    return result.size();
  }

  private void dfs(final List<String> result, final String s, final String curPath, int start) {
    if (start >= s.length()) {
      result.add(curPath);
      return;
    }
    dfs(result, s, curPath + s.charAt(start), start + 1);

    if (start < s.length() - 1 && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
      dfs(result, curPath, curPath + (char) (Integer.parseInt(s.substring(start, start + 2)) - 1 + 'A'), start + 2);
    }
  }
}
