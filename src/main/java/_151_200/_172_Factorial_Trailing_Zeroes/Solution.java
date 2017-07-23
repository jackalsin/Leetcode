package _151_200._172_Factorial_Trailing_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public int trailingZeroes(int n) {
//    5=1*5, 10=2*5, 15=3*5, 20=4*5, 25=5*5, 30=6*5 ... , 50=10*5=2*5*5, did you see that the numbers before each 5 in the multiplications: 1,2,3,4,5,6,...,10 has formed the (n/5) subproblem?
    return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
  }
}
