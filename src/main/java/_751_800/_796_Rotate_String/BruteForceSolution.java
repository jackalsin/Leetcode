package _751_800._796_Rotate_String;

public final class BruteForceSolution implements Solution {
  public boolean rotateString(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    if (A.length() == 0) {
      return true;
    }
    for (int i = 0; i < B.length(); ++i) {
      if (A.equals(B.substring(i) + B.substring(0, i))) {
        return true;
      }
    }
    return false;
  }
}
