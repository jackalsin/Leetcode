package google._686_Repeated_String_Match;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public class NormalSolution implements Solution {
  @Override
  public int repeatedStringMatch(String a, String b) {
    tag:
    for (int aIndex = 0; aIndex < a.length(); aIndex++) {
      for (int bIndex = 0; bIndex < b.length(); bIndex++) {
        if (a.charAt((aIndex + bIndex) % a.length()) != b.charAt(bIndex)) {
          continue tag;
        }
      }
      final int total = aIndex + b.length();
      return total % a.length() != 0 ? (total / a.length() + 1) : (total / a.length());
    }

    return -1;
  }
}
