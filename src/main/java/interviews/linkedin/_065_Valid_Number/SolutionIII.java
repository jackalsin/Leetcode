package interviews.linkedin._065_Valid_Number;

public class SolutionIII implements Solution {
  private static final String REG_NUMBER = "((\\d+(\\.\\d*)?)|(\\d*\\.\\d+))";

  @Override
  public boolean isNumber(String s) {
    s = s.trim();
    return s.matches("[+-]?" + REG_NUMBER + "(" + "[Ee][+-]?\\d+)?");
  }
}
