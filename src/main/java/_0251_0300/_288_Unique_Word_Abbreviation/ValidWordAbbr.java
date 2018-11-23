package _0251_0300._288_Unique_Word_Abbreviation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class ValidWordAbbr {
  /**
   * If value is null -> never appear
   * If value is "" -> a dup
   * if value is a non-empty -> unique
   */
  private final Map<String, String> keyToWord;

  public ValidWordAbbr(String[] dictionary) {
    keyToWord = new HashMap<>();
    for (String child : dictionary) {
      String key = getKey(child);
      String val = keyToWord.get(key);
      if (val != null && !val.equals(child)) {
        keyToWord.put(key, "");
      } else {
        keyToWord.put(key, child);
      }
    }
  }

  private String getKey(String child) {
    if (child.length() <= 2) return child;
    else return new StringBuilder().append(child.charAt(0))
        .append(child.length() - 2).append(child.charAt(child.length() - 1)).toString();
  }

  public boolean isUnique(String word) {
    String possibleValue = keyToWord.get(getKey(word));
    return possibleValue == null || possibleValue.equals(word);
  }
}
