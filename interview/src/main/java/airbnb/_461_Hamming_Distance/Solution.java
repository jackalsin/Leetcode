package airbnb._461_Hamming_Distance;

/**
 * @author jacka
 * @version 1.0 on 2/9/2019.
 */
public class Solution {
  public int hammingDistance(int x, int y) {
    int dist = 0;
    for (int i = (1 << 31); i != 0; i >>>= 1) {
      final int one = x & i, that = y & i;
      if (one != that) {
        dist++;
      }
    }
    return dist;
  }
}
