package _451_500._476_Number_Complement;

public class Solution {
  public int findComplement(int num) {
    int res = 0, shift = 0;
    while (num != 0) {
      int bit = num & 1;
      num /= 2;
      res += (bit ^ 1) << shift;
      shift++;
    }
    return res;
  }
}
