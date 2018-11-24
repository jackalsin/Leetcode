package _0751_0800._800_Similar_RGB_Color;

public class Solution {
  private static final int[] HEX = {
      0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66,
      0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd,
      0xee, 0xff
  };

  public String similarRGB(String color) {
    final StringBuilder sb = new StringBuilder().append("#");
    for (int i = 1; i < color.length(); i += 2) {
      final int cur = Integer.parseInt(color.substring(i, i + 2), 16);
      final int j1 = binarySearch(cur);
      if (j1 == 0) {
        sb.append("00");
        continue;
      }
      int j0 = j1 - 1;
      if ((cur - HEX[j0]) * (cur - HEX[j0]) > (HEX[j1] - cur) * (HEX[j1] - cur)) {
        sb.append(Integer.toHexString(HEX[j1]));
      } else {
        final String toAdd = Integer.toHexString(HEX[j0]);
        sb.append(toAdd.length() == 1 ? "00" : toAdd);
      }
    }
    return sb.toString();
  }

  /**
   * First >=
   *
   * @param cur
   * @return
   */
  private static int binarySearch(final int cur) {
    int left = 0, right = HEX.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (HEX[mid] >= cur) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    assert (HEX[left] >= cur);
    return left;
  }
}
