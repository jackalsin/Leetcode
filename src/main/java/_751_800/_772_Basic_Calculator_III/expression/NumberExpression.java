package _751_800._772_Basic_Calculator_III.expression;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class NumberExpression implements Expression {
  private final double val;

  public NumberExpression(double val) {
    this.val = val;
  }

  @Override
  public double eval() {
    return 0;
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }
}
