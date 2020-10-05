package uber._249_Group_Shifted_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private static final int N = 26;

  public List<List<String>> groupStrings(String[] strings) {
    final Map<String, List<String>> resultMap = new HashMap<>();
    for (final String str : strings) {
      final String shiftToPrefixA = getShift(str);
      final List<String> result = resultMap.getOrDefault(shiftToPrefixA, new ArrayList<>());
      result.add(str);
      resultMap.put(shiftToPrefixA, result);
    }
    return new ArrayList<>(resultMap.values());
  }

  private String getShift(String str) {
    if (str.isEmpty()) {
      return "";
    }
    final char[] chars = str.toCharArray();
    final int biasToA = str.charAt(0) - 'a';
    for (int i = 0; i < chars.length; i++) {
      final char chr = chars[i];
      if (chr - biasToA < 'a') {
        chars[i] += N;
      }
      chars[i] -= biasToA;
    }
    return String.valueOf(chars);
  }
}
