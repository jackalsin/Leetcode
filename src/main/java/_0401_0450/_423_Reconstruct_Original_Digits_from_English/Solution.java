package _0401_0450._423_Reconstruct_Original_Digits_from_English;

public class Solution {

  public String originalDigits(String s) {
    final int[] count = new int[10];
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == 'z') count[0]++;
      if (chr == 'x') count[6]++;
      if (chr == 's') count[7]++; // 7 - 6
      if (chr == 'g') count[8]++;
      if (chr == 'h') count[3]++; // 3 - 8
      if (chr == 'v') count[5]++; // 5 - 7
      if (chr == 'f') count[4]++; // 4 - 5
      if (chr == 'w') count[2]++;
      if (chr == 'i') count[9]++; // 9 - 8 - 5 - 6
      if (chr == 'o') count[1]++; // 1 - 2 - 4 - 0
    }

    count[7] -= count[6];
    count[3] -= count[8];
    count[5] -= count[7];
    count[4] -= count[5];
    count[9] -= (count[8] + count[5] + count[6]);
    count[1] -= (count[2] + count[4] + count[0]);

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < count[i]; j++) {
        sb.append(i);
      }
    }
    return sb.toString();
  }

}
