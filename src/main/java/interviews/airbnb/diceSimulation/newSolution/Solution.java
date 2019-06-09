package interviews.airbnb.diceSimulation.newSolution;

public interface Solution {
  /**
   * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=514714&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
   * coding 2: 写一个similator, simulate 一个游戏：掷两个骰子，得到两个数 a,b. 现在有九个开着的箱子，标注1-9. 根据a+b的和(a+b=c),
   * 可以选择关闭c号的箱子，或者关闭任意两个标号和为c的箱子，比如c=5, 可以关五号箱，或者关1，4，或者 2, 3。关的箱子必须要是开着的。
   * 如果发现c不能关任何箱子了，就输了。如果所有箱子都关闭了，就赢了。
   * 让先写一个简单的关箱子策略（无脑for loop找），算出win rate (跑一百次）。可能还要写别的策略，但是来不及了，面试官说close enough。
   */
  boolean solve();
}
