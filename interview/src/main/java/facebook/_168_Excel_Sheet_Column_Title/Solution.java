package facebook._168_Excel_Sheet_Column_Title;

public class Solution {

  public String convertToTitle(int n) {

    final StringBuilder sb = new StringBuilder();
    while (n > 0) {
      n--;
      final int charIndex = n % 26;
      final char chr = (char) (charIndex + 'A');
      sb.append(chr);
      n /= 26;
    }
    return sb.reverse().toString();
  }

}
