package _251_300._288_Unique_Word_Abbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class ValidWordAbbr {
  private final Map<String, Set<String>> beginToEndToCount;
  public ValidWordAbbr(String[] dictionary) {
    beginToEndToCount = new HashMap<>();
    for (String child: dictionary) {
      String key = getKey(child);
      beginToEndToCount.putIfAbsent(key, new HashSet<>());
      beginToEndToCount.get(key).add(child);
    }
  }

  private String getKey(String child) {
    if (child.length() <= 2) return child;
    else return new StringBuilder().append(child.charAt(0))
        .append(child.length() - 2).append(child.charAt(child.length() - 1)).toString();
  }

  public boolean isUnique(String word) {
    Set<String> candidates = beginToEndToCount.getOrDefault(getKey(word), new HashSet<>());
    return (candidates.size() == 1 && candidates.contains(word)) || (candidates.size() == 0);
  }
}
