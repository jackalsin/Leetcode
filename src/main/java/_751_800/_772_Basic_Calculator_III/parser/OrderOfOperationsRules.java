package _751_800._772_Basic_Calculator_III.parser;

import java.util.Map;

import _751_800._772_Basic_Calculator_III.operator.Operator;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class OrderOfOperationsRules {
  /**
   * The precedence table.
   */
  private final Map<String, Integer> table;

  /**
   * Instantiates a new order of operations rules.
   *
   * @param table the table
   */
  public OrderOfOperationsRules(Map<String, Integer> table) {
    this.table = table;
  }

  /**
   * Compares the precedence of two operators
   *
   * @param operator1 the operator1
   * @param operator2 the operator2
   * @return the comparison result
   */
  public int compare(Operator operator1, Operator operator2) {
    return Integer.compare(getPrecedence(operator1), getPrecedence(operator2));
  }

  /**
   * Gets the precedence.
   *
   * @param operator the operator
   * @return the precedence
   */
  private int getPrecedence(Operator operator) {

    final String operatorString = operator.toString();
    if (table.containsKey(operatorString)) {
      return table.get(operatorString);
    }
    return 0; // Operator isn't in the table, treat it as highest precedence
  }
}
