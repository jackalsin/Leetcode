package interviews.microsoft._028_Implement_strStr;

public class Solution {
  public int strStr(String haystack, String needle) { // TODO: redo with KMP
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.startsWith(needle, i)) {
        return i;
      }
    }
    return -1;
  }
}
