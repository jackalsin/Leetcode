package _0901_0950._937_Reorder_Data_in_Log_Files;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (l1, l2) -> {
      final int i1 = l1.indexOf(' '), i2 = l2.indexOf(' ');
      final boolean isLetter1 = Character.isLetter(l1.charAt(i1 + 1)),
          isLetter2 = Character.isLetter(l2.charAt(i2 + 1));
//      System.out.println(l1.charAt(i1 + 1) + ", " + l2.charAt(i2 + 1));
      if (isLetter1 && !isLetter2) {
        return -1;
      } else if (!isLetter1 && isLetter2) {
        return 1;
      } else if (isLetter1 && isLetter2) {
        final int cmpLog = l1.substring(i1 + 1).compareTo(l2.substring(i2 + 1));
        if (cmpLog != 0) {
          return cmpLog;
        }
        return l1.substring(0, i1).compareTo(l2.substring(0, i2));
      } else {
        return 0;
      }
    });
    return logs;
  }
}
