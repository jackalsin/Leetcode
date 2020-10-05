package linkedin._065_Valid_Number;

public class SolutionIII implements Solution {
  private static final String REGEX = "[+-]?(([\\d]+(\\.\\d*)?)|([\\d]*\\.\\d+))([eE][+-]?\\d+)?";

  public boolean isNumber(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }
    s = s.trim();
    return s.matches(REGEX);
  }
}
