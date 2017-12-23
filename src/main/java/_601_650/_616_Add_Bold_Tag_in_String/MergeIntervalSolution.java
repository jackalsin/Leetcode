package _601_650._616_Add_Bold_Tag_in_String;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeIntervalSolution implements Solution {
  private static final String START_TAG = "<b>";
  private static final String END_TAG = "</b>";
  private final Queue<int[]> tagPosition = new PriorityQueue<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      final int cmp = Integer.compare(o1[0], o2[0]);
      if (cmp == 0) {
        return Integer.compare(o2[1], o1[1]);
      }
      return cmp;
    }
  });

  public String addBoldTag(String s, String[] dict) {

    StringBuilder sb = new StringBuilder().append(s);
    for (String str : dict) {
      for (int start = 0; start <= s.length() - str.length(); start++) {
        if (s.startsWith(str, start)) {
          tagPosition.add(new int[]{start, start + str.length()});
        }
      }
    }
    List<int[]> finalList = new ArrayList<>();
    int[] lastSeen = tagPosition.peek();
    while (!tagPosition.isEmpty()) {
      int[] removed = tagPosition.remove();
//      System.out.println(Arrays.toString(removed));
      if (removed[0] > lastSeen[1]) {
        finalList.add(lastSeen);
        lastSeen = removed;
      } else {
        lastSeen[1] = Math.max(removed[1], lastSeen[1]);
      }
    }
    if (lastSeen != null) {
      finalList.add(lastSeen);
    }
    int tagLen = 0;
    for (int[] tagPos : finalList) {
      sb.insert(tagLen + tagPos[0], START_TAG);
      sb.insert(tagLen + tagPos[1] + START_TAG.length(), END_TAG);
      tagLen += START_TAG.length() + END_TAG.length();
    }

    return sb.toString();
  }

}
