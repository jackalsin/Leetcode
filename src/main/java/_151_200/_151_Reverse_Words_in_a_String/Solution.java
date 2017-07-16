package _151_200._151_Reverse_Words_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    } else {
      String[] sArray = s.split("\\s+");
      if (sArray.length == 0) return "";
      StringBuilder sb = new StringBuilder();
      for (int i = sArray.length - 1; i >= 0; i--) {
        if (!sArray[i].isEmpty()) {
          sb.append(" ").append(sArray[i]);
        }
      }
      return sb.substring(1);
    }
  }
}
