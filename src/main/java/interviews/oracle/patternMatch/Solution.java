package interviews.oracle.patternMatch;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public interface Solution {
  /**
   * 第一轮：
   * 判断source string和pattern string是否match， ？代表任意一个字母，比如
   * s = "Happy"
   * p = "H?pp?"
   * 这种情况就是match，然后？可以代表任意n个字母再判断
   *
   * @param str
   * @param pattern
   * @return
   */
  boolean isMatch(String str, String pattern);
}
