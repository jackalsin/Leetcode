package _451_500._471_Encode_String_with_Shortest_Length;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 11/25/2017.
 */
public interface Solution {
  String encode(String s);

  default void display(final String[][] dp) {
    final int maxLen = Arrays.stream(dp).max(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        int o1Max = Arrays.stream(o1).max(new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return -Integer.compare(o1.length(), o2.length());
          }
        }).get().length();
        int o2Max = Arrays.stream(o1).max(new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return -Integer.compare(o1.length(), o2.length());
          }
        }).get().length();
        return -Integer.compare(o1Max, o2Max);
      }
    }).get().length;
    for (final String[] row : dp) {
      for (final String val : row) {
        final String padding = getPadding(val, maxLen);
        System.out.print(padding);
        System.out.print(val);
      }
      System.out.println();
    }
  }

  default String getPadding(String val, int len) {
    final StringBuilder sb = new StringBuilder();
    final int indent = val == null ? 4 : val.length();
    for (int i = 0; i < len - indent; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }
}
