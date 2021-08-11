package linkedin._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionV implements Solution {
  private static final int N = 10;

  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() < N) return Collections.emptyList();
    int key = 0;
    for (int i = 0; i < N; ++i) {
      final char c = s.charAt(i);
      key = key << 2 | getVal(c);
    }
    final Set<Integer> visited = new HashSet<>();
    visited.add(key);
    final Set<String> result = new HashSet<>();
    for (int i = N; i < s.length(); ++i) {
      key = (key << 2 | getVal(s.charAt(i))) & 0b1111_1111_1111_1111_1111;
      if (!visited.add(key)) {
//        System.out.println("start = " + (i + 1 - N) + ", end = "+(i + 1));
        result.add(s.substring(i + 1 - N, i + 1));
      }
    }
    return new ArrayList<>(result);
  }

  private static int getVal(final char c) {
    switch (c) {
      case 'A':
        return 0;
      case 'C':
        return 1;
      case 'G':
        return 2;
      case 'T':
        return 3;
    }
    throw new IllegalStateException("c = " + c);
  }
}
