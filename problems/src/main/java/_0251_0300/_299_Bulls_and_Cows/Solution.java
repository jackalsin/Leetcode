package _0251_0300._299_Bulls_and_Cows;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Solution {

  /**
   *
   * secret: 1100 guess: 0011
   * The first element in the following tuples denotes secret, the second denotes the guess
   * We assume (1 at 0, 1at 2), (1 at 1, 1 at 3), (0 at 2, 0 at 0) (0 at 3, 0 at 1) are cows,
   * In the description, since we only have one mismatch '1' at the 0th position, so eventually,
   * it's 1A1B
   * @param secret
   * @param guess
   * @return
   */
  public String getHint(String secret, String guess) {
    int bull = 0, cow = 0;
    int[] count = new int[10];

    for (int i = 0; i < secret.length(); ++i) {
      int s = secret.charAt(i) - '0';
      int g = guess.charAt(i) - '0';
      if (s == g) {
        bull++;
      } else {
        if (count[s] < 0) cow++;
        if (count[g] > 0) cow++;
        ++count[s];
        --count[g];
      }
    }

    return bull + "A" + cow + "B";
  }
}
