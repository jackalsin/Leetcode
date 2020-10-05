package tableau.tableToTree;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public interface Solution {
  /**
   * 表格到树
   * 输入是：
   * apple M 1
   * apple M 2
   * pear M 3
   * banana L 4
   * banana M 5
   * 输出要打印成：
   * apple
   * M
   * 1
   * 2
   * pear
   * M
   * 3
   * banana
   * L
   * 4
   * M
   * 5
   */
  List<String> transform(final List<String> input);
}
