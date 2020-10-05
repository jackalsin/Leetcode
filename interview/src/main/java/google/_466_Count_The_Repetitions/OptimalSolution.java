package google._466_Count_The_Repetitions;

public final class OptimalSolution implements Solution {
  @Override
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    final int[] nextIndex = new int[s2.length() + 1],
        repeatCount = new int[s2.length() + 1];
    int j = 0, rep = 0; // j is s2 index, rep denotes repeatCount
    for (int k = 1; k <= n1; ++k) {
      for (int i = 0; i < s1.length(); ++i) {
        if (s1.charAt(i) == s2.charAt(j)) {
          j++;
          if (j == s2.length()) {
            rep++;
            j = 0;
          }
        }
      } // end of for (int i = 0;

      repeatCount[k] = rep;
      nextIndex[k] = j;

      for (int start = 0; start < k; ++start) {
        if (j == nextIndex[start]) {
          int beforePattern = repeatCount[start],
              patternCount = (repeatCount[k] - repeatCount[start]) * ((n1 - start) / (k - start)),
              afterPattern = repeatCount[start + (n1 - start) % (k - start)] - repeatCount[start];
          return (beforePattern + patternCount + afterPattern) / n2;
        }
      }
    }
    return rep / n2;
  }
}
