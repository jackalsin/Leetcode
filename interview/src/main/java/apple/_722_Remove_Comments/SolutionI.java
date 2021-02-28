package apple._722_Remove_Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/27/2021
 */
public final class SolutionI implements Solution {
  private static final String LEFT_MULTI = "/*",
      RIGHT_MULTI = "*/", SINGLE_LINE = "//";

  public List<String> removeComments(String[] source) {
    final List<String> result = new ArrayList<>();
    final StringBuilder sb = new StringBuilder();
    boolean isInMultiLineBlock = false;
    for (final String line : source) {
      for (int i = 0; i < line.length(); ++i) {
        if (!isInMultiLineBlock && line.startsWith(LEFT_MULTI, i)) {
          isInMultiLineBlock = true;
          i++;
          continue;
        } else if (isInMultiLineBlock && line.startsWith(RIGHT_MULTI, i)) {
          isInMultiLineBlock = false;
          ++i;
        } else if (!isInMultiLineBlock && line.startsWith(SINGLE_LINE, i)) {
          i = line.length() - 1;
        } else if (!isInMultiLineBlock) {
          sb.append(line.charAt(i));
        }
        if (!isInMultiLineBlock && i == line.length() - 1 && sb.length() != 0) {
          result.add(sb.toString());
          sb.setLength(0);
        }
      }
    }
    return result;
  }
}
