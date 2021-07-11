package doordash._937_Reorder_Data_in_Log_Files;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/10/2021
 */
public final class SolutionII implements Solution {
  private static final String SPACE = " ";

  /**
   * Time Complexity:
   *
   * @param logs
   * @return
   */
  public String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length == 0) return logs;
    Arrays.sort(logs, (l1, l2) -> {
      final int i1 = l1.indexOf(SPACE), i2 = l2.indexOf(SPACE);
      final String identifier1 = l1.substring(0, i1), identifier2 = l2.substring(0, i2); // O(len)
      final boolean isLetter1 = Character.isLetter(l1.charAt(i1 + 1)),
          isLetter2 = Character.isLetter(l2.charAt(i2 + 1));
      if (isLetter1 && isLetter2) {
        final int contentCmp = l1.substring(i1 + 1).compareTo(l2.substring(i2 + 1)); // O (len)
        if (contentCmp != 0) return contentCmp;
        return identifier1.compareTo(identifier2);
      } else if (isLetter1) {
        return -1;
      } else if (isLetter2) {
        return 1;
      } else {
        return 0;
      }
    });
    return logs;
  }
}
