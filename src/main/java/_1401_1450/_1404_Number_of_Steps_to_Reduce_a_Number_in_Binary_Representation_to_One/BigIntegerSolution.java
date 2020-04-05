package _1401_1450._1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One;


import java.math.BigInteger;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class BigIntegerSolution implements Solution {

  public int numSteps(String s) {
    int steps = 0;
    BigInteger big = new BigInteger(s, 2);
    while (!big.equals(BigInteger.ONE)) {
      if (big.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
        big = big.divide(BigInteger.TWO);
      } else {
        big = big.add(BigInteger.ONE);
      }
      steps++;
    }
    return steps;
  }
}
