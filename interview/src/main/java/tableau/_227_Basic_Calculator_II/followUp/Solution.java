package tableau._227_Basic_Calculator_II.followUp;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
public interface Solution {
  /**
   * 3. 在第二问的基础上实现一个excel计算器 输入list of strings，其中"AXX"的"XX"代表一个之前的cell的index (0-based)，输出list of integers：
   * input: { "1+2", "3*4+5", "A0*2", "A1+6", "A2+A3" }
   * output: { 3, 17, 6(3*2), 23(17+6), 29(6+23) }
   */
  List<String> calculate(final List<String> line);
}
