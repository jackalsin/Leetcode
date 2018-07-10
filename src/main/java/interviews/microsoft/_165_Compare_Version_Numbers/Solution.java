package interviews.microsoft._165_Compare_Version_Numbers;

public class Solution {
  public int compareVersion(String version1, String version2) {
    final String[] v1 = version1.split("\\."), v2 = version2.split("\\.");

    for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
      final int v1Digits = i >= v1.length ? 0 : Integer.parseInt(v1[i]),
          v2Digits = i >= v2.length ? 0 : Integer.parseInt(v2[i]),
          cmp = compare(v1Digits, v2Digits);
      if (cmp != 0) {
        return cmp;
      }
    }
    return 0;
  }

  private static int compare(int a, int b) {
    if (a == b) {
      return 0;
    } else if (a > b) {
      return 1;
    } else {
      return -1;
    }
  }

}
