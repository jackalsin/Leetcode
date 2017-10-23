package interviews.linkedin._205_Isomorphic_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    final char[] map = new char[256];
    final boolean[] visited = new boolean[256];
    final char[] sArray = s.toCharArray();
    final char[] tArray = t.toCharArray();
    for (int i = 0; i < sArray.length; i++) {
      final char sChr = sArray[i];
      if (visited[tArray[i]]) {
        if (map[sChr] != tArray[i]) {
          return false;
        }
      } else if (map[sChr] == '\u0000') {
        map[sChr] = tArray[i];
        visited[tArray[i]] = true;
      } else {
        if (map[sChr] != tArray[i]) {
          return false;
        }
      }
    }
    return true;
  }
}
