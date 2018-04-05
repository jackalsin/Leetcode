package _401_450._418_Sentence_Screen_Fitting;

/**
 * @author jacka
 * @version 1.0 on 4/1/2018.
 */
public final class TLESolution implements Solution {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    int count = 0, sIndex = 0;
    for (int row = 0, curRowLen = 0; row < rows; ) {
      final String word = sentence[sIndex];
      if (curRowLen + word.length() > cols) {
        curRowLen = 0;
        row++;
      } else {
        curRowLen += word.length();
        sIndex++;
        if (curRowLen != cols) { // not necessary
          curRowLen++;
        }
        if (curRowLen == cols) {
          curRowLen = 0;
          row++;
        }
        if (sIndex == sentence.length) {
          sIndex = 0;
          count++;
        }
      }

      if (row >= rows) {
        break;
      }

    }
    return count;
  }
}
