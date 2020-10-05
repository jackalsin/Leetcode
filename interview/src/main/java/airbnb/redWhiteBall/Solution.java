package airbnb.redWhiteBall;

public interface Solution {
  /**
   * Round 3: Coding, 这题好难啊(不知道是不是新题还是这位面试官突发奇想出的…)
   * 一个袋子里有R个红色糖果W个白色糖果，每次取一个糖果，如果取到红色就吃掉，
   * 取到白色就放回袋里，但如果下一次再取到白色那就吃掉。求袋里最后剩下一个糖果为红色的机率。
   * 一开始各种数学推导，后来面试官提示说从最终状况开始往回推 才想到了可以用DP来解,
   * 写是写出来了 但感觉transition formula写得不太对。有好的思路的话欢迎讨论。
   * (感觉很像编成之美里面的某道题，但不完全一样)
   *
   * @param red
   * @param white
   * @return
   */
  double getProbability(final int red, final int white);
}
