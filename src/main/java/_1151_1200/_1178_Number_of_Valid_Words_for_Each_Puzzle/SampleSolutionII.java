package _1151_1200._1178_Number_of_Valid_Words_for_Each_Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/15/2019
 */
public class SampleSolutionII implements Solution {
  @Override
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (String word : words) {
      int mask = 0;
      for (char ch : word.toCharArray()) {
        mask |= 1 << (ch - 'a');
      }
      map.put(mask, map.getOrDefault(mask, 0) + 1);
    }

    //从puzzle的bit mask中找所有可以能substring
    for (String puzzle : puzzles) {
      int mask = 0;
      for (char ch : puzzle.toCharArray()) {
        mask |= 1 << (ch - 'a');
      }
      int sub = mask;
      int first = 1 << (puzzle.charAt(0) - 'a');
      int count = 0;//从puzzle的mask中不断变化找到substring的mask然后和找有没有对应的word
      while (true) {
        //check sub & first是为了找到带first letter的substring，其他的就排除掉了
        if ((sub & first) == first && map.containsKey(sub)) {
          count += map.get(sub);
        }
        if (sub == 0)
          break;

        sub = (sub - 1) & mask;
      }
      res.add(count);
    }
    return res;
  }
}

