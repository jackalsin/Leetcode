package _401_450._438_Find_All_Anagrams_in_a_String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class SampleSolution implements Solution {

  @Override
  public List<Integer> findAnagrams(String s, String t) {
    List<Integer> result = new LinkedList<>();
    if (t.length() > s.length()) return result;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int counter = map.size();

    int begin = 0, end = 0;

    while (end < s.length()) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) counter--;
      }
      end++;

      while (counter == 0) {
        char tempc = s.charAt(begin);
        if (map.containsKey(tempc)) {
          map.put(tempc, map.get(tempc) + 1);
          if (map.get(tempc) > 0) {
            // 任何一个char 的count 大于0，使得count++， 则会跳出这个while loop，不会发生有多个char invalid
            counter++;
          }
        }
        if (end - begin == t.length()) {
          result.add(begin);
        }
        begin++;
      }

    }
    return result;
  }
}
