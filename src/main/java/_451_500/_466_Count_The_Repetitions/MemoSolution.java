package _451_500._466_Count_The_Repetitions;

public final class MemoSolution implements Solution {
  // TODO: figure it out
  @Override
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    final int[] repeatCount = new int[s2.length() + 1], nextIndex = new int[s2.length() + 1];
    int j = 0, rep = 0;
    for (int k = 1; k <= n1; k++) {
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          j++;
          if (j == s2.length()) {
            j = 0;
            rep++;
          }
        }
      }
      repeatCount[k] = rep;
      nextIndex[k] = j;
      for (int start = 0; start < k; start++) {
        if (nextIndex[start] == j) { // used as a set.
          int beforePattern = repeatCount[start];
          int patternCount = (repeatCount[k] - repeatCount[start]) * ((n1 - start) / (k - start));
          int afterPattern = repeatCount[start + (n1 - start) % (k - start)] - repeatCount[start];
          return (beforePattern + patternCount + afterPattern) / n2;
        }
      }
    }
    return rep / n2;
  }
}
