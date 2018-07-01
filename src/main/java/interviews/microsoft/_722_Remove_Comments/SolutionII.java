package interviews.microsoft._722_Remove_Comments;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {

  public List<String> removeComments(String[] source) {
    final List<String> result = new ArrayList<>();
    boolean inBlockComment = false;
    final StringBuilder sb = new StringBuilder();
    for (String s : source) {
      for (int i = 0; i < s.length(); i++) {
        if (!inBlockComment &&
            (s.charAt(i) == '/' && (i + 1 < s.length() && s.charAt(i + 1) == '*'))
            ) {
          inBlockComment = true;
          i++;
        } else if (inBlockComment &&
            (s.charAt(i) == '*' && (i + 1 < s.length() && s.charAt(i + 1) == '/'))
            ) {
          inBlockComment = false;
          i++;
        } else if (!inBlockComment && s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
          break;
        } else if (!inBlockComment) {
          sb.append(s.charAt(i));
        }
      }

      if (!inBlockComment && sb.length() != 0) {
        result.add(sb.toString());
        sb.setLength(0);
      }
    }
    return result;
  }

}
