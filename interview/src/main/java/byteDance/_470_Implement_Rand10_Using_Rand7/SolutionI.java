package byteDance._470_Implement_Rand10_Using_Rand7;

import definition._470_Implement_Rand10_Using_Rand7.SolBase;

/**
 * @author jacka
 * @version 1.0 on 5/9/2020
 */
public final class SolutionI extends SolBase implements Solution {
  @Override
  public int rand10() {
    int sum = 0;
    for (int i = 0; i < 7; ++i) {
      sum += rand7() - 1;
    }
    return sum % 10 + 1;
  }
}
