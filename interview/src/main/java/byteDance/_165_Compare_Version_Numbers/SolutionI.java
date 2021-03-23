package byteDance._165_Compare_Version_Numbers;

/**
 * @author jacka
 * @version 1.0 on 3/22/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int compareVersion(String version1, String version2) {
    assert version1 != null && version2 != null;
    final String[] ver1 = version1.split("\\."), ver2 = version2.split("\\.");
    final int len1 = ver1.length, len2 = ver2.length, len = Math.max(len1, len2);
    for (int i = 0; i < len; ++i) {
      final int num1 = i < len1 ? Integer.parseInt(ver1[i]) : 0,
          num2 = i < len2 ? Integer.parseInt(ver2[i]) : 0,
          cmp = Integer.compare(num1, num2);
      if (cmp != 0) {
        return cmp;
      }
    }
    return 0;
  }
}
