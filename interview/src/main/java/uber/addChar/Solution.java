package uber.addChar;

/**
 * @author jacka
 * @version 1.0 on 4/16/2021
 */
public interface Solution {
  /**
   * 第二题给a, b两个string, char by char 加在一起
   * Example: a =  "99", b = "99", 返回 "1818"
   * a = "13", b = "230", 返回"243"
   *
   * @param a
   * @param b
   * @return
   */
  String addChar(final String a, final String b);
}
