package interviews.google._466_Count_The_Repetitions;

public final class BruteForceSolution implements Solution {
  @Override
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    final char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
    int count = 0;
    for (int j = 0, m = 0; m < n1; m++) {
      for (int i = 0; i < s1.length(); i++) {
        if (chars1[i] == chars2[j]) {
          j++;
        }

        if (j == chars2.length) {
          j = 0;
          count++;
        }
      }
    }

    return count / n2;
  }
}
