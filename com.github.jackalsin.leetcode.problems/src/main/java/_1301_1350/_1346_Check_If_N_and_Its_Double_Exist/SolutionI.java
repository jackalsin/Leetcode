package _1301_1350._1346_Check_If_N_and_Its_Double_Exist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionI implements Solution {
  public boolean checkIfExist(int[] arr) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    final Set<Integer> visited = new HashSet<>();
    for (int a : arr) {
      if (visited.contains(2 * a) || (a % 2 == 0 && visited.contains(a / 2))) {
        return true;
      }
      visited.add(a);
    }
    return false;
  }
}
