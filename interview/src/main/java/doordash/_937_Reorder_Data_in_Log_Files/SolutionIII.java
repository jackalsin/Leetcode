package doordash._937_Reorder_Data_in_Log_Files;

import java.util.Arrays;

public final class SolutionIII implements Solution {
  private static final char SPACE = ' ';

  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (l1, l2) -> {
      final int firstSpace1 = l1.indexOf(SPACE), firstSpace2 = l2.indexOf(SPACE);
      final boolean isLetter1 = Character.isLetter(l1.charAt(firstSpace1 + 1)),
          isLetter2 = Character.isLetter(l2.charAt(firstSpace2 + 1));
      if (isLetter1 && isLetter2) {
        final String c1 = l1.substring(firstSpace1),
            c2 = l2.substring(firstSpace2);
        final int cCmp = c1.compareTo(c2);
        if (cCmp != 0) return cCmp;
        return l1.substring(0, firstSpace1).compareTo(l2.substring(0, firstSpace2));
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
