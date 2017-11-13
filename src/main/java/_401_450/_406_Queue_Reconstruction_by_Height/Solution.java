package _401_450._406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class Solution {

  /**
   * https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution
   * @param people
   * @return
   */
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return Integer.compare(o1[1], o2[1]);
        }
        return Integer.compare(o2[0], o1[0]);
      }
    });

    final List<int[]> res = new LinkedList<>();
    for (int i = 0; i < people.length; i++) {
      final int[] person = people[i];
      res.add(person[1], person);
    }
    return res.toArray(new int[0][0]);
  }
}
