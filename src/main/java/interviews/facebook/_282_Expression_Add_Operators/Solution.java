package interviews.facebook._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    dfs(result, target, num, "", 0, 0, 1);
    return result;
  }

  private static int deep = 0;

  private void dfs(final List<String> result, final int target, final String num, final String curPath,
                   final int start, final long curVal, final long curMul) {
//    ++deep;
    //    System.out.println(result + " target = " + target + " num = " + num + " curPath = " + curPath + " start = " + start + " curVal = " + curVal + " curMul = " + curMul);
//    System.out.println(indent() + result + " curPath = \"" + curPath + "\" start = " + start + " curVal = " + curVal +
//        " curMul = " + curMul);
    if (start == num.length()) {
      if (curVal + curMul == target) {
        result.add(curPath);
      }
//      --deep;
      return;
    } // end if start == num.length()

    // i is an inclusive end
    for (int i = start; i < num.length(); i++) {
      // Pitfall 2: Leading Zero. It is possible to have "05" -> 5, "005"
      if (i != start && num.charAt(start) == '0') {
        break;
      }
      final long curNum = Long.valueOf(num.substring(start, i + 1));
//      System.out.println(curVal + (curPath.length() == 0 ? 0 : curMul));
      // curVal + (curPath.length() == 0 ? 0 : curMul) 如果不打括号，先运算左边的加法
//      System.out.println(indent() + "Deep = " + (deep) + " calling add when i = " + i);
      dfs(result, target, num, curPath.length() == 0 ? "" + curNum : (curPath + "+" + curNum), i + 1,
          curVal + (curPath.length() == 0 ? 0 : curMul), curNum);
      if (curPath.length() != 0) {
//        System.out.println(indent() + "Deep = " + (deep) + " calling sub when i = " + i);
        dfs(result, target, num, curPath + "-" + curNum, i + 1,
            curVal + curMul, -curNum);
      }
      if (curPath.length() != 0) { // 如果首次进入，curPath == ""
//        System.out.println(indent() + "Deep = " + (deep) + " calling multiple when i = " + i);
        dfs(result, target, num, curPath + "*" + curNum, i + 1,
            curVal, curMul * curNum);
      }
    }
//    --deep;
  }

  private static String indent() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < deep; i++) {
      sb.append("\t");
    }
    return sb.toString();
  }

}
