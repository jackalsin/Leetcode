package _5001_5050._5176_Number_of_Valid_Words_for_Each_Puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class SampleSolution implements Solution {
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    int[][] puz = new int[puzzles.length][2];
    for (int i = 0; i < puzzles.length; i++) {
      // 首字符
      puz[i][0] = (int) (puzzles[i].charAt(0) - 'a');
      for (int j = 0; j < puzzles[i].length(); j++) {
        int bit = 1 << (puzzles[i].charAt(j) - 'a');
        puz[i][1] |= bit; // 整个字符
      }

    }
    int[] wor = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        int bit = 1 << (words[i].charAt(j) - 'a');
        wor[i] |= bit;
      }
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < puz.length; i++) {
      int count = 0;
      for (int j = 0; j < wor.length; j++) {
        if ((puz[i][1] | wor[j]) != puz[i][1]) continue;
        if ((wor[j] & (1 << puz[i][0])) != 0) {
          count++;
        }
      }
      res.add(count);
    }
    return res;
  }
}
