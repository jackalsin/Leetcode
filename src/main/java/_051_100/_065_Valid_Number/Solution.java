package _051_100._065_Valid_Number;

import java.util.regex.Pattern;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
public class Solution {
  public boolean isNumber(String s) {
    if (s == null) {
      return false;
    }
    s = s.trim();
    if (s.isEmpty()) return false;

    Pattern pattern = Pattern.compile("[+-]?((\\d+\\.?\\d*)|(\\d*\\.?\\d+))(e[+-]?\\d+)?");
    return pattern.matcher(s).matches();
  }

  public static void main(String[] args) {
    Pattern p = Pattern.compile("(\\d+\\.?\\d*)|(\\d*\\.?\\d+)");
    System.out.println(p.matcher("").matches());
    Pattern p2 = Pattern.compile("(\\d+\\.?\\d*)");
    System.out.println(p2.matcher("").matches());
    Pattern p3 = Pattern.compile("(\\d*\\.?\\d+)");
    System.out.println(p3.matcher("").matches());

  }
}
