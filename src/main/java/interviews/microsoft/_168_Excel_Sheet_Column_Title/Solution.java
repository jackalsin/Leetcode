package interviews.microsoft._168_Excel_Sheet_Column_Title;

public class Solution {
  private static final char BASE = 'A';

  public String convertToTitle(int n) {
    final StringBuilder sb = new StringBuilder();
    while (n != 0) {
      n--;
      sb.append((char) (n % 26 + BASE));
      n /= 26;
    }
    return sb.reverse().toString();
  }

}
