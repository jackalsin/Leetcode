package _1401_1450._1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR;


import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  @Override
  public int countTriplets(int[] nums) {
    /*
      初步观察，如果有 a == b，则有
      a ^ a = b ^ a, thus
      0 = b ^ a, thus
      arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k] = 0
      prefix[k+1] = prefix[i]

      We only need to find out how many pair (i, k) of prefix value are equal.
      So we can calculate the prefix array first,
      Now say currently we are at index i and let xor([0...i]) = x.

      Now say x has occurred 3 times previously at indices (i1, i2, i3)
      our answer for i will be = (i - i1 - 1) + (i - i2 - 1) + (i - i3 - 1)
      if you simplify this further you get f * i - (i1 + i2 + i3) - f = (i - 1) * f - (i1 + i2 + i3)
      f = no. of times x has occurred previously.
      (i1 + i2 + i3) = sum of all the indices where x has occurred previously.
     */

    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int n = nums.length;
    int result = 0, prefix = 0;
    final Map<Integer, Integer> count = new HashMap<>() {{
      put(0, 1);
    }}, total = new HashMap<>();
    for (int k = 0; k < nums.length; ++k) {
      prefix ^= nums[k];
      final int c = count.getOrDefault(prefix, 0),
          t = total.getOrDefault(prefix, 0);
      result += c * k - t;
      count.put(prefix, c + 1);
      total.put(prefix, t + k + 1);
    }
    return result;
  }

}
