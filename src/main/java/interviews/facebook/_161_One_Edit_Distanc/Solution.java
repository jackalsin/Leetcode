package interviews.facebook._161_One_Edit_Distanc;

public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    final int lenDiff = Math.abs(s.length() - t.length());
    if (lenDiff > 1) return false;
    if (s.length() > t.length()) {
      return isOneEditDistance(t, s);
    }
    if (s.equals(t)) {
      return false;
    }
//    assert s.length() <= t.length();
    // s has to add or edit
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        return s.substring(i + 1).equals(t.substring(i + 1)) // edit
            || s.substring(i).equals(t.substring(i + 1)); // add
      }
    }
    return true;
  }
}
