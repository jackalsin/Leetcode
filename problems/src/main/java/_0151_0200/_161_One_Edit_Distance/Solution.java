package _0151_0200._161_One_Edit_Distance;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/20/2017.
 */
public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
      if(s.charAt(i) != t.charAt(i)) {
        if (s.length() == t.length()) { // the only option is replace
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else if (s.length() < t.length()) { // chop t[i]
          return s.substring(i).equals(t.substring(i + 1));
        } else {
          return s.substring(i + 1).equals(t.substring(i));
        }
      }
    }
    return Math.abs(s.length() - t.length()) == 1;
  }
}
