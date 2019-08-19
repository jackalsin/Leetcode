package interviews.linkedin._796_Rotate_String;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean rotateString(String A, String B) {
    if (A == null || B == null) {
      return false;
    }
    return A.length() == B.length() && (A + A).contains(B);
  }
}
