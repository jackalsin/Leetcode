package _501_550._520_Detect_Capital;

public class Solution {
  /**
   * We define the usage of capitals in a word to be right when one of the following cases holds:
   * <p>
   * All letters in this word are capitals, like "USA".
   * All letters in this word are not capitals, like "leetcode".
   * Only the first letter in this word is capital if it has more than one letter, like "Google".
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse(String word) {
    int charCounts = word.length(), capitalCount = 0;
    for (char chr : word.toCharArray()) {
      if (chr >= 'A' && chr <= 'Z') {
        capitalCount++;
      }
    }
    return (charCounts == capitalCount) || (capitalCount == 0)
        || (word.length() > 1 && capitalCount == 1 && Character.isUpperCase(word.charAt(0)));
  }
}
