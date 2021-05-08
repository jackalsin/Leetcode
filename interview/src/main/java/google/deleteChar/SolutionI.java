package google.deleteChar;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int delete(String a, String b) {
    assert a != null && b != null;
    if (a.length() < b.length()) return delete(b, a);
    int j = 0, count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (j < b.length() && a.charAt(i) == b.charAt(j)) ++j;
      else count++;
    }
    return j == b.length() ? count : -1;
  }
}
