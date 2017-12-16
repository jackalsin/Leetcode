package _501_550._527_Word_Abbreviation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<String> wordsAbbreviation(List<String> dict) {
    final Map<String, Integer> index = new HashMap<>();
    final Map<String, String> abbrToOrigin = new HashMap<>();
    for (int i = 0; i < dict.size(); i++) {
      final String str = dict.get(i);
      index.put(str, i);
      helper(abbrToOrigin, str, getAbbr(str, 1, str.length() - 2));
    }
    final String[] res = new String[dict.size()];
    for (Map.Entry<String, String> entry : abbrToOrigin.entrySet()) {
      final String abbr = entry.getKey(), origin = entry.getValue();
      if (res[index.get(origin)] == null) {
        res[index.get(origin)] = abbr;
      } else {
        if (res[index.get(origin)].length() < abbr.length()) {
          res[index.get(origin)] = abbr;
        }
      }
    }
    return Arrays.asList(res);

  }

  void helper(final Map<String, String> abbrToOrigin, final String str, String abbr) {
    if (abbrToOrigin.containsKey(abbr) && !abbrToOrigin.get(abbr).equals(str)) {
      final String conflict = abbrToOrigin.get(abbr);
      final String[] resolved = resolveConflict(conflict, str);
      helper(abbrToOrigin, conflict, resolved[0]);
      helper(abbrToOrigin, str, resolved[1]);
    } else {
      abbrToOrigin.put(abbr, str);
    }
  }

  static String[] resolveConflict(String conflict, String str) {
    int len = Math.min(conflict.length(), str.length());
    int i = 0;
    for (; i < len; i++) {
      if (conflict.charAt(i) != str.charAt(i)) break;
    }

    return new String[]{
        getAbbr(conflict, i + 1, conflict.length() - 2),
        getAbbr(str, i + 1, str.length() - 2)
    };
  }

  static String getAbbr(final String str, int start, int end) {
    if ((end - start + 1) < 2) {
      return str;
    }
    return str.substring(0, start) + String.valueOf(end - start + 1) + str.substring(end + 1);
  }
}
