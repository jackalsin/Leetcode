package _1401_1450._1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class BestSolution implements Solution {
  @Override
  public int numSteps(String s) {
    int step = 0, carry = 0;
    for (int i = s.length() - 1; i > 0; --i) {
      final int val = s.charAt(i) - '0';
      if (val + carry == 1) { // need add one and divide by 2
        carry = 1;
        step += 2;
      } else {
        step++;
      }
    }
    return step + carry;
  }
}
