package _801_850._825_Friends_Of_Appropriate_Ages;

public final class ONSolution implements Solution {

  public int numFriendRequests(int[] ages) {
    if (ages == null || ages.length == 0) {
      return 0;
    }
    int[] ageSum = new int[121];
    int[] ageCount = new int[121];

    for (int age : ages) {
      ageCount[age]++;
    }
//    B is in range ( 0.5 * A + 7, A ]

    int sum = 0;
    for (int age = 1; age <= 120; age++) {
      sum += ageCount[age];
      ageSum[age] = sum;
    }

    int res = 0;
    for (int age = 15; age <= 120; age++) {
//      sum += ageCount[age];
//      ageSum[age] = sum;
      if (ageCount[age] == 0) {
        continue;
      }
      final int bCount = ageSum[age] - ageSum[age / 2 + 7];
      res += bCount * ageCount[age] - ageCount[age];
    }
    return res;
  }

}
