package _0801_0850._833_Find_And_Replace_in_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    List<int[]> index = new ArrayList<>();
    for (int i = 0; i < indexes.length; ++i) {
      index.add(new int[]{indexes[i], i});
    }

    Collections.sort(index, new Comparator<int[]>() {
      @Override
      public int compare(final int[] i, int[] j) {
        return Integer.compare(j[0], i[0]);
      }
    });

    for (int k = 0; k < index.size(); ++k) {
      final int[] pos = index.get(k);
      final int i = pos[0], j = pos[1];
      if (!S.startsWith(sources[j], i)) continue;
      S = new StringBuilder().append(S.substring(0, i)).append(targets[j])
          .append(S.substring(i + sources[j].length()))
          .toString();
      System.out.println(S);
    }
    return S;
  }

}
