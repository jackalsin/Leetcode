package amazon.reorderedTheLine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Solution {
  public List<String> reorderLines(int logFileSize, final List<String> logfile) {
    final TreeSet<Pair> treeMap = new TreeSet<>(new Comparator<>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        // words first;
        int cmp = o1.line.compareTo(o2.line);
        final boolean o1IsDigit = Character.isDigit(o1.line.charAt(0)),
            o2IsDigit = Character.isDigit(o2.line.charAt(0));
        if (o1IsDigit && o2IsDigit) {
          cmp = Integer.compare(o1.index, o2.index);
        } else if ((o1IsDigit && !o2IsDigit)) {
          return 1;
        } else if (!o1IsDigit && o2IsDigit) {
          return -1;
        } else {
          cmp = o1.line.toUpperCase().compareTo(o2.line.toUpperCase());
        }
        if (cmp == 0) {
//          return o1.identifier.toUpperCase().compareTo(o2.identifier.toUpperCase());
          return o1.identifier.compareTo(o2.identifier);
        }
        return cmp;
      }
    });
    for (int i = 0; i < logfile.size(); i++) {
      final String logLine = logfile.get(i);
      final String[] logItems = logLine.split(" ", 2);
      assert logItems.length == 2;
      treeMap.add(new Pair(logItems[0], logItems[1], i));
    }

    final List<String> result = new ArrayList<>();
    for (final Pair pair : treeMap) {
      result.add(pair.identifier + " " + pair.line);
    }
    return result;
  }

  private static final class Pair {
    private final String identifier, line;
    private final int index;

    private Pair(String identifier, String line, int i) {
      this.identifier = identifier;
      this.line = line;
      index = i;
    }
  }
}
