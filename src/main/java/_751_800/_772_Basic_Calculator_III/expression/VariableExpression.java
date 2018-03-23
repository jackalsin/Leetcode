package _751_800._772_Basic_Calculator_III.expression;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class VariableExpression implements Expression {
  private final String variable;
  private final double val;

  public VariableExpression(String variable, double val) {
    this.variable = variable;
    this.val = val;
  }

  @Override
  public double eval() {
    return val;
  }

  @Override
  public String toString() {
    return variable;
  }
}
