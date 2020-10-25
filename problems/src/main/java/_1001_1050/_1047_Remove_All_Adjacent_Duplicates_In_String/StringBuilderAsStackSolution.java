package _1001_1050._1047_Remove_All_Adjacent_Duplicates_In_String;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class StringBuilderAsStackSolution implements Solution {
  @Override
  public String removeDuplicates(String S) {
    final StringBuilder sb = new StringBuilder();
    for (final char chr : S.toCharArray()) {
      final int n = sb.length();
      if (n != 0 && sb.charAt(n - 1) == chr) {
        sb.setLength(n - 1);
      } else {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
