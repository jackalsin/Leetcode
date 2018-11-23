package _0451_0500._466_Count_The_Repetitions;

public final class BruteForceSolution implements Solution {
  @Override
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int s2Index = 0, repeatCount = 0;
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < s1.length(); j++) {
        if (s1.charAt(j) == s2.charAt(s2Index)) {
          s2Index++;
        }

        if (s2Index == s2.length()) {
          s2Index = 0;
          repeatCount++;
        }
      }
    }
    return repeatCount / n2;
  }
}
