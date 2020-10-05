package uber._418_Sentence_Screen_Fitting;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    final String s = String.join(" ", sentence) + " ";
    int start = 0;
    final int l = s.length();
    for (int row = 0; row < rows; row++) {
      start += cols;
      if (s.charAt(start % l) == ' ') {
        start++;
      } else {
        while (start > 0 && s.charAt((start - 1) % l) != ' ') {
          start--;
        }
      }
    }
    return start / l;
  }
}
