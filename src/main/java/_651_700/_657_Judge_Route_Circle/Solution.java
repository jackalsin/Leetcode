package _651_700._657_Judge_Route_Circle;

public class Solution {

  public boolean judgeCircle(String moves) {
    int[] pos = {0, 0};
    for (char chr : moves.toCharArray()) {
      switch (chr) {
        case 'U':
          pos[0] += 1;
          pos[1] += 0;
          break;
        case 'D':
          pos[0] += -1;
          pos[1] += 0;
          break;
        case 'L':
          pos[0] += 0;
          pos[1] += -1;
          break;
        case 'R':
          pos[0] += 0;
          pos[1] += 1;
          break;
      }
    }
    return pos[0] == 0 && pos[1] == 0;
  }
}
