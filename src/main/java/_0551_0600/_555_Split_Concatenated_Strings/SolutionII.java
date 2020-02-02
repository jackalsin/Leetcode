package _0551_0600._555_Split_Concatenated_Strings;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionII implements Solution {
  @Override
  public String splitLoopedString(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    // reverse to max string
    for (int i = 0; i < strs.length; i++) {
      final String str = strs[i];
      final String rev = new StringBuilder(str).reverse().toString();
      if (rev.compareTo(str) > 0) {
        strs[i] = rev;
      }
    }
    String res = "";
    // 假设strs[i]是分割的地方，我们需要loop所有的特点
    for (int i = 0; i < strs.length; ++i) {
      final String rev = new StringBuilder(strs[i]).reverse().toString();
      for (final String str : new String[]{rev, strs[i]}) {
        for (int k = 0; k < str.length(); ++k) {
          final StringBuilder sb = new StringBuilder();
          sb.append(str.substring(k));
          for (int j = i + 1; j < strs.length; ++j) {
            sb.append(strs[j]);
          }
          for (int j = 0; j < i; ++j) {
            sb.append(strs[j]);
          }
          sb.append(str.substring(0, k));
          if (res.compareTo(sb.toString()) < 0) {
            res = sb.toString();
          }
        }
      }
    }
    return res;
  }
}
