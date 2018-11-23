package _0601_0650._616_Add_Bold_Tag_in_String;

import java.util.Arrays;

public class BooleanArraySolution implements Solution {

  private static final String START_TAG = "<b>";
  private static final String END_TAG = "</b>";

  @Override
  public String addBoldTag(String s, String[] dict) {
    boolean[] isBold = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (String sub : dict) {
        if (s.startsWith(sub, i)) {
          Arrays.fill(isBold, i, i + sub.length(), true);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (isBold[i]) {
        int j = i;
        while (j < isBold.length && isBold[j]) {
          j++;
        }
        sb.append(START_TAG).append(s.subSequence(i, j)).append(END_TAG);
        i = j - 1;
      } else {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }
}
