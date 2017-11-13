package _401_450._408_Valid_Word_Abbreviation;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class Solution {
  public boolean validWordAbbreviation(String word, String abbr) {
    int wordPtr = 0;
    for (int aPtr = 0; aPtr < abbr.length(); aPtr++) {
      final char chr = abbr.charAt(aPtr);
      if (Character.isDigit(chr)) {
        int digitEnd = aPtr;
        while (digitEnd < abbr.length() && Character.isDigit(abbr.charAt(digitEnd))) {
          digitEnd++;
        }
        if (chr == '0') {
          return false;
        }
        int skip = Integer.parseInt(abbr.substring(aPtr, digitEnd));
        wordPtr += skip;
        aPtr = digitEnd - 1;
      } else {
        if (wordPtr >= word.length() || chr != word.charAt(wordPtr++)) {
          return false;
        }
      }
    }
    return wordPtr == word.length();
  }
}
