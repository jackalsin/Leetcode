package interviews.hulu.addParentheses;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/4/2020
 */
public interface Solution {

  /**
   * input:string
   * outlist:List<Integer>
   * example:"2+4*2+3"
   * 有数字，加减乘除
   * 不是用不同的 括号来制造很多中可能，输出最后的可能
   * 2+4*2+3:2+8+3=13
   * (2+4)*2+3:12+3=15
   * 2+4*(2+3):2+20=22
   * (2+4)*(2+3):6*5=30
   */
  List<Integer> getPossibleResult(final String input);
}
