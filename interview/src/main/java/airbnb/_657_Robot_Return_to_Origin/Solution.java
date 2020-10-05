package airbnb._657_Robot_Return_to_Origin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public class Solution {
  private static final Map<Character, int[]> DIRS = new HashMap<Character, int[]>() {{
    put('U', new int[]{1, 0});
    put('D', new int[]{-1, 0});
    put('R', new int[]{0, 1});
    put('L', new int[]{0, -1});
  }};

  public boolean judgeCircle(String moves) {
    int[] pos = {0, 0};
    for (char chr : moves.toCharArray()) {
      final int[] move = DIRS.get(chr);
      pos[0] += move[0];
      pos[1] += move[1];
    }
    return pos[0] == 0 && pos[1] == 0;
  }
}
