package oracle._555_Split_Concatenated_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/27/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String splitLoopedString(String[] strs) {
    // create an array descending
    for (int i = 0; i < strs.length; ++i) {
      final String reverse = new StringBuilder(strs[i]).reverse().toString();
      if (reverse.compareTo(strs[i]) > 0) {
        strs[i] = reverse;
      }
    }
    String result = "";
    for (int i = 0; i < strs.length; ++i) {
      final String reverse = new StringBuilder(strs[i]).reverse().toString();
      for (String str : new String[]{strs[i], reverse}) {
        for (int j = 0; j < str.length(); ++j) {
          final StringBuilder sb = new StringBuilder(str.substring(j));
          for (int k = i + 1; k < strs.length; k++) {
            sb.append(strs[k]);
          }
          for (int k = 0; k < i; k++) {
            sb.append(strs[k]);
          }
          sb.append(str, 0, j);
          if (sb.toString().compareTo(result) > 0) {
            result = sb.toString();
          }
        }
      }
    }
    return result;
  }
}
