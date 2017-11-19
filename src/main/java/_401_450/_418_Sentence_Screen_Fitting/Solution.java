package _401_450._418_Sentence_Screen_Fitting;

public class Solution {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    final String whole = String.join(" ", sentence) + " ";
    final int l = whole.length();
    int start = 0;
    for (int row = 0; row < rows; row++) {
      start += cols;
      if (whole.charAt(start % l) == ' ') {
        start++; //结尾是0，移动到下一个
      } else {
        while (start > 0 && whole.charAt((start - 1) % l) != ' ') {
          start--;
        }
      }
    }
    return start / l;
  }

}
