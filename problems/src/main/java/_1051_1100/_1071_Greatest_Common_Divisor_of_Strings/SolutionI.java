package _1051_1100._1071_Greatest_Common_Divisor_of_Strings;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  public String gcdOfStrings(String str1, String str2) {
    /*
     GCD means greatest common divider, 不一定是辗转相除法或者更相减损术
    */
    assert str1 != null && str2 != null;
    if (str1.length() < str2.length()) {
      return gcdOfStrings(str2, str1);
    } else if (str2.isEmpty()) {
      return str1;
    } else if (str1.startsWith(str2)) {
      return gcdOfStrings(str1.substring(str2.length()), str2);
    } else {
      return "";
    }
  }
}
