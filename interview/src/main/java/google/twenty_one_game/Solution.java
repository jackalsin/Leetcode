package google.twenty_one_game;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class Solution {
  /**
   * 21点游戏 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�.
   * 牌只有1-10点，如果还没满17点就要再拿一张，问超过21点的机率是多少？
   * DP问题，但面试时太紧张，不知道怎么设定DP，尤其是被一直抽牌有好几轮迷惑了。最后面试官提示，只要用DP计算拿到我点的机率，然后1-（P（17 ）+ P（18）+ P（19）+
   * P（20）+ P（21））就好，还是太浅了我
   */
  public double largerThan21() {
    final double[] dp = new double[27]; // max is 26
    dp[1] = 1d / 10d;
    for (int i = 2; i <= 26; i++) {
      if (i <= 10) {
        dp[i] += 1d / 10;
        for (int j = 1; j < i; j++) {
          dp[i] += (dp[j]) / 10d;
        }
      } else {
        for (int j = i - 10; j < i && j < 17; j++) {
          dp[i] += (dp[j]) / 10d;
        }
      }
    }
    System.out.println(Arrays.toString(dp));
    return 1 - dp[17] - dp[18] - dp[19] - dp[20] - dp[21];
  }
}
