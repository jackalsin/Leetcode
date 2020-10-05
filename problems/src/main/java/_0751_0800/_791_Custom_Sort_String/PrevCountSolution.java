package _0751_0800._791_Custom_Sort_String;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class PrevCountSolution implements Solution {
  @Override
  public String customSortString(String S, String T) {
    final int[] counts = new int[26];
    for (char t : T.toCharArray()) {
      counts[t - 'a']++;
    }
    final StringBuilder sb = new StringBuilder();
    for (final char s : S.toCharArray()) {
      for (int c = 0; c < counts[s - 'a']; ++c) {
        sb.append(s);
      }
      counts[s - 'a'] = 0;
    }
    for (int i = 0, chr = 'a'; chr <= 'z'; chr++, ++i) {
      final int count = counts[i];
      for (int k = 0; k < count; ++k) {
        sb.append((char) chr);
      }
    }
    return sb.toString();
  }
}
