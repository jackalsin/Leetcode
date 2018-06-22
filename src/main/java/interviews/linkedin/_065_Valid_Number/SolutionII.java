package interviews.linkedin._065_Valid_Number;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionII implements Solution {
  private static final String NUM_REGEX = "[+\\-]?(([0-9]*(\\.)?[0-9]+)|([0-9]+(\\.)?[0-9]*))([eE][+\\-]?[0-9]+)?";

  public boolean isNumber(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }
    s = s.trim();
    return s.matches(NUM_REGEX);
  }

}
