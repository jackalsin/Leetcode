package interviews.linkedin._187_Repeated_DNA_Sequences;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionII implements Solution {
  private static final int A = 0, C = 1, T = 2, G = 3;

  public List<String> findRepeatedDnaSequences(String s) {
    final Set<Integer> visisted = new HashSet<>();
    final List<String> result = new ArrayList<>();
    final Deque<Character> queue = new ArrayDeque<>();
    int cur = 0;
    for (int i = 0; i < 10; i++) {
      cur <<= 2;
      cur |= getVal(s.charAt(i));
      queue.add(s.charAt(i));
    }
    // TODO: unifishied

    return result;
  }

  private int getVal(char c) {
    switch (c) {
      case 'A':
        return A;
      case 'C':
        return C;
      case 'T':
        return T;
      case 'G':
        return G;
    }
    throw new IllegalStateException();
  }
}
