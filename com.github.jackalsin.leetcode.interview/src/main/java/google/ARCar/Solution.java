package google.ARCar;

/**
 * 一个车，可以收两个指令A和R。A就向前走一秒然后速度加倍。R就停下来然后反向。给一个AR组成的string求最后停在哪里。反问如果给位置求string。
 * http://www.1point3acres.com/bbs/thread-310267-1-1.html
 *
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public class Solution {
  private static final char A = 'A', R = 'R';

  public int getLocation(final String path) {
    int location = 0, speed = 1;
    for (char chr : path.toCharArray()) {
      if (chr == A) {
        if (speed < 0) {
          speed = 1;
        }
        location += speed;
        speed *= 2;
      } else {
        if (speed > 0) {
          speed = -1;
        }
        location += speed;
        speed *= 2;
      }
    }
    return location;
  }


//  public String getPath(int location) {
//
//
//    return null;
//  }
}
