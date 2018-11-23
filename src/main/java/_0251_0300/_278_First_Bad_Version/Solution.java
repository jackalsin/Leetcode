package _0251_0300._278_First_Bad_Version;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while(left <= right) {
      int mid = (right - left) / 2 + left;
      if (isBadVersion(mid)) right = mid - 1;
      else left = mid + 1;
    }
    return right + 1;
  }
}
