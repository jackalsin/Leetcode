package google._299_Bulls_and_Cows;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String getHint(String secret, String guess) {
    final int[] count = new int[10];
    int bulls = 0, cows = 0;
    for (int i = 0; i < secret.length(); ++i) {
      final int s = secret.charAt(i) - '0',
          g = guess.charAt(i) - '0';
      if (s == g) {
        bulls++;
      } else {
        if (count[s] < 0) cows++;
        if (count[g] > 0) cows++;
        count[s]++;
        count[g]--;
      }
    }
    return bulls + "A" + cows + "B";
  }
}
