package google.amplitude;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minAmplitude(int[] input) {
    if (input == null || input.length <= 3) return 0;
    Arrays.sort(input);
    return input[input.length - 4] - input[0];
  }
}
