package uber._161_One_Edit_Distance;

public class Solution {
  /**
   * Time complexity O (N)
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isOneEditDistance(String s, String t) {
    /*
     * consider 3 operations:
     *   1)  replace
     *        abcde
     *        apcde
     *   2)  delete
     *        abcde
     *        abde
     *   3)  add
     *        abcde
     *        abde
     * */
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (s.length() == t.length()) { // replace
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else if (s.length() > t.length()) {
          return s.substring(i + 1).equals(t.substring(i));
        } else {
          assert t.length() > s.length();
          return t.substring(i + 1).equals(s.substring(i));
        }
      }
    }
    return Math.abs(s.length() - t.length()) == 1;
  }
}
