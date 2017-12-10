package _451_500._482_License_Key_Formatting;

/**
 * @author jacka
 * @version 1.0 on 12/9/2017.
 */
public class Solution {

  public String licenseKeyFormatting(String S, int K) {
    final char[] res = new char[S.length() + S.length() / K + 1];
    int resIdx = res.length - 1;
    for (int sIdx = S.length() - 1; sIdx >= 0; sIdx--) {
      if (S.charAt(sIdx) != '-') {
        if ((res.length - resIdx) % (K + 1) == 0) {
          res[resIdx--] = '-';
          sIdx++;
        } else {
          res[resIdx--] = Character.toUpperCase(S.charAt(sIdx));
        }
      }
    }
//    System.out.println(Arrays.toString(res));
//    System.out.println();
    // res.length - 1 - (resIdx + 1) + 1
    return String.valueOf(res, resIdx + 1, res.length - resIdx - 1);
  }
}
