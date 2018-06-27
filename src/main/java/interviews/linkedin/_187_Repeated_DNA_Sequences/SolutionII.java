package interviews.linkedin._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionII implements Solution {
  private static final int A = 0, C = 1, T = 2, G = 3;

  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() < 10) {
      return new ArrayList<>();
    }
    final Set<Integer> visited = new HashSet<>(), result = new HashSet<>();

    int cur = 0;
    for (int i = 0; i < 10; i++) {
      cur <<= 2;
      cur |= getVal(s.charAt(i));
    }
    visited.add(cur);
    for (int i = 10; i < s.length(); i++) {
      final int curDigit = getVal(s.charAt(i));
      cur <<= 2;
      cur &= 0b1111_1111_1111_1111_1111;
      cur |= curDigit;
      if (visited.contains(cur)) {
        result.add(cur);
      }
      visited.add(cur);
    }

    return getResult(result);
  }

  private List<String> getResult(Set<Integer> allInts) {
    final List<String> result = new ArrayList<>();
    for (int allInt : allInts) {
      final char[] chars = new char[10];
      for (int i = 9; i >= 0; i--) {
        chars[i] = getVal(allInt & 0b11);
        allInt >>>= 2;
      }
      assert 0 == allInt;
      result.add(String.valueOf(chars));
    }
    return result;
  }

  private char getVal(int i) {
    switch (i) {
      case A:
        return 'A';
      case C:
        return 'C';
      case T:
        return 'T';
      case G:
        return 'G';
    }
    throw new IllegalStateException();
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
