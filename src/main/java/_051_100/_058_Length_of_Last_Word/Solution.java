package _051_100._058_Length_of_Last_Word;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class Solution {

  public int lengthOfLastWord(String s) {
    if (s == null) {
      return 0;
    }
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') end--;
    int count = 0;
    while (end >= 0 && s.charAt(end) != ' ') {
      count++;
      end--;
    }
    return count;
  }
}
