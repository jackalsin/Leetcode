package interviews.amazon._299_Bulls_and_Cows;

public class Solution {
  private static final String HIT = "A", BIAS = "B";

  public String getHint(String secret, String guess) {
    final int[] counts = new int[10];
    int hit = 0, bias = 0;
    for (int i = 0; i < guess.length(); i++) {
      final int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
      if (s == g) {
        hit++;
      } else {
        if (counts[s] < 0) bias++;
        if (counts[g] > 0) bias++;
        counts[s]++;
        counts[g]--;
      }
    }

    return hit + HIT + bias + BIAS;
  }
}
