package interviews.linkedin._065_Valid_Number;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class Solution {
  private static final String NUM_REGEX = "[+\\-]?((\\d+" +"\\.?\\d*)|(\\d*\\.?\\d+))([Ee][+\\-]?[\\d]+)?";
  public boolean isNumber(String s) {
    if (s == null) return false;
    s = s.trim();
    if (s.isEmpty()) return false;
//    final Pattern pattern = Pattern.compile("");
    return s.matches(NUM_REGEX);
  }

}
