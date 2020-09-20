package _1551_1600._1592_Rearrange_Spaces_Between_Words;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String reorderSpaces(String text) {
    final String[] words = text.trim().split("\\s+");
    final int totalWordLen = getLens(words), totalWordCount = words.length,
        spaces = totalWordCount == 1 ? 0 : (text.length() - totalWordLen) / (totalWordCount - 1);
    final StringBuilder sb = new StringBuilder().append(words[0]);
    for (int i = 1; i < totalWordCount; ++i) {
      for (int k = 0; k < spaces; ++k) {
        sb.append(" ");
      }
      sb.append(words[i]);
    }
    while (sb.length() < text.length()) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private static int getLens(final String[] words) {
    int res = 0;
    for (final String word : words) {
      res += word.length();
    }
    return res;
  }
}
