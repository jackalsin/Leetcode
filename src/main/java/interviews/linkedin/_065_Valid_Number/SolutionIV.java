package interviews.linkedin._065_Valid_Number;

/**
 * @author jacka
 * @version 1.0 on 8/23/2019
 */
public final class SolutionIV implements Solution {

  public boolean isNumber(String s) {
    if (s == null) {
      return false;
    }
    s = s.trim();
    return s.matches("[+\\-]?" +
        "(" +
        "([\\d]+\\.?[\\d]*)" + "|" +
        "([\\d]*\\.?[\\d]+)" +
        ")([Ee][+\\-]?[\\d]+)?"
    );
  }

}
