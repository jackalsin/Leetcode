package interviews.amazon.reorderLines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<String> reorderLines(final int logFileSize, List<String> logFile) {
    final List<String> result = new ArrayList<>(logFile);
    Collections.sort(result, (x, y) -> {
      int cmp = x.substring(1).compareTo(y.substring(1));
      if (cmp == 0) {
        return Character.compare(x.charAt(0), y.charAt(0));
      }
      return cmp;
    });

    return result;
  }
}
